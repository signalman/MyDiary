package Diary.demo.controller;

import Diary.demo.domain.Member;
import Diary.demo.domain.Post;
import Diary.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.event.WindowStateListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;

    @GetMapping
    public String PostsForm(Model model, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        /**
         * TODO
         * 추후에 스프링 인터셉터로 구현해볼것!
         */
        if(session == null){
            String loginErr = "로그인을 먼저 해주세요";
            model.addAttribute("loginErr", loginErr);
            return "home";
        }
        return "post";
    }

    @PostMapping
    public String savePosts(@ModelAttribute Post post, HttpServletRequest request){

        HttpSession session = request.getSession(false);
        Member loginMember = (Member) session.getAttribute("loginMember");

        post.setCreateAt(LocalDateTime.now().toString());
        post.setMemberId(loginMember.getId());

        postService.save(post.getTitle(), post.getContent(), post.getCreateAt(), post.getMemberId());
        return "redirect:/";
    }



}
