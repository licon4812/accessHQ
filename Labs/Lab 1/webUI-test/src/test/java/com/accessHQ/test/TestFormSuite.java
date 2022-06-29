package com.accessHQ.test;

import com.accessHQ.models.ModernForm;
import com.accessHQ.models.TraditionalForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFormSuite {
    private ChromeDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/index.html#/forms");
        driver.manage().window().maximize();
    }

    @Test
    public void TestModernForm(){
        var form = new ModernForm(driver);
        form.setName("James");
        form.setEmail("jalickolli@gmail.com");
        form.setState("NSW");
        form.clickAgree();
        form.clickSubmit();
        form.getPopUp();
        Assertions.assertEquals("Thanks for your feedback James", form.getPopUp());
    }

    @Test
    public void TestTraditionalForm(){
        var form = new TraditionalForm(driver);
        form.openForm();
        form.setAddress("31 Champagne Drive Tweed Heads South");
        form.setGender("Male");
        form.clickAllow();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
