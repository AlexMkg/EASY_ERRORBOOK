package com.mkg.controller;

import com.mkg.domain.User;
import com.mkg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author 毛凯钢
 * @create 2020-03-22 21:44
 * @desc controller层
 **/
@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/findAll")
    public Map< String, Object> findAll(){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            List<User> ff = userService.findAll();
            map.put("findAll", ff);
            System.out.println(666);
            for(User user:ff){
                System.out.println(user);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/InsertIntoUser", method = RequestMethod.POST)
    public void InsertIntoUser(@RequestParam("open_id") String op,@RequestParam("nick_name") String nn){
        System.out.println(op);
        System.out.println(nn);
        User user=new User(op,nn);
        List<User> select=userService.SelectInfoByOpid(op);
        if(select.isEmpty()){
            userService.InsertIntoUser(user);
        }
    }
}
