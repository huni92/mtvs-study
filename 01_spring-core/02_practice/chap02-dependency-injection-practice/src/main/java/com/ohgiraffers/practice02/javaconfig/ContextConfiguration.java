package com.ohgiraffers.practice02.javaconfig;

import com.ohgiraffers.common.BoardDTO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public MemberDTO memberDTO() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(1L);
        memberDTO.setNickname("test");

        return memberDTO;
    }

    @Bean
    public BoardDTO boardDTO() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(1L);
        boardDTO.setTitle("제목2");
        boardDTO.setContent("내용222222");
        boardDTO.setWriter(memberDTO());

        return boardDTO;
    }
}
