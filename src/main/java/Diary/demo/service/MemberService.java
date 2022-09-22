package Diary.demo.service;

import Diary.demo.domain.Member;
import Diary.demo.domain.SignUpForm;
import Diary.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Optional<Member> login(String uid, String password){
        return memberRepository.findByUidAndPw(uid, password);
    }
    public void signUp(String uid, String password, String name, String phone){
        memberRepository.save(uid, password, name, phone);
    }
}
