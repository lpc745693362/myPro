package com.lpc.user.dao;

import com.lpc.user.entity.User;

/**
 * Created by liupengcheng1 on 2016/5/16.
 */
public interface UserDao {

    public User selectById(Long id);

}
