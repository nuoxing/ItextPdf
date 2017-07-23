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

public class TestTable {

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
		
		String[] tableTitle = new String[]{"姓名","性别","职务","住所","身份证号码","产生方式"};
		List<Map<String,String>> tableContent = new ArrayList<Map<String,String>>();
		Map<String,String> map1 = new HashMap<String, String>();
		map1.put("姓名", "小明");
		map1.put("性别", "男");
		map1.put("职务", "经理");
		map1.put("住所", "广东省广州市");
		map1.put("身份证号码", "46545645645645");
		map1.put("产生方式", "聘用");
		tableContent.add(map1);
		tableContent.add(map1);
		tableContent.add(map1);
		tableContent.add(map1);
		tableContent.add(map1);
		tableContent.add(map1);
		tableContent.add(map1);
		tableContent.add(map1);
		PdfPTable table = createSimpleTable(tableTitle,tableContent,6,new float[]{0.2f,0.1f,0.1f,0.4f,0.3f,0.2f},99f);
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
		int contentSize = tableContent.size();
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
			
		}
		return table;
		
	}
}
