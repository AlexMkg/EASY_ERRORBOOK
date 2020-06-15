package com.mkg.service.impl;

import com.mkg.dao.IUserDao;
import com.mkg.domain.User;
import com.mkg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 毛凯钢
 * @create 2020-03-22 21:39
 * @desc UserServiceImpl
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    IUserDao Dao;
    @Override
    public List<User> findAll(){
        return Dao.findAll();
    }

    @Override
    public void InsertIntoUser(User user){
        Dao.InsertIntoUser(user);
    }

    @Override
    public List<User> SelectInfoByOpid(String opid){
        return Dao.SelectInfoByOpid(opid);
    }

}
