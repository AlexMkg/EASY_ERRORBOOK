package com.mkg.errorbook;

import com.mkg.dao.IUserDao;
import com.mkg.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 毛凯钢
 * @create 2020-03-20 18:00
 * @desc 测试类
 **/
public class MyBatisTest {
    /**
     * @Description: 测试 mybatis
     * @Param: [args] 
     * @create: 2020/3/20 18:01
     * @return: void
     */ 
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession session=factory.openSession();
        IUserDao userDao=session.getMapper(IUserDao.class);
        List<User> users=userDao.findAll();
        for(User user:users){
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
