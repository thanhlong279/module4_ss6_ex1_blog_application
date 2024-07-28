package com.example.ex1_blog_application.dto;

import com.example.ex1_blog_application.models.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BlogDTO implements Validator {
    @NotBlank(message = "ten ko dc de trong")
    @Pattern(regexp = "^[A-Za-z ]{2,100}$", message = "ten ko dung dinh dang")
    private String title;
    @NotNull(message = "moi dung ko dc de trong")
    private String content;
    private Category category;

    public BlogDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BlogDTO blog = (BlogDTO) target;
        if (blog.getCategory() == null)
            errors.rejectValue("title", "", "the loai ko dc de trong");
    }
}
