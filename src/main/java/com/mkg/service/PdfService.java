package com.mkg.service;

import com.mkg.domain.Pdf;

import java.util.List;
import java.util.Map;

public interface PdfService { 
    /**
     * @Description:  
     * @Param: [pdf] 
     * @create: 2020/5/1 20:44
     * @return: void
     */ 
    public void InsertIntoPdf(Pdf pdf);
    
    /**
     * @Description:  
     * @Param: [map] 
     * @create: 2020/5/1 20:59
     * @return: java.util.List<com.mkg.domain.Pdf>
     */ 
    public List<Pdf> SelectPdf(Map map);

    /**
     * @Description:
     * @Param: [map]
     * @create: 2020/6/10 14:34
     * @return: java.util.List<com.mkg.domain.Pdf>
     */
    public List<Pdf> CheckPdf(Map map);
}
