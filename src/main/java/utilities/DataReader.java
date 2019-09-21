package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

	static XSSFWorkbook wb=null;
	static XSSFSheet sheet=null;
	
	public static Object [][] xl_Reader(String path,String sheetName) throws IOException {
	File file=new File(path);
	FileInputStream fis=new FileInputStream(file);
	wb=new XSSFWorkbook(fis);
	sheet=wb.getSheet(sheetName);
	int rows=sheet.getLastRowNum();
	int columns=sheet.getRow(0).getLastCellNum();
	
	Object[][] data=new Object[rows][columns];
	for(int i=0;i<data.length;i++) {
		for(int j=0;j<columns;j++) {
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
	}
	
	return data;
	}
	
	
	
}
