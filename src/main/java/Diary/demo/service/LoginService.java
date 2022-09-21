package Diary.demo.service;

import Diary.demo.domain.Member;
import Diary.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public Member login(String uid, String password){
        return memberRepository.login(uid, password).orElse(null);
    }
}
