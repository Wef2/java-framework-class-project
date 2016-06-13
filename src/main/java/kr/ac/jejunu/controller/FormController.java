package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.Article;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.ArticleRepository;
import kr.ac.jejunu.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by neo-202 on 2016-06-08.
 */
@Controller
@SessionAttributes("user")
public class FormController {

    private final static Logger logger = LoggerFactory.getLogger(FormController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getUser(@ModelAttribute User user, HttpSession httpSession){
        User newUser = userRepository.findByIdAndPassword(user.getId(), user.getPassword());
        try{
            httpSession.setAttribute("user", newUser);
            return "redirect:/";
        }
        catch(NullPointerException e){
            return "login";
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user) {
        userRepository.save(user);
        logger.info(userRepository.findAll().toString());
        return "/";
    }

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public String saveArticle(@ModelAttribute Article article){
        articleRepository.save(article);
        return "/";
    }
}