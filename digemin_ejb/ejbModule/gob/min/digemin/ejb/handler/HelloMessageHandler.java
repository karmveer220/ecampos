package gob.min.digemin.ejb.handler;

import java.util.Collections;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * trabajaa nivel del SOAP
 * puedo nacvegar nodo por nodo del mensaje SOAP
 *
 * @author Elvis Campos
 */
public class HelloMessageHandler implements SOAPHandler<SOAPMessageContext> {

       public boolean handleMessage(SOAPMessageContext messageContext) {
        Boolean outboundProperty = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        SOAPMessage message = messageContext.getMessage();
        try {
            if (outboundProperty) {
                System.out.println("HelloMessageHandler outbound message...");
                
            } else {
                System.out.println("HelloMessageHandler inbound message...");
                System.out.println(message.getSOAPHeader());
            }
            message.writeTo(System.out);
            System.out.println("............");
        } catch (Exception e) {
            System.out.println("Exception in handler: " + e);
        }
        return true;
    }


    public Set<QName> getHeaders() {
    	System.out.println("********************* GET HEADER RETURN EMPTY SET");
        //return Collections.EMPTY_SET;
    	return null;
    }

    public boolean handleFault(SOAPMessageContext messageContext) {
        return true;
    }

    public void close(MessageContext context) {
    }

}
