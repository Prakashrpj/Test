package DDT_Scripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_Multiple_data {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./Excel_data/Sample_data.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		int count = sh.getLastRowNum();
	//	System.out.println(count); --> 2

		
		  for(int i=0;i<=count;i++)
		  { 
			 Row row = sh.getRow(i); 
	
			 for(int j=0;j<row.getLastCellNum();j++)
			 {
			 Cell cell = row.getCell(j); 
			 System.out.println(cell.toString()+" "); 
			 }
		  }
		  System.out.println();
		 

	}

}
