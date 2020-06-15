package com.mkg.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mkg.domain.Pdf;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

public class PDFDemo {
    private Color black = new Color(0, 0, 0); // 黑色
    private Color red = new Color(255, 0, 0); // 红色
    private Color blue = new Color(0, 0, 255); // 蓝色
    private int bold = Font.BOLD; // 粗体
    private int normal = Font.NORMAL; // 正常字体
    private int italic = Font.ITALIC; // 斜体
    private int boldItalic = Font.BOLDITALIC; // 粗斜体
    private float setting = 200; // 首行缩进参数
    public Document createDoc(String filename) throws Exception {
        // 新建document对象
        // 第一个参数是页面大小。接下来的参数分别是左、右、上和下页边距。
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        // 建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
        // 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        return document;
    }
    public void writePdf(String filename, String imgPath,String context) throws Exception {
        Document document = createDoc(filename); // 打开文档XX
        document.open(); // 文档里写入
        Paragraph paragraph=convertParToChinese("-----------------------------------------------------------------------------------", 15, bold, BaseColor.BLACK);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));

        if (checkFile(imgPath)) {
            Image image = writeImg(imgPath);
            image.setAlignment(Element.ALIGN_CENTER);
            document.add(image);
            document.add(new Paragraph("\n"));
        }
        document.add(new Paragraph("\n"));

        Paragraph parcontext=convertParToChinese(context, 13, normal, BaseColor.BLACK);
        parcontext.setFirstLineIndent(20);
        document.add(parcontext);
        document.close();
    }
    public Image writeImg(String imgPath) throws Exception {
        Image img = Image.getInstance(imgPath); // 控制图片大小
        img.scaleAbsolute(400, 250);
        return img;
    }
    public boolean checkFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            return true;
        }
        return false;
    }
    public static Paragraph convertParToChinese(String text, float fontsize, int fontStyle, BaseColor color)
            throws Exception {
        BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(baseFontChinese, fontsize, fontStyle, color);
        Paragraph graph = new Paragraph(text, fontChinese);
        return graph;
    }
    public Chunk convertChunkByChinese(String text, int fontsize, int fontStyle, BaseColor color) throws Exception {
        BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(baseFontChinese, fontsize, fontStyle, color);
        Chunk chunk = new Chunk(text, fontChinese);
        return chunk;
    }
    public static void main(String[] args) throws Exception {
        PDFDemo pdfDemo = new PDFDemo();
        String context="666";
        pdfDemo.writePdf("F:\\360MoveData\\Users\\毛凯钢\\Desktop\\2.pdf",
                "F:\\360MoveData\\Users\\毛凯钢\\Desktop\\IMG_2920(20200415-163625).JPG","打印pdf调整段落缩进怎样调?_百度知道" +
                        "1个回答 - 回答时间: 2017年11月25日" +
                        "最佳答案: 你的意思是对整段缩进?还是首行缩进? 整段缩进可以设置Paragraph的IndentationRight或者IndentationLeft 首行缩进可以通过设置Paragraph的FirstLineIndent属性...\n" +
                        "更多关于java怎么让pdf文字首行缩进的问题>>\n" +
                        "百度知道 - 百度快照\n" +
                        "IText实现对PDF文档属性的基本设置 - 半亩池光 - 博客园\n" +
                        "2017年1月19日 - iText是著名的开放源码的站点sourceforge一个项目,是用于生成PDF文档的一个java类库...另外也可以设定段落的首行缩进、对齐方式(左对齐、右对齐、居中...\n" +
                        "https://www.cnblogs.com/matrix...  - 百度快照\n" +
                        "iText设置首行缩进 - dKnightL的博客 - CSDN博客\n" +
                        "2017年6月9日 - 系统中,报表处理一直占比较重要的作用,本文将介绍一种生成PDF报表的Java组件--...最近用QLabel显示文字,需要设置首行缩进,发现网上资料很少,特来分享...\n" +
                        "CSDN技术社区 - 百度快照\n" +
                        "为您推荐：itext设置行间距pdf首行缩进PDF首行缩2怎么做JAVA生产word框架\n" +
                        "itext首行缩进pdf行间距怎么设置itext两端对齐下一页itext\n" +
                        "用iText生成PDF,如何设置段落Paragraph中的内容的行间距-CSDN论坛");


    }

}