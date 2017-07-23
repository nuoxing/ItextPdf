package com.swy.test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TestTable2 {

	@Test
	public void testCreateTable() throws Exception
	{
		// 1.新建document对象,将rect作为预设的样式传入，后面的10,101,10,10是文档的外边距
		Document document = new Document(PageSize.A4);
		
		// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		// 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/sjakl/Desktop/电子化2.pdf"));

		// 3.打开文档
		document.open();
		
		
		BaseFont baseFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED); 
		Font chinesefont = new Font(baseFont);
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(90);//占用空白的百分比
		table.setTotalWidth(new float[]{0.1f,0.3f,0.3f,0.3f});//设置各列的比例
		
		
		
		Phrase phrase = null;
		PdfPCell cell = null;
		
		phrase = new Phrase("测试",chinesefont);
		cell = new PdfPCell(phrase);
		table.addCell(cell);
		table.addCell(cell);
		table.addCell(cell);
		table.addCell(cell);
		table.addCell(cell);
		
		
		cell.setColspan(3);
		table.addCell(cell);
		
		document.add(table);
		document.close();
	}
	
	
	}
