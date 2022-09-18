package Diary.demo.controller;

import Diary.demo.domain.Member;
import Diary.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
@WebServlet
public class Home {
    private final MemberService memberService;

    @GetMapping("/")
    public String hello(@CookieValue(name="memberId", required = false) String memberId, Model model){
        model.addAttribute("memberId", memberId);
        return "index";
    }

    @PostMapping("login")
    public ModelAndView loginComp(HttpServletResponse response, @RequestParam String uid, String password) {
        ModelAndView mv = new ModelAndView();
        if(memberService.login(uid, password).isPresent()){
            Member findMember = memberService.login(uid, password).get();
            mv.setViewName("redirect:/");
            Cookie idCookie = new Cookie("memberId", String.valueOf(findMember.getUid()));
            response.addCookie(idCookie);
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
