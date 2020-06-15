package com.mkg.domain;

/**
 * @author 毛凯钢
 * @create 2020-03-25 17:31
 * @desc 科目实体类
 **/
public class Subject {
    private int subject_id;
    private String open_id;
    private String subject_name;

    public Subject(String open_id, String subject_name) {
        this.open_id = open_id;
        this.subject_name = subject_name;
    }

    public Subject(String subject_name, String open_id,int subject_id) {
        this.subject_id = subject_id;
        this.open_id = open_id;
        this.subject_name = subject_name;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
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

    @Override
    public String toString() {
        return "Subject{" +
                "subject_id=" + subject_id +
                ", open_id='" + open_id + '\'' +
                ", subject_name='" + subject_name + '\'' +
                '}';
    }
}
