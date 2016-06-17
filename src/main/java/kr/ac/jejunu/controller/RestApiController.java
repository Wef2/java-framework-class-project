package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.Article;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.ArticleRepository;
import kr.ac.jejunu.repository.RecommendationRepository;
import kr.ac.jejunu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<?> user(@PathVariable String id) {
        User user = userRepository.findOne(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/articles")
    Iterable<Article> articleList() {
        return articleRepository.findAll(new Sort(Sort.Direction.DESC, "date"));
    }

    @RequestMapping(value = "/articles/page/{page}")
    ResponseEntity<?> articlePage(@PathVariable int page) {
        Page<Article> articles = articleRepository.findAll(new PageRequest(page, 10, Sort.Direction.DESC, "date"));
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

}