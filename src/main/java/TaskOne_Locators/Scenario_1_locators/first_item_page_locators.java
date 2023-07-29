package TaskOne_Locators.Scenario_1_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class first_item_page_locators
{
    public WebElement cart_btn(WebDriver driver) {
        return driver.findElement(By.cssSelector("span > input[aria-labelledby=\"submit.add-to-cart-announce\"]"));
    }
    public WebElement cart_btn_after_adding_item(WebDriver driver) {
        return driver.findElement(By.cssSelector("span > a[data-csa-c-content-id=\"sw-gtc_CONTENT\"]"));
    }
    public WebElement proceed_checkout(WebDriver driver) {
        return driver.findElement(By.cssSelector("span > input[name=\"proceedToRetailCheckout\"]"));
    }
    public WebElement added_successfully_txt(WebDriver driver) {
        return driver.findElement(By.cssSelector("span[class=\"a-size-medium-plus a-color-base sw-atc-text a-text-bold\"]"));
    }
    public WebElement cart_icon(WebDriver driver) {
        return driver.findElement(By.id("nav-cart-count-container"));
    }
}
