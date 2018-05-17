
package lt.insoft.cpr2epolicija.model.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for report complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="report"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="attachments" type="{http://ws.s2s.eservices.insoft.lt/}file" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="fields" type="{http://ws.s2s.eservices.insoft.lt/}keyValuePair" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="reportDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="idInSenderSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "report", propOrder = {
    "attachments",
    "fields",
    "reportDate",
    "idInSenderSystem"
})
@XmlRootElement // Pridėta rankomis, kad veiktų XmlUtils.marshal
public class Report {

    @XmlElement(nillable = true)
    protected List<File> attachments;
    @XmlElement(nillable = true)
    protected List<KeyValuePair> fields;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar reportDate;
    protected String idInSenderSystem;

    /**
     * Gets the value of the attachments property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachments property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachments().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link File }
     *
     *
     */
    public List<File> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<File>();
        }
        return this.attachments;
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
     * {@link KeyValuePair }
     *
     *
     */
    public List<KeyValuePair> getFields() {
        if (fields == null) {
            fields = new ArrayList<KeyValuePair>();
        }
        return this.fields;
    }

    /**
     * Gets the value of the reportDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getReportDate() {
        return reportDate;
    }

    /**
     * Sets the value of the reportDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setReportDate(XMLGregorianCalendar value) {
        this.reportDate = value;
    }

    /**
     * Gets the value of the idInSenderSystem property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdInSenderSystem() {
        return idInSenderSystem;
    }

    /**
     * Sets the value of the idInSenderSystem property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdInSenderSystem(String value) {
        this.idInSenderSystem = value;
    }

}
