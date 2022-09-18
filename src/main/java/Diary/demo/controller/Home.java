package Diary.demo.controller;

import Diary.demo.domain.Member;
import Diary.demo.repository.MemberRepository;
import Diary.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.WebServlet;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@WebServlet
public class Home {
    private final MemberService memberService;

    @PostMapping("login")
    public ModelAndView loginComp(@RequestParam String uid, String password) {
        //로그인을 검증하는 로직?
        ModelAndView mv = new ModelAndView();
        if(memberService.login(uid, password).isPresent()){
            mv.setViewName("index");
        }
        else{
            mv.setViewName("login");
            mv.addObject("message", "error");
        }
        return mv;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("signup")
    public String signUp(){
        return "signup";
    }
    @PostMapping("signup")
    public String signUp(@RequestParam String uid, String password, String name, String phone){
        Member member = new Member();
        member.setUid(uid);
        member.setPassword(password);
        member.setName(name);
        member.setPhone(phone);
        memberService.signUp(member);
        return "index";
    }
    @GetMapping("hello")
    public String a(){
        return "hello";
    }
}
