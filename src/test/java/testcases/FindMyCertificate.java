package testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class FindMyCertificate {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void openCertifiedTestersPage( ) {
		driver.get("http://www.istqb.in/istqb-foundation/foundationnew");
		String pageHeader=driver.findElement(By.xpath("//div[@class='page-header']/h1")).getText();
		assertEquals(pageHeader, "CERTIFIED TESTERS (Foundation)");
	}
	
	@Test
	public void searchByName() {
		driver.findElement(By.cssSelector("input.inputbox.searchword")).sendKeys("Harshada Chandrashekhar Kulkarni");
		driver.findElement(By.cssSelector("button.btn.btn-search")).click();
		String searchResults = driver.findElement(By.xpath("//div[@class='joodb database-list']/form[@name='joodbForm']/p[1]")).getText();
		assertEquals(searchResults, "Results 1 - 1 of 1");
	}

}
