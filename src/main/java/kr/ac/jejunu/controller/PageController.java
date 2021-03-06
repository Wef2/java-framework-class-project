package kr.ac.jejunu.controller;

import kr.ac.jejunu.MyUtil;
import kr.ac.jejunu.SpringClassProjectApplication;
import kr.ac.jejunu.model.Article;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.ArticleRepository;
import kr.ac.jejunu.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by neo-202 on 2016-06-07.
 */

@Controller
@SessionAttributes("userId")
public class PageController {

    private final static Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping("/")
    public String home(Model model, HttpSession httpSession) {
        User user = new User();
        if (httpSession.getAttribute("userId") != null) {
            String id = (String) httpSession.getAttribute("userId");
            user = userRepository.findOne(id);
        }
        List<Article> articleList = (List<Article>) articleRepository.findAll(new Sort(Sort.Direction.DESC, "date"));
        model.addAttribute("user", user);
        model.addAttribute("articles", articleList);
        return "home";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping("/modification")
    public String modification(Model model, HttpSession httpSession) {
        String id = (String) httpSession.getAttribute("userId");
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        return "modification";
    }

    @RequestMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping("/write")
    public String write(Model model) {
        model.addAttribute("article", new Article());
        return "write";
    }

    @RequestMapping(value = "/user/{id}/profile")
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        String imagePath = userRepository.findOne(id).getImageFileName();
        File image = new File(SpringClassProjectApplication.ROOT + "/" + imagePath);
        byte[] bytes = new byte[0];
        try {
            bytes = MyUtil.getBytesFromFile(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }

}
