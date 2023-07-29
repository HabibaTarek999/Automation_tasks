package TaskTwo_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class seat_page {
    public WebElement select_seat(WebDriver driver) {
        return  driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[1]/div[1]/div[3]/div/input[4]"));
    }
    public WebElement select_chair(WebDriver driver,int i) {
        return  driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div/ul[4]/li["+i+"]/span"));
    }
    public WebElement boarding(WebDriver driver) {
        return  driver.findElement(By.id("Forwardboarding-tab"));
    }
    public WebElement dropping(WebDriver driver) {
        return  driver.findElement(By.id("Forwarddroping-tab"));
    }
    public WebElement customer_profile_btn(WebDriver driver) {
        return  driver.findElement(By.id("Forwardprofile-tab"));   }
    public WebElement mobile_num(WebDriver driver) {
        return  driver.findElement(By.name("mobileNo"));
    }
    public WebElement email(WebDriver driver) {
        return  driver.findElement(By.name("email"));
    }
    public WebElement passenger_name(WebDriver driver) {
        return  driver.findElement(By.id("passengerNameForward0"));
    }
    public WebElement passenger_gender_tab(WebDriver driver) {
        return  driver.findElement(By.id("genderCodeIdForward0"));
    }
    public WebElement passenger_gender_type(WebDriver driver) {
        return  driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[3]/div/div/div/div/div[1]/div/div[2]/div[2]/select/option[2]"));
    }
    public WebElement passenger_age(WebDriver driver) {
        return  driver.findElement(By.name("passengerAge"));
    }
    public WebElement passenger_concession(WebDriver driver) {
        return  driver.findElement(By.id("concessionIdsForward0"));
    }
    public WebElement select_passenger_concession(WebDriver driver) {
        return  driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[3]/div/div/div/div/div[1]/div/div[2]/div[5]/select/option[2]"));
    }
    public WebElement make_payement(WebDriver driver) {
        return  driver.findElement(By.id("PgBtn"));
    }
}
