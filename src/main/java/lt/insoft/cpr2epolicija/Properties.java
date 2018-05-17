package lt.insoft.cpr2epolicija;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("properties")
public class Properties {

    private String epolicijaServiceUrl;
    private int epolicijaConnectTimeout = 5000;
    private int epolicijaReadTimeout = 30000;

    private String defaultSenderCode;

    private Resource privateKey;
    private String privateKeyPassword;
    private Resource certificate;

    public String getEpolicijaServiceUrl() {
        return epolicijaServiceUrl;
    }

    public void setEpolicijaServiceUrl(String epolicijaServiceUrl) {
        this.epolicijaServiceUrl = epolicijaServiceUrl;
    }

    public int getEpolicijaConnectTimeout() {
        return epolicijaConnectTimeout;
    }

    public void setEpolicijaConnectTimeout(int epolicijaConnectTimeout) {
        this.epolicijaConnectTimeout = epolicijaConnectTimeout;
    }

    public int getEpolicijaReadTimeout() {
        return epolicijaReadTimeout;
    }

    public void setEpolicijaReadTimeout(int epolicijaReadTimeout) {
        this.epolicijaReadTimeout = epolicijaReadTimeout;
    }

    public Resource getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(Resource privateKey) {
        this.privateKey = privateKey;
    }

    public String getPrivateKeyPassword() {
        return privateKeyPassword;
    }

    public void setPrivateKeyPassword(String privateKeyPassword) {
        this.privateKeyPassword = privateKeyPassword;
    }

    public Resource getCertificate() {
        return certificate;
    }

    public void setCertificate(Resource certificate) {
        this.certificate = certificate;
    }

    public String getDefaultSenderCode() {
        return defaultSenderCode;
    }

    public void setDefaultSenderCode(String defaultSenderCode) {
        this.defaultSenderCode = defaultSenderCode;
    }
}
