import TaskOne_Locators.Scenario_2_locators.Todaysdeal_pg_locators;
import TaskOne_Locators.Scenario_1_locators.Car_accessories_Page_locators;
import TaskOne_Locators.Scenario_1_locators.Cart_locators;
import TaskOne_Locators.Scenario_1_locators.Search_page_locators;
import TaskOne_Locators.Scenario_1_locators.first_item_page_locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TaskOne
{
    String search_statement="car accessories";
    Search_page_locators search_page_locators;
    Car_accessories_Page_locators car_accessories_page;
    first_item_page_locators first_item;
    Cart_locators cart_locators;
    Todaysdeal_pg_locators td;
    WebDriver driver= new ChromeDriver();
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void open_browser()
    {
        WebDriverManager.chromedriver().setup();

        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        search_page_locators = new Search_page_locators();
        first_item = new first_item_page_locators();
        car_accessories_page= new Car_accessories_Page_locators();
        cart_locators= new Cart_locators();
        td=new Todaysdeal_pg_locators();
    }
        @Test
     public void add_first_item_to_cart_Successfully()
     {
         // 1- Open amazon link “https://www.amazon.com/” then type " car accessories"
         search_page_locators.getSearch_txt_elem(driver).clear();
         search_page_locators.getSearch_txt_elem(driver).sendKeys(search_statement);
         softAssert.assertTrue(search_page_locators.get_Search_btn_elem(driver).isDisplayed());
         search_page_locators.get_Search_btn_elem(driver).click();

         //2- Select the first Item
         car_accessories_page.getFirstItem(driver).click();
         String product_title=driver.findElement(By.id("productTitle")).getText();

         //3- Add item to the cart
         softAssert.assertTrue(first_item.cart_btn(driver).isDisplayed(),"Add to the cart button is not displayed !!");
         first_item.cart_btn(driver).click();

         // item is added succesfully Text
         softAssert.assertTrue(first_item.cart_btn_after_adding_item(driver).isDisplayed(),"The cart button is not displayed !!");
         softAssert.assertTrue(first_item.proceed_checkout(driver).isDisplayed(),"proceed to Checkout button is not displayed !!");
         String item_is_added=first_item.added_successfully_txt(driver).getText();
         softAssert.assertEquals("Added to Cart",item_is_added,"Added to the cart text contains error !!");

         // 4-Go to the cart and check that item is added successfully
         first_item.cart_icon(driver).click();
         String Product_title_cart = cart_locators.product_title(driver).getText();

         // Remove the last Three characters (ex: three dots)
         String Product_title_cart2 = Product_title_cart.substring(0, Product_title_cart.length()-3);

         System.out.println("Title without last three characters " + Product_title_cart2);
          softAssert.assertEquals(product_title.contains(Product_title_cart2),true);
          softAssert.assertAll();
     }
    @Test
    public void todays_deal() throws InterruptedException {
        // 1- Open today's deals
        td.todaysdealbtn(driver).click();

        // 2- from the left side filters select "Headphones" and "grocery"
        td.grocery(driver).click();
        td.headphones(driver).click();

        //3- from the discount part choose "10% off or more"
        td.discount(driver).click();
        Thread.sleep(10000);

        //4- go to the fourth page then select any item and add it to the cart

         // Check for the actual number of pages in the website
        String x=td.page_number(driver).getAttribute("aria-label");
        String [] page_numbers=x.split(" ");
        int page=Integer.parseInt(page_numbers[page_numbers.length-1]);

        Assert.assertTrue(page>=4,"Page 4 is not found");
        System.out.println("pages : "+page);

        // if the assertion is true and pages greater than 4 then click on the next button till page 4 appears and open it
        while(true)
        {
            try {
                td.nextBTN(driver).click();
                Thread.sleep(10000);
                driver.findElement(By.xpath("/html/body/div[1]/div[20]/div/div/div/div[3]/div/ul/li[5]")).click();
            } catch (Exception e) {
                System.out.println("page is not found!");
            }
        }
    }

    @AfterTest
    public void Close_browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}