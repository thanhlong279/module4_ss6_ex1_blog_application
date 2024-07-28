package com.example.ex1_blog_application.services.impl;

import com.example.ex1_blog_application.models.Category;
import com.example.ex1_blog_application.repositories.ICategoryRepository;
import com.example.ex1_blog_application.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
