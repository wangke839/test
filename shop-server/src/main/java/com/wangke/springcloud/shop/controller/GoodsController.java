package com.wangke.springcloud.shop.controller;

import com.wangke.springcloud.shop.comm.POJO;
import com.wangke.springcloud.shop.comm.ResultInfo;
import com.wangke.springcloud.shop.entity.Goods;
import com.wangke.springcloud.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(@RequestBody Goods goods){
        boolean flag  = goodsService.saveOrUpdate(goods);
        return  new ResultInfo().ok(flag);
    }
    @RequestMapping("delete")
    @ResponseBody
    public Object delete(Integer[] ids){
        boolean flag  = goodsService.delete(ids);
        return  new ResultInfo().ok(flag);
    }
}
