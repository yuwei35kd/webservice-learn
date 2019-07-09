package client;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * ##报文体：
 * PRD_ID: 10111（固定值）
 * CHL_ID:1（固定值）
 * GROUP_NO:1（固定值）
 * SEND_NO:手机号（传参数）
 * SEND_CONTENT:告警内容（传参数）
 * MSG_EXP_FLAG:2（固定值）
 *
 * 交易流水号	SEQ_NO:10位数字（每次请求不重复）
 * ESB发布交易码	SERVICE_ID: msg01（固定值）
 * 请求系统号	SERVER_ID: 8069（固定值）
 * 系统号 CHANNEL_ID:8231（固定值）
 * 交易机构	BANK_CODE:	9901（固定值）
 * 交易柜员	USER_ID:01016437（固定值）
 * 交易日期	TRAN_DATE: 请求方交易日期，YYYYMMDD形式
 * 交易时间	TRAN_TIME：请求方交易时间，HHMMSS形式
 */
public class MsgSendClient {

    private static String wsdlUrl = "http://66.0.42.6:8001/EsbService/ECIFMSGTAS_CTL_MsgSendProxyService?wsdl";
    public static void main(String[] args) throws Exception{
        String ns = "http://www.jscb.com.cn/ecifmsg/ECIFMSGTAS_CTL_MsgSend/";

        String phone = args[0];
        String content = args[1];
        if(args!=null && args.length>2){
            wsdlUrl = args[2];
        }

        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPPart part = message.getSOAPPart();
        SOAPEnvelope envelope = part.getEnvelope();
        SOAPBody body = envelope.getBody();

        QName qname = new QName(ns, "TAS_CTL_MsgSendRequest", "ecif");
        SOAPBodyElement element = body.addBodyElement(qname);
        element.addChildElement("SEQ_NO").setValue(getSeqNo());
        element.addChildElement("SERVICE_ID").setValue("msg01");
        element.addChildElement("SERVER_ID").setValue("8069");
        element.addChildElement("BANK_CODE").setValue("9901");
        element.addChildElement("USER_ID").setValue("01016437");
        element.addChildElement("CHANNEL_ID").setValue("8231");
        element.addChildElement("TRAN_DATE").setValue(getTranDate());
        element.addChildElement("TRAN_TIME").setValue(getTranTime());
        element.addChildElement("PRD_ID").setValue("10111");

        SOAPElement soapElement = element.addChildElement("GROUP_SND_LIST");

        SOAPElement gele = soapElement.addChildElement("GROUP_SND");
        gele.addChildElement("CHL_ID").setValue("1");
        gele.addChildElement("GROUP_NO").setValue("01");
        gele.addChildElement("SEND_NO").setValue(phone);
        gele.addChildElement("SEND_CONTENT").setValue(packContent(content));
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

    /**
     * 生成交易流水号
     */
    private static String getSeqNo(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-","");
        return uuid.substring(0,10);
    }

    /**
     * 生成交易日期
     */
    private static String getTranDate(){
        return formatCurrentDate("YYYYMMdd");
    }

    /**
     * 生成交易时间
     */
    private static String getTranTime(){
        return formatCurrentDate("HHmmss");
    }

    /**
     * 生成当前时间 格式 YYYY-MM-DD HH:mm:ss
     */
    private static String generateCurrentTime(){
        return formatCurrentDate("YYYY-MM-DD HH:mm:ss");
    }

    private static String formatCurrentDate(String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }

    /**
     * 封装短信内容，按照下面格式处理
     *
     * 2#应用系统#1#警告#3#性能指标#ZABBIX监控系统#<告警内容>#YYYY-MM-DD HH:mm:ss#1#8231####
     */
    private static String packContent(String content){
        StringBuffer sb = new StringBuffer();
        sb.append("2#应用系统#1#警告#3#性能指标#ZABBIX监控系统#").
                append(content+"#").append(generateCurrentTime()).append("#1#8231####");
        return sb.toString();
    }

}
