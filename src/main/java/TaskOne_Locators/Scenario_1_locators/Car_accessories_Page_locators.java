package TaskOne_Locators.Scenario_1_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Car_accessories_Page_locators {
    public WebElement getFirstItem(WebDriver driver) {
        return driver.findElement(By.cssSelector("div[data-index = \"3\"]"));
    }
}
