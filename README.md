# cpr2epolicija service

A wrapper around epolicija SOAP web service that allows accessing it using simple JSON HTTP calls
while also separating concerns, limiting exposure and adding extra security layer.


## Building

Install Java and Maven:
```
# CentOS
sudo yum install java-1.8.0-openjdk maven

# Ubuntu
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update  # not needed in Ubuntu 18.04
sudo apt install openjdk-8-jdk maven
```

Clone GitHub repository:
```
cd /home/username
git clone https://github.com/vilnius/cpr2epolicija.git
cd cpr2epolicija
```

**Configuration**

Copy configuration template file and edit it:
```
cp src/main/resources/application.properties.template src/main/resources/application.properties
```

* `properties.epolicija-service-url` - Location of ePolicija web service
* `properties.default-sender-code` - Unique sender code which is registered in epolicija (default, can be customized per request)
* `properties.private-key` - Location of private key file, e.g. `classpath:keys/cprkey.pem` (relative to `resources/` folder)
* `properties.private-key-password` - Password for private key
* `properties.certificate` - Location of certificate file, e.g. `classpath:keys/cprcer.pem`
* `server.port` - Port this service should bind to
* `logging.path` - Location of log files

Build the package using maven:
```
mvn package
```
New folder `target/` should appear with `.jar` file inside.
All resources specified in configuration must be next to this `.jar` file inside `resources/` folder.


## Deploying

Create a launcher `run-cpr2epolicija.sh`, remember to make it executable (+x):
```
#!/bin/bash
/usr/bin/java -jar /home/username/cpr2epolicija/target/cpr-to-epolicija-0.1-SNAPSHOT.jar
```

Create systemd service as `/etc/systemd/system/cpr2epolicija.service`:
```
[Unit]
Description=cpr2epolicija
After=network.target

[Service]
WorkingDirectory=/home/username/cpr2epolicija
SyslogIdentifier=cpr2epolicija
ExecStart=/home/username/cpr2epolicija/run-cpr2epolicija.sh
User=username
Type=simple
Restart=always

[Install]
WantedBy=multi-user.target
```

Enable service to autostart on startup, and start it:
```
sudo systemctl enable cpr2epolicija.service
sudo systemctl start cpr2epolicija.service
```
If you experience errors, go to `/var/log/messages` to investigate them.


## Usage

There are two methods exposed by this service:
* `sendReport` - to register new event
* `getReportStatus` – to get the status of already registered event

The final URLs:
* http://<server ip>:<port>/epolicija/sendReport
* http:// <server ip>:<port>/epolicija/getReportStatus

* `SenderCode` can be passed as an URL parameter `.../epolicija/getReportStatus?senderCode=SENDER`,
if no value is given the default specified in configuration is used.
* Date format can be either in ISO 8601 (e.g. `2017-05-21T18:25:43.563Z`) or epoch (e.g. `1495380343000`)
* Log files are being rotated each month by default
* Requests must contain HTTP header `Content-Type: application/json`
* When sending attachment files their content must be encoded using base64.

### `getReportStatus`

Required fields: `dateFrom` and `dateTo` or `roik`.

**Example requests**
```
{
    "dateFrom": "2018-05-06T18:25:43Z",
    "dateTo": "2018-05-07T18:00:00"
}
```
```
{
    "roik": "9918000000206"
}
```

### `sendReport`

Required fields: `idInSenderSystem` (unique id in your system) and `fields` array containing key-values of:
`laikas.nuo`, `tipas`, `aplinkybes`, `atsakingasAsmuo.asmensKodas`, `atsakingasAsmuo.vardas`, `atsakingasAsmuo.pavarde`.

**Example requests**
Minimal request:
```
{
    "idInSenderSystem": "5afdca6179c18b1580b532be",
    "fields": [{
        "key": "laikas.nuo",
        "value": "2018-05-07T12:12:45"
    }, {
        "key": "tipas",
        "value": "4000"
    }, {
        "key": "aplinkybes",
        "value": "Testavimas. Testing. Please ignore."
    }, {
        "key": "atsakingasAsmuo.asmensKodas",
        "value": "12345678901"
    }, {
        "key": "atsakingasAsmuo.vardas",
        "value": "Vardenis"
    }, {
        "key": "atsakingasAsmuo.pavarde",
        "value": "Pavardenis"
    }]
}
```

With attachment and additional fields:
```
{
    "idInSenderSystem": "5afdca6179c18b1580b532be",
    "reportDate": "2017-05-23T18:25:43.100",
    "fields": [{
        "key": "laikas.nuo",
        "value": "2018-05-07T12:12:45"
    }, {
        "key": "laikas.iki",
        "value": 1495380343000
    }, {
        "key": "tipas",
        "value": "4000"
    }, {
        "key": "aplinkybes",
        "value": "Testavimas. Testing. Please ignore."
    }, {
        "key": "atsakingasAsmuo.asmensKodas",
        "value": "12345678901"
    }, {
        "key": "atsakingasAsmuo.vardas",
        "value": "Vardenis"
    }, {
        "key": "atsakingasAsmuo.pavarde",
        "value": "Pavardenis"
    }, {
        "key": "adresas.kelias.kmNuoPradzios",
        "value": 565.12132321
    }, {
        "key": "adresas.koordinates.x",
        "value": 580435
    }, {
        "key": "adresas.koordinates.y",
        "value": 6060589
    }],
    "attachments": [{
        "mimeType": "image/png",
        "filename": "myimage.png",
        "binaryData": "iVBORw0KGgoAANSUgAAA...base64.data...QWIUOEuekYF"
    }]
}
```
