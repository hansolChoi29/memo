package com.example.memo.dto;


import com.example.memo.entity.Memo;
import lombok.Getter;

@Getter
//응답데이터 처리하는 객체
public class MemoResponseDto {

    private Long id;
    private String title;
    private String contents;

    //생성자 만들기
    public MemoResponseDto(Memo memo) {
        this.id=memo.getId();
        this.title=memo.getTitle();
        this.contents=memo.getContents();
    }



}
