package com.extended.foodsordering.controller;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.extended.foodsordering.bean.Email;
import com.extended.foodsordering.utility.EMailSender;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class SendController {
	
	@Autowired
	private EMailSender eMailSender;
	
    final private String sid="AC3c62d5f36a8743d5d1e997d9cb8bdfed";
    final private String auth="6f5770cb4a3da6e3fffc41c04964fd5f";
    final private String number="+14097976131";

	 @GetMapping("/sendSMS")
	    public String sendSMS() {
	        Twilio.init(sid, auth);
	        Message.creator(new PhoneNumber("+91 9713483633"), new PhoneNumber(number), "otp 980908").create();
	        return ("Message sent successfully");
	    }
		
	 @PostMapping("/sendAttachment")
	 public String sendAttachment(@RequestBody Email email) {
		 return eMailSender.sendEmailWihAttachment(email);
	 }
	 
	 
	 @GetMapping("/generateOTP")
	    public String generateOTP(){
		 Random random = new Random();
		 int randomNumber = random.nextInt(1000000);
		 if(randomNumber<100000) {
			 randomNumber+=100000;
		 }
		 String otp = Integer.toString(randomNumber);
		 Twilio.init(sid, auth);
	        Message.creator(new PhoneNumber("+91 9713483633"), new PhoneNumber(number),"otp for your order "+otp).create();
	        return ("Otp sent successfully");
		 
	 }
	 
	 @GetMapping("/sendmail")
	 public String sendEmail() {
		 eMailSender.sendEmail("akshay.nasree7@gmail.com", "Insert Successful", "Your data is insert into table");
		 return "mail";
	 }
		
		
		
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 


	 
	 /*
		@EventListener(ApplicationReadyEvent.class)
	    public void sendEmail() {
			eMailSender.sendEmail("akshay.nasree7@gmail.com", "Successful send mail",  "Body");
			}*/
		 
}
