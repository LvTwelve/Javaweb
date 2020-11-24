package service.impl;

import org.apache.naming.factory.MailSessionFactory;
import service.EmailService;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailServiceImpl implements EmailService {
    @Override
    public boolean SendEmail(String receiveEmail,String orderId,String orderTime) throws AddressException {

        //参数配置
        Properties properties = new Properties();
        //邮箱服务器
        properties.setProperty("mail.smtp.host","smtp.sina.com");
        //通信协议 - SMTP
        properties.setProperty("mail.transport.protocol","smtp");
        //密码认证
        properties.setProperty("mail.smtp.auth","true");

        //创建session对象
        Session session = Session.getInstance(properties);
        //设置输出日志
        session.setDebug(true);

        //邮件相关信息
        String emailUser = "lvtwelve@sina.com";
        String title = "Your LvTwelve Store Receipt" + orderId;
        String emailMsg = "订单信息<br/><br/>订单号："+orderId+"<br/>订单时间："+orderTime+"<br/>来源：LvTwelve Store";

        String emailHost = "smtp.sina.com";
        int emailPort = 25;
        String emailPwd = "a1f8f2a298f9b630";

        //邮件发送对象
        MimeMessage message = new MimeMessage(session);

        try {
            //发送人
            message.setFrom(new InternetAddress(emailUser));
            //接收人
            message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receiveEmail));
            //邮件 - 主题
            message.setSubject(title);
            //邮件 - 内容
            message.setContent((emailMsg),"text/html;charset=utf-8");
            //管道
            Transport transport = session.getTransport();
            //连接
            transport.connect(emailHost,emailPort, emailUser, emailPwd);
            //发送
            transport.sendMessage(message,message.getAllRecipients());
            //关闭
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return true;
    }
}
