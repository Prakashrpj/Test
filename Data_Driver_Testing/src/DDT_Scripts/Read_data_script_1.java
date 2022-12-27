package DDT_Scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_data_script_1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

// specify the path of the excel file		
		FileInputStream fis = new FileInputStream("./Excel_data/Sample_data.xlsx");
// open the excel file		
		Workbook book = WorkbookFactory.create(fis);
// specify the sheet name
		Sheet sh = book.getSheet("Sheet1");
// specify the row number
		Row row = sh.getRow(2);
// specify the cell number
		Cell cell = row.getCell(0);
// fetch the data
		String value = cell.toString();
		System.out.println(value);
	}

}
