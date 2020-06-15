package com.mkg.dao;

import com.mkg.domain.WrongedQuestions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Param:
 * @create: 2020/3/28 15:33
 * @return:
 */
@Repository
public interface IWrongedQuestionsDao {
    /**
     * @Description:
     * @Param: [wrongedQuestions]
     * @create: 2020/3/28 15:19
     * @return: void
     */
    void InsertIntoWrongedQuestions(WrongedQuestions wrongedQuestions);
    /**
     * @Description:
     * @Param: [open_id]
     * @create: 2020/3/28 15:19
     * @return: java.util.List<com.mkg.domain.WrongedQuestions>
     */
    List<WrongedQuestions> SelectAll(Map map);
    /**
     * @Description:
     * @Param: [open_id]
     * @create: 2020/3/28 15:19
     * @return: int
     */
    int SelectWqCounts(Map map);

    /**
     * @Description:
     * @Param: [map]
     * @create: 2020/3/30 21:34
     * @return: void
     */
    void DeleteWq(Map map);

    /**
     * @Description:
     * @Param: [map]
     * @create: 2020/4/2 14:58
     * @return: java.util.List<com.mkg.domain.WrongedQuestions>
     */
    List<WrongedQuestions> SelectWqInfo(Map map);

    /**
     * @Description:
     * @Param: [map]
     * @create: 2020/6/6 16:15
     * @return: java.util.List<com.mkg.domain.WrongedQuestions>
     */
    List<WrongedQuestions> SelectWqId(Map map);

    /**
     * @Description:
     * @Param: [map]
     * @create: 2020/6/6 18:01
     * @return: void
     */
    void UpdateWeight(Map map);
}

