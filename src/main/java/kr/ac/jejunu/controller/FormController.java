package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.Article;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.ArticleRepository;
import kr.ac.jejunu.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by neo-202 on 2016-06-08.
 */
@Controller
public class FormController {

    private final static Logger logger = LoggerFactory.getLogger(FormController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user) {
        userRepository.save(user);
        logger.info(userRepository.findAll().toString());
        return "redirect:board";
    }

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public String saveArticle(@ModelAttribute Article article){
        articleRepository.save(article);
        return "redirect:board";
    }
}