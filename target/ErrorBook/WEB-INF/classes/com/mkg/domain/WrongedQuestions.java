package com.mkg.domain;

import java.sql.Date;

/**
 * @author 毛凯钢
 * @create 2020-03-28 14:53
 * @desc WrongedQuestions实体类
 **/
public class WrongedQuestions {
    private int wq_id;
    private String open_id;
    private String subject_name;
    private String question_context;
    private String img_url;
    private String data_time;
    private int weight;

    public WrongedQuestions(String open_id, String subject_name, String question_context, String img_url, String data_time) {
        this.open_id = open_id;
        this.subject_name = subject_name;
        this.question_context = question_context;
        this.img_url = img_url;
        this.data_time = data_time;
    }

    public WrongedQuestions(int wq_id, String open_id, String subject_name, String question_context, String img_url, String data_time,int weight) {
        this.wq_id = wq_id;
        this.open_id = open_id;
        this.subject_name = subject_name;
        this.question_context = question_context;
        this.img_url = img_url;
        this.data_time = data_time;
        this.weight = weight;
    }

    public int getWq_id() {
        return wq_id;
    }

    public void setWq_id(int wq_id) {
        this.wq_id = wq_id;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getQuestion_context() {
        return question_context;
    }

    public void setQuestion_context(String question_context) {
        this.question_context = question_context;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getData_time() {
        return data_time;
    }

    public void setData_time(String data_time) {
        this.data_time = data_time;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "WrongedQuestions{" +
                "wq_id=" + wq_id +
                ", open_id='" + open_id + '\'' +
                ", subject_name='" + subject_name + '\'' +
                ", question_context='" + question_context + '\'' +
                ", img_url='" + img_url + '\'' +
                ", data_time='" + data_time + '\'' +
                ", weight=" + weight +
                '}';
    }
}
