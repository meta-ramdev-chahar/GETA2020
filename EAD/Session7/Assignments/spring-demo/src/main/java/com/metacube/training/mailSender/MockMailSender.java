package com.metacube.training.mailSender;
import org.springframework.stereotype.Component;

//@Component("mockmailsender")
public class MockMailSender implements MailSender
{
	
	@Override
	public void sendMail()
	{
		System.out.println("MESSAGE WRITTEN");
	}
}
