package AmazonTest;

import java.io.File;
import java.util.List;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import com.mysql.cj.jdbc.Driver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshotObj = new File("image.png");

		FileUtils.copyFile(fileObj, screenshotObj);

		WebElement Search = driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']"));
		Search.sendKeys("Samsung mobiles");
		Thread.sleep(2000);

		WebElement btn_search = driver.findElement(By.id("nav-search-submit-button"));
		btn_search.click();
	}

	List<WebElement> Product_name = driver.findElements(By.xpath("//div[@class='a-setion']//h2//span"));

	List<WebElement> Product_Price = driver
			.findElements(By.xpath("//div[@class='a-setion']//a//span[@class='a-price-whole']"));

	List<WebElement> Product_currency = driver
			.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
	{

		for (int i = 0; i < Product_name.size(); i++) {
			System.out.println("Product : " + Product_name.get(i).getText());

			System.out.println("Price : " + Product_Price.get(i).getText());
		}

	}
}