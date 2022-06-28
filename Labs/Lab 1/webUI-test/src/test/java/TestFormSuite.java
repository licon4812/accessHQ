import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFormSuite {
    private ChromeDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/index.html#/forms");
        driver.manage().window().maximize();
    }

    @Test
    public void SubmitForm(){
       driver.findElement(By.id("name")).sendKeys("James");
       driver.findElement(By.id("email")).sendKeys("jalickolli@gmail.com");
        driver.findElement(By.id("state")).sendKeys("NSW");;
        driver.findElement(By.cssSelector("[for=agree]")).click();

        driver.findElement(By.className("v-btn__content")).click();

        var popupElement = driver.findElement(By.className("popup-message"));
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(popupElement));
        Assertions.assertEquals("Thanks for your feedback James", popupElement.getText());
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
