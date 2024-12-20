package com.springrest.springrest.server;

import com.springrest.springrest.Dao.BlogDao;
import com.springrest.springrest.entity.Blog;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServerImpl implements BlogServer{

    @Autowired
    private BlogDao blogdao;

    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {
        return blogdao.save(blog);
    }

    @Transactional
    @Override
    public List<Blog> getBlogsByUserId(String userId) {
        return blogdao.findByUserId(userId);
    }

    @Transactional
	@Override
	public List<Blog> getAllBlogs() {
		return blogdao.findAll();
	}

	@Override
	public Blog updateBlog(Long id, Blog blogDetails) {
		// TODO Auto-generated method stub
		blogDetails.setId(id);
		blogdao.save(blogDetails);
		return null;
	}

	@Override
	public void deleteBlog(Long id) {
		// TODO Auto-generated method stub
		blogdao.deleteById(id);
		
	}
    
} 
