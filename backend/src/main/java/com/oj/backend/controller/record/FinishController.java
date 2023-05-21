package com.oj.backend.controller.record;

import com.oj.backend.service.record.FinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class FinishController {
    @Autowired
    private FinishService finishService;

    @PostMapping("/api/record/finish/")
    public Map<String, String> finish(@RequestParam Map<String, String> data) {
        return finishService.finish(data);
    }
}
