
package lt.insoft.cpr2epolicija.model.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for sendReport complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="sendReport"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="senderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="encodedSignedReport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendReport", propOrder = {
    "senderCode",
    "encodedSignedReport"
})
public class SendReport {

    protected String senderCode;
    protected String encodedSignedReport;

    /**
     * Gets the value of the senderCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSenderCode() {
        return senderCode;
    }

    /**
     * Sets the value of the senderCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSenderCode(String value) {
        this.senderCode = value;
    }

    /**
     * Gets the value of the encodedSignedReport property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEncodedSignedReport() {
        return encodedSignedReport;
    }

    /**
     * Sets the value of the encodedSignedReport property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEncodedSignedReport(String value) {
        this.encodedSignedReport = value;
    }

}
