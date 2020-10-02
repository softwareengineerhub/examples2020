
package com.jaxws.detector;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for capability.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="capability">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="STUPID"/>
 *     &lt;enumeration value="DUMB"/>
 *     &lt;enumeration value="NORMAL"/>
 *     &lt;enumeration value="SMART"/>
 *     &lt;enumeration value="GENIUS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "capability")
@XmlEnum
public enum Capability {

    STUPID,
    DUMB,
    NORMAL,
    SMART,
    GENIUS;

    public String value() {
        return name();
    }

    public static Capability fromValue(String v) {
        return valueOf(v);
    }

}
