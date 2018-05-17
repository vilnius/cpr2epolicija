package lt.insoft.cpr2epolicija;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import lt.insoft.cpr2epolicija.model.PrivateKeyWithCertificate;
import lt.insoft.cpr2epolicija.model.ws.S2SService;
import lt.insoft.cpr2epolicija.utils.CertificateUtils;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public S2SService s2sService(Properties properties) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(S2SService.class);
        factory.setAddress(properties.getEpolicijaServiceUrl());

        S2SService service = (S2SService) factory.create();

        Client client = ClientProxy.getClient(service);
        HTTPConduit conduit = (HTTPConduit) client.getConduit();
        HTTPClientPolicy policy = new HTTPClientPolicy();
        policy.setConnectionTimeout(properties.getEpolicijaConnectTimeout());
        policy.setReceiveTimeout(properties.getEpolicijaReadTimeout());
        conduit.setClient(policy);

        return service;
    }

    @Bean
    public PrivateKeyWithCertificate privateKeyWithCertificate(Properties properties) throws Exception {
        PrivateKey privateKey = CertificateUtils.getPrivateKey(properties.getPrivateKey(), properties.getPrivateKeyPassword());
        X509Certificate certificate = CertificateUtils.getX509Certificate(properties.getCertificate());
        return new PrivateKeyWithCertificate(privateKey, certificate);
    }

}
