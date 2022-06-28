package com.accessHQ.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class TestWebUISuite {
    private ChromeDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/index.html#/");
        driver.manage().window().maximize();
    }

    @Test
    public void SubmitName(){
        driver.findElement(By.id("forename")).sendKeys("James");
        driver.findElement(By.id("submit")).click();

        var popupElement = driver.findElement(By.className("popup-message"));

        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(popupElement));
        Assertions.assertEquals("Hello James", popupElement.getText());
    }

    @Test
    public void MakeButtonGoUpAndDown(){
        var button = driver.findElement(By.className("anibtn"));
        button.click();

        button = driver.findElement(By.className("transition-y"));
        button.click();
        //Assertions.assertEquals("Click me up!".toUpperCase(Locale.ROOT), button.getText());
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
