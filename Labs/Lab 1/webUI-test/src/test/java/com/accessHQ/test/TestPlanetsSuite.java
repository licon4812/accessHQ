package com.accessHQ.test;

import com.accessHQ.models.Nav;
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
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/index.html#");
        driver.manage().window().maximize();
    }

    @Test
    public void testEarthExplore(){
        Nav nav = new Nav(driver,"Planets");
        nav.clickTab();
        var planetPage = new PlanetPage(driver);
        planetPage.getPlanet(p -> p.getName().equalsIgnoreCase("Earth"));
        Assertions.assertEquals("Exploring Earth", planetPage.getPopUp());
    }

    @Test
    public void findPlanetWithRadiusOf58232(){
        Nav nav = new Nav(driver,"Planets");
        nav.clickTab();
        var planetPage = new PlanetPage(driver);
        planetPage.getPlanet(p -> p.getRadius() == 58232);
        Assertions.assertEquals("Exploring Saturn", planetPage.getPopUp());
    }

    @Test
    public void findPlanetWithDistanceOf57910000(){
        Nav nav = new Nav(driver,"Planets");
        nav.clickTab();
        var planetPage = new PlanetPage(driver);
        planetPage.getPlanet(p -> p.getDistance() == 57910000L);
        Assertions.assertEquals("Exploring Mercury", planetPage.getPopUp());
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
