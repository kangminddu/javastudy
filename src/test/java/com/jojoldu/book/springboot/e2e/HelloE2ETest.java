package com.jojoldu.book.springboot.e2e;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
@Disabled
public class HelloE2ETest {

    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--headless=new",           // 헤드리스(신규)
                "--disable-gpu",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--remote-allow-origins=*"); // ⭐︎ Chrome 115+ 보안 차단 해제

        driver = new ChromeDriver(options);
    }

    @Test
    void helloEndpointDisplaysHello() {
        driver.get("http://localhost:8080/hello");
        String body = driver.findElement(By.tagName("body")).getText();
        Assertions.assertEquals("hello", body);
    }

    @AfterAll
    static void teardown() {
        if (driver != null) driver.quit();
    }
}