package GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelsheetlibrary {

	public String readdatafromeexcelsheet(String sheetname,int row,int cell) throws  IOException {
		
		FileInputStream fis1=new FileInputStream(Iconstants.excelfilepath);
		
	   Workbook wb = WorkbookFactory.create(fis1);
	  Sheet sh = wb.getSheet(sheetname);
	  Row rw = sh.getRow(row);
	  Cell cl = rw.getCell(cell);
	  String cellvalue = cl.getStringCellValue();
	  return cellvalue;
	}

	
	   public int getrowcount(String sheetname) throws IOException {
			  FileInputStream fis=new FileInputStream(Iconstants.excelfilepath); 
			  Workbook wb = WorkbookFactory.create(fis);
			  Sheet sh = wb.getSheet(sheetname);
			 int rc = sh.getLastRowNum();
			 wb.close();
			 return rc;		  
	}
	   public void writedataintoexcel(String sheetname,int rownum,int cellnum,String value) throws IOException {
		   FileInputStream fis=new FileInputStream(Iconstants.excelfilepath); 
			  Workbook wb = WorkbookFactory.create(fis);
			  Sheet sh = wb.getSheet(sheetname);
			  Row rw = sh.getRow(rownum);
			  Cell ce = rw.createCell(cellnum);
			  ce.setCellValue(value);
			  FileOutputStream fos=new FileOutputStream(Iconstants.excelfilepath);
			  wb.write(fos);
			  
			  
			   }
	
	    public Object[][] writemultipledataintoexcel(String sheetname) throws EncryptedDocumentException, IOException {
	    	
	    	FileInputStream fis=new FileInputStream(Iconstants.excelfilepath);
	    	
	         Workbook wb = WorkbookFactory.create(fis);
	         
	         Sheet sh = wb.getSheet(sheetname);
	    
	          int lastrow = sh.getLastRowNum();	
	          
	          int lastcell = sh.getRow(0).getLastCellNum();
	           
	          Object[][] obj=new Object[lastrow][lastcell];
	          
	          for(int i=0;i<lastrow;i++) {
	        	  
	        	  for(int j=0;j<lastcell;j++) {
	        		  
	        	 obj[i][j]= sh.getRow(i+1).getCell(j).getStringCellValue();  
	        	  }
	          }
	          return obj;
	    }	
	    	
	    	
	    }
	
	
	
	
	
	
	
	

