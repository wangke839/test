package com.wangke.springcloud.shop.service;

import com.wangke.springcloud.shop.entity.Nation;

import java.util.List;

public interface NationService {
    List<Nation> listByPid(Integer pid);
}
