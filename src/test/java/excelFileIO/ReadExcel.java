package excelFileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public HashMap<String, String> readExcel(String filePath, String fileName, String sheetName) throws IOException{

		HashMap<String, String> map = new HashMap<String, String>();

		//Create a object of File class to open xlsx file

		File file =    new File(filePath+"\\"+fileName);

		//Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(inputStream);;

		//Read sheet inside the workbook by its name

		Sheet sheet = workbook.getSheet(sheetName);

		//Find number of rows in excel file

		int rowCount = sheet.getLastRowNum()- sheet.getFirstRowNum();

		//Create a loop over all the rows of excel file to read it
		DataFormatter formatter = new DataFormatter();
		Row firstRow = sheet.getRow(0);

		for (int i = 1; i < 2; i++) {

			Row row = sheet.getRow(i);

			// Get key and value for HashMap

			Cell keyCell = firstRow.getCell(2);
			Cell valueCell = row.getCell(2);
			String key = formatter.formatCellValue(keyCell);
			String value = formatter.formatCellValue(valueCell);
			System.out.println("key: " + key + "   value: " + value);
			map.put(key,  value);	        
		}
		return map;
	}
	
	public HashMap<String, String> loadDataToHash(String filename, String sheetname) throws IOException {
		//ReadExcelFile excelFile = new ReadExcelFile();
		String filePath = System.getProperty("user.dir");
		return readExcel(filePath, filename, sheetname);
	}
}
