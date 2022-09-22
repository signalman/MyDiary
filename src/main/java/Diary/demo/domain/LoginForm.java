package Diary.demo.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotEmpty(message = "공백은 입력할 수 없습니다.")
    private String uid;

    @NotEmpty(message = "공백은 입력할 수 없습니다.")
    private String password;
}
