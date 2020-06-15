package com.mkg.dao;

import com.mkg.domain.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description: Subject接口 
 * @Param:  
 * @create: 2020/3/25 18:00
 * @return: 
 */ 
@Repository
public interface ISubjectDao {
    /**
     * @Description:
     * @Param: [sub]
     * @create: 2020/3/25 17:58
     * @return: void
     */
    void InsertIntoSubject(Subject sub);

    /**
     * @Description:
     * @Param: [subName]
     * @create: 2020/3/25 17:58
     * @return: java.util.List<com.mkg.domain.Subject>
     */
    List<Subject> SelectSubBySubName(Subject subject);

    /**
     * @Description:
     * @Param: []
     * @create: 2020/3/25 18:32
     * @return: java.util.List<com.mkg.domain.Subject>
     */
    List<Subject> SelectAll(String op);

    /**
     * @Description:
     * @Param: []
     * @create: 2020/3/26 10:56
     * @return: int
     */
    int SelectSubCounts(String op);
    
    /**
     * @Description:  
     * @Param: [subjectName] 
     * @create: 2020/3/29 19:58
     * @return: void
     */ 
    void DeleteSubBySubName(Map map);
}
