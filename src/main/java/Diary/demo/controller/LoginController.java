package Diary.demo.controller;

import Diary.demo.domain.LoginForm;
import Diary.demo.domain.Member;
import Diary.demo.service.LoginService;
import Diary.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @GetMapping
    public String loginForm(){
        return "login";
    }

    @PostMapping
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "login";
        }
        Member loginMember = loginService.login(form.getUid(), form.getPassword());
        if(loginMember == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            return "login";
        }
        return "redirect:/";
    }

}
