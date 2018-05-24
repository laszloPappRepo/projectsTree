package gemini.superHeroAPI;
import gemini.superHeroAPI.Service.LoginValidationService;
import gemini.superHeroAPI.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication

public class SuperHeroApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SuperHeroApiApplication.class, args);
	}

	LoginValidationService loginValidationService;

	@Autowired
	AccountRepository accountRepository;

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < accountRepository.listAll().size(); i++) {
			System.out.println(accountRepository.listAll().get(i).getPassword());
		}
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
