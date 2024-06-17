package com.bum.jun;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bum.jun.dto.PostDto;
import com.bum.jun.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService BService;
	
	/**
	 * 게시판 이동
	 * @return 신범준
	 */
	@GetMapping("/board.do")
	public ModelAndView board() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board");
		
		return mv;
	} 
	
	/**
	 * 게시글 이동
	 * @return 신범준
	 */
	@GetMapping("/boardList.do")
	public ModelAndView boardList() {
		
		ModelAndView mv = new ModelAndView();
		
		// 게시글 리스트
		List<PostDto> postList = BService.getPostList();
		System.out.println("게시글 리스트 : " + postList);
		
		mv.addObject("postList", postList);
		mv.setViewName("boardList");
		
		return mv;
	} 
	
	/**
	 * 신규 글 작성
	 * 
	 * @return 신범준
	 */
	@GetMapping("/writePost.do")
	public ModelAndView writePost() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("writePost");
		
		return mv;
	} 
	
	/**
	 * readPost.do?num=${post.num}
	 * 
	 * @return 신범준
	 */
	@GetMapping("/readPost.do")
	public ModelAndView readPost(int num) {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("게시판 번호 : " + num);
		PostDto read = BService.readPost(num);
		
		mv.addObject("read", read);
		mv.setViewName("readPost");
		
		return mv;
	} 
	
	/**
	 * 게시글 작성
	 * @return 신범준
	 */
	@PostMapping("/createPost.do")
	public ModelAndView createPost(PostDto postDto) {
		ModelAndView mv = new ModelAndView();
		
		// PostDto [num=0, title=제목, writer=작성자, content=내용, regDate=null]
		System.out.println("게시글 작성 : " + postDto);
		int cnt = BService.createPost(postDto);
		
		if(!(cnt == 1)) {
			System.out.println("게시글 실패 성공 : " + cnt);
		}
		
		// 게시글 리스트
		List<PostDto> postList = BService.getPostList();
		System.out.println("게시글 리스트 : " + postList);
		
		mv.addObject("postList", postList);
		mv.setViewName("boardList");
		return mv;
	} 
	
	/**
	 * 게시글 삭제 처리
	 */
	@GetMapping("/deletePost.do")
	public ModelAndView deletePost(int num) {
	    ModelAndView mv = new ModelAndView();
	    int cnt = BService.deletePost(num);
	    
	    if (cnt != 1) {
	        System.out.println("게시글이 삭제되지 않았습니다: " + cnt);
	        mv.addObject("msg", "게시글이 삭제되지 않았습니다");
	    } else {
	        System.out.println("게시글이 삭제 되었습니다: " + cnt);
	        mv.addObject("msg", "게시글이 삭제되었습니다");
	    }
	    
	    System.out.println("게시글이 삭제 되었습니다" + cnt);
	    
	    // 삭제 후 게시글 리스트 다시 조회
	    List<PostDto> postList = BService.getPostList();
	    mv.addObject("postList", postList);
	    mv.setViewName("boardList");
	    return mv;
	}
	
	
	
	
}


