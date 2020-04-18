package com.wangke.springcloud.mongo.controller;

import com.wangke.springcloud.mongo.dao.LogRepository;
import com.wangke.springcloud.mongo.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    private LogRepository logRepository;

    @RequestMapping("save")
    @ResponseBody
    private Object save(Log log){
       logRepository.save(log);
        return  true;
    }
}
