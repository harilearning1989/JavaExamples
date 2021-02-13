package com.practice.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class ReadExcelExample {
	public static void main(String[] args) throws Exception {
		readExcel("D:/Student.xlsx");
	}
	public static void readExcel(String filename) throws Exception {
		try {
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filename));
			HSSFSheet sheet = wb.getSheetAt((int) 0);
			if (sheet != null) {
				Iterator<?> rowIterator = sheet.rowIterator();
				while (rowIterator.hasNext()) {
					HSSFRow row = (HSSFRow) rowIterator.next();
					HSSFCell cellStudentID = row.getCell(0);
					HSSFCell cellStudentName = row.getCell(1);
					try {
						String studentId = cellStudentID.getStringCellValue();
						String studentName = cellStudentName
								.getStringCellValue();
						System.out
						.println(studentId + "        " + studentName);
					} catch (NullPointerException e) {
						continue;
					}
				}
			} else {
				System.out.println("Sheet not found");
			}
		} catch (FileNotFoundException fne) {
			System.out.println("File not found");
		}
	}
}
