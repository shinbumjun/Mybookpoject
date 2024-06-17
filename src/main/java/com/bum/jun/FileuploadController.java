package com.bum.jun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bum.jun.dto.Fileupload;

@Controller
public class FileuploadController {

	// 파일 업로드 폼
	@GetMapping("/Fileupload01.do")
	public ModelAndView getAllBooks1() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("Fileupload01");
		return mv;
	}
	
	/**
	 * 파일 업로드 폼
	 * @return 신범준
	 */
	@GetMapping("/fileupload01.do")
	public ModelAndView fileupload01() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("Fileupload01");
		return mv;
	}
	
	/**
	 * 파일 업로드 하기
	 * name
	 * subject
	 * filename
	 * @return 신범준
	 */
	@PostMapping("/fileupload01.do")
	public ModelAndView fileupload02(@ModelAttribute Fileupload file) {
		ModelAndView mv = new ModelAndView();
		
		// Fileupload [name=신범준, subject=파일 업로드, filename=MultipartFile[field="filename", 
		//             filename=2024-06-11 15 15 23.png, contentType=image/png, size=48911]]
		System.out.println("파일 업로드 : " + file);
		
		mv.addObject("file", file);
		mv.setViewName("file");
		
		return mv;
	}
}