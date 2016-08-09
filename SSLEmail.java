package com.sendEmail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SSLEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String fromEmail = "**********@gmail.com";//please provide actual sender's email
		final String password = "********";// please provide actual password
		final String toEmail = "***********@gmail.com";//please provide actual sender's email
		
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host","smtp.gmail.com");//SMTP HOST
		props.put("mail.smtp.socketFactory.port","465"); // SSL Port
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//SSLSocketFactory class
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.port", "465");
		
		Authenticator auth = new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(fromEmail,password);
			}
			
		};
		Session session = Session.getDefaultInstance(props, auth);
		EmailUtil.sendAttachmentEmail(session, toEmail, "Testing email Program", "Testing@ an email with attachment using java Program");
		
		
		
		
		

	}

}
