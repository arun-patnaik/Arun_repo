package day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class Test1 {
@Parameters("browser")
	@Test
	
	public void set(String b)throws IOException {
	System.out.println(b);
	DesiredCapabilities cap=null;
	if(b.equals("firefox")){
		cap=DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.ANY);
	}
	else if(b.equals("chrome"))
	{
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.ANY);
	}
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://49.204.65.122:5656/wd/hub"),cap);
	driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.linkText("REGISTER")).click();
		FileInputStream f=new FileInputStream("D:\\Alok\\seleniumjava\\Book1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet sh=wb.getSheet("Sheet1");
		
		Row r=null;
		Cell c=null;
		WebElement el=driver.findElement(By.name("country"));
		List<WebElement>list=el.findElements(By.tagName("option"));
	
		for(int i=0;i<list.size();i++)
		{
			r=sh.createRow(i);
			
			String  s=list.get(i).getText();
			list.get(i).click();
			r.createCell(1).setCellValue(s);
			
		}
		FileOutputStream f1=new FileOutputStream("D:\\Alok\\seleniumjava\\Book.xlsx");
		wb.write(f1);
		f1.close();
	}

	

}
