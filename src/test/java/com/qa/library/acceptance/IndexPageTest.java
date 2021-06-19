package com.qa.library.acceptance;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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
@Sql(scripts = {"classpath:Library-Schema.sql","classpath:Library-Data.sql"}, 
executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class IndexPageTest {

    private static WebDriver driver;
    private static WebElement targ;
    private static String URL = ("http://localhost:8080/");

    @BeforeAll  
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().window().maximize(); 

    } 

    @Test
    public void testCreate() throws InterruptedException {
        driver.get(URL);

        WebElement i = driver.findElement(By.xpath("/html/body/main/section[2]/div/form[1]/fieldset/input"));
        
        i.sendKeys("Rowan Library");
        
        Thread.sleep(2000);
          
        i.submit();
        
        Thread.sleep(2000);
      
        
        targ = driver.findElement(By.xpath("/html/body/main/section[3]/div/div[2]/div/div[1]/p[1]"));
        assertEquals("Library Name: Rowan Library", targ.getText());
    }
    
    @Test
    public void testRead() throws InterruptedException {
        driver.get(URL);
            
        Thread.sleep(2000);
            
        WebElement i = driver.findElement(By.xpath("/html/body/main/section[3]/div/div[1]/div/div[1]/p[1]"));
           
        assertEquals("Library Name: Birch Library", i.getText());
                     
    }
    
    @Test
    public void testUpdate() throws InterruptedException {
    	driver.get(URL);
    	
    	Thread.sleep(2000);
       	
    	targ = driver.findElement(By.xpath("/html/body/main/section[3]/div/div/div/div[2]/a[3]"));
    
    	targ.click();	
    	
    	Thread.sleep(4000);
    	
    	WebElement i = driver.findElement(By.xpath("/html/body/main/section[2]/div/form[2]/fieldset/div/input"));
    	
    	Thread.sleep(3000);
    	
    	i.sendKeys("Elm Library"); 	
    	i.submit();
    	
    	Thread.sleep(3000);
    	
    	targ = driver.findElement(By.xpath("/html/body/main/section[3]/div/div[1]/div/div[1]/p[1]"));
    	assertEquals("Library Name: Elm Library", targ.getText());
    	
    }
    
//    @Test
//    public void testDelete() throws InterruptedException {
//    	driver.get(URL);
//    	Thread.sleep(5000);
//    	
////    	WebElement i = driver.findElement(By.xpath("/html/body/main/section[3]/div/div[1]/div/div[1]/p[1]"));
//    	
//    	targ = driver.findElement(By.xpath("/html/body/main/section[3]/div/div[1]/div/div[2]/a[2]"));
//    	Thread.sleep(2000);
//    	targ.click();
//    	Thread.sleep(2000);
//    	
//    	
////    	Assertions.assertEquals(false, i.isDisplayed());
//    }
    
    @AfterAll
    public static void tearDown() {
		driver.quit();
    }

} 
