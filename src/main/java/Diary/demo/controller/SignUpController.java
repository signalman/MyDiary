package Diary.demo.controller;

import Diary.demo.domain.Member;
import Diary.demo.domain.SignUpForm;
import Diary.demo.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
@Slf4j
public class SignUpController {

     private final MemberService memberService;

    @GetMapping
    public String signUpForm(@ModelAttribute("signupForm") SignUpForm signUpForm){
        return "signup";
    }

    @PostMapping
    public String signUp(@Validated @ModelAttribute("signupForm") SignUpForm signUpForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "signup";
        }

        memberService.signUp(signUpForm.getUid(), signUpForm.getPassword(), signUpForm.getName(), signUpForm.getPhone());
        return "redirect:/";
    }

}
