package com.example.ex1_blog_application.services;

import com.example.ex1_blog_application.models.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Optional<Blog> findById(Long id);

    void update(Blog blog);

    void delete(Long id);

    interface ICategorySevice {
    }
}
