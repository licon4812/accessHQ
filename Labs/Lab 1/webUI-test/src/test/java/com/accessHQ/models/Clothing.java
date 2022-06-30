package com.accessHQ.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Clothing {
    private final WebElement itemElement;

    public Clothing(WebElement itemElement) {
        this.itemElement = itemElement;
    }

    public String getName(){
        return itemElement.findElement(By.cssSelector("td[data-v-3e2c7690]")).getText();
    }
}
