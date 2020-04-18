package com.wangke.springcloud.shop.dao;

import com.wangke.springcloud.shop.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GoodsRepository extends JpaRepository<Goods,Integer>, JpaSpecificationExecutor<Goods> {
}
