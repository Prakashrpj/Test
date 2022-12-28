package DDT_Scripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.batik.parser.ShapeProducer;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Write_Multiple_data {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./Excel_data/Sample_data.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		
		System.setProperty("webdriver.gecko.driver","./softwares/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		 List<WebElement> links = driver.findElements(By.xpath("//a"));
		 int count=links.size();
		 
		 for (int i=0;i<count;i++) 
		 {
		 Row row = sh.createRow(i);
		 Cell cell = row.createCell(0);
		 cell.setCellValue(links.get(i).getAttribute("href"));
		}
		FileOutputStream fos = new FileOutputStream("./Excel_data/Sample_data.xlsx");
		
		book.write(fos);
	}
	
	

}
