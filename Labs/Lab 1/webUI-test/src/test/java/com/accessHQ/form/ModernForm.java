package com.accessHQ.form;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModernForm {
    private ChromeDriver driver;

    public ModernForm(ChromeDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void setState(String state) {
        driver.findElement(By.id("state")).sendKeys(state);
    }

    public void clickAgree() {
        driver.findElement(By.cssSelector("[for=agree]")).click();
    }

    public void clickSubmit() {
        for(WebElement currentElement: driver.findElements(By.tagName("button"))){
            if(currentElement.getText().equalsIgnoreCase("submit")){
                currentElement.click();
                break;
            }
        }
    }

    public String getPopUp() {
        var popupElement = driver.findElement(By.className("popup-message"));
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(popupElement));
        return popupElement.getText();
    }
}
