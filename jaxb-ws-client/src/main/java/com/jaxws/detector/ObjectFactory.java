
package com.jaxws.detector;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jaxws.detector package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DetectResponse_QNAME = new QName("http://detector.jaxws.com/", "detectResponse");
    private final static QName _Detect_QNAME = new QName("http://detector.jaxws.com/", "detect");
    private final static QName _Guess_QNAME = new QName("http://detector.jaxws.com/", "guess");
    private final static QName _GuessResponse_QNAME = new QName("http://detector.jaxws.com/", "guessResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jaxws.detector
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Guess }
     * 
     */
    public Guess createGuess() {
        return new Guess();
    }

    /**
     * Create an instance of {@link GuessResponse }
     * 
     */
    public GuessResponse createGuessResponse() {
        return new GuessResponse();
    }

    /**
     * Create an instance of {@link Detect }
     * 
     */
    public Detect createDetect() {
        return new Detect();
    }

    /**
     * Create an instance of {@link DetectResponse }
     * 
     */
    public DetectResponse createDetectResponse() {
        return new DetectResponse();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://detector.jaxws.com/", name = "detectResponse")
    public JAXBElement<DetectResponse> createDetectResponse(DetectResponse value) {
        return new JAXBElement<DetectResponse>(_DetectResponse_QNAME, DetectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Detect }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://detector.jaxws.com/", name = "detect")
    public JAXBElement<Detect> createDetect(Detect value) {
        return new JAXBElement<Detect>(_Detect_QNAME, Detect.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Guess }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://detector.jaxws.com/", name = "guess")
    public JAXBElement<Guess> createGuess(Guess value) {
        return new JAXBElement<Guess>(_Guess_QNAME, Guess.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuessResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://detector.jaxws.com/", name = "guessResponse")
    public JAXBElement<GuessResponse> createGuessResponse(GuessResponse value) {
        return new JAXBElement<GuessResponse>(_GuessResponse_QNAME, GuessResponse.class, null, value);
    }

}
