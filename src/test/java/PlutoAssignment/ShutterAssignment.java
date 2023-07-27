package PlutoAssignment;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ShutterAssignment {
	void uploadImage(String urrl, int rw, int ce) throws AWTException, Exception{
	WebDriverManager.chromedriver().setup();
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.shutterstock.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiIconButton-root.MuiIconButton-sizeLarge.mui-anbjyi-reverseSearchImageButton")).click();
		WebElement uploadFile = driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedSecondary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-disableElevation.MuiButton-root.MuiButton-contained.MuiButton-containedSecondary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-disableElevation.mui-fcn18w-uploadButton"));
		uploadFile.sendKeys("C:\\Users\\Piyush Jaiswal\\Downloads");
		Robot rb = new Robot();
		rb.delay(3000);
	    StringSelection str = new StringSelection(urrl);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    WebElement firstImage= driver.findElement(By.xpath("//div[@class='MuiBox-root mui-19n8dai']/div/div/div[1]"));
	    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(4000));
	    wait.until(ExpectedConditions.visibilityOf(firstImage));
	    firstImage.click();
	    Thread.sleep(2000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)", "");
		driver.findElement(By.xpath("//div[@class='MuiBox-root mui-1m5d6cg']/div/span/button")).click();
		Thread.sleep(2000);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		File file = new File("C:\\Users\\Public\\shutterstockid.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		XSSFSheet sheet1= wb.getSheetAt(0); 
		sheet1.createRow(rw).createCell(ce).setCellValue(result);
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		JavascriptExecutor ts = (JavascriptExecutor) driver;
		ts.executeScript("window.scrollBy(0,-600)", "");
		driver.findElement(By.xpath("//a[@class='mui-o90xvh-a-inherit-logo']/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".MuiInputBase-inputTypeSearch")).sendKeys(result);
		driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiIconButton-root.MuiIconButton-colorSecondary")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='mui-31qtcp-root']/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='MuiBox-root mui-1sf3xto']/button")).click();
		Thread.sleep(2000);
		ts.executeScript("window.scrollBy(0,600)", "");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sstock@yopmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
		public static void main(String[] args) throws Exception{
		ShutterAssignment objDog= new ShutterAssignment();
		ShutterAssignment objCat= new ShutterAssignment();
		ShutterAssignment objCar= new ShutterAssignment();
		objDog.uploadImage("C:\\Users\\Piyush Jaiswal\\Downloads\\Funny_Image_of_Dog_with_open_teeth.png", 1, 0 );
		objCat.uploadImage("C:\\Users\\Piyush Jaiswal\\Downloads\\low_Coolest Cat_cover.jpg", 2, 0);
		objCar.uploadImage("C:\\Users\\Piyush Jaiswal\\Downloads\\supra.jpeg", 3, 0);
		}
	}
