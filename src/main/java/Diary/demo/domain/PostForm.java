package Diary.demo.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PostForm {
    private int id;

    @NotEmpty(message = "제목을 입력해주세요.")
    private String title;

    @NotEmpty(message = "내용을 입력해주세요.")
    private String content;

    private String createAt;

    private String memberName;
}
