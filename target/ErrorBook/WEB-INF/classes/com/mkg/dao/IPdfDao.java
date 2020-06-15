package com.mkg.dao;

import com.mkg.domain.Pdf;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Param:
 * @create: 2020/5/1 20:28
 * @return:
 */
@Repository
public interface IPdfDao {

    /**
     * @Description:
     * @Param: [pdf]
     * @create: 2020/5/1 20:28
     * @return: void
     */
    void InsertIntoPdf(Pdf pdf);


    /**
     * @Description:
     * @Param: [map]
     * @create: 2020/5/1 20:44
     * @return: java.util.List<com.mkg.domain.Pdf>
     */
    List<Pdf> SelectPdf(Map map);

    /**
     * @Description:
     * @Param: [map]
     * @create: 2020/6/10 14:34
     * @return: java.util.List<com.mkg.domain.Pdf>
     */
    List<Pdf> CheckPdf(Map map);
}
