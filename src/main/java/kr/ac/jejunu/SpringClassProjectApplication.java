package kr.ac.jejunu;

import kr.ac.jejunu.model.Article;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.ArticleRepository;
import kr.ac.jejunu.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringClassProjectApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringClassProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringClassProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository, ArticleRepository articleRepository) {
        for (int i = 1; i <= 10; i++) {
            userRepository.save(new User("test" + i, "test123", "테스트" + i, "테스트입니다" + i));
        }

        for (int i = 1; i <= 50; i++) {
            articleRepository.save(new Article("test1", String.valueOf(Math.random()), new Date()));
        }

        return (args) -> {
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User user : userRepository.findAll()) {
                log.info(user.toString());
            }
            log.info("Articles found with findAll():");
            log.info("-------------------------------");
            for (Article article : articleRepository.findAll()) {
                log.info(article.toString());
            }
        };
    }
}