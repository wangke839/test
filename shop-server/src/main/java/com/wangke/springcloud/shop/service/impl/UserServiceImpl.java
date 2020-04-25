package com.wangke.springcloud.shop.service.impl;

import com.wangke.springcloud.shop.dao.UserRepository;
import com.wangke.springcloud.shop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
}
