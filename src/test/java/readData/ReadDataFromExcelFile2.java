package readData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelFile2 {

	public static void main(String[] args) throws Exception {

		// file location

		FileInputStream fis = new FileInputStream("./testData/RegistrationData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("smokeTest");

		int rowCount = sheet.getLastRowNum(); // return rows count details
		int columnsCount = sheet.getRow(0).getLastCellNum(); // return cloumns count details

		System.out.println("Rows count: " + rowCount);
		System.out.println("Columns Count: " + columnsCount);

		for (int i = 1; i <= rowCount; i++) {

			XSSFRow currentRow = sheet.getRow(i);

			String firstName = currentRow.getCell(0).toString();
			String lastName = currentRow.getCell(1).toString();
			String email = currentRow.getCell(2).toString();
			String phone = currentRow.getCell(3).toString();
			String address = currentRow.getCell(4).toString();

			
			System.out.println("FirstName and Address: " + firstName + " : " + address);
			System.out.println("--------------------");
			
			
		}

	}

}
