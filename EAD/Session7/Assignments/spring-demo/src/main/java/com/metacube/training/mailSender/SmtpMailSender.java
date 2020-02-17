package com.metacube.training.mailSender;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("smtpmailsender")
//@Primary
public class SmtpMailSender implements MailSender {
	
	@Override
	public void sendMail()
	{
		System.out.println("MAIL SENT!!! ");
	}
}
