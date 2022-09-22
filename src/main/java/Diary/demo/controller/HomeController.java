package Diary.demo.controller;

import Diary.demo.domain.LoginForm;
import Diary.demo.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {


    @GetMapping
    public String home(HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        if(session != null){
            Member member =  (Member) session.getAttribute("loginMember");
            model.addAttribute("loginMember", member);
        }
        return "home";
    }
}
