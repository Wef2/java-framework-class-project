package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.Article;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.ArticleRepository;
import kr.ac.jejunu.repository.RecommendationRepository;
import kr.ac.jejunu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by neo-202 on 2016-06-08.
        */
@RequestMapping("/rest")
@RestController
public class RestApiController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    RecommendationRepository recommendationRepository;

    @RequestMapping(value = "/user/{id}")
    User user(@PathVariable String id){
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/users")
    Iterable<User> userList() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/articles")
    Iterable<Article> articleList(){
        return articleRepository.findAllOrderByDate();
    }

}