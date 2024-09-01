package com.springrest.springrest.server;

import java.util.List;

import com.springrest.springrest.entity.Blog;

public interface BlogServer {

	Blog saveBlog(Blog blog);

	List<Blog> getBlogsByUserId(String userId);

	List<Blog> getAllBlogs();

	Blog updateBlog(Long id, Blog blogDetails);

	void deleteBlog(Long id);

}
