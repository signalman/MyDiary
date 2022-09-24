package Diary.demo.repository;

import Diary.demo.domain.Post;
import Diary.demo.domain.PostForm;
import Diary.demo.domain.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PostRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public PostRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(String title, String content, String date, int memberId) {
        String sql = "insert into post (title, content, createdAt, memberId) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, title, content, date, memberId);
    }

    public List<PostForm> findAll(Search search){
        String sql = "select post.id, post.title, post.createdAt, post.content, member.name from post " +
                "join member on member.id=post.memberId " +
                "order by id desc limit ?, ?;";
        return jdbcTemplate.query(sql, postRowMapper(), search.getPagination().getLimitStart(), search.getRecordSize());
    }
    private RowMapper<PostForm> postRowMapper(){
        return (rs, rowNum) -> {
            PostForm postForm = new PostForm();
            postForm.setTitle(rs.getString("title"));
            postForm.setId(rs.getInt("id"));
            postForm.setContent(rs.getString("content"));
            postForm.setMemberName(rs.getString("name"));
            postForm.setCreateAt(rs.getString("createdAt"));
            return postForm;
        };
    }

    public int count(Search search){
        String sql = "select count(*) from post";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public PostForm findById(String postId) {
        String sql = "select post.id, post.title, post.createdAt, post.content, member.name from post join member on member.id=post.memberId where post.id = ?";
        return jdbcTemplate.queryForObject(sql, postRowMapper(), postId);
    }
}
