package com.oj.backend.service.impl.record;

import com.oj.backend.mapper.RecordMapper;
import com.oj.backend.pojo.Record;
import com.oj.backend.service.record.FinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FinishServiceImpl implements FinishService {
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public Map<String,String>finish(Map<String, String> data){
        int record_id = Integer.parseInt(data.get("record_id"));
        Map<String, String> map = new HashMap<>();
        Record record = recordMapper.selectById(record_id);
        if(record == null)
        {
            map.put("error_messsage","不存在或者已删除");
            return map;
        }
        recordMapper.deleteById(record_id);
        map.put("error_message","success");
        return map;
    }
}
