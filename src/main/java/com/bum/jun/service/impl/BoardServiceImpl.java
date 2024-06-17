package com.bum.jun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bum.jun.dao.BoardDao;
import com.bum.jun.dto.PostDto;
import com.bum.jun.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao BDao;
	
	@Override
	public int createPost(PostDto postDto) {
		System.out.println("게시글 작성 : " + postDto);
		int cnt = BDao.createPost(postDto);
		return cnt;
	}

	@Override
	public List<PostDto> getPostList() {
		List<PostDto> list = BDao.getPostList();
		return list;
	}

	@Override // 게시글 읽기
	public PostDto readPost(int num) { 
		PostDto read = BDao.readPost(num);
		return read;
	}

	@Override
	public int deletePost(int num) {
		int cnt = BDao.deletePost(num);
		return cnt;
	}
}





