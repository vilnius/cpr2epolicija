package lt.insoft.cpr2epolicija.helper.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import lt.insoft.cpr2epolicija.Properties;
import lt.insoft.cpr2epolicija.helper.S2SHelper;
import lt.insoft.cpr2epolicija.model.PrivateKeyWithCertificate;
import lt.insoft.cpr2epolicija.model.ws.KeyValuePair;
import lt.insoft.cpr2epolicija.model.ws.Report;
import lt.insoft.cpr2epolicija.model.ws.S2SService;
import lt.insoft.cpr2epolicija.model.ws.S2SServiceException_Exception;
import lt.insoft.cpr2epolicija.model.ws.StatusRequest;
import lt.insoft.cpr2epolicija.model.ws.StatusResponse;
import lt.insoft.cpr2epolicija.utils.XmlUtils;

@Component
class S2SHelperImpl implements S2SHelper {
    private static final Log LOG = LogFactory.getLog(S2SHelperImpl.class);

    private static final List<String> DATE_TYPE_KEYS = Arrays.asList("laikas.nuo", "laikas.iki");

    @Autowired
    private S2SService s2sService;
    @Autowired
    private PrivateKeyWithCertificate privateKeyWithCertificate;
    @Autowired
    private Properties properties;

    @Override
    public List<StatusResponse> getReportStatus(String senderCode, StatusRequest request) throws S2SServiceException_Exception {
        Objects.requireNonNull(request, "Parameter request is required");
        return s2sService.getReportStatus(ObjectUtils.defaultIfNull(senderCode, properties.getDefaultSenderCode()), signAndBase64Encode(request));
    }

    @Override
    public String sendReport(String senderCode, Report report) throws S2SServiceException_Exception {
        Objects.requireNonNull(report, "Parameter report is required");
        fixDateFields(report.getFields());
        return s2sService.sendReport(ObjectUtils.defaultIfNull(senderCode, properties.getDefaultSenderCode()), signAndBase64Encode(report));
    }

    private void fixDateFields(List<KeyValuePair> fields) {
        for (KeyValuePair field : fields) {
            if (DATE_TYPE_KEYS.contains(field.getKey())) {
                field.setValue(getDateFromObject(field.getValue()));
            }
        }
    }

    private Date getDateFromObject(Object object) {
        long epochMilliSecond;
        if (object instanceof Long) {
            epochMilliSecond = (Long) object;
        } else {
            epochMilliSecond = DateTimeFormatter.ISO_DATE_TIME.parse(object.toString(), LocalDateTime::from).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        }

        return new Date(epochMilliSecond);
    }

    private String signAndBase64Encode(Object object) {
        // marshalling
        Document doc;
        try {
            doc = (Document) XmlUtils.marshal(object);
        } catch (Exception e) {
            LOG.error("Failed to marshall object", e);
            throw new IllegalStateException(e);
        }

        if (doc == null) {
            return null;
        }

        // signing
        XmlUtils.signDocument(doc, privateKeyWithCertificate.getPrivateKey(), privateKeyWithCertificate.getCertificate());

        // encoding
        return XmlUtils.base64EncodeDocument(doc);
    }

}
