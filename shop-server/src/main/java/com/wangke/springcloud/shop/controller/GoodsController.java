package com.wangke.springcloud.shop.controller;

import com.wangke.springcloud.shop.comm.POJO;
import com.wangke.springcloud.shop.comm.ResultInfo;
import com.wangke.springcloud.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("list")
    @ResponseBody
    public Object list(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "3")Integer pageSize, POJO pojo){
        Page page = goodsService.list(pageNum,pageSize,pojo);
        return  new ResultInfo().ok(page);
    }
}
