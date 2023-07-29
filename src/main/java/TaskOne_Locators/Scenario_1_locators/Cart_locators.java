package TaskOne_Locators.Scenario_1_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart_locators
{
    public WebElement product_title(WebDriver driver) {
        return driver.findElement(By.className("a-truncate-cut"));
    }
}
