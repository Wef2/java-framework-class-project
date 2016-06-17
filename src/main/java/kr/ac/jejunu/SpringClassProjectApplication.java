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

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringClassProjectApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringClassProjectApplication.class);

    public static String ROOT = "profile_images";

    public static Random random = new Random();
    public static int numberOfRandomImages = 4;
    public static int numberOfRandomUsers = 10;
    public static int numberOfRandomArticles = 100;

    public static void main(String[] args) {
        SpringApplication.run(SpringClassProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(UserRepository userRepository, ArticleRepository articleRepository) {

        new File(ROOT).mkdir();

        for (int i = 1; i <= numberOfRandomUsers; i++) {
            userRepository.save(new User("test" + i, "test123", "테스트" + i, "테스트입니다" + i, "default_profile_image" + (random.nextInt(numberOfRandomImages) + 1) + ".png"));
        }

        for (int i = 1; i <= numberOfRandomArticles; i++) {
            articleRepository.save(new Article("test" + (random.nextInt(numberOfRandomUsers) + 1), MyUtil.randomStrGenerate(20), new Date()));
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
            log.info("Image files in folder");
            log.info("-------------------------------");
            File rootFolder = new File(SpringClassProjectApplication.ROOT);
            List<String> fileNames = Arrays.stream(rootFolder.listFiles())
                    .map(f -> f.getName())
                    .collect(Collectors.toList());
            fileNames.forEach(s -> log.info(s));
        };
    }
}