package com.oj.backend.controller.blog;

import com.alibaba.fastjson2.JSONObject;
import com.oj.backend.service.blog.GetBlogListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetBlogListController {
    @Autowired
    private GetBlogListService getBlogListService;

    @GetMapping("/api/blog/getlist/")
    JSONObject getblogList(@RequestParam Map<String, String> data) {
        Integer page = Integer.parseInt(data.get("page"));
        return getBlogListService.getblogList(page);
    }
}
