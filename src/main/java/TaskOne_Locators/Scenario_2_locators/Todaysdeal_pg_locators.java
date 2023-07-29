package TaskOne_Locators.Scenario_2_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Todaysdeal_pg_locators
{
    public WebElement todaysdealbtn(WebDriver driver) {
        return driver.findElement(By.cssSelector("a[data-csa-c-slot-id=\"nav_cs_0\"]"));
    }
    public WebElement headphones(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[data-csa-c-element-id=\"filter-department-16310101\"]"));
    }
    public WebElement grocery(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[data-csa-c-element-id=\"filter-department-172541\"]"));
    }
    public WebElement discount(WebDriver driver) {
        return  driver.findElement(By.cssSelector("a[data-csa-c-element-id=\"filter-discount-10-\"]"));
    }
    public WebElement nextBTN(WebDriver driver) {
        return   driver.findElement(By.cssSelector("li[class=\"a-last\"]"));
    }
    public WebElement page_number(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div[20]/div/div/div/div[3]/div/ul/li[2]"));
    }
}
