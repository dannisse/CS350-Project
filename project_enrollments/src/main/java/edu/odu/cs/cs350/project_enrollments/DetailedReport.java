package edu.odu.cs.cs350.project_enrollments;

import java.io.FileOutputStream;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("PMD")
public class DetailedReport { 
	
	public void createExcel(SortedMap<String, Course> hist, SortedMap<String, Course> curr, String path) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		String[] heading = {"d historical", "date/year", "d current", "date/year", "d projected", "projected"};
		
		for (String key : hist.keySet()) {
			int rowNum = 0;
			int col = 0;
			XSSFSheet sheet = workbook.createSheet(hist.get(key).getCourseTitle());
			Row head = sheet.createRow(rowNum++);
			for (int i = 0; i < 6; i++) {
				Cell headings = head.createCell(col++);
				headings.setCellValue(heading[i]);
			}
			
			Row data = sheet.createRow(rowNum++);
			Cell dHist = data.createCell(1);
			
		}
		try (FileOutputStream outputStream = new FileOutputStream(path)) {
	        workbook.write(outputStream);
  
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
}