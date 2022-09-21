package Diary.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Member {
    private int id;
    private String uid;
    private String password;
    private String name;
    private String phone;
}
