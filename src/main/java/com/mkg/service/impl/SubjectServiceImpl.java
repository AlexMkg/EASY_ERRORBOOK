package com.mkg.service.impl;

import com.mkg.dao.ISubjectDao;
import com.mkg.domain.Subject;
import com.mkg.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 毛凯钢
 * @create 2020-03-25 17:37
 * @desc SubjectServiceImpl
 **/
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    ISubjectDao Dao;

    @Override
    public void InsertIntoSubject(Subject sub) {
        Dao.InsertIntoSubject(sub);
    }

    @Override
    public List<Subject> SelectSubBySubName(Subject subject) {
        return Dao.SelectSubBySubName(subject);
    }

    @Override
    public List<Subject> SelectAll(String op) {
        return Dao.SelectAll(op);
    }

    @Override
    public int SelectSubCounts(String op) {
        return Dao.SelectSubCounts(op);
    }

    @Override
    public void DeleteSubBySubName(Map map) {
        Dao.DeleteSubBySubName(map);
    }
}
