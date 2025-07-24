package com.example.memo.entity;


import com.example.memo.dto.MemoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Memo {

    //식별자 사용 시 Long 많이 사용함
    private Long id;
    private String title;
    private String contents;


    //업데이트 메서드 만듦
    public void update(MemoRequestDto dto) {
        this.title = dto.getTitle();
        this.contents = dto.getContents();
    }

}
