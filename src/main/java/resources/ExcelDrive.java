package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDrive {

	FileInputStream fileInput;
	File source;
	XSSFWorkbook book;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

	public ArrayList<String> getData(int sheetIndex) {
		ArrayList<String> array = new ArrayList<String>();

		try {

			String path = "C://ProjectElevate//TestData//TestDataDrive.xlsx";
			source = new File(path);
			fileInput = new FileInputStream(source);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			book = new XSSFWorkbook(fileInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheetAt(sheetIndex);

		Iterator<Row> allRows = sheet.iterator();
		Row headerRow = allRows.next();
		Row dataRow = allRows.next();
		Iterator<Cell> dataCellValues = dataRow.cellIterator();
		while (dataCellValues.hasNext()) {

			Cell dataCellValue = dataCellValues.next();
			if (dataCellValue.getCellTypeEnum() == CellType.STRING) {
				array.add(dataCellValue.getStringCellValue());
			} else {
				array.add(NumberToTextConverter.toText(dataCellValue.getNumericCellValue()));

			}

		}
		return array;
	}
}
