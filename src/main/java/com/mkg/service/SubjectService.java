package com.mkg.service;

import com.mkg.domain.Subject;

import java.util.List;
import java.util.Map;

public interface SubjectService {
    /**
     * @Description:
     * @Param: [sub]
     * @create: 2020/3/25 17:58
     * @return: void
     */
    public void InsertIntoSubject(Subject sub);

    /**
     * @Description:
     * @Param: [subName]
     * @create: 2020/3/25 17:58
     * @return: java.util.List<com.mkg.domain.Subject>
     */
    public List<Subject> SelectSubBySubName(Subject subject);
    
    /**
     * @Description:  
     * @Param: [] 
     * @create: 2020/3/25 19:16
     * @return: java.util.List<com.mkg.domain.Subject>
     */ 
    public List<Subject> SelectAll(String op);
    
    /**
     * @Description:  
     * @Param: [] 
     * @create: 2020/3/26 10:56
     * @return: int
     */ 
    public int SelectSubCounts(String op);

    /**
     * @Description:
     * @Param: [subjectName]
     * @create: 2020/3/29 20:00
     * @return: void
     */
    public void DeleteSubBySubName(Map map);
}
