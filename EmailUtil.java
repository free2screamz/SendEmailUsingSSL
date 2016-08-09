package com.sendEmail;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {

	
	public static void sendEmail(Session session,String toEmail,String subject,String body){
		try{
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type","text/HTML;charset- UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("***********@gmail.com","Hello-Testing"));
			msg.setReplyTo(InternetAddress.parse("***********@gmail.com", false));
			msg.setSubject(subject,"UTF-8");
			msg.setText(body,"UTF-8");
			msg.setSentDate(new Date());
			
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is Ready");
			Transport.send(msg);
			
			System.out.println("Email Sent successfully!");
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * Utility Method to send Email with the attachment
	 */
	public static void sendAttachmentEmail(Session session,String toEmail,String subject,String body){
		try{
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type","text/HTML; charset=UTF-8");
			msg.addHeader("format","flowed");
			msg.addHeader("Content-Transfer-Encoding", "8-bit");
			msg.setFrom(new InternetAddress("*********@gmail.com","NoReply - Testing Phase Only"));
			msg.setReplyTo(InternetAddress.parse("**********@gmail.com",false));
			
			msg.setSubject(subject,"UTF-8");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail,false));
			
			//creating the msg bodyPart
			BodyPart msgBodyPart = new MimeBodyPart();
			//Fill the message
			msgBodyPart.setText(body);
			
			//creating the Multipart message  for attachment
			Multipart multipart = new MimeMultipart();
			//Set text message part
			multipart.addBodyPart(msgBodyPart);
			//setting the attachment part
			msgBodyPart = new MimeBodyPart();
			String fileName = "************";//please provide the path for attachment file
			DataSource source = new FileDataSource(fileName);
			msgBodyPart.setDataHandler(new DataHandler(source));
			msgBodyPart.setFileName(fileName);
			multipart.addBodyPart(msgBodyPart);
			//Send the complete message part
			msg.setContent(multipart);
			//Send the message
			Transport.send(msg);
			System.out.println("Email Sent successfully with attachment");
			
			
			
			
			
		}catch(MessagingException e){
			e.printStackTrace();
		}
		catch(UnsupportedEncodingException e){
			e.printStackTrace();
			
		}
		
		
	}
	
	
}
