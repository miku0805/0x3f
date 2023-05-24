package com.oj.backend.controller.blog;

import com.oj.backend.service.blog.AddBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddBlogController {
    @Autowired
    private AddBlogService addBlogService;

    @PostMapping("/api/blog/add/")
    public Map<String,String> addblog(@RequestParam Map<String,String>data) {return  addBlogService.addblog(data);};

}
