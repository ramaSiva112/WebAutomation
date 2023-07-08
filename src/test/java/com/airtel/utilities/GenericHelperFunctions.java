package com.airtel.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class GenericHelperFunctions {
	
	public static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
		Workbook workbook = null;

		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}

		return workbook;
	}

	public static Object[][] getExcelData(String excelFilePath, String sheetName) {

		List<Map<String, String>> iterations = new ArrayList<Map<String, String>>();
		String value = null;
		try {

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = getWorkbook(inputStream, excelFilePath);
			Sheet sheet = workbook.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			if (headerRow == null) {
				Reporter.log("Unable to find a header row in the spreadsheet");
				inputStream.close();
				//workbook.close();
				return null;
			}

			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				Map<String, String> data = new TreeMap<String, String>();
				for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);

					switch (currentCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						value = currentCell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC:
						long longVal = (long) currentCell.getNumericCellValue();
						value = Long.valueOf(longVal).toString();
						break;
					}
					data.put(headerRow.getCell(j).getStringCellValue(), value);

				}
				if (data.size() > 0) {
					Reporter.log("[Row " + i + "] " + data);
					iterations.add(data);
				} else {
					Reporter.log("[Row " + i + "] Data Not Found");
				}
			}

			inputStream.close();
			//workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return convertToArray(iterations);

	}

	public static Object[][] convertToArray(List<Map<String, String>> dataMaps) {
		Reporter.log("Converting results to an Array for TestNG");
		Object testData[][] = new Object[dataMaps.size()][1];
		for (int index = 0; index < dataMaps.size(); index++) {
			testData[index][0] = dataMaps.get(index);
		}
		Reporter.log("Finished converting results to an Array for TestNG");
		return testData;
	}


}
