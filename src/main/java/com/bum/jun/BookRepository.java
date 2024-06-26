package com.bum.jun;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bum.jun.dto.Book;

@Controller
@Component
public class BookRepository {
	
    // private List<Book> listOfBooks = new ArrayList<>();
	private static List<Book> listOfBooks = new ArrayList<>();
	
    public BookRepository() {
        // 책 목록 생성 및 모델에 추가
        Book book1 = new Book("ISBN1234", "C# 프로그래밍", 27000);
        book1.setAuthor("우재남");
        book1.setDescription("C#을 처음 접하는 독자를 대상으로 일대일 수업처럼 자세히 설명한 책이다. 꼭 알아야 할 핵심 개념은 기본 예제로 최대한 쉽게 설명했으며, 중요한 내용은 응용 예제, 퀴즈, 셀프 스터디, 예제 모음으로 한번 더 복습할 수 있다.");
        book1.setPublisher("한빛아카데미");
        book1.setCategory("IT모바일");
        book1.setUnitsInStock(1000);
        book1.setReleaseDate("2022/10/06");
        book1.setImageUrl("./resources/images/prod1.jpg"); // 로컬 이미지 URL 설정

        Book book2 = new Book("ISBN1235", "자바마스터", 30000);
        book2.setAuthor("송미영");
        book2.setDescription("자바를 처음 배우는 학생을 위해 자바의 기본 개념과 실습 예제를 그림을 이용하여 쉽게 설명합니다. 자바의 이론적 개념→기본 예제→프로젝트 순으로 단계별 학습이 가능하며, 각 챕터의 프로젝트를 실습하면서 온라인 서점을 완성할 수 있도록 구성하였습니다.");
        book2.setPublisher("한빛아카데미");
        book2.setCategory("IT모바일");
        book2.setUnitsInStock(1000);
        book2.setReleaseDate("2023/01/01");
        book2.setImageUrl("./resources/images/prod2.jpg"); // 로컬 이미지 URL 설정

        Book book3 = new Book("ISBN1236", "파이썬 프로그래밍", 30000);
        book3.setAuthor("최성철");
        book3.setDescription("파이썬으로 프로그래밍을 시작하는 입문자가 쉽게 이해할 수 있도록 기본 개념을 상세하게 설명하며, 다양한 예제를 제시합니다. 또한 프로그래밍의 기초 원리를 이해하면서 파이썬으로 데이터를 처리하는 기법도 배웁니다.");
        book3.setPublisher("한빛아카데미");
        book3.setCategory("IT모바일");
        book3.setUnitsInStock(1000);
        book3.setReleaseDate("2023/01/01");
        book3.setImageUrl("./resources/images/prod3.jpg"); // 로컬 이미지 URL 설정

        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
    }

    // 책 목록을 가져오는 메소드
    public List<Book> getAllBooks() {
    	System.out.println("555555555555555555555 : " + listOfBooks);
        return listOfBooks;
    }

    // 책을 추가하는 메소드
    public void addBook(Book book) {
        listOfBooks.add(book);
    }

	@GetMapping("/books.do")
	public ModelAndView getAllBooks1() {
		ModelAndView mv = new ModelAndView();
		// commit한번 해보기2
		mv.addObject("listOfBooks", listOfBooks);
		mv.setViewName("books");
		return mv;
	}
	
