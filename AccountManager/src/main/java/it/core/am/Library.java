package it.core.am;
/*
 * This Java source file was auto generated by running 'gradle buildInit --type java-library'
 * by '10035848' at '27/09/16 11.08' with Gradle 2.14.1
 *
 * @author 10035848, @date 27/09/16 11.08
 */

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class Library  extends WebMvcConfigurerAdapter
{
	private Locale localLanguage = Locale.US;
	 
	public static void main(String[] args) 
	{
		Library l = new Library();
		l.setLocalLanguage(("IT".equals(args[0]) ? Locale.ITALY : Locale.US));
        
		SpringApplication.run(l.getClass(), args);
    }

	public void addViewControllers(ViewControllerRegistry registry) 
	{
	    registry.addViewController("/login").setViewName("login");
	}
	
	@Bean
	public LocaleResolver localeResolver() 
	{
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    
	    slr.setDefaultLocale(getLocalLanguage());
	    
	    return slr;
	}
	
	

	public Locale getLocalLanguage() {
		return localLanguage;
	}

	public void setLocalLanguage(Locale localLanguage) {
		this.localLanguage = localLanguage;
	}

	@Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
	
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
	
	public boolean someLibraryMethod() {
		
		return true;
	}
}
