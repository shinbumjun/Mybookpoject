package com.bum.jun.dao;

import java.util.List;

import com.bum.jun.dto.PostDto;

public interface BoardDao {

	int createPost(PostDto postDto);

	List<PostDto> getPostList();

}
