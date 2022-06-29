package com.accessHQ.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PlanetPage {
    private final ChromeDriver driver;
    private final String planetName;
    private final WebElement planetWebElement;

    public PlanetPage(ChromeDriver driver, String planetName) {
        this.driver = driver;
        this.planetName = planetName;
        planetWebElement = null;
    }
    public void clickExplore(String planetName) {
        for(Planet planet: getPlanets()){
            if(planet.getName().equalsIgnoreCase(planetName)){
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
