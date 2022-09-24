package Diary.demo.service;

import Diary.demo.domain.*;
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

//    public List<PostForm> findAll(Search search){
//        return postRepository.findAll(search);
//    }
    public PagingResponse<PostForm> findAll(Search search){
        int count = postRepository.count(search);
        Pagination pagination = new Pagination(count, search);
        search.setPagination(pagination);

        List<PostForm> list = postRepository.findAll(search);
        return new PagingResponse<>(list, pagination);
    }

    public PostForm findById(String postId) {
        return postRepository.findById(postId);
    }

    public int count(Search search){
        return postRepository.count(search);
    }

}
