package com.example.memo.controller;


import com.example.memo.dto.MemoRequestDto;
import com.example.memo.dto.MemoResponseDto;
import com.example.memo.entity.Memo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// 데이터를 항상 JSON형태로 통신하기로 함
@RestController

@RequestMapping("/memos")

//데이터베이스에 저장하는 게 아니라 자료구조를 사용하여 임시로
//데이터를 저장할 거임
public class MemoController {

    //메모리스트라는 빈 map자료구조가 생성됨.
    private final Map<Long, Memo> memoList= new HashMap<>();

    //생성이기 때문에
    @PostMapping


    //호출해서 사용 할 컨트롤러api생성
    //() : 클라이언트로 부터 JSON 요청받았을 때 바인딩
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto dto) {

        //식별자가 1씩 증가하도록 만들어야 됨 중복불가
        Long memoId=memoList.isEmpty()? 1: Collections.max(memoList.keySet())+1;
        //Collection.max : 최대값을 뽑아내는 메서드.
        //memoList.keySet() : 메모리스트의 키값을 모두 꺼내보기.


        //요청받은 데이터로 메모 생성할거임
        //MemoRequestDto dto로 받았기 때문에 memo객체로 바꿔야 함
       Memo memo= new Memo(memoId, dto.getTitle(), dto.getContents());


        //힙메모리(임의가 아닌 자바의 map자료구조) 데이터베이스에 메모를 저장할 거임
        memoList.put(memoId, memo);

        // responseDto형태로 변환돼서 실제로 응답이 이뤄짐
        return new MemoResponseDto(memo);
    }

}
