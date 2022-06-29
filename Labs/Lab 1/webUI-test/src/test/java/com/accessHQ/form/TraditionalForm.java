package com.accessHQ.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TraditionalForm {
    private final ChromeDriver driver;

    public TraditionalForm(ChromeDriver driver) {
        this.driver = driver;
    }
    public void clickAllow() {
        driver.findElement(By.id("allow")).click();
    }

    public void setAddress(String address) {
        driver.findElement(By.id("address")).sendKeys("31 Champagne Drive");
    }

    public void setGender(String gender) {
        for(WebElement currentElement: driver.findElements(By.tagName("select"))){
            if(currentElement.getText().equalsIgnoreCase(gender)){
                currentElement.click();
                break;
            }
        }
    }

    public void openForm() {
        for(WebElement currentElement: driver.findElements(By.className("v-tab"))){
            if(currentElement.getText().equalsIgnoreCase("traditional")){
                currentElement.click();
                break;
            }
        }
    }
}
