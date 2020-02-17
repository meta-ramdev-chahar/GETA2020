package com.metacube.training.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.training.mailSender.MailSender;
import com.metacube.training.mailSender.MockMailSender;
import com.metacube.training.mailSender.SmtpMailSender;

@RestController
public class MailController 
{	

	//@Autowired
	//@Qualifier("smtpmailsender")
	private MailSender mailSender;
	/**
    public MailController() 
    {
    	MailSender smtp = new SmtpMailSender();
    	this.mailSender = smtp;
	}
	*/
	@Autowired
	public void setMailSender(MailSender mock) 
	{
		this.mailSender = mock;
	}
	
	@GetMapping("/send") 
	public String sendMail()
	{			
		mailSender.sendMail();
		return "Mail Done";
	}		
}

