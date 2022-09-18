package Diary.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Post {
    private int id;
    private String title;
    private String createAt;
    private int memberId;
    private String content;
}
