package biz.module2;
import javax.mail.*;
import javax.mail.internet.*;



import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class mail {

    public static void main(String[] args) {

        final String fromEmail = "ankita@biz-insights.com"; // change accordingly
        final String password = "Heeva5387"; // change accordingly
        final String toEmail = "krunal@biz-insights.com"; // change accordingly
        final String filePath = "./src/test/java/files/test.xlsx"; // change accordingly

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getInstance(properties, authenticator);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Sending email with attachment using JavaMail");

            // Body
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Attached is the Excel file.");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Attachment
            messageBodyPart = new MimeBodyPart();
            FileDataSource fileDataSource = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(fileDataSource));
            messageBodyPart.setFileName(fileDataSource.getName());
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully with attachment!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
