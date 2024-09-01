package com.springrest.springrest.controller;

import com.springrest.springrest.entity.Blog;
import com.springrest.springrest.server.BlogServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {

    @Autowired
    private BlogServer blogServer;

    @PostMapping("/create")
    public Blog createBlog(@RequestBody Blog blog) {
        return blogServer.saveBlog(blog);
    }

    @GetMapping("/user/{userId}")
    public List<Blog> getUserBlogs(@PathVariable String userId) {
        return blogServer.getBlogsByUserId(userId);
    } 
    @GetMapping("/blogs")
    public List<Blog> getAllBlogs(){
    	return blogServer.getAllBlogs();    		
    }
} 
