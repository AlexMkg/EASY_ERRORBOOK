package com.mkg.service.impl;

import com.mkg.dao.IPdfDao;
import com.mkg.domain.Pdf;
import com.mkg.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 毛凯钢
 * @create 2020-05-01 20:45
 * @desc pdfserviceimpl
 **/

@Service
public class PdfServiceImpl implements PdfService {

    @Autowired
    IPdfDao Dao;

    @Override
    public void InsertIntoPdf(Pdf pdf) {
        Dao.InsertIntoPdf(pdf);
    }

    @Override
    public List<Pdf> SelectPdf(Map map) {
        return Dao.SelectPdf(map);
    }

    @Override
    public List<Pdf> CheckPdf(Map map) {
        return Dao.CheckPdf(map);
    }
}
