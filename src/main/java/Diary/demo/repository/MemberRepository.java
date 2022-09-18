package Diary.demo.repository;

import Diary.demo.domain.Member;
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

    public void save(Member member){
        String sql = "insert into member(uid, password, name, phone) values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, member.getUid(), member.getPassword(), member.getName(), member.getPhone());
    }
    public Optional<Member> findByUidAndPw(String uid, String pw){
        String sql = "select * from member where uid = ? and password = ?";
//        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, memberRowMapper(), uid, pw));
        List<Member> result= jdbcTemplate.query(sql, memberRowMapper(), uid, pw);
//        if(result.stream().findAny().isPresent()) System.out.println("존재한다.");
//        else System.out.println("Null값이다");
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