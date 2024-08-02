package com.ohgiraffers.practice02.javaconfig;

import com.ohgiraffers.common.BoardDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public BoardDTO getBoard() {
        return new BoardDTO(2L, "제목2", "내용2내용2내용2내용2내용2내용2", "작성자2");
    }
}
