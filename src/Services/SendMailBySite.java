package Services;

import java.util.Properties;  
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class SendMailBySite {  
 public  void send(String name) {  
  
  String host="smtp.gmail.com";  
  final String user="dhaker.karous@esprit.tn";//change accordingly  
  final String password="25509722";//change accordingly  
    
  String to="karousdhaker@gmail.com";//change accordingly  
  
   //Get the session object  
   Properties props = new Properties();  
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true"); 
     
   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
   try {  
     MimeMessage message = new MimeMessage(session);  
     message.setFrom(new InternetAddress(user));  
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
     message.setSubject("Pi_dev");  
     message.setText("test de l'api mail");  
       MimeMultipart multipart = new MimeMultipart("related");
         // first part (the html)
         BodyPart messageBodyPart = new MimeBodyPart();
         String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
         messageBodyPart.setContent(htmlText, "text/html");
         // add it
         multipart.addBodyPart(messageBodyPart);
         // second part (the image)
         messageBodyPart = new MimeBodyPart();
         DataSource fds = new FileDataSource(
            "A:/QR Code/"+name+".png");
         messageBodyPart.setDataHandler(new DataHandler(fds));
         messageBodyPart.setHeader("Content-ID", "<image>");
         // add image to the multipart
         multipart.addBodyPart(messageBodyPart);
         // put everything together
         message.setContent(multipart);
    //send the message  
     Transport.send(message);  
     System.out.println("message sent successfully...");  
     } catch (MessagingException e) {e.printStackTrace();} 
 }  
}  