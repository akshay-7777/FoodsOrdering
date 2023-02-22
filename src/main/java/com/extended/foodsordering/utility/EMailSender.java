package com.extended.foodsordering.utility;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.extended.foodsordering.bean.Email;

import jakarta.mail.internet.MimeMessage;

@Service
public class EMailSender {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String toEmail, String toSubject, String body) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("akshay.nasree7@gmail.com");
		simpleMailMessage.setTo(toEmail);
		simpleMailMessage.setSubject(toSubject);
		simpleMailMessage.setText(body);
		try {
			javaMailSender.send(simpleMailMessage);
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println("Email send successfully....");
	}
	
	public String sendEmailWihAttachment(Email email) {
		try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("akshay.nasree7@gmail.com");
            mimeMessageHelper.setTo(email.getTo());
            mimeMessageHelper.setSubject(email.getSubject());
            mimeMessageHelper.setText(email.getBody());
            FileSystemResource fileSystemResource = new FileSystemResource(new File(email.getAttachment()));
            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
            javaMailSender.send(mimeMessage);
            return "mail sent";
            } catch (Exception ex) {
            return "sending failed";
            }
	}
}
