package com.example.demo.sentry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
public class SentryTest {

	@Bean
	public HandlerExceptionResolver sentryExceptionResolver() {
	    return new io.sentry.spring.SentryExceptionResolver();
	}
}
