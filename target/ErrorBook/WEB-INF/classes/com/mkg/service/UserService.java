package com.mkg.service;

import com.mkg.domain.User;
import java.util.List;

/**
 * @author 毛凯钢
 * @create 2020-03-22 21:38
 * @desc UserService层
 **/
public interface UserService {
    /**
     * @Description: findAll接口 
     * @Param: [] 
     * @create: 2020/3/22 21:47
     * @return: java.util.List<com.mkg.errorbook.domain.User>
     */ 
    public List<User> findAll();

    /**
     * @Description: InsertIntoUser
     * @Param: [user]
     * @create: 2020/3/23 20:00
     * @return: void
     */
    public void InsertIntoUser(User user);

    /**
     * @Description:  SelectInfoByOpid
     * @Param: [opid]
     * @create: 2020/3/23 23:43
     * @return: java.util.List<com.mkg.domain.User>
     */
    public List<User> SelectInfoByOpid(String opid);
}

