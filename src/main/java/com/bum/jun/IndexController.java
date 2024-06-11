package com.bum.jun;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Book;

@Controller
public class IndexController {

	@Autowired
    private final BookRepository bookRepository;

    @Autowired
    public IndexController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("IndexController initialized.");
    }

    // 홈 화면
    @GetMapping("/index.do")
    public ModelAndView loginForm() {
        ModelAndView mv = new ModelAndView();

        // BookRepository에서 책 목록 가져오기
        // mv.addObject("listOfBooks", bookRepository.getAllBooks());
        // [Book [bookId=ISBN1234, name=C# 프로그래밍, unitPrice=27000, author=우재남, description=C#을 처음...
        // System.out.println("@@@@@@@@@@@@@@@@@@@@@@ : " + bookRepository.getAllBooks());
        
        // BookRepository에서 책 목록 가져오기
        List<Book> listOfBooks = bookRepository.getAllBooks();
        
        // Book 목록을 순회하면서 description을 처리
        for (Book book : listOfBooks) {
            if (book.getDescription() != null && book.getDescription().length() > 60) {
                book.setDescription(book.getDescription().substring(0, 60) + "...");
            }
        }
        mv.addObject("listOfBooks", listOfBooks);
        // [Book [bookId=ISBN1234, name=C# 프로그래밍, unitPrice=27000, author=우재남, description=C#을 처음...
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@ : " + listOfBooks);
        
        mv.setViewName("index");

        return mv;
    }
}



