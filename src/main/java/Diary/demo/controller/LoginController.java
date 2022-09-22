package Diary.demo.controller;

import Diary.demo.domain.LoginForm;
import Diary.demo.domain.Member;
import Diary.demo.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @GetMapping
    public String loginForm(@ModelAttribute("loginForm") LoginForm form){
        return "login";
    }

    @PostMapping
    public String login(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request){

        if(bindingResult.hasErrors()){
            return "login";
        }
        Member loginMember = loginService.login(form.getUid(), form.getPassword());
        if(loginMember == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            return "login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginMember);

        return "redirect:/";
    }

}
