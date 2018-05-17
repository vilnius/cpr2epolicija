package lt.insoft.cpr2epolicija.utils;

import java.io.ByteArrayOutputStream;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Objects;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * Kodas kopijuotas iš epolice (lt.insoft.eservices.s2s.ws.XmlUtils)
 */
public final class XmlUtils {
    private static final Log LOG = LogFactory.getLog(XmlUtils.class);

    private XmlUtils() {
    }

    public static Node marshal(Object data) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(data.getClass());

        DOMResult result = new DOMResult();
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(data, result);
        return result.getNode();
    }

    public static String base64EncodeDocument(Document document) {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            trans.transform(new DOMSource(document), new StreamResult(output));
            return new Base64(4096, null).encodeToString(output.toByteArray());
        } catch (Exception e) {
            LOG.error("base64EncodeDocument exception", e);
            throw new IllegalStateException(e);
        }
    }

    public static void signDocument(Document document, PrivateKey privateKey, X509Certificate cert) {
        Objects.requireNonNull(document, "Parameter document is required");
        Objects.requireNonNull(privateKey, "Parameter privateKey is required");
        Objects.requireNonNull(cert, "Parameter cert is required");

        try {
            DOMSignContext dsc = new DOMSignContext(privateKey, document.getDocumentElement());
            XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

            Reference ref = fac.newReference("", fac.newDigestMethod(DigestMethod.SHA1, null),
                    Collections.singletonList(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)), null, null);

            SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS, (C14NMethodParameterSpec) null),
                    fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));

            KeyInfoFactory kif = fac.getKeyInfoFactory();
            KeyValue kv = kif.newKeyValue(cert.getPublicKey());
            KeyInfo ki = kif.newKeyInfo(Collections.singletonList(kv));

            XMLSignature signature = fac.newXMLSignature(si, ki);
            signature.sign(dsc);

        } catch (Exception e) {
            LOG.error("signDocument exception", e);
            throw new IllegalStateException(e);
        }
    }
}
