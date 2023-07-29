package TaskOne_Locators.Scenario_1_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search_page_locators
{
    public WebElement getSearch_txt_elem(WebDriver driver) {
        return driver.findElement(By.id("twotabsearchtextbox"));
    }
    public WebElement get_Search_btn_elem(WebDriver driver) {
        return driver.findElement(By.id("nav-search-submit-button"));
    }


}
