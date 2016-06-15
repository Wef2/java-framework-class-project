package kr.ac.jejunu.controller;

import kr.ac.jejunu.SpringClassProjectApplication;
import kr.ac.jejunu.model.Article;
import kr.ac.jejunu.model.Recommendation;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.ArticleRepository;
import kr.ac.jejunu.repository.RecommendationRepository;
import kr.ac.jejunu.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by neo-202 on 2016-06-08.
 */
@Controller
@SessionAttributes("userId")
public class FormController {

    private final static Logger logger = LoggerFactory.getLogger(FormController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    RecommendationRepository recommendationRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getUser(@ModelAttribute User user, HttpSession httpSession) {
        try {
            User newUser = userRepository.findByIdAndPassword(user.getId(), user.getPassword());
            httpSession.setAttribute("userId", newUser.getId());
            return "redirect:/";
        } catch (NullPointerException e) {
            return "login";
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser(@RequestParam("file") MultipartFile file, @ModelAttribute User user) {
        String imageFolderPath = SpringClassProjectApplication.ROOT;
        String fileName = System.currentTimeMillis() + "_"+ file.getOriginalFilename();
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(imageFolderPath + "/" + fileName)));
                FileCopyUtils.copy(file.getInputStream(), stream);
                stream.close();
                logger.info("Successfully Uploaded : " + fileName);
            }
            catch (Exception e) {
                logger.error("Failed to upload" + fileName);
                logger.error(e.toString());
            }
        }
        user.setImagePath(fileName);
        userRepository.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/modification", method = RequestMethod.POST)
    public String modifyUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public String saveArticle(@ModelAttribute Article article, HttpSession httpSession) {
        article.setUserId((String)httpSession.getAttribute("userId"));
        article.setDate(new Date());
        articleRepository.save(article);
        return "redirect:/";
    }

    @RequestMapping(value = "/recommendation", method = RequestMethod.POST)
    public ResponseEntity<Recommendation> recommendation(@RequestParam("articleId") int articleId,
                                                         @RequestParam("value") boolean value,
                                                         HttpSession httpSession){
        String userId = (String)httpSession.getAttribute("userId");
        Recommendation recommendation = new Recommendation();
        recommendation.setArticleId(articleId);
        recommendation.setUserId(userId);
        recommendation.setValue(value);
        Recommendation newRecommendation = null;
        try{
            recommendationRepository.findByArticleIdAndUserId(articleId, userId);
            newRecommendation = recommendationRepository.update(articleId, userId, value);
            logger.info("Updated Recommendation : " + newRecommendation);
        }catch(Exception e){
            newRecommendation = recommendationRepository.save(recommendation);
            logger.info("Saved Recommendation : " + newRecommendation);
        }
        return new ResponseEntity<Recommendation>(newRecommendation, HttpStatus.OK);
    }

}