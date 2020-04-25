package com.wangke.springcloud.shop.service.impl;

import com.wangke.springcloud.shop.comm.POJO;
import com.wangke.springcloud.shop.dao.GoodsRepository;
import com.wangke.springcloud.shop.entity.Goods;
import com.wangke.springcloud.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Page list(Integer pageNum, Integer pageSize, POJO pojo) {
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(pojo.getName() != null && pojo.getName() != ""){
                    Predicate predicate = criteriaBuilder.like(root.get("name"),"%".concat(pojo.getName()).concat("%"));
                    predicates.add(predicate);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Pageable pageable = PageRequest.of(pageNum-1,pageSize);
        return goodsRepository.findAll(specification,pageable);
    }

    @Override
    public boolean saveOrUpdate(Goods goods) {
        return goodsRepository.save(goods) != null;
    }

    @Override
    public boolean delete(Integer[] ids) {
        List<Goods> allById = goodsRepository.findAllById(Arrays.asList(ids));
        goodsRepository.deleteInBatch(allById);
        return true;
    }
}
