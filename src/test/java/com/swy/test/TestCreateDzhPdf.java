package com.swy.test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TestCreateDzhPdf {

	@Test
	public void testCreate() throws DocumentException, IOException {
		
		
	
	
		 // 中文支持，需要引入 itext-asian.jar  
		BaseFont chinessFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);  
		Font font = new Font(chinessFont,20);
		font.setStyle(Font.BOLD);
		// 1.新建document对象,将rect作为预设的样式传入，后面的10,101,10,10是文档的外边距
		Document document = new Document();

		// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		// 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Administrator/Desktop/电子化.pdf"));

		// 3.打开文档
		document.open();
		
	   
		
		// 添加一个标题 
        Paragraph p1 = new Paragraph("公司董事会成员、监事会成员、经理情况",font);
        //设置居中显示
        p1.setAlignment(Element.ALIGN_CENTER);
		document.add(p1);
		
		//添加一个表格
		PdfPTable table = new PdfPTable(6);
		//定义一个表格单元
		PdfPCell cell = new PdfPCell();
		
		//定义一个表格单元的跨度
		cell.setColspan(4);

		// 5.关闭文档
		document.close();
	}
}
