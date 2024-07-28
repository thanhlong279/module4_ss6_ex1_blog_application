package com.example.ex1_blog_application.controllers;

import com.example.ex1_blog_application.models.Blog;
import com.example.ex1_blog_application.services.IBlogService;
import com.example.ex1_blog_application.services.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {

    private final IBlogService blogService;
    @Autowired
    public BlogRestController(IBlogService blogService) {
        this.blogService = blogService;
    }
    @GetMapping
    public ResponseEntity<?> getBlogs() {
        List<Blog> blogs = blogService.findAll();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


}
