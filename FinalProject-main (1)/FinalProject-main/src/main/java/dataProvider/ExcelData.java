package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelData {

	@DataProvider(name = "DATA")
	public Object[][] readData() throws Exception {

		File f = new File(System.getProperty("user.dir")+"/resources/exceldata/onecogsearch.xlsx");
		FileInputStream input = new FileInputStream(f);
		XSSFWorkbook w = new XSSFWorkbook(input);
		XSSFSheet s = w.getSheet("Sheet1");

		int rowCount = s.getPhysicalNumberOfRows();
		int colCount = s.getRow(0).getLastCellNum();

		Object [][] data = new Object[rowCount-1][colCount];

		for(int r=0 ; r<rowCount-1 ; r++) {
			XSSFRow row = s.getRow(r+1);
			for(int c=0;c<colCount;c++) {

				XSSFCell cell = row.getCell(c);

				CellType celltype = cell.getCellType();

				switch(celltype) {

				case STRING:
					data[r][c] = cell.getStringCellValue();
					break;

				default:
					break;
				}
			}
		}
		w.close();
		return data;
	}

}

