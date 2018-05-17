
package lt.insoft.cpr2epolicija.model.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for statusResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="statusResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reportROIK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reportIdInSenderSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statusText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fields" type="{http://ws.s2s.eservices.insoft.lt/}statusField" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "statusResponse", propOrder = {
    "reportROIK",
    "reportIdInSenderSystem",
    "statusCode",
    "statusText",
    "date",
    "fields"
})
public class StatusResponse {

    protected String reportROIK;
    protected String reportIdInSenderSystem;
    protected String statusCode;
    protected String statusText;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(nillable = true)
    protected List<StatusField> fields;

    /**
     * Gets the value of the reportROIK property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReportROIK() {
        return reportROIK;
    }

    /**
     * Sets the value of the reportROIK property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReportROIK(String value) {
        this.reportROIK = value;
    }

    /**
     * Gets the value of the reportIdInSenderSystem property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReportIdInSenderSystem() {
        return reportIdInSenderSystem;
    }

    /**
     * Sets the value of the reportIdInSenderSystem property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReportIdInSenderSystem(String value) {
        this.reportIdInSenderSystem = value;
    }

    /**
     * Gets the value of the statusCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the statusText property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatusText() {
        return statusText;
    }

    /**
     * Sets the value of the statusText property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatusText(String value) {
        this.statusText = value;
    }

    /**
     * Gets the value of the date property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the fields property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fields property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFields().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusField }
     *
     *
     */
    public List<StatusField> getFields() {
        if (fields == null) {
            fields = new ArrayList<StatusField>();
        }
        return this.fields;
    }

}
