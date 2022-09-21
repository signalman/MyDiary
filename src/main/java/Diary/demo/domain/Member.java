package Diary.demo.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Member {

    private int id;

    @NotNull
    @Length(min = 3, max= 20)
    private String uid;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String phone;
}
