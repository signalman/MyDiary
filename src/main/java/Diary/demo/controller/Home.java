package Diary.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {

    @GetMapping("/")
    public String home(){
        return "index.html";
    }
    @PostMapping("/login")
    public String loginComp(@RequestParam String uid, String password){
        //로그인을 검증하는 로직?

        return "index.html";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signUp(){
        return "signup";
    }
}
