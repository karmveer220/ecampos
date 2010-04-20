package gob.min.digemin.ejb.handler;

import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

/**
 * TRABAJA A NIVEL DEL DOOM
 * Con objetos java
 * a nivel del body cotenido del mensaje
 * @author Elvis Ruben Campos Mori
 */
public class HelloLogicalHandler implements LogicalHandler<LogicalMessageContext> {

     public boolean handleMessage(LogicalMessageContext messageContext) {
       /* Boolean outboundProperty = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        LogicalMessage lm = messageContext.getMessage();
        DOMSource payload = (DOMSource) lm.getPayload();
        System.out.println(" en el HelloLogicalHandler ");
        if (outboundProperty) {
            System.out.println("HelloLogicalHandler outbound message..."+outboundProperty+"=REGRESO");
            System.out.println("mensaje = "+payload.getNode().getFirstChild().getTextContent());
        } else {
            System.out.println("HelloLogicalHandler inbound message..."+outboundProperty+"=IDA");
            System.out.println("mensaje = "+payload.getNode().getFirstChild().getTextContent());
            payload.getNode().getFirstChild().setTextContent("Luis Alberto Ruiz");
        }
       */
        return true;
    }


    public boolean handleFault(LogicalMessageContext messageContext) {
        return true;
    }

    public void close(MessageContext context) {
    }

}
