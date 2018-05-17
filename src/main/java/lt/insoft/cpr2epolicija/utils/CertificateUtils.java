package lt.insoft.cpr2epolicija.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8DecryptorProviderBuilder;
import org.bouncycastle.operator.InputDecryptorProvider;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.springframework.core.io.Resource;

public final class CertificateUtils {

    private CertificateUtils() {
    }

    public static X509Certificate getX509Certificate(Resource certificate) throws Exception {
        if (certificate == null) {
            throw new IOException("certificate is not set");
        }

        try (InputStream is = certificate.getInputStream()) {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(is);
        }
    }

    public static PrivateKey getPrivateKey(Resource privateKey, String password) throws Exception {
        if (privateKey == null) {
            throw new IOException("privateKey is not set");
        }

        try (InputStream is = privateKey.getInputStream(); InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8); PEMParser parser = new PEMParser(reader)) {
            Object item = parser.readObject();
            if (item instanceof PEMKeyPair) {
                return new JcaPEMKeyConverter().getKeyPair((PEMKeyPair) item).getPrivate();
            } else if (item instanceof PKCS8EncryptedPrivateKeyInfo) {
                Security.addProvider(new BouncyCastleProvider());
                InputDecryptorProvider provider = new JceOpenSSLPKCS8DecryptorProviderBuilder().build(password.toCharArray());
                PrivateKeyInfo privateKeyInfo = ((PKCS8EncryptedPrivateKeyInfo) item).decryptPrivateKeyInfo(provider);
                return new JcaPEMKeyConverter().getPrivateKey(privateKeyInfo);
            }
        }

        throw new IOException("could not read private key");
    }
}
