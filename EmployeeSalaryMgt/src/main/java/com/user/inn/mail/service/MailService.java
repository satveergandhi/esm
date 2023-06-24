package com.user.inn.mail.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.user.mail.model.Mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import java.text.SimpleDateFormat;  
import java.util.Date;  

@Service
public class MailService{
	@Autowired
	private JavaMailSender javaMailSender;
	
	  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	  Date date = new Date();  
	  String todayDate = formatter.format(date);
	  
	public void SendMail(Mail mail){
		 try {
		 SimpleMailMessage msg = new SimpleMailMessage();
		 msg.setTo(mail.getEmail());
		 msg.setSubject("Salary Credited");
		 msg.setText("Dear "+mail.getName()+",\n"+" Your Salary "+mail.getSalary()+"was credited on "+todayDate);
		 
		 javaMailSender.send(msg);
		 
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
	}
}
