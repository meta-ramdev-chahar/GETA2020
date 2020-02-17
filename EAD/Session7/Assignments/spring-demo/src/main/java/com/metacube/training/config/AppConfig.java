package com.metacube.training.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.training.mailSender.MockMailSender;
import com.metacube.training.mailSender.SmtpMailSender;

@Configuration
public class AppConfig 
{

	@Bean("mock")	
	public MockMailSender mockMailSender() 
	{
		return new MockMailSender();
	}
	
	@Bean("smtp")
	public SmtpMailSender smtpMailSender() 
	{
		return new SmtpMailSender();
	}
}
