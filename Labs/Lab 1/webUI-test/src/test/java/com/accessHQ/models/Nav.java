package com.accessHQ.models;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nav {
    private final ChromeDriver driver;
    private final String tab;

    public Nav(ChromeDriver driver, String tab) {
        this.driver = driver;
        this.tab = tab;
    }

    public void clickTab(){
        driver.findElement(By.cssSelector("[aria-label = planets]")).click();
    }
}
