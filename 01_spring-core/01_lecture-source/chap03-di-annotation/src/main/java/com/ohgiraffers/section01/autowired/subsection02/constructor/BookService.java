package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceConstructor")
public class BookService {

    private final BookDAO bookDAO;

    //@Autowired, 스프링이 없어도 작동 가능(테스트 가능)
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> findAllBooks() {

        return bookDAO.findAllBooks();
    }

    public BookDTO findBookBySeq(int seq) {

        return bookDAO.findBookBySeq(seq);
    }
}
