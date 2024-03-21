package com.effort.nxt.util;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

	
	public static void sendEmail(String to, String subject, String body) {
		
          // Configure mail properties
		  Properties properties = new Properties();
//	      properties.put("mail.smtp.host", "smtp.gmail.com");
//	      properties.put("mail.smtp.port", "587");	   
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.starttls.enable", "true");
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.port", "587");      
	      
        Session session2 = Session.getInstance(properties, new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication("srinivas.maddy@spoors.in", "Darlingsri");
           }
       });
	   
	   try {
           // Create message
           Message message = new MimeMessage(session2);
           message.setFrom(new InternetAddress("srinivas.maddy@spoors.in"));
           message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
           message.setSubject(subject);
           message.setText(body);

           // Send message
           Transport.send(message);

           System.out.println("Email sent successfully!");

       } catch (MessagingException e) {
           e.printStackTrace();
       }
	   
	 
	}
	
}
