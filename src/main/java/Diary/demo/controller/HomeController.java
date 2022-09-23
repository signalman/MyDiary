package Diary.demo.controller;

import Diary.demo.domain.Member;
import Diary.demo.domain.Post;
import Diary.demo.domain.PostForm;
import Diary.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;
    @GetMapping("/")
    public String home(HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        if(session != null){
            Member member =  (Member) session.getAttribute("loginMember");
            model.addAttribute("loginMember", member);
        }

        List<PostForm> postList = postService.findAll();
        for (PostForm postForm : postList) {
            postForm.setCreateAt(postForm.getCreateAt().substring(0,16));
        }
        model.addAttribute("postList", postList);
        return "home";
    }

    @GetMapping("/posts")
    public String postsForm(Model model, HttpServletRequest request){
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

    @PostMapping("/posts")
    public String savePosts(@ModelAttribute Post post, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Member loginMember = (Member) session.getAttribute("loginMember");

        post.setCreateAt(LocalDateTime.now().toString());
        post.setMemberId(loginMember.getId());
        postService.save(post.getTitle(), post.getContent(), post.getCreateAt(), post.getMemberId());
        return "redirect:/";
    }

    @GetMapping("/posts/{postId}")
    public String showPosts(@PathVariable String postId, Model model){
        PostForm findPost = postService.findById(postId);
        findPost.setCreateAt(findPost.getCreateAt().substring(0,16));
        model.addAttribute("findPost", findPost);
        return "post-single";
    }



















}
