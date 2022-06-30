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

    public void clickExplore(Planet planet) {
        planet.clickExploreButton();
    }

    public void getPlanet(Predicate<Planet> strategy){
        for(Planet planet: getPlanets()){
            if(strategy.test(planet)){
                clickExplore(planet);
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
        new WebDriverWait(driver,1).until(d->
                ExpectedConditions.visibilityOf(d.findElement(By.className("popup-message"))));
    }

    public String getPopUp() {
        return driver.findElement(By.className("popup-message")).getText();
    }

}
