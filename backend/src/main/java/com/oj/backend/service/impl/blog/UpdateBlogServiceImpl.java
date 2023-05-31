package com.oj.backend.service.impl.blog;

import com.oj.backend.mapper.BlogMapper;
import com.oj.backend.pojo.Blog;
import com.oj.backend.service.blog.UpdateBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateBlogServiceImpl implements UpdateBlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Map<String, String> updateblog(Map<String, String> data) {
        Map<String,String>map = new HashMap<>();
        int id = Integer.parseInt(data.get("id"));
        String title = data.get("title");
        String brief = data.get("brief");
        String image = data.get("image");
        String content = data.get("content");
        Blog blog = blogMapper.selectById(id);
        Blog new_blog = new Blog(blog.getId(),content,title,brief,image,new Date());
        blogMapper.updateById(new_blog);
        map.put("error_message","success");
        return map;
    }
}
