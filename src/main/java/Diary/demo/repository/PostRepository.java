package Diary.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class PostRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public PostRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

}
