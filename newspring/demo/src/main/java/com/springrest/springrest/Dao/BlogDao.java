package com.springrest.springrest.Dao;

import com.springrest.springrest.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BlogDao extends JpaRepository<Blog, Long> {
    List<Blog> findByUserId(String userId);
}