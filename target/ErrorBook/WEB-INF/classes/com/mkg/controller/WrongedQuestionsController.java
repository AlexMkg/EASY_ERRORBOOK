package com.mkg.controller;

import com.mkg.domain.Subject;
import com.mkg.domain.WrongedQuestions;
import com.mkg.service.SubjectService;
import com.mkg.service.WrongedQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 毛凯钢
 * @create 2020-03-28 15:30
 * @desc WrongedQuestionsController
 **/
@Controller
@RequestMapping("/WrongedQuestions")
public class WrongedQuestionsController {
    @Autowired
    WrongedQuestionsService wrongedQuestionsService;
    @Autowired
    SubjectService subjectService;

    @ResponseBody
    @RequestMapping(value = "/uploadImg")
    public String upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        System.out.println("执行upload");
        request.setCharacterEncoding("UTF-8");
        String question_context = request.getParameter("question_context");
        String open_id = request.getParameter("open_id");
        String subject_name = request.getParameter("subject_name");
        System.out.println(question_context);
        System.out.println(open_id);
        System.out.println(subject_name);
        System.out.println(file.isEmpty());
        if(!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String path = null;
            String type = null;
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            System.out.println(type);
            if (type != null) {
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    System.out.println(realPath);
                    // 自定义的文件名称
                    String trueFileName = System.currentTimeMillis() + fileName;
                    System.out.println(trueFileName);
                    // 设置存放图片文件的路径
                    File file1=new File(realPath + "uploads"+File.separator);
                    if(!file1.exists()){//如果文件夹不存在
                        file1.mkdir();//创建文件夹
                    }
                    File file2=new File(realPath + "uploads"+File.separator+open_id+File.separator);
                    if(!file2.exists()){//如果文件夹不存在
                        file2.mkdir();//创建文件夹
                    }

                    path = realPath + "uploads"+File.separator+open_id +File.separator+ trueFileName;
                    String path1 = "https:"+File.separator + File.separator + "marquez.top"+ File.separator + "uploads"+File.separator+open_id +File.separator+ trueFileName;
                    System.out.println(path1);
                    file.transferTo(new File(path));
                    Date date = new Date(System.currentTimeMillis());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dateStr = format.format(date);
                    WrongedQuestions wq=new WrongedQuestions(open_id,subject_name,question_context,path1,dateStr);
                    wrongedQuestionsService.InsertIntoWrongedQuestions(wq);
                }else {
                    System.out.println("error");
                    return "error";
                }
            }else {
                System.out.println("error");
                return "error";
            }
        }else {
            System.out.println("error");
            return "error";
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/SelectAll")
    public Map<String,Object> SelectAll(@RequestParam("open_id") String opid,@RequestParam("subject_name") String subname){
        Map<String, Object> map = new HashMap<>();
        HashMap<String,Object> paramap=new HashMap<>();
        paramap.put("open_id",opid);
        paramap.put("subject_name",subname);
        System.out.println(opid+subname);
        List<WrongedQuestions> wrongedQuestionsList =wrongedQuestionsService.SelectAll(paramap);
        int wq_counts=wrongedQuestionsService.SelectWqCounts(paramap);
        map.put("wrongedquestions_info",wrongedQuestionsList);
        map.put("wq_counts",wq_counts);
        System.out.println("wq_counts="+wq_counts);
        return map;
    }

    @ResponseBody
    @RequestMapping("/DeleteWq")
    public void DeleteWq(@RequestParam("open_id") String opid,@RequestParam("wq_id") String wqid){
        HashMap<String,Object> map=new HashMap<>();
        map.put("open_id",opid);
        map.put("wq_id",wqid);
        wrongedQuestionsService.DeleteWq(map);
    }

    @ResponseBody
    @RequestMapping("/SelectWqInfo")
    public Map<String, Object> SelectWqInfo(@RequestParam("open_id") String opid, @RequestParam("wq_id") String wqid){
        HashMap<String,Object> paramap=new HashMap<>();
        paramap.put("open_id",opid);
        paramap.put("wq_id",wqid);
        List<WrongedQuestions> wq_info=wrongedQuestionsService.SelectWqInfo(paramap);
        wrongedQuestionsService.UpdateWeight(paramap);
        HashMap<String,Object> map=new HashMap<>();
        map.put("wq_info",wq_info);
        return map;
    }

    @ResponseBody
    @RequestMapping("/SelectWqId")
    public Map<String,Object> SelectWqId(@RequestParam("open_id") String opid, @RequestParam("subject_name") String subname){
        HashMap<String,Object> paramap=new HashMap<>();
        paramap.put("open_id",opid);
        paramap.put("subject_name",subname);
        List list=wrongedQuestionsService.SelectWqId(paramap);
        HashMap<String,Object> map=new HashMap<>();
        map.put("wq_id",list);
        return map;
    }

    @ResponseBody
    @RequestMapping("/InsertNewWqInfo")
    public void InsertNewWqInfo(@RequestParam("open_id_1") String opid1,@RequestParam("open_id_2") String opid2,@RequestParam("wq_id") String wqid){
        HashMap<String,Object> paramap=new HashMap<>();
        paramap.put("open_id",opid1);
        paramap.put("wq_id",wqid);
        List<WrongedQuestions> wq_info=wrongedQuestionsService.SelectWqInfo(paramap);
        String sub_name=null;
        String question_context=null;
        String img_url=null;
        String date_time=null;
        for(WrongedQuestions w : wq_info){
            sub_name=w.getSubject_name();
            question_context=w.getQuestion_context();
            img_url=w.getImg_url();
            date_time=w.getData_time();
        }
        WrongedQuestions wrongedQuestions=new WrongedQuestions(wqid,opid2,sub_name,question_context,date_time);
        Subject sub=new Subject(opid2,sub_name);
        if(subjectService.SelectSubBySubName(sub)==null){
            subjectService.InsertIntoSubject(sub);
            wrongedQuestionsService.InsertIntoWrongedQuestions(wrongedQuestions);
        }

    }
}
