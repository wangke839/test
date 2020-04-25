package com.wangke.springcloud.shop.service;

import com.wangke.springcloud.shop.comm.POJO;
import com.wangke.springcloud.shop.entity.Goods;
import org.springframework.data.domain.Page;

public interface GoodsService {
    Page list(Integer pageNum, Integer pageSize, POJO pojo);

    boolean saveOrUpdate(Goods goods);

    boolean delete(Integer[] ids);
}
