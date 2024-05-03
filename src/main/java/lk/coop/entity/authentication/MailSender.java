package lk.coop.entity.authentication;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender {
    public static void sendMail(String subject, String body, List<String> mails, File att) {
        System.out.println("sending");
        String username = "coop.notification@coopinsu.com";
        String password = "Mcq%d%\"6Hv#zr3S";
        Properties props = new Properties();
        props.put("mail.smtp.host", "172.20.11.11");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("coop.notification@coopinsu.com", "Mcq%d%\"6Hv#zr3S");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("coop.notification@coopinsu.com"));
            Iterator var9 = mails.iterator();

            while(var9.hasNext()) {
                String mail = (String)var9.next();
                message.setRecipients(RecipientType.TO, InternetAddress.parse(mail));
            }

            message.setSubject(subject);
            Multipart multipart = new MimeMultipart("mixed");
            MimeBodyPart BodyPart = new MimeBodyPart();
            BodyPart.setContent(body, "text/html; charset=utf-8");
            multipart.addBodyPart(BodyPart);
            if (att != null) {
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                String file = att.getPath();
                String fileName = att.getName();
                DataSource source = new FileDataSource(file);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(fileName);
                multipart.addBodyPart(messageBodyPart);
            }

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Done");
        } catch (Exception var15) {
            var15.printStackTrace();
        }

    }
}