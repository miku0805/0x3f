package com.oj.backend.service.impl.record;

import com.oj.backend.mapper.RecordMapper;
import com.oj.backend.pojo.Record;
import com.oj.backend.service.record.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AddServiceImpl implements AddService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public Map<String, String> add(Map<String, String> data) {
        Map<String,String>map = new HashMap<>();
        Date now = new Date();
        String content = data.get("content");
        Record record = new Record(null,content,now);
        recordMapper.insert(record);
        map.put("error_message","success");
        return map;
    }
}
