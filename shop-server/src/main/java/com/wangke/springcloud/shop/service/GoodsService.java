package com.wangke.springcloud.shop.service;

import com.wangke.springcloud.shop.comm.POJO;
import org.springframework.data.domain.Page;

public interface GoodsService {
    Page list(Integer pageNum, Integer pageSize, POJO pojo);
}
