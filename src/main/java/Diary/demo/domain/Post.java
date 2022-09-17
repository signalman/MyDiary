package Diary.demo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Post {
    private int id;
    private String title;
    private String createAt;
    private int memberId;
    private String content;
}
