package Diary.demo.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotEmpty
    @Length(min = 3, max= 20)
    private String uid;

    @NotEmpty
    private String password;
}
