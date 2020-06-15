package com.mkg.service.impl;

import com.mkg.dao.IWrongedQuestionsDao;
import com.mkg.domain.WrongedQuestions;
import com.mkg.service.WrongedQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 毛凯钢
 * @create 2020-03-28 15:21
 * @desc WrongedQuestionsServiceImpl
 **/
@Service
public class WrongedQuestionsServiceImpl implements WrongedQuestionsService {
    @Autowired
    IWrongedQuestionsDao Dao;

    @Override
    public void InsertIntoWrongedQuestions(WrongedQuestions wrongedQuestions) {
        Dao.InsertIntoWrongedQuestions(wrongedQuestions);
    }

    @Override
    public List<WrongedQuestions> SelectAll(Map map) {
        return Dao.SelectAll(map);
    }

    @Override
    public int SelectWqCounts(Map map) {
        return Dao.SelectWqCounts(map);
    }

    @Override
    public void DeleteWq(Map map) {
        Dao.DeleteWq(map);
    }

    @Override
    public List<WrongedQuestions> SelectWqInfo(Map map) {
        return Dao.SelectWqInfo(map);
    }

    @Override
    public List<WrongedQuestions> SelectWqId(Map map) {
        return Dao.SelectWqId(map);
    }

    @Override
    public void UpdateWeight(Map map) {
        Dao.UpdateWeight(map);
    }
}
