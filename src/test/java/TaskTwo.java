import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import TaskTwo_Locators.*;
import java.util.concurrent.TimeUnit;

public class TaskTwo {
    String from="CHIKKAMAGALURU";
    String to="BENGALURU";
    String mobile_num="6789125987";
    String mail="Mohamed@gmail.com";
    String Customer_name="Mohamed";
    String age="24";
    popular_routes_locators popularRoutes;
    seat_page seat;
    WebDriver driver= new ChromeDriver();
    SoftAssert softAssert = new SoftAssert();
    @BeforeTest
    public void open_browser()
    {

        WebDriverManager.chromedriver().setup();
        driver.navigate().to("https://ksrtc.in/oprs-web/guest/home.do?h=1");
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        popularRoutes=new popular_routes_locators();
        seat=new seat_page();

    }
    @Test
    public void reserve_seat() throws InterruptedException {

        //-	Choose the following ((from "CHIKKAMAGALURU" to "BENGALURU”)) from the popular routes
        popularRoutes.placefrom(driver).clear();
        popularRoutes.placefrom(driver).sendKeys(from);
        popularRoutes.selectfrom(driver).click();
        popularRoutes.placeto(driver).sendKeys(to);
        Thread.sleep(1000);
        popularRoutes.selectto(driver).click();

        //-	Choose the arrival date only
        popularRoutes.arrival(driver).click();
        popularRoutes.right_arrow(driver).click();
        popularRoutes.select_date(driver).click();

        //-	Click “Search for bus”
        popularRoutes.search_btn(driver).click();

        //-	Select a seat
        seat.select_seat(driver).click();

        //-	Choose the boarding point and dropping point
        seat.boarding(driver).click();
        Thread.sleep(1000);
        seat.dropping(driver).click();
        Thread.sleep(1000);

        //-	Fill the “Customer” details
        seat.customer_profile_btn(driver).click();
        seat.mobile_num(driver).sendKeys(mobile_num);
        seat.email(driver).sendKeys(mail);

        // searching for the first available seat
        seat.select_chair(driver,1).click();
        for (int i=2;i<13;i++) {
            try {
                seat.passenger_name(driver);
                break;
            } catch (Exception e) {
                System.out.println("The Seat is not empty please select another Seat");
                seat.select_chair(driver,i).click();
            }
        }
        //-	Fill the “Passenger” details
        seat.passenger_name(driver).sendKeys(Customer_name);
        seat.passenger_gender_tab(driver).click();
        seat.passenger_gender_type(driver).click();
        seat.passenger_age(driver).sendKeys(age);
        seat.passenger_concession(driver).click();
        seat.select_passenger_concession(driver).click();
        //-	Click on “make payment” and fill all the fields without submitting the payment
        seat.make_payement(driver).click();



    }
    @AfterTest
    public void Close_browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
