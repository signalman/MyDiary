package Diary.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
    private int id;
    private int memberId;
    private String content;
    private int postId;
    private String createAt;
}