	/**
	 * bookId 도서코드
	 * name 도서명
	 * unitPrice 가격
	 * author 저자
	 * publisher 출판사
	 * releaseDate 출판일 
	 * description 상세정보
	 * category 분류
	 * unitsInStock 재고수 
	 * condition 상태(New, Old, EBook)
	 * imageUrl 이미지(경로)
	 * 
	 * Book Dto 생성
	 * 
	 * @return 신범준
	 */
	// @ModelAttribute는 MultipartFile을 자동으로 매핑할 수 없기 때문에, 이미지 파일을 개별적으로 받고 이를 Book 객체에 설정하는 과정이 필요
	// 생략 @RequestParam("image") MultipartFile image
	@PostMapping("/processAddBook.do") 
	public ModelAndView processAddBook(@ModelAttribute Book newBook, HttpServletRequest request) {
		
	    // image=1.jpg 이미지 받아오기
	    MultipartFile image = newBook.getImage();
	    // MultipartFile[field="image", filename=1.jpg, contentType=image/jpeg, size=11366]
	    System.out.println("image 받아온 정보" + image); 
	    
	    // imageUrl=./resources/images/galic.jpg
	    // imageUrl=./resources/images/prod2.jpg

	    // 이미지 파일을 처리합니다.
	    if (image != null && !image.isEmpty()) {
	        try {
	            // 파일 저장 경로 설정 (실제 경로)
	            String uploadDir = "C:\\Users\\user\\minibumjun\\JSPBook\\WebContent\\resources\\images\\";
	            String imageName = image.getOriginalFilename();
	            Path path = Paths.get(uploadDir + imageName);

	            // 경로 확인
	            System.out.println("path 정보 확인" + path);

	            // 파일 저장
	            Files.createDirectories(path.getParent()); // 디렉토리가 존재하지 않으면 생성
	            Files.write(path, image.getBytes());

	            // Book 객체에 이미지 URL 설정
	            newBook.setImageUrl("./resources/images/" + imageName); 
	         // ./resources/images/1.jpg
	            System.out.println("@@@@@@@@@@@@@@@" + newBook.getImageUrl());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Book [bookId=100, name=신범준, unitPrice=10000, author=신범준, description=이미지 파일 추가해보겠습니다, publisher=한빛, 
	    //       category=판타지, unitsInStock=8, releaseDate=10월, condition=New , imageUrl=./resources/images/1.jpg]
	    System.out.println("@@@@@@추가 데이터@@@@@@" + newBook); // ok
	    System.out.println("@@@@@@전체 데이터@@@@@@" + listOfBooks); // 잘 출력되는 것은 -> ./resources/images/prod1.jpg
	    
	    // 새로운 책을 목록에 추가
	    listOfBooks.add(newBook);
	    
	    // 목록을 모델에 담아서 books.jsp로 이동
		ModelAndView mv = new ModelAndView();
		// 여기서 새로운 책 정보(newBook)를 처리하고 책 목록 페이지로 이동하는 코드 작성
		mv.addObject("listOfBooks", listOfBooks);
		// mv.setViewName("books");
		mv.setViewName("index"); // 홈 페이지로 이동
		
		return mv;
	}
	
	
	
	// 자세히 보기
    public Book getBookById(String bookId) {
        return listOfBooks.stream()
                          .filter(book -> book.getBookId().equals(bookId))
                          .findFirst()
                          .orElse(null);
    }
	// 자세히 보기 - @PathVariable 대신해서 @RequestParam 사용
    @GetMapping("/book.do")
    public ModelAndView getBookDetail(@RequestParam("id") String bookId) {
        ModelAndView mv = new ModelAndView();
        Book book = getBookById(bookId);
        
        // book 내용 출력 : Book [bookId=ISBN1234, name=C# 프로그래밍, unitPrice=27000, author=우재남, 
        // 				description=C#을 처음 접하는 독자를 대상으로 일대일 수업처럼 자세히 설명한 책이다. 꼭 알아야 할 핵심 개념은 기본 예제로 최대한 쉽게 설명했으며, 
        // 				중요한 내용은 응용 예제, 퀴즈, 셀프 스터디, 예제 모음으로 한번 더 복습할 수 있다., publisher=한빛아카데미, 
        // 				category=IT모바일, unitsInStock=1000, releaseDate=2022/10/06, condition=null]
        System.out.println("book 내용 출력 : " + book);
        
        mv.addObject("book", book);
        mv.setViewName("bookDetail");
        return mv;
    }
}
