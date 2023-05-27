package com.oj.backend.service.impl.blog;

import com.alibaba.fastjson2.JSONObject;
import com.oj.backend.mapper.BlogMapper;
import com.oj.backend.pojo.Blog;
import com.oj.backend.service.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public JSONObject getblog(Integer id) {
        Blog blog = blogMapper.selectById(id);
        JSONObject resp = new JSONObject();
        JSONObject item = new JSONObject();
        item.put("id",blog.getId());
        item.put("createtime",blog.getCreatetime());
        item.put("content",blog.getContent());
        item.put("brief",blog.getBrief());
        item.put("title",blog.getTitle());
        item.put("image",blog.getImage());
//        item.put("blog",blog);
        resp.put("blog",item);
        return resp;
    }
}
