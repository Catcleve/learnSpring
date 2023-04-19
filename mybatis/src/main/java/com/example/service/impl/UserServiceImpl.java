package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dto.User;
import com.example.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.listAll();
    }
}
