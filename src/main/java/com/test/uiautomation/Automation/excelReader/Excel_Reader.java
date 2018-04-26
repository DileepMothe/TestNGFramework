package com.test.uiautomation.Automation.excelReader;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {

	public String path;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

	public Excel_Reader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public String[][] getDataFromSheet(String sheetName, String excelName) {
		String dataSets[][] = null;

		try {
			sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum() + 1;
			int totalColumn = sheet.getRow(0).getLastCellNum();
			dataSets = new String[totalRow - 1][totalColumn];
			for (int i = 1; i < totalRow; i++) {
				XSSFRow rows = sheet.getRow(i);
				for (int j = 0; j < totalColumn; j++) {
					XSSFCell cell = rows.getCell(j);

					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						dataSets[i - 1][j] = cell.getStringCellValue();
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						String cellText = String.valueOf(cell.getStringCellValue());
						dataSets[i - 1][j] = cellText;
					} else
						dataSets[i - 1][j] = String.valueOf(cell.getBooleanCellValue());

				}
			}

			return dataSets;
		} catch (Exception e) {
			System.out.println("Exception is occured while reading excel" + e.getMessage());
			e.printStackTrace();
		}

		return dataSets;
	}

	
	
	
	

	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			int col_Num = 0;
			int index = workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			XSSFRow row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equals(colName)) {
					col_Num = i;
				}
			}
			row = sheet.getRow(rowNum - 1);
			XSSFCell cell = row.getCell(col_Num);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				return String.valueOf(cell.getNumericCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				return String.valueOf(cell.getBooleanCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, int colName, int rowNum) {
		try {
			int index = workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			XSSFRow row = sheet.getRow(0);
			row = sheet.getRow(rowNum - 1);
			XSSFCell cell = row.getCell(colName);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				return String.valueOf(cell.getNumericCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				return String.valueOf(cell.getBooleanCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}*/

	public int getRowCount(String sheetName) {
		try {
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1) {
				return 0;
			} else {
				sheet = workbook.getSheetAt(index);
				int number = sheet.getLastRowNum() + 1;
				return number;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getColumnCount(String sheetName) {
		try {
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1) {
				return 0;
			} else {
				sheet = workbook.getSheet(sheetName);
				row = sheet.getRow(0);
				return row.getLastCellNum();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "//src//test//resources//Login.xlsx";
		Excel_Reader obj = new Excel_Reader(path);
		// System.out.println(obj.getCellData("Login", "UserName", 4));

		System.out.println(obj.getRowCount("Login"));

		System.out.println(obj.getColumnCount("Login"));

		System.out.println(obj.getCellData("Login", 2, 3));
	}*/

}