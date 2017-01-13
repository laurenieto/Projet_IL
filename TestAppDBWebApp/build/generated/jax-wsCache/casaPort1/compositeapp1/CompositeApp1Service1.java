
package compositeapp1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3.3-hudson-757-SNAPSHOT
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "CompositeApp1Service1", targetNamespace = "CompositeApp1", wsdlLocation = "http://localhost:9080/CompositeApp1Service1/casaPort1?wsdl")
public class CompositeApp1Service1
    extends Service
{

    private final static URL COMPOSITEAPP1SERVICE1_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(compositeapp1.CompositeApp1Service1 .class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = compositeapp1.CompositeApp1Service1 .class.getResource(".");
            url = new URL(baseUrl, "http://localhost:9080/CompositeApp1Service1/casaPort1?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:9080/CompositeApp1Service1/casaPort1?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        COMPOSITEAPP1SERVICE1_WSDL_LOCATION = url;
    }

    public CompositeApp1Service1(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CompositeApp1Service1() {
        super(COMPOSITEAPP1SERVICE1_WSDL_LOCATION, new QName("CompositeApp1", "CompositeApp1Service1"));
    }

    /**
     * 
     * @return
     *     returns ClientAuthWSDLPortType
     */
    @WebEndpoint(name = "casaPort1")
    public ClientAuthWSDLPortType getCasaPort1() {
        return super.getPort(new QName("CompositeApp1", "casaPort1"), ClientAuthWSDLPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ClientAuthWSDLPortType
     */
    @WebEndpoint(name = "casaPort1")
    public ClientAuthWSDLPortType getCasaPort1(WebServiceFeature... features) {
        return super.getPort(new QName("CompositeApp1", "casaPort1"), ClientAuthWSDLPortType.class, features);
    }

}