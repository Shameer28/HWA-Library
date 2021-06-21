package com.qa.library.acceptance;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.qa.library.LibraryProjectApplication;

@SpringBootTest(classes = LibraryProjectApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@Sql(scripts = { "classpath:Library-Schema.sql",
		"classpath:Library-Data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class AddBooksPageTest {

	private static WebDriver driver;
	private static WebElement targ;
	private static String URL = ("http://localhost:8080"); 

	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().window().setSize(new Dimension(1366, 4000));

	}

	@Test
	public void testCreate() throws InterruptedException {
		driver.get(URL);
		Thread.sleep(3000);
		         
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,250)", ""); //FOR SCROLLING DOWN IN PAGE
		
	    Thread.sleep(2000);
	    
		WebElement i = driver.findElement(By.xpath("/html/body/main/section[3]/div/div[1]/div/div[2]/a[1]"));
		i.click();
		 
		Thread.sleep(2000);
		 
		WebElement y = driver.findElement(By.xpath("/html/body/main/section[1]/div/form[1]/fieldset/div/input[1]"));
		y.sendKeys("Macbeth");
		 
		WebElement z = driver.findElement(By.xpath("/html/body/main/section[1]/div/form[1]/fieldset/div/input[2]"));
		z.sendKeys("Shakesphere");
		z.submit();
		 
		Thread.sleep(2000);
		 
		targ = driver.findElement(By.xpath("/html/body/main/section[2]/div/div[2]/div/div[1]/p[1]"));
	    assertEquals("Book Name: Macbeth", targ.getText());
		 
	    targ = driver.findElement(By.xpath("/html/body/main/section[2]/div/div[2]/div/div[1]/p[2]"));
	    assertEquals("Author: Shakesphere", targ.getText());
	}

	@Test
	public void testRead() throws InterruptedException {
		driver.get(URL);
		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,250)", ""); //FOR SCROLLING DOWN IN PAGE
		
	    Thread.sleep(2000);
		
	    WebElement i = driver.findElement(By.xpath("/html/body/main/section[3]/div/div[1]/div/div[2]/a[1]"));
		i.click();
		 
		Thread.sleep(2000);
		 
		WebElement y = driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div[1]/p[1]"));
		assertEquals("Book Name: Romeo & Julliet", y.getText());
		 
		targ = driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div[1]/p[2]"));
		assertEquals("Author: JK Rowling", targ.getText());
	}

	@Test
	public void testUpdate() throws InterruptedException {
		driver.get(URL);
		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,250)", ""); //FOR SCROLLING DOWN IN PAGE
		
	    Thread.sleep(2000);
		
		WebElement i = driver.findElement(By.xpath("/html/body/main/section[3]/div/div[1]/div/div[2]/a[1]"));
		i.click();
		
		Thread.sleep(2000);
		
		WebElement y = driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div[2]/a[2]"));
		y.click();
		
		WebElement z = driver.findElement(By.xpath("/html/body/main/section[1]/div/form[2]/fieldset/div/input[1]"));
		z.sendKeys("Hamelt");
		
		WebElement x = driver.findElement(By.xpath("/html/body/main/section[1]/div/form[2]/fieldset/div/input[2]"));
		x.sendKeys("Shakesphere");	
		x.submit();
		
		Thread.sleep(3000);
		
		WebElement t = driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div[1]/p[1]"));
		assertEquals("Book Name: Hamelt", t.getText());
		 
		targ = driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div[1]/p[2]"));
		assertEquals("Author: Shakesphere", targ.getText());
	}

	@Test
	public void testDelete() throws InterruptedException {
		driver.get(URL);
		
    	Thread.sleep(3000);
    	
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", ""); //FOR SCROLLING DOWN IN PAGE
        
        Thread.sleep(2000);
        
        WebElement addb  = driver.findElement(By.xpath("/html/body/main/section[3]/div/div[1]/div/div[2]/a[1]"));
        addb.click();
        
        Thread.sleep(1000);
        
        WebElement delb = driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div[2]/a[1]"));
        delb.click();
        
        Thread.sleep(1000);
        
        Boolean isPresent = driver.findElements(By.xpath("/html/body/main/section[2]/div/div/div/div[1]/p[1]")).size() > 0;

    	assertEquals(false, isPresent);
	}

	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
}