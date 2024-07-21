package com.example.ex1_blog_application.controllers;

import com.example.ex1_blog_application.models.Blog;
import com.example.ex1_blog_application.services.IBlogService;
import com.example.ex1_blog_application.services.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String displayBlog(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "blog/list";
    }

    @GetMapping("create")
    public String viewCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("create")
    public String createBlog(@ModelAttribute("blog") Blog blog,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "blog/create";
        } else {
            blogService.save(blog);
            redirectAttributes.addFlashAttribute("message", "them moi thanh cong");
        }
        return "redirect:/blog";
    }

    @GetMapping("view/{id}")
    public String getBlogById(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id).orElse(null);
        model.addAttribute("blog", blog);
        return "blog/view";
    }

    @GetMapping("edit/{id}")
    public String editBlog(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id).orElse(null);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping("update/{id}")
    public String updateBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        try {
            blogService.update(blog);
            redirectAttributes.addFlashAttribute("message", "sua thanh cong");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("message", "ko tim thay bai viet");
        }
        return "redirect:/blog";
    }

    @GetMapping("delete/{id}")
    public String deleteBlog(@PathVariable Long id,
                             RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id).orElse(null);
        if (blog == null) {
            redirectAttributes.addFlashAttribute("message", "ko tim thay bai viet");
        }else {
            blogService.delete(id);
            redirectAttributes.addFlashAttribute("message", "xoa thanh cong");
        }
        return "redirect:/blog";
    }
}
