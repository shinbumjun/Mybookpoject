package com.bum.jun.service;

import java.util.List;

import com.bum.jun.dto.PostDto;

public interface BoardService {

	int createPost(PostDto postDto); // 게시글 작성

	List<PostDto> getPostList(); // 게시글 리스트

}
