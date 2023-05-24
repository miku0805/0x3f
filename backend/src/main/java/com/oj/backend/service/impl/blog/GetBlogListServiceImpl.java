package com.oj.backend.service.impl.blog;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oj.backend.mapper.BlogMapper;
import com.oj.backend.pojo.Blog;
import com.oj.backend.service.blog.GetBlogListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GetBlogListServiceImpl implements GetBlogListService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public JSONObject getblogList(Integer page) {
        IPage<Blog> recordIPage = new Page<>(page, 10);
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        List<Blog> blogs = blogMapper.selectPage(recordIPage, queryWrapper).getRecords();
        JSONObject resp = new JSONObject();
        List<JSONObject> items = new LinkedList<>();
        for (Blog blog: blogs) {
            JSONObject item = new JSONObject();
            item.put("id",blog.getId());
            item.put("brief",blog.getBrief());
            item.put("content",blog.getContent());
            item.put("blog",blog);
            items.add(item);
        }
        resp.put("blogs", items);
        resp.put("blogs_count", blogMapper.selectCount(null));

        return resp;
}
}
