package com.wangke.springcloud.shop.controller;

import com.wangke.springcloud.shop.comm.ResultInfo;
import com.wangke.springcloud.shop.dao.NationRepository;
import com.wangke.springcloud.shop.entity.Nation;
import com.wangke.springcloud.shop.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("nation")
public class NationController {
    @Autowired
    private NationService nationService;
    @RequestMapping("listByPid")
    @ResponseBody
    public Object listByPid(@RequestParam("pid") Integer pid){
        List<Nation> list = nationService.listByPid(pid);
        return new ResultInfo().ok(list);
    }
}
