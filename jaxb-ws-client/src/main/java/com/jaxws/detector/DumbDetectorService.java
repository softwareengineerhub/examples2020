
package com.jaxws.detector;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DumbDetectorService", targetNamespace = "http://detector.jaxws.com/", wsdlLocation = "http://127.0.0.1:8084/detector?wsdl")
public class DumbDetectorService
    extends Service
{

    private final static URL DUMBDETECTORSERVICE_WSDL_LOCATION;
    private final static WebServiceException DUMBDETECTORSERVICE_EXCEPTION;
    private final static QName DUMBDETECTORSERVICE_QNAME = new QName("http://detector.jaxws.com/", "DumbDetectorService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:8084/detector?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DUMBDETECTORSERVICE_WSDL_LOCATION = url;
        DUMBDETECTORSERVICE_EXCEPTION = e;
    }

    public DumbDetectorService() {
        super(__getWsdlLocation(), DUMBDETECTORSERVICE_QNAME);
    }

    public DumbDetectorService(WebServiceFeature... features) {
        super(__getWsdlLocation(), DUMBDETECTORSERVICE_QNAME, features);
    }

    public DumbDetectorService(URL wsdlLocation) {
        super(wsdlLocation, DUMBDETECTORSERVICE_QNAME);
    }

    public DumbDetectorService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DUMBDETECTORSERVICE_QNAME, features);
    }

    public DumbDetectorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DumbDetectorService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DumbDetector
     */
    @WebEndpoint(name = "DumbDetectorPort")
    public DumbDetector getDumbDetectorPort() {
        return super.getPort(new QName("http://detector.jaxws.com/", "DumbDetectorPort"), DumbDetector.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DumbDetector
     */
    @WebEndpoint(name = "DumbDetectorPort")
    public DumbDetector getDumbDetectorPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://detector.jaxws.com/", "DumbDetectorPort"), DumbDetector.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DUMBDETECTORSERVICE_EXCEPTION!= null) {
            throw DUMBDETECTORSERVICE_EXCEPTION;
        }
        return DUMBDETECTORSERVICE_WSDL_LOCATION;
    }

}
