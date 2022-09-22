package Diary.demo.service;

import Diary.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void save(String title, String content, String date, int memberId) {
        postRepository.save(title, content, date, memberId);
    }
}
