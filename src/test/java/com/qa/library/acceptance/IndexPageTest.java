package com.qa.library.acceptance;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.qa.library.LibraryProjectApplication;

@SpringBootTest(classes = LibraryProjectApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class IndexPageTest {

    private WebDriver driver;
    private String URL = ("http://localhost:8080/");

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));

    } 

    @Test
    public void test() throws InterruptedException {
        driver.get(URL);

        assertEquals("Home Page", driver.getTitle()); 
        
        Thread.sleep(5000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

  
       
        

    } 
    
    
    
    
    
    
    

