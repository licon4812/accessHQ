package com.accessHQ.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlanetPage {
    private final ChromeDriver driver;

    public PlanetPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void clickExplore(Predicate<Planet> strategy) {
        for(Planet planet: getPlanets()){
            if(strategy.test(planet)){
                planet.clickExploreButton();
                waitForPopupMessage();
                break;
            }
        }
    }

    private List<Planet> getPlanets() {
        var planets = new ArrayList<Planet>();
        for (WebElement planetWebElement: driver.findElements(By.className("planet"))) {
            planets.add(new Planet(planetWebElement));
        }
        return planets;
    }

    public void waitForPopupMessage() {
        var popup = driver.findElement(By.className("popup-message"));
        new WebDriverWait(driver,1).until(ExpectedConditions.visibilityOf(popup));
    }

    public String getPopUp() {
        return driver.findElement(By.className("popup-message")).getText();
    }

}
