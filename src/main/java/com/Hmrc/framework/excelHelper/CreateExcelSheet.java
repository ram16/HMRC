package com.Hmrc.framework.excelHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Hmrc.framework.beans.VehcileDescrition;
import com.Hmrc.framework.beans.VehcileDetails;

public class CreateExcelSheet {
	XSSFSheet sheet;

	// Creating Excel Sheet
	public void createExcelSheet() throws IOException {
		try {

			// Created to add data
			VehcileDescrition V = new VehcileDescrition();

			// Excel Created
			XSSFWorkbook workbook = new XSSFWorkbook();

			// Sheet Added
			XSSFSheet sheet = workbook.createSheet("RegistrationDetails");

			XSSFRow rowHeading = sheet.createRow(0);
			rowHeading.createCell(0).setCellValue("VechileNumber");
			rowHeading.createCell(1).setCellValue("Make");
			rowHeading.createCell(2).setCellValue("Color");

			for (int i = 0; i < 3; i++) {
				XSSFCellStyle stylerowHeading = workbook.createCellStyle();
				XSSFFont font = workbook.createFont();
				font.setBold(true);
				font.setFontHeightInPoints((short) 12);
				stylerowHeading.setFont(font);

			}

			int r = 1;

			for (VehcileDetails details1 : V.VDetailsAll()) {
				Row row = sheet.createRow(r);

				Cell cellVehcileNumber = row.createCell(0);
				cellVehcileNumber.setCellValue(details1.getVechileNumber());
				Cell cellMake = row.createCell(1);
				cellMake.setCellValue(details1.getMake());
				Cell cellColor = row.createCell(2);
				cellColor.setCellValue(details1.getColor());
				r++;
			}
			for (int i = 0; i < 3; i++)
				sheet.autoSizeColumn(i);

			// output of Excel created this path.Refresh the project.
			FileOutputStream out = new FileOutputStream(new File(
					"C:\\Users\\RAMU\\workspace\\HmrcAutomation\\src\\main\\java\\com\\Hmrc\\framework\\TestData\\Test.xlsx"));
			workbook.write(out);
			out.close();

			System.out.println("Sucess");

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
