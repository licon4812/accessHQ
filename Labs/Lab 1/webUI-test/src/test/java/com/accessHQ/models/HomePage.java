package com.accessHQ.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HomePage {
    private final ChromeDriver driver;

    public HomePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void setItemQtn(Clothing clothing) {
        WebElement itemElement = getItemElement(c -> c.getName().
                equalsIgnoreCase());
        itemElement.findElement(By.tagName("input")).sendKeys("3");
    }
    

    private WebElement getItem(Predicate<Clothing> strategy) {
        for(Clothing clothing: getItems()){
            if(strategy.test(clothing)){
                setItemQtn(clothing);
                getSubTotal(clothing);
                getTotal(clothing);
                break;
            }
        }
    }
    private List<Clothing> getItems() {
        var items = new ArrayList<Clothing>();
        for (WebElement itemElement: driver.findElements(By.className("[data-v-3e2c7690]"))) {
            items.add(new Clothing(itemElement));
        }
        return items;
    }
}
