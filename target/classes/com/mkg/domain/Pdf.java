package com.mkg.domain;

/**
 * @author 毛凯钢
 * @create 2020-05-01 20:18
 * @desc PDF实体类
 **/
public class Pdf {
    private String open_id;
    private String pdf_id;
    private String pdf_url;
    private String wq_id;

    public Pdf(String open_id, String pdf_url,String wq_id) {
        this.open_id = open_id;
        this.pdf_url = pdf_url;
        this.wq_id = wq_id;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getPdf_id() {
        return pdf_id;
    }

    public void setPdf_id(String pdf_id) {
        this.pdf_id = pdf_id;
    }

    public String getPdf_url() {
        return pdf_url;
    }

    public void setPdf_url(String pdf_url) {
        this.pdf_url = pdf_url;
    }

    public String getWq_id() {
        return wq_id;
    }

    public void setWq_id(String wq_id) {
        this.wq_id = wq_id;
    }

    @Override
    public String toString() {
        return "Pdf{" +
                "open_id='" + open_id + '\'' +
                ", pdf_id='" + pdf_id + '\'' +
                ", pdf_url='" + pdf_url + '\'' +
                ", wq_id='" + wq_id + '\'' +
                '}';
    }
}
