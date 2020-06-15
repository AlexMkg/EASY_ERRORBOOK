package com.mkg.dao;

import com.mkg.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 毛凯钢
 * @create 2020-03-20 17:13
 * @desc User接口
 **/
@Repository
public interface IUserDao {
    /**
     * @Description:  查询User表所有数据
     * @Param: [] 
     * @create: 2020/3/20 17:26
     * @return: java.util.List<com.mkg.errorbook.domain.User>
     */ 
    List<User> findAll();
    
    /**
     * @Description: 插入用户信息
     * @Param: [user] 
     * @create: 2020/3/23 20:07
     * @return: void
     */ 
    void InsertIntoUser(User user);

    /**
     * @Description: 判断是否已经有这个用户信息
     * @Param: [opid]
     * @create: 2020/3/23 23:39
     * @return: java.util.List<com.mkg.domain.User>
     */
    List<User> SelectInfoByOpid(String opid);
}
