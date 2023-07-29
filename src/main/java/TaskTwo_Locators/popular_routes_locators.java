package TaskTwo_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class popular_routes_locators {
    public WebElement placefrom(WebDriver driver) {
        return  driver.findElement(By.id("fromPlaceName"));
    }
    public WebElement placeto(WebDriver driver) {
        return  driver.findElement(By.id("toPlaceName"));
    }
    public WebElement arrival(WebDriver driver) {
        return driver.findElement(By.id("txtJourneyDate"));
    }
    public WebElement select_date(WebDriver driver) {
        return  driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[4]/td[6]/a"));
    }
    public WebElement right_arrow(WebDriver driver) {
        return driver.findElement(By.cssSelector("span[class=\"ui-icon ui-icon-circle-triangle-e\"]"));
    }
    public WebElement search_btn(WebDriver driver) {
        return  driver.findElement(By.cssSelector("button[class='btn btn-primary btn-lg btn-block btn-booking']"));
    }
    public WebElement selectfrom(WebDriver driver) {
        return driver.findElement(By.id("ui-id-3"));
    }
    public WebElement selectto(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/ul[2]/li"));
    }
}
