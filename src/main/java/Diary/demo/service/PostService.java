package Diary.demo.service;

import Diary.demo.domain.Post;
import Diary.demo.domain.PostForm;
import Diary.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void save(String title, String content, String date, int memberId) {
        postRepository.save(title, content, date, memberId);
    }

    public List<PostForm> findAll(){
        return postRepository.findAll();
    }

    public PostForm findById(String postId) {
        return postRepository.findById(postId);
    }
}
