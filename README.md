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

Clone repository and build the project:
```
cd /home/username
git clone https://github.com/vilnius/cpr2epolicija.git
cd cpr2epolicija

# Copy configuration template file and edit it
cp src/main/resources/application.properties.template src/main/resources/application.properties
```

Put certificate/key `.pem` files inside `resources/` and build the package using maven:
```
mvn package
```
New folder `target/` should appear with `.jar` file inside.


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
If you experience errors, go to /var/log/messages to investigate them.
