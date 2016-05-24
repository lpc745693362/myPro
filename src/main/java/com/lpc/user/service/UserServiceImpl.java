package com.lpc.user.service;

import com.lpc.user.dao.UserDao;
import com.lpc.user.entity.User;

import javax.annotation.Resource;

/**
 * Created by liupengcheng1 on 2016/5/16.
 */
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User selectById(Long id) {
        return userDao.selectById(id);
    }

}
