package com.lpc.user.dao.impl;

import com.lpc.user.dao.UserDao;
import com.lpc.user.entity.User;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 * Created by liupengcheng1 on 2016/5/16.
 */
public class UserDaoImpl implements UserDao {

    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public User selectById(Long id) {
        return (User)sqlMapClientTemplate.queryForObject("User.selectById", id);
    }

    public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
        this.sqlMapClientTemplate = sqlMapClientTemplate;
    }
}
