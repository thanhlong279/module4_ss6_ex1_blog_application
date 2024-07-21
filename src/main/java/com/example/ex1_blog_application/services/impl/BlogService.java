package com.example.ex1_blog_application.services.impl;

import com.example.ex1_blog_application.models.Blog;
import com.example.ex1_blog_application.repositories.IBlogRepository;
import com.example.ex1_blog_application.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        if(blog.getId() != null && blogRepository.existsById(blog.getId())) {
            blogRepository.save(blog);
        }else{
            throw new IllegalArgumentException("blog not found");
        }
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }
}
