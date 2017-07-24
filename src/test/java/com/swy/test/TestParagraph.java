package com.swy.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class TestParagraph {

	
	@Test
	public void testCreatePdf1() throws Exception 	{
		BaseFont chinessFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);  
		Font font = new Font(chinessFont);
		Document document = new Document(PageSize.A4);
		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(new File("C:/Users/sjakl/Desktop/段落.pdf")));
	   
		document.open();
		
		Paragraph p = new Paragraph("居中",font);
	    p.setAlignment(Element.ALIGN_CENTER);
	    document.add(p);
	   
	    p = new Paragraph("居左",font);
	    p.setAlignment(Element.ALIGN_LEFT);
	    document.add(p);
	    
	    document.newPage();
	    
	    p = new Paragraph("缩进",font);
	   
	    //缩进
	    p.setIndentationLeft(100);
	    document.add(p);
	    
	    document.newPage();
	    
	    //设置行距10
	    p = new   Paragraph(20,"行距设置所添加的文本超过的文档的右边缘，段对象知道如何添加行距。行距是用单位来衡量。每英寸有72个单位。默认间距是字体高度的1.5倍。您可以更改行距间距作为参数传递给段落构造方法。 所添加的文本超过的文档的右边缘，段对象知道如何添加行距。行距是用单位来衡量。每英寸有72个单位。默认间距是字体高度的1.5倍。您可以更改行距间距作为参数传递给段落构造方法。 ",font);
	    //首行缩进
	    p.setFirstLineIndent(15);
	    //行距
	    //p.setLeading(10);
	    document.add(p);
	    document.close();
	}
}
