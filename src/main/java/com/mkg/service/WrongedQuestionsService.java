package com.mkg.service;

import com.mkg.domain.WrongedQuestions;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Param:
 * @create: 2020/3/28 15:32
 * @return:
 */
public interface WrongedQuestionsService {

    /**
     * @Description:
     * @Param: [wrongedQuestions]
     * @create: 2020/3/28 15:23
     * @return: void
     */
    public void InsertIntoWrongedQuestions(WrongedQuestions wrongedQuestions);

    /**
     * @Description:
     * @Param: [open_id]
     * @create: 2020/3/28 15:23
     * @return: java.util.List<com.mkg.domain.WrongedQuestions>
     */
    public List<WrongedQuestions> SelectAll(Map map);

    /**
     * @Description:
     * @Param: [open_id]
     * @create: 2020/3/28 15:23
     * @return: int
     */
    public int SelectWqCounts(Map map);
    
    /**
     * @Description:  
     * @Param: [map] 
     * @create: 2020/3/30 21:34
     * @return: void
     */ 
    public void DeleteWq(Map map);

    /**
     * @Description:
     * @Param: [map]
     * @create: 2020/4/2 15:00
     * @return: java.util.List<com.mkg.domain.WrongedQuestions>
     */
    public List<WrongedQuestions> SelectWqInfo(Map map);
    
    /**
     * @Description:  
     * @Param: [map] 
     * @create: 2020/6/6 16:26
     * @return: java.util.List<com.mkg.domain.WrongedQuestions>
     */ 
    public List<WrongedQuestions> SelectWqId(Map map);
    
    /**
     * @Description:  
     * @Param: [map] 
     * @create: 2020/6/6 18:02
     * @return: void
     */ 
    public void UpdateWeight(Map map);
}
