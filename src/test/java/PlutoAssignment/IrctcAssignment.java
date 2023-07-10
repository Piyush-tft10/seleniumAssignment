package PlutoAssignment;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class IrctcAssignment {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(By.cssSelector("#disha-banner-close")).click();
		driver.findElement(By.cssSelector(".railDrishti.fa.fa-bus")).click();
		Set<String> handle = driver.getWindowHandles();
		java.util.Iterator<String> it = handle.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		js.executeScript("window.scrollBy(0,300)", "");
		driver.findElement(By.cssSelector("#departFrom")).sendKeys("del");
		List<WebElement> FromLoc = driver.findElements(By.cssSelector(".ui-menu-item"));
		for (WebElement ele : FromLoc) {
			String dept = ele.getText();
			if (dept.equalsIgnoreCase("Delhi")) {
				ele.click();
			}
		}
		driver.findElement(By.cssSelector("#goingTo")).sendKeys("Manali");
		Thread.sleep(2000);
		List<WebElement> toLoc = driver.findElements(By.cssSelector(".ui-menu-item"));
		for (WebElement ele : toLoc) {
			String dept = ele.getText();
			if (dept.equalsIgnoreCase("Manali")) {
				ele.click();
			}
		}
		List<WebElement> dates = driver.findElements(By.cssSelector(".ui-state-default"));
		for (WebElement ele : dates) {
			String dept = ele.getText();
			if (dept.equalsIgnoreCase("25")) {
				ele.click();
			}
		}
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		WebElement selectSeat = driver.findElement(By.xpath("(//div[@id='accordionExample']/div)[1]/div[7]"));
		selectSeat.click();
		for (int i = 1; i <= 2; i++) {
			driver.findElement(By.xpath("(//span[@class='Seating'])[1]")).click();
		}
		js.executeScript("window.scrollBy(0,300)", "");
		driver.findElement(By.xpath("//div[@class='Seat-right-wrap mt-2']/div[4] //button")).click();
		driver.findElement(By.cssSelector("#loginuserid")).sendKeys("");
		driver.findElement(By.cssSelector("#pwd")).sendKeys("");
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)", "");
		WebElement state = driver.findElement(By.xpath("//select[@name='state']"));
		Select StateSelect = new Select(state);
		StateSelect.selectByVisibleText("DELHI");
		driver.findElement(By.xpath("(//input[@placeholder='Traveller Name'])[1]")).sendKeys("travelone");
		Select gen1 = new Select(driver.findElement(By.xpath("(//select[@name='select'])[1]")));
		gen1.selectByValue("M");
		driver.findElement(By.xpath("(//input[@placeholder='Age'])[1]")).sendKeys("25");
		driver.findElement(By.xpath("(//input[@placeholder='Traveller Name'])[2]")).sendKeys("traveltwo");
		Select gen2 = new Select(driver.findElement(By.xpath("(//select[@name='select'])[2]")));
		gen2.selectByValue("M");
		driver.findElement(By.xpath("(//input[@placeholder='Age'])[2]")).sendKeys("22");
		
		js.executeScript("window.scrollBy(0,-500)", "");
		driver.findElement(By.xpath("//input[@id='agree']")).click();
		
		driver.findElement(By.xpath("//button[@class='btn btn-md btn-primary btn-radius yellow-gradient']")).click();
		
	}
}