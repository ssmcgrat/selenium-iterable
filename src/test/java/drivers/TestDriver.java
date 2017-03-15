package drivers;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import excelFileIO.ReadExcel;

public class TestDriver {
	
	protected WebDriver driver;
	protected HashMap<String, String> data;
	protected ReadExcel readExcel = new ReadExcel();
	private String dataFile = "testData1.xlsx";
	
	@BeforeTest
	public void beforeTest() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		this.data = readExcel.loadDataToHash(dataFile, "Sheet1");
	}

	@AfterTest
	public void afterTest() {	
		driver.quit();
	}
		
}
