package com.accessHQ.test;

import com.accessHQ.models.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHomeSuite {
    private ChromeDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/index.html#");
        driver.manage().window().maximize();
    }

    @Test
    public void testTotalWhenLeviQtnIs3(){
        var homePage = new HomePage(driver);
        homePage.setItemQtn("Levi 501s classic denim", 3);
        Assertions.assertEquals(209.97, homePage.getSubTotal());
        Assertions.assertEquals(249.95, homePage.getTotal());
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
