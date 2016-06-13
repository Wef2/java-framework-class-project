package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by neo-202 on 2016-06-07.
 */

@Controller
@SessionAttributes("user")
public class PageController {

    private final static Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("/")
    public String home() {
        return "board";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping("/modification")
    public String modification(Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        model.addAttribute("user", user);
        return "modification";
    }

    @RequestMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

}
