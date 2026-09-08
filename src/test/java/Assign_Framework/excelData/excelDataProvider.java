package Assign_Framework.excelData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDataProvider {
	
	FileInputStream inputStream;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow rowData;
	XSSFCell cellData;
	DataFormatter dataformatter=new DataFormatter();
	protected String excelPath;
	protected String sheetname;
	int rowCount=0;
	int colCount=0;
	Object excelData[][];
	
	public excelDataProvider(String excelPath,String sheetname)
	{
		this.excelPath=excelPath;
		this.sheetname=sheetname;
	}
	
	public int NumberofRows(String excelPath,String sheetname) throws IOException
	{
		try {
			inputStream= new FileInputStream(excelPath);
			workbook=new XSSFWorkbook(inputStream);
			sheet=workbook.getSheet(sheetname);
			
			rowCount=sheet.getPhysicalNumberOfRows();
			//System.out.println(rowCount);
			return rowCount;
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			workbook.close();
			inputStream.close();
		}
		return rowCount;
	}
	
	
	public int NumberofColumns(String excelPath,String sheetname) throws IOException
	{
		try {
			inputStream= new FileInputStream(excelPath);
			workbook=new XSSFWorkbook(inputStream);
			sheet=workbook.getSheet(sheetname);
			
			rowCount=sheet.getPhysicalNumberOfRows();
		
			if(rowCount>0)
			{
				rowData=sheet.getRow(0);
				
				//System.out.println(rowData);
				colCount=rowData.getLastCellNum();
			}
			//System.out.println(colCount);
			return colCount;
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			workbook.close();
			inputStream.close();
		}
		return colCount;
	}
	
	
	
	public Object[][] excelDataFormatter(String excelPath,String sheetname) throws IOException
	{
		try {
			inputStream= new FileInputStream(excelPath);
			workbook=new XSSFWorkbook(inputStream);
			sheet=workbook.getSheet(sheetname);
			
			rowCount=sheet.getPhysicalNumberOfRows();
									
			if(rowCount>0)
			{
				rowData=sheet.getRow(0);
				colCount=rowData.getLastCellNum();
				excelData= new Object[rowCount-1][colCount];
				//System.out.println(rowCount-1);
				//System.out.println(colCount);
				for(int i=0;i<rowCount-1;i++)
				{
						rowData=sheet.getRow(i+1);
										
					for(int j=0;j<colCount;j++)
					{
						cellData=rowData.getCell(j);
						//System.out.println(cellData.toString()); 
						//System.out.println("i j"+i+" "+j);
						excelData[i][j]=dataformatter.formatCellValue(cellData);
						
						//System.out.println("Exceldata " +excelData[i][j]);
					}
				}

			}
			return excelData;
			
			
			
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			workbook.close();
			inputStream.close();
			
		}
		return excelData;
		
		
		
	}

}
