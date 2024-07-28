package com.example.ex1_blog_application.services;

import com.example.ex1_blog_application.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
