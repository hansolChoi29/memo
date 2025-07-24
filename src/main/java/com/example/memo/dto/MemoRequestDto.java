package com.example.memo.dto;

import lombok.Getter;

@Getter
// 요청데이터를 처리하는 객체
public class MemoRequestDto {
// 요청받을 데이터는 title, contents임
    private String title;
    private String contents;



}
