package client;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * @author Haiway  on 2019/6/4
 */
public class ThreeApplication {

    private static String wsdlUrl = "http://66.0.42.6:8001/EsbService/ECIFMSGTAS_CTL_MsgSendProxyService?wsdl";
    public static void main(String[] args) throws Exception{
        String ns = "http://www.jscb.com.cn/ecifmsg/ECIFMSGTAS_CTL_MsgSend/";

        String phone = args[0];
        String content = args[1];
        if(args!=null && args.length>2){
            wsdlUrl = args[2];
        }

        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage();
        SOAPPart part = message.getSOAPPart();
        SOAPEnvelope envelope = part.getEnvelope();
        SOAPBody body = envelope.getBody();

        QName qname = new QName(ns, "TAS_CTL_MsgSendRequest", "ecif");
        SOAPBodyElement element = body.addBodyElement(qname);
        element.addChildElement("SEQ_NO").setValue("010122500298");
        element.addChildElement("SERVICE_ID").setValue("msg01");
        element.addChildElement("SERVER_ID").setValue("8069");
        element.addChildElement("BANK_CODE").setValue("9901");
        element.addChildElement("USER_ID").setValue("01016437");
        element.addChildElement("CHANNEL_ID").setValue("8231");
        element.addChildElement("TRAN_DATE").setValue("20190603");
        element.addChildElement("TRAN_TIME").setValue("150504");
        element.addChildElement("PRD_ID").setValue("10111");

        SOAPElement soapElement = element.addChildElement("GROUP_SND_LIST");

        SOAPElement gele = soapElement.addChildElement("GROUP_SND");
        gele.addChildElement("CHL_ID").setValue("1");
        gele.addChildElement("GROUP_NO").setValue("01");
        gele.addChildElement("SEND_NO").setValue(phone);
        gele.addChildElement("SEND_CONTENT").setValue(content);
        gele.addChildElement("MSG_EXP_FLAG").setValue("2");

        message.writeTo(System.out);

        //创建服务（Service）
        URL url = new URL(wsdlUrl);

        QName sname = new QName(ns,"ECIFMSGTAS_CTL_MsgSendSOAPQSService");
        Service service = Service.create(url, sname);
        //创建Dispatch
        Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName(ns,"ECIFMSGTAS_CTL_MsgSendSOAPQSPort"),SOAPMessage.class,Service.Mode.MESSAGE);

        SOAPMessage response = dispatch.invoke(message);
        response.writeTo(System.out);
    }
}
