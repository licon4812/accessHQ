package com.accessHQ.test;

import com.accessHQ.models.PlanetPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPlanetsSuite {
    private ChromeDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/index.html#/planets");
        driver.manage().window().maximize();
    }

    @Test
    public void testEarthExplore(){
        var planet = new PlanetPage(driver, "Earth");
        planet.clickExplore("Earth");
        Assertions.assertEquals("Exploring Earth", planet.getPopUp());
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
