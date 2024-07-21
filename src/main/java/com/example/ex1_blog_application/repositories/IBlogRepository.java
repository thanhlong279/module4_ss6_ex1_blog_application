package com.example.ex1_blog_application.repositories;

import com.example.ex1_blog_application.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {

}
