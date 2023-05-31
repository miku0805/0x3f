package com.oj.backend.controller.blog;

import com.oj.backend.service.blog.UpdateBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateBlogController {
    @Autowired
    UpdateBlogService updateBlogService;

    @PostMapping("/api/blog/update/")
    public Map<String,String> updateblog(@RequestParam Map<String,String> data) {return updateBlogService.updateblog(data);};
}
