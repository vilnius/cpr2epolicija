
package lt.insoft.cpr2epolicija.model.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for statusField complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="statusField"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fieldCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fieldText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "statusField", propOrder = {
    "fieldCode",
    "fieldText",
    "value"
})
public class StatusField {

    protected String fieldCode;
    protected String fieldText;
    protected Object value;

    /**
     * Gets the value of the fieldCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFieldCode() {
        return fieldCode;
    }

    /**
     * Sets the value of the fieldCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFieldCode(String value) {
        this.fieldCode = value;
    }

    /**
     * Gets the value of the fieldText property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFieldText() {
        return fieldText;
    }

    /**
     * Sets the value of the fieldText property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFieldText(String value) {
        this.fieldText = value;
    }

    /**
     * Gets the value of the value property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setValue(Object value) {
        this.value = value;
    }

}
