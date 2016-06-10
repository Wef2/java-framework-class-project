package kr.ac.jejunu;

import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringClassProjectApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringClassProjectApplication.class);

	@Bean
	public CommandLineRunner demo(UserRepository userRepository) {
		return (args) -> {
			log.info("Users found with findAll():");
			log.info("-------------------------------");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringClassProjectApplication.class, args);
	}
}
