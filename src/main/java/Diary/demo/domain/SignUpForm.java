package Diary.demo.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class SignUpForm {

    @NotEmpty(message = "아이디를 입력해주세요")
    @Length(min = 3, max= 20)
    private String uid;

    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String password;

    @NotEmpty(message = "이름을 입력해주세요")
    private String name;

    @NotEmpty(message = "전화번호를 입력해주세요")
    private String phone;


}
