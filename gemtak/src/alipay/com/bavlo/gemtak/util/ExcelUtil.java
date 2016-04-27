package com.bavlo.gemtak.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import com.bavlo.domain.Customer;


public class ExcelUtil {

	public static void createExcel(String fileName,String filePath,List<String> columnHeadres,List<List<String>>rows)
	{
		WritableWorkbook workbook=null;
		WritableSheet sheet=null;
		//创建一个可写入的excel文件对象
		String realPath=filePath+fileName;
		try
		{
			File xlsFile=new File(realPath);
			if (xlsFile.exists()) {
				xlsFile.mkdir();
			}
			workbook = Workbook.createWorkbook(new File(realPath));
		}catch (IOException e) {
			e.printStackTrace();
		}
		try
		{
			sheet = workbook.createSheet("客户列表",0);
			sheet.setColumnView(0, 15); 
			sheet.setColumnView(1, 25); 
			sheet.setColumnView(2, 35); 
			sheet.setColumnView(3, 35); 
			sheet.setColumnView(4, 15);
			jxl.write.WritableFont wfc1 = new jxl.write.WritableFont(WritableFont.ARIAL,20,WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK); 
			jxl.write.WritableCellFormat wcfFC1 = new jxl.write.WritableCellFormat(wfc1); 
			wcfFC1.setBackground(jxl.format.Colour.GRAY_25); 
			wcfFC1.setAlignment(Alignment.CENTRE);	

			jxl.write.WritableFont wfc = new jxl.write.WritableFont(WritableFont.TIMES,10,WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK); 
			jxl.write.WritableCellFormat wcfFC = new jxl.write.WritableCellFormat(wfc); 
			//设置背景颜色 
			//wcfFC.setBackground(jxl.format.Colour.GRAY_25); 
			//水平居中 
			wcfFC.setAlignment(Alignment.CENTRE);
			//Label label=new Label(0,0,activity.getName()+"客户信息表",wcfFC1);
			//sheet.addCell(label);
			//sheet.mergeCells(0, 1, 6, 2);
			for(int i=0; i<columnHeadres.size(); i++)
			{
				sheet.addCell(new Label(i,0,columnHeadres.get(i)));
			}
			for(int i=0; i<rows.size(); i++)
			{
				List<String>row = rows.get(i);
				for(int j=0; j<row.size(); j++)
				{
					sheet.addCell(new Label(j,i+1,row.get(j),wcfFC));
				}
			}
			workbook.write();			//写入信息
			workbook.close();			//关闭Excel表
		}catch (Exception e) {
			try
			{
				workbook.close();
			}catch (WriteException el) {
				el.printStackTrace();
			}catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void createExcel(String fileName,String filePath,List<String> columnHeadres,List<List<String>>rows,String sheetName)
	{
		WritableWorkbook workbook=null;
		WritableSheet sheet=null;
		//创建一个可写入的excel文件对象
		String realPath=filePath+fileName;
		try
		{
			File xlsFile=new File(realPath);
			if (xlsFile.exists()) {
				xlsFile.mkdir();
			}
			workbook = Workbook.createWorkbook(new File(realPath));
		}catch (IOException e) {
			e.printStackTrace();
		}
		try
		{
			sheet = workbook.createSheet(sheetName,0);
			sheet.setColumnView(0, 15); 
			sheet.setColumnView(1, 25); 
			sheet.setColumnView(2, 35); 
			sheet.setColumnView(3, 35); 
			sheet.setColumnView(4, 15);
			jxl.write.WritableFont wfc1 = new jxl.write.WritableFont(WritableFont.ARIAL,20,WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK); 
			jxl.write.WritableCellFormat wcfFC1 = new jxl.write.WritableCellFormat(wfc1); 
			wcfFC1.setBackground(jxl.format.Colour.GRAY_25); 
			wcfFC1.setAlignment(Alignment.CENTRE);	

			jxl.write.WritableFont wfc = new jxl.write.WritableFont(WritableFont.TIMES,10,WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK); 
			jxl.write.WritableCellFormat wcfFC = new jxl.write.WritableCellFormat(wfc); 
			//设置背景颜色 
			//wcfFC.setBackground(jxl.format.Colour.GRAY_25); 
			//水平居中 
			wcfFC.setAlignment(Alignment.CENTRE);
			//Label label=new Label(0,0,activity.getName()+"客户信息表",wcfFC1);
			//sheet.addCell(label);
			//sheet.mergeCells(0, 1, 6, 2);
			for(int i=0; i<columnHeadres.size(); i++)
			{
				sheet.addCell(new Label(i,0,columnHeadres.get(i)));
			}
			for(int i=0; i<rows.size(); i++)
			{
				List<String>row = rows.get(i);
				for(int j=0; j<row.size(); j++)
				{
					sheet.addCell(new Label(j,i+1,row.get(j),wcfFC));
				}
			}
			workbook.write();			//写入信息
			workbook.close();			//关闭Excel表
		}catch (Exception e) {
			try
			{
				workbook.close();
			}catch (WriteException el) {
				el.printStackTrace();
			}catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	public static List<Customer> readExcel(File file)
	{
		List<Customer> listCustomer=new ArrayList<Customer>();
		Customer customer=new Customer();
		Workbook wb=null;
		try
		{
			//构造Workbook（工作薄）对象
			wb=Workbook.getWorkbook(file);   
		}catch (BiffException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		if(wb==null)	return null;
		//获得了Workbook对象之后，就可以通过它得到Sheet（工作表）对象了    
		Sheet[] sheet = wb.getSheets();
		if(sheet!=null&&sheet.length>0)
		{
			System.out.println(sheet.length+"^^^^^^sheet");
			for(int i=0;i<sheet.length;i++)
			{
				int rowNum = sheet[i].getRows();
				System.out.println(rowNum+"***********rows");
				for(int j=1;j<rowNum;j++)
				{
					Cell[] cells = sheet[i].getRow(j); 
					System.out.println(cells+"***********cells");
					if(cells!=null&&cells.length>0)
					{
						customer.setRealName(cells[0].getContents());
						customer.setUsername(cells[1].getContents());
						customer.setTel(cells[2].getContents());
						customer.setUser_type(new Long(1));
						listCustomer.add(customer);
						customer=new Customer();
					}
				}
			}
		}			
		wb.close();							//关闭资源，释放内存	
		//System.out.println(listCustomer+"ssssssss");
//		for(int i = 0; i<str.size(); i++)
//		{
//			System.out.println(str.get(i).get(i)+"sssssssssssss");
//		}
		return listCustomer;
	}
}
