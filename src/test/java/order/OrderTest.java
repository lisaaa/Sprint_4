package order;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.MainPage;
import pom.OrderPage;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private String browser;
    private String orderButtonPosition;
    private String name;
    private String surname;
    private String address;
    private String metro;
    private String mobile;
    private String date;
    private String period;
    private String color;
    private String comment;

    public OrderTest( String browser,String orderButtonPosition,String name,String surname, String address, String metro, String mobile, String date, String period, String color,String comment) {

        this.browser = browser;
        this.orderButtonPosition = orderButtonPosition;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.mobile = mobile;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"chrome","up","Иван", "Иванов", "ул Елова д 34", "Красносельская","89223451234" ,"06.11.2022","сутки","черный","привезите пораньше"},
                //{"chrome","down","Петр", "Петров", "ул Родонитовая д 34", "Сокольники","89225678945" ,"17.11.2022","трое суток","серый","спасибо"},
        };
    }

    @Before
    public  void setDriver() {

            WebDriverManager.chromedriver().setup();
            //WebDriverManager.firefoxdriver().setup();
    }

    @After
    public void quit() {

        driver.quit();
    }

    @Test
    public void createOrder(){

        MainPage mainPage = new MainPage(getDriver(browser));

        mainPage
                .open()
                .clickCookiesButton()
                .clickOrderButton(orderButtonPosition);

        OrderPage orderPage = new OrderPage(driver);
        orderPage
                .getInputName(name)
                .getInputSurname(surname)
                .getInputAddress(address)
                .getInputMetro(metro)
                .getInputMobile(mobile)
                .clickNextButton()
                .getOrderDate(date)
                .getOrderPeriod(period)
                .clickCheckBoxColor(color)
                .getComment(comment)
                .clickFinalButtonOrder()
                .clickModalOrderButtonYes();
        Assert.assertFalse("Заказ не оформлен",orderPage.checkModalOrdered());
    }

    public WebDriver getDriver(String browser) {
        if (browser == "chrome"){
            driver = new ChromeDriver();
        } else if (browser == "ff"){
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
