package com.accessHQ.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;

public class Planet {
    private final WebElement planetWebElement;

    public Planet(WebElement planetWebElement) {
        this.planetWebElement = planetWebElement;
    }

    public void clickExploreButton() {
        planetWebElement.findElement(By.tagName("button")).click();
    }

    public String getName() {
        return planetWebElement.findElement(By.className("name")).getText();
    }

    public Double getRadius() {
       var radius = planetWebElement.findElement(By.className("radius")).getText();
       radius = radius.replace(",","");
       radius = radius.replace("km","");
       return Double.parseDouble(radius);
    }
}
