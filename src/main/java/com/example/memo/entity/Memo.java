package com.example.memo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Memo {

    //식별자 사용 시 Long 많이 사용함
    private Long id;
    private String title;
    private String contents;


}
