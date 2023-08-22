package PlutoAssignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelClass {
	FileInputStream inputStream;
	FileOutputStream fos;
	XSSFWorkbook wb;

	public void excelData(int rw, int ce, String result) {

		File file = new File("C:\\Users\\Public\\shutterstockid.xlsx");

		try {
			inputStream = new FileInputStream(file);
			wb = new XSSFWorkbook(inputStream);
			XSSFSheet sheet1 = wb.getSheetAt(0);
			sheet1.createRow(rw).createCell(ce).setCellValue(result);
			fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
