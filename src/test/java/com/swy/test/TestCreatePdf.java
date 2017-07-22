package com.swy.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class TestCreatePdf {

	@Test
	public void testCreate1() throws FileNotFoundException, DocumentException {
		// 1.新建document对象
		Document document = new Document();

		// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		// 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Administrator/Desktop/test.pdf"));

		// 3.打开文档
		document.open();

		// 4.添加一个内容段落
		document.add(new Paragraph("Hello World!"));

		// 5.关闭文档
		document.close();
	}
	
	
	
	@Test
	public void testCreate2() throws DocumentException, IOException {
		//定义一个A4大小的矩形组件
		Rectangle rect = new Rectangle(PageSize.A4);
		
		//设置背景色为浅灰色
		//rect.setBackgroundColor(BaseColor.LIGHT_GRAY);
		
		//设置border类型为box（四周都有）
		rect.setBorder(Rectangle.BOX);
		
		//设置border颜色为深灰色
		//rect.setBorderColor(BaseColor.DARK_GRAY);
		
		//设置border宽度为5
		rect.setBorderWidth(5);
		
		 // 中文支持，需要引入 itext-asian.jar  
		BaseFont chinessFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);  
		Font font = new Font(chinessFont);
		// 1.新建document对象,将rect作为预设的样式传入，后面的10,101,10,10是文档的外边距
		Document document = new Document(rect,10,10,10,10);

		// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		// 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Administrator/Desktop/test.pdf"));

		// 3.打开文档
		document.open();

		// 4.添加一个内容段落
		document.add(new Paragraph("企业名称：广州天恩服装有限公司广州天恩服装有限公司广州天恩服装有限公司广州天恩服装有限公司广州天恩服装有限公司广州天恩服装有限公司",font));

		// 5.关闭文档
		document.close();
	}
	
	
	@Test
	public void testCreate3() throws DocumentException, IOException {
		
		
		Chunk chunk1 = new Chunk("hello world");
	
		 // 中文支持，需要引入 itext-asian.jar  
		BaseFont chinessFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);  
		Font font = new Font(chinessFont);
		// 1.新建document对象,将rect作为预设的样式传入，后面的10,101,10,10是文档的外边距
		Document document = new Document();

		// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		// 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Administrator/Desktop/test.pdf"));

		// 3.打开文档
		document.open();
		
		document.add(chunk1);

		// 4.添加一个内容段落
		document.add(new Paragraph("企业名称：广州天恩服装有限公司广州天恩服装有限公司广州天恩服装有限公司广州天恩服装有限公司广州天恩服装有限公司广州天恩服装有限公司",font));

		// 5.关闭文档
		document.close();
	}
}
