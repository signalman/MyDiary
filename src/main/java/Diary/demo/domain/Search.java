package Diary.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Search {
    private int page; //현재 페이지
    private int recordSize; //보여줄 데이터 개수
    private int pageSize; //전체 페이지 사이즈
    private String keyword;
    private String searchType;
    private Pagination pagination;

    public Search(){
        this.page = 1;
        this.recordSize = 10;
        this.pageSize = 10;
    }
    public int getOffset(){
        return (page - 1) * recordSize;
    }
}
