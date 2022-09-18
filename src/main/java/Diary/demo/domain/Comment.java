package Diary.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Comment {
    private int id;
    private int memberId;
    private String content;
    private int postId;
    private String createAt;
}
