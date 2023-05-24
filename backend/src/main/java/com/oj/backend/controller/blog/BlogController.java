package com.oj.backend.controller.blog;

import com.alibaba.fastjson2.JSONObject;
import com.oj.backend.service.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/api/blog/{id}/")
    public JSONObject detail(@PathVariable(name = "id") Integer id) {
        return blogService.getblog(id);
    }
}
