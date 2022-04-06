package com.PC00466_VoDangKhoa_ASM_java4.helper;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailHelper {
public void SendcodeEmail(String userEmail , int rdCode) {
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		String username = "deathhell1234m@gmail.com";
		String password = "cajytpszdtujczay";
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
					
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
			message.setSubject("Code quên mật khẩu của bạn ");
	        message.setText("Code của bạn là:" + rdCode);
	        message.setReplyTo(message.getFrom());
	        Transport.send(message);
	        System.out.println("Email was send");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
