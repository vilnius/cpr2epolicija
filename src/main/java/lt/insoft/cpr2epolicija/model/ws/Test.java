
package lt.insoft.cpr2epolicija.model.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for test complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="test"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arg0" type="{http://ws.s2s.eservices.insoft.lt/}report" minOccurs="0"/&gt;
 *         &lt;element name="arg1" type="{http://ws.s2s.eservices.insoft.lt/}statusRequest" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "test", propOrder = {
    "arg0",
    "arg1"
})
public class Test {

    protected Report arg0;
    protected StatusRequest arg1;

    /**
     * Gets the value of the arg0 property.
     *
     * @return
     *     possible object is
     *     {@link Report }
     *
     */
    public Report getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     *
     * @param value
     *     allowed object is
     *     {@link Report }
     *
     */
    public void setArg0(Report value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     *
     * @return
     *     possible object is
     *     {@link StatusRequest }
     *
     */
    public StatusRequest getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     *
     * @param value
     *     allowed object is
     *     {@link StatusRequest }
     *
     */
    public void setArg1(StatusRequest value) {
        this.arg1 = value;
    }

}
