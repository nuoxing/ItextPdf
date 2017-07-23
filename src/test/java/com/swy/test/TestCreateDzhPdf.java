package com.swy.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TestCreateDzhPdf {

	@Test
	public void testCreateSimple() throws DocumentException, IOException {
	
		 // 中文支持，需要引入 itext-asian.jar  
		BaseFont chinessFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);  
		Font font = new Font(chinessFont,21);
		font.setStyle(Font.BOLD);
		// 1.新建document对象,将rect作为预设的样式传入，后面的10,101,10,10是文档的外边距
		Document document = new Document(PageSize.A4);
		

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
		
		
		//添加一个表格,6列
		PdfPTable table = new PdfPTable(6);
		
		//设置占用空白区域的百分比 99%
		table.setWidthPercentage(99);
	  
		/*
		 * table.setTotalWidth(float[] columnWidth);//设置表格的各列宽度
		 */
		table.setTotalWidth(new float[]{2,1,1,4,3,2});
		
		//使用以上两个函数，必须使用以下函数，将宽度锁定。
		 //table.setLockedWidth(true);
		
		//表格默认

		
		
		//定义一个表格单元
		//PdfPCell cell = new PdfPCell();	
		//定义一个表格单元的跨度
	   // cell.setColspan(6);
		
		Font chinesefont = new Font(chinessFont);
		Phrase p2 = new Phrase ("姓名",chinesefont);
		//p2.setAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1 = new PdfPCell(p2);
		cell1.setBorderWidth(0.5f);
		//设置单元格居中显示内容,水平
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		//垂直
		cell1.setUseAscender(true); //设置垂直之前必须
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell1);
		
		p2 = new Phrase ("性别",chinesefont);
		//p2.setAlignment(Element.ALIGN_CENTER);
		PdfPCell cell2 = new PdfPCell(p2);
		cell2.setBorderWidth(0.5f);
		//设置单元格居中显示内容
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setUseAscender(true); //设置垂直之前必须
		cell2.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell2);
		
		p2 = new Phrase ("职务",chinesefont);
		//p2.setAlignment(Element.ALIGN_CENTER);
		PdfPCell cell3 = new PdfPCell(p2);
		//设置边框宽度
		cell3.setBorderWidth(0.5f);
		//设置单元格居中显示内容
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell3.setUseAscender(true); //设置垂直之前必须
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell3);
		
		p2 = new Phrase ("住所",chinesefont);
		//p2.setAlignment(Element.ALIGN_CENTER);
		PdfPCell cell4 = new PdfPCell(p2);
		cell4.setBorderWidth(0.5f);
		//设置单元格居中显示内容
		cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell4.setUseAscender(true); //设置垂直之前必须
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell4);
		
		p2 = new Phrase ("身份证号码",chinesefont);
		//p2.setAlignment(Element.ALIGN_CENTER);
		PdfPCell cell5 = new PdfPCell(p2);
		cell5.setBorderWidth(0.5f);
		//设置单元格居中显示内容
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setUseAscender(true); //设置垂直之前必须
		cell5.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell5);
		
		p2 = new Phrase ("产生方式",chinesefont);
		//p2.setAlignment(Element.ALIGN_CENTER);
		PdfPCell cell6 = new PdfPCell(p2);
		cell6.setBorderWidth(0.5f);
		//设置单元格居中显示内容
		cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//cell6.setUseAscender(true); //设置垂直之前必须
		cell6.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell6);
	
	
	/*	//加入空行
        Paragraph blankRow4 = new Paragraph(18f, " ", FontChinese16); 
        document.add(blankRow4);*/
	
		
		
		
	/*	table.addCell(new Paragraph ("小明",chinesefont));
		table.addCell(new Paragraph ("男",chinesefont));
		table.addCell(new Paragraph ("经理",chinesefont));
		table.addCell(new Paragraph ("广东省广州市发的发的发的",chinesefont));
		table.addCell(new Paragraph ("465465465465465",chinesefont));
		table.addCell(new Paragraph ("聘任",chinesefont));
		
		
		table.addCell(new Paragraph ("小明",chinesefont));
		table.addCell(new Paragraph ("男",chinesefont));
		table.addCell(new Paragraph ("经理",chinesefont));
		table.addCell(new Paragraph ("广东省广州市发的发的发的",chinesefont));
		table.addCell(new Paragraph ("465465465465465",chinesefont));
		table.addCell(new Paragraph ("聘任",chinesefont));
		
		
		table.addCell(new Paragraph ("小明",chinesefont));
		table.addCell(new Paragraph ("男",chinesefont));
		table.addCell(new Paragraph ("经理",chinesefont));
		table.addCell(new Paragraph ("广东省广州市发的发的发的",chinesefont));
		table.addCell(new Paragraph ("465465465465465",chinesefont));
		table.addCell(new Paragraph ("聘任",chinesefont));
		
		
		table.addCell(new Paragraph ("小明",chinesefont));
		table.addCell(new Paragraph ("男",chinesefont));
		table.addCell(new Paragraph ("经理",chinesefont));
		table.addCell(new Paragraph ("广东省广州市发的发的发的",chinesefont));
		table.addCell(new Paragraph ("465465465465465",chinesefont));
		table.addCell(new Paragraph ("聘任",chinesefont));*/
		
		//设置表格与之前的元素的距离
		table.setSpacingBefore(20);
		document.add(table);
		
		
		//添加页脚
		/**
		 * 设置缩进  
		 */
        //paragraph.setIndentationLeft(50);  
        // paragraph.setIndentationRight(50);
		Paragraph footer1 = new Paragraph("注：①按董事会成员中、董事会成员、经理顺序填写。",chinesefont);
		document.add(footer1);
		
		Paragraph footer2 = new Paragraph("        ②“职务”系指董事、董事长、执行董事、监事、经理等",chinesefont);
		document.add(footer2);
		 
		Paragraph footer3 = new Paragraph("        ③“产生方式”系指委派、选举、聘用",chinesefont);
		document.add(footer3);
		// 5.关闭文档
		document.close();
	}
	
	
	@Test
	public void testCreate2() throws Exception
	{
		// 1.新建document对象,将rect作为预设的样式传入，后面的10,101,10,10是文档的外边距
		Document document = new Document(PageSize.A4);
		
		// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		// 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Administrator/Desktop/电子化2.pdf"));

		// 3.打开文档
		document.open();
		
		String[] tableTitle = new String[]{"姓名","性别","职务","住所","身份证号码","产生方式"};
		List<Map<String,String>> tableContent = new ArrayList<Map<String,String>>();
		Map<String,String> map1 = new HashMap<String, String>();
		map1.put("姓名", "小明");
		map1.put("性别", "男");
		map1.put("职务", "经理");
		map1.put("住所", "广东省广州市XXXXXXXXXXXXXXX");
		map1.put("身份证号码", "465456456456456456465XXX");
		map1.put("产生方式", "聘用");
		tableContent.add(map1);
		tableContent.add(map1);
		tableContent.add(map1);
		tableContent.add(map1);
		tableContent.add(map1);
		tableContent.add(map1);
		tableContent.add(map1);
		tableContent.add(map1);
		PdfPTable table = createSimpleTable(tableTitle,tableContent,6,new float[]{2,1,1,4,3,2},99f);
		document.add(table);
		document.close();
	}
	
	
	
	private PdfPTable createSimpleTable(String[] tableTitle,List<Map<String,String>> tableContent,int colnum,
			float[] colRatio,float widthPercentage) throws Exception
	{
		
		BaseFont baseFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED); 
		Font chinesefont = new Font(baseFont);
		PdfPTable table = new PdfPTable(colnum);
		table.setWidthPercentage(widthPercentage);//占用空白的百分比
		table.setTotalWidth(colRatio);//设置各列的比例
		
		
		Phrase phrase = null;
		PdfPCell cell = null;
		//先是添加第一行标题
		for(int i=0;i<colnum;i++)
		{
			phrase = new Phrase(tableTitle[i],chinesefont);
			cell = new PdfPCell(phrase);
			//设置边框宽度
			cell.setBorderWidth(0.5f);
			//设置单元格居中显示内容,水平
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			//垂直水平
			cell.setUseAscender(true); //设置垂直之前必须
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}
		
		
		//表格内容添加
		/*int contentSize = tableContent.size();
		for(int i=0;i<contentSize;i++)
		{
			
			Map<String,String> map = tableContent.get(i);
			for(int j=0;j<colnum;j++)
			{
				phrase = new Phrase(map.get(tableTitle[j]),chinesefont);
				//p2.setAlignment(Element.ALIGN_CENTER);
				cell = new PdfPCell(phrase);
				cell.setBorderWidth(0.2f);
				//设置单元格居中显示内容,水平
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//垂直水平
				cell.setUseAscender(true); //设置垂直之前必须
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			}
			
		}*/
		return table;
		
	}
}
