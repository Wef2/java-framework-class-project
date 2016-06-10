package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by neo-202 on 2016-06-07.
 */

@Controller
public class PageController {

    @RequestMapping("/")
    public String home(){
        return "board";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/board")
    public String board(){
        return "board";
    }

    @RequestMapping("/modification")
    public String modification(){
        return "modification";
    }

    @RequestMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

}
