package Diary.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Comment {
    @Id
    private int id;
    private int memberId;
    private String content;
    private int postId;
    private String createAt;
}
