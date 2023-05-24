package com.oj.backend.service.blog;

import com.alibaba.fastjson2.JSONObject;

public interface GetBlogListService {
    JSONObject getblogList(Integer page);
}
