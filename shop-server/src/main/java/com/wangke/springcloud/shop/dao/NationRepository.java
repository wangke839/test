package com.wangke.springcloud.shop.dao;

import com.wangke.springcloud.shop.entity.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NationRepository extends JpaRepository<Nation,Integer> {

    List<Nation> findAllByPid(Integer pid);
}
