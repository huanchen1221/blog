package com.huan.blog.controllers;

import com.huan.blog.models.Blog;
import com.huan.blog.models.User;
import com.huan.blog.repos.BlogRepo;
import com.huan.blog.repos.UserRepo;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {

    // dependency injection --> IOC
    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping({"/", "/blogs"})        //when URL request is /, handermapping will know send this request to this method
    public String allBlogs(Model model){

        Iterable<Blog> blogs = blogRepo.findAll();      //select * from blogs
        model.addAttribute("blogsForView", blogs);
        return "allBlogs";
    }

    @GetMapping("/blogs/{id}")
    public String blog(Model model, @PathVariable("id") int id){


        // get blog from database
        // blogRepo is a bridge to connect model(blog) and database table (blogs)
        // it will generate sql from model to table and conver sql result to java object from table to class
        Blog blog = blogRepo.findById(id).get();


        // model is used to pass data from controller to view
        // it is hold by dispatchSeverlet, and it will be assigned to view engine.
        // pass blog to view
        model.addAttribute("blogForView", blog);


        // return view name to dispatchSererlet,
        // dispatchSeverlet will use this name to get full view by view resolver's help
        return "blogPage";
    }

    @GetMapping("/blogs/new")
    public String blogForm(Model model){
        //used to help controller connect with templates(new.jsp)
//        model.addAttribute("blog",new Blog());
        return "new";
    }

    //https://guides.rubyonrails.org/routing.html#crud-verbs-and-actions
    @PostMapping("/blogs")
//    @RequestMapping(value = "/blogs", method = RequestMethod.POST)
    public String saveBlog(@ModelAttribute Blog blog, Principal principal){
        // insert a blog record to db
//        model.put()
        System.out.println("==========received data from blog post");
        System.out.println(blog.getTitle());
        System.out.println(blog.getContent());

        User user = userRepo.findByUsername(principal.getName());
        blog.setUser(user);

        // if blog has id, it will update the blog
        // if blog doesn't have id, it will create a blog with generated id
        blogRepo.save(blog);

        return "create-success";
    }

    @GetMapping("/blogs/{id}/edit")         //update process --> 1.get edit page 2. use put method to update content
    public String editBlog(Model model, @PathVariable("id") int id, Principal principal){
        // get blog from database
        Blog blog =blogRepo.findById(id).get();
        model.addAttribute("blog", blog);
        return "edit-form";
    }
}
