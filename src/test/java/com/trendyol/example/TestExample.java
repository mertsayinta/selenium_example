package com.trendyol.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

@Listeners(Listener.class)
public class TestExample {

    WebDriver webDriver;

    @BeforeSuite
    public void beforeSuite() {
        // mac & linux chmod +x chromedriver
        System.setProperty("webdriver.chrome.driver", "/Users/mert.sayinta/Downloads/chromedriver");
        System.out.println("before suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.get("http://www.trendyol.com");
        Thread.sleep(2000);
        System.out.println("before method");
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
        System.out.println("after method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite");
    }

    @Test
    public void testOne() throws InterruptedException {
        System.out.println("Test 1");
        WebElement popupElement = webDriver.findElement(By.className("fancybox-close"));
        popupElement.click();
        Thread.sleep(3000);

        WebElement searchBox = webDriver.findElement(By.className("search-box"));
        searchBox.click();
        Thread.sleep(1000);

        searchBox.sendKeys("elbise");
        Thread.sleep(1000);

        WebElement searchButtonElement = webDriver.findElement(By.className("search-icon"));
        searchButtonElement.click();
        Thread.sleep(1000);

        WebElement searchText = webDriver.findElement(By.cssSelector(".dscrptn h1"));
        String searchTxt = searchText.getText();

        boolean isSame = searchTxt.equals("elbise");
        assertTrue(isSame, "Elbise bulunamadi");
    }

}
