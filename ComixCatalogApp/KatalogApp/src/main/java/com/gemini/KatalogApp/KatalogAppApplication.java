package com.gemini.KatalogApp;

import com.gemini.KatalogApp.service.FileHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@SpringBootApplication
public class KatalogAppApplication implements CommandLineRunner {

	@Autowired
	private FileHandlingService fileHandlingService;

	public static void main(String[] args){SpringApplication.run(KatalogAppApplication.class, args);}

	@Override
	public void run(String... args) throws Exception {
	}

	@Configuration
	@EnableWebMvc
	public class WebConfig extends WebMvcConfigurerAdapter {

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler(
					"/static/**",
					"/webjars/**",
					"/img/**",
					"/css/**",
					"/static/js/**")
					.addResourceLocations("classpath:/static/");
		}

		@Bean
		public ViewResolver getViewResolver() {
			InternalResourceViewResolver resolver = new InternalResourceViewResolver();
			resolver.setPrefix("/WEB-INF/");
			resolver.setSuffix(".html");
			return resolver;
		}
	}
}
