package com.mkg.controller;

import com.mkg.domain.Pdf;
import com.mkg.domain.WrongedQuestions;
import com.mkg.pdf.PDFDemo;
import com.mkg.service.PdfService;
import com.mkg.service.WrongedQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 毛凯钢
 * @create 2020-03-31 19:16
 * @desc PdfController
 **/
@Controller
@RequestMapping("/Pdf")
public class PdfController {

    @Autowired
    WrongedQuestionsService wrongQuestionService;

    @Autowired
    PdfService pdfService;

    @ResponseBody
    @RequestMapping(value = "/SelectPdf",method = RequestMethod.POST)
    public Map<String, Object> SelectPdf(@RequestParam("open_id") String opid){
        Map<String,Object > map = new HashMap<>();
        Map<String,Object > parammap = new HashMap<>();
        parammap.put("open_id",opid);
        List<Pdf> pdfList=pdfService.SelectPdf(parammap);
        map.put("pdf_info",pdfList);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/toPdf",method = RequestMethod.POST)
    public Map<String, Object> toPdf(HttpServletRequest request, @RequestParam("open_id") String opid,@RequestParam("wq_id") String wqid) throws Exception {
        Map<String,Object > map = new HashMap<>();
        HashMap<String,Object> paramap=new HashMap<>();
        paramap.put("open_id",opid);
        paramap.put("wq_id",wqid);
        List<WrongedQuestions> wrongedQuestionsList=wrongQuestionService.SelectWqInfo(paramap);
        String context=null;
        String img=null;
        String subject=null;
        for(WrongedQuestions wrongedQuestions : wrongedQuestionsList){
            context=wrongedQuestions.getQuestion_context();
            img=wrongedQuestions.getImg_url();
            subject=wrongedQuestions.getSubject_name();
        }
        String filepath=request.getSession().getServletContext().getRealPath("/");
        img=filepath+img.substring(20);
        System.out.println(img);

        File file1=new File(filepath + "topdf"+File.separator);
        if(!file1.exists()){//如果文件夹不存在
            file1.mkdir();//创建文件夹
        }
        File file2=new File(filepath + "topdf"+File.separator+opid+File.separator);
        if(!file2.exists()){//如果文件夹不存在
            file2.mkdir();//创建文件夹
        }
        File file3=new File((filepath + "topdf"+File.separator+opid+File.separator+wqid+".pdf"));
        PDFDemo pdfDemo=new PDFDemo();
        pdfDemo.writePdf(file3.toString(),img,context);

        String pdfurl="https:"+File.separator+File.separator+"marquez.top"+File.separator+"topdf"+File.separator+opid+File.separator+wqid+".pdf";

        Pdf pdf=new Pdf(opid,pdfurl,wqid);
        HashMap<String,Object> param=new HashMap<String,Object>();
        param.put("open_id",opid);
        param.put("wq_id",wqid);
        if(pdfService.CheckPdf(param).isEmpty()){
            pdfService.InsertIntoPdf(pdf);
        }

        map.put("pdfurl",pdfurl);
        return map;
    }
}

