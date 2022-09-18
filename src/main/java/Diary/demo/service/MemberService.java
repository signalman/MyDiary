package Diary.demo.service;

import Diary.demo.domain.Member;
import Diary.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    public Optional<Member> login(String uid, String password){
        return memberRepository.findByUidAndPw(uid, password);
    }
    public void signUp(Member member){
        memberRepository.save(member);
    }



}
