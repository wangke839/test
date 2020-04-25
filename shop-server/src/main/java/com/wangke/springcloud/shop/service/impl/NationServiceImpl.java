package com.wangke.springcloud.shop.service.impl;

import com.wangke.springcloud.shop.dao.NationRepository;
import com.wangke.springcloud.shop.entity.Nation;
import com.wangke.springcloud.shop.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl implements NationService {
    @Autowired
    private NationRepository nationRepository;

    @Override
    public List<Nation> listByPid(Integer pid) {
        return nationRepository.findAllByPid(pid);
    }
}
