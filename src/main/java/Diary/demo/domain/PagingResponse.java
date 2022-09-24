package Diary.demo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO
 * 여기선 왜 ?
 * final 키워드 안쓰는지 /?
 * 왜 @RequiredArgsConstructor가 안되는지?
 * Component없어도 되는지?
 *
 * */
@Getter
public class PagingResponse<T> {
    private List<T> list = new ArrayList<>();
    private Pagination pagination;

    public PagingResponse(List<T> list, Pagination pagination) {
        this.list = list;
        this.pagination = pagination;
    }
}
