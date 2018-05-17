package gemini.superHeroAPI;
import gemini.superHeroAPI.modell.Account;
import gemini.superHeroAPI.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@SpringBootApplication
public class SuperHeroApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SuperHeroApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

	@Configuration
	@EnableWebMvc
	public class webConfig extends WebMvcConfigurerAdapter {

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/static/**")
					.addResourceLocations("classpath:/static/");
		}
	}
}
