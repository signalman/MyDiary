package Diary.demo.repository;

import Diary.demo.domain.Member;
import Diary.demo.domain.SignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class MemberRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public MemberRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(String uid, String pw, String name, String phone){
        String sql = "insert into member(uid, password, name, phone) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, uid, pw, name, phone);
    }

    public Optional<Member> findByUidAndPw(String uid, String pw){
        String sql = "select * from member where uid = ? and password = ?";
        List<Member> result= jdbcTemplate.query(sql, memberRowMapper(), uid, pw);
        return result.stream().findAny();
    }

    public Optional<Member> findByUid(String uid){
        String sql = "select * from member where uid = ? ";
        List<Member> result = jdbcTemplate.query(sql, memberRowMapper(), uid);
        return result.stream().findAny();
    }
    public List<Member> findAll(){
        String sql = "select * from member";
        List<Member> result  = jdbcTemplate.query(sql, memberRowMapper());
        return result;
    }
    public Optional<Member> login(String uid, String password){
        String sql = "select * from member where uid = ? and password = ?";
        List<Member> result = jdbcTemplate.query(sql, memberRowMapper(), uid, password);
        return result.stream().findAny();
    }


    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setUid((rs.getString("uid")));
            member.setPassword(rs.getString("password"));
            member.setId(rs.getInt("id"));
            member.setName(rs.getString("name"));
            member.setPhone(rs.getString("phone"));
            return member;
        };
    }


}