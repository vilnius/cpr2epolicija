
package lt.insoft.cpr2epolicija.model.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for getReportStatus complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="getReportStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="senderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="encodedSignedStatusRequest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getReportStatus", propOrder = {
    "senderCode",
    "encodedSignedStatusRequest"
})
public class GetReportStatus {

    protected String senderCode;
    protected String encodedSignedStatusRequest;

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
     * Gets the value of the encodedSignedStatusRequest property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEncodedSignedStatusRequest() {
        return encodedSignedStatusRequest;
    }

    /**
     * Sets the value of the encodedSignedStatusRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEncodedSignedStatusRequest(String value) {
        this.encodedSignedStatusRequest = value;
    }

}
