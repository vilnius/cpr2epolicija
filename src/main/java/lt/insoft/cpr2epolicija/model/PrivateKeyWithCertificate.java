package lt.insoft.cpr2epolicija.model;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Objects;

public class PrivateKeyWithCertificate {

    private final PrivateKey privateKey;
    private final X509Certificate certificate;

    public PrivateKeyWithCertificate(PrivateKey privateKey, X509Certificate certificate) {
        this.privateKey = Objects.requireNonNull(privateKey);
        this.certificate = Objects.requireNonNull(certificate);
    }

    public X509Certificate getCertificate() {
        return certificate;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

}
