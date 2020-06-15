package com.mkg.controller;

import com.mkg.domain.Subject;
import com.mkg.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author 毛凯钢
 * @create 2020-03-25 18:08
 * @desc Subject控制器
 **/
@Controller
@RequestMapping("/Subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @ResponseBody
    @RequestMapping("/InsertIntoSubject")
    public void InsertIntoSubject(@RequestParam("open_id") String op, @RequestParam("subject_name") String sn){
        System.out.println(op+sn);
        Subject sub=new Subject(op,sn);
        subjectService.InsertIntoSubject(sub);
    }

    @ResponseBody
    @RequestMapping("/SelectAll")
    public Map<String, Object> SelectAll(@RequestParam("open_id") String op){
        Map<String, Object> map = new HashMap<>();
        List<Subject> subjects=subjectService.SelectAll(op);
        int subcounts=subjectService.SelectSubCounts(op);
        map.put("subject_info",subjects);
        map.put("subject_counts",subcounts);
        return map;
    }

    @ResponseBody
    @RequestMapping("/DeleteSubBySubName")
    public void DeleteSubBySubName(@RequestParam("subject_name") String SubName,@RequestParam("open_id") String op){
        System.out.println(SubName+op);
        HashMap <String,Object> map=new HashMap<String,Object>();
        map.put("subject_name",SubName);
        map.put("open_id",op);
        subjectService.DeleteSubBySubName(map);
    }
}
