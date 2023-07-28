package com.kandlekeep.kandlekeep.util;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageConfig implements WebMvcConfigurer {

	@Bean
	public LocaleResolver localeResolver() {
		System.out.println("MessageConfig.localeResolver()");
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		slr.setLocaleAttributeName("session.current.locale");
		slr.setTimeZoneAttributeName("session.current.timezone");
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		System.out.println("MessageConfig.localeChangeInterceptor()");
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		return localeChangeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("MessageConfig.addInterceptors()");
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean("messageSource")
	public MessageSource messageSource() {
		System.out.println("MessageConfig.messageSource()");
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("languages/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}
