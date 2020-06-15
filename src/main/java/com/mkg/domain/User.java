package com.mkg.domain;

import java.io.Serializable;

/**
 * @author 毛凯钢
 * @create 2020-03-20 17:10
 * @desc User类
 **/
public class User implements Serializable {
    private String open_id;
    private String nick_name;

    public User(String open_id, String nick_name) {
        this.open_id = open_id;
        this.nick_name = nick_name;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "open_id='" + open_id + '\'' +
                ", nick_name='" + nick_name + '\'' +
                '}';
    }
}
