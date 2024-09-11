package com.springrest.springrest.controller;

import com.springrest.springrest.entity.Blog;
import com.springrest.springrest.server.BlogServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
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
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blogDetails) {
        Blog updatedBlog = blogServer.updateBlog(id, blogDetails);
        return ResponseEntity.ok(updatedBlog);
    }

    // Delete Blog
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
        blogServer.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/blogs")
    public List<Blog> getAllBlogs(){
    	return blogServer.getAllBlogs();    		
    }
} 
