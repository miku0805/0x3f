package com.oj.backend.service.impl.blog;

import com.oj.backend.mapper.BlogMapper;
import com.oj.backend.pojo.Blog;
import com.oj.backend.service.blog.AddBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AddBlogServiceImpl implements AddBlogService {

    @Autowired
    private BlogMapper blogMapper;
    @Override
    public Map<String, String> addblog(Map<String, String> data) {
        Map<String,String>map = new HashMap<>();
        Date now = new Date();
        String content = data.get("content");
        String brief = data.get("brief");
        Blog blog = new Blog(null,content,brief,now);
        blogMapper.insert(blog);
        map.put("error_message","success");
        return map;
    }
}
