package com.swy.test;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class TestList {

	

	@Test
	public void testCreatePdf1() throws Exception 	{
		BaseFont chinessFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);  
		Font font = new Font(chinessFont);
		Document document = new Document(PageSize.A4);
		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(new File("C:/Users/sjakl/Desktop/list.pdf")));
	   
		document.open();
		
	
		//true为排序
		List list = new List(true,20);
		list.add(new ListItem("First"));
		list.add(new ListItem("First2"));
		document.add(list);
		
	    document.close();
	}
	
}
