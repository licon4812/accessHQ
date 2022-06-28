import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestWebUISuite {
    @Test
    public void SubmitName(){
        var driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/index.html#/");

        driver.manage().window().maximize();
        driver.findElement(By.id("forename")).sendKeys("James");
        driver.findElement(By.id("submit")).click();

        var popupElement = driver.findElement(By.className("popup-message"));

        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(popupElement));
        Assertions.assertEquals("Hello James", popupElement.getText());

        driver.quit();
    }
}
