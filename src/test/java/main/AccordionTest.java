package main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;

import java.util.Arrays;
import java.util.List;


public class AccordionTest {

    private WebDriver driver;

    List<String> expectedPanelText = Arrays.asList
            ("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                    "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                     "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                     "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                     "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                     "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                     "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                     "Да, обязательно. Всем самокатов! И Москве, и Московской области.");

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
    public void CheckAccordionText(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.
                open().
                clickCookiesButton();
        List<WebElement> heading = mainPage.getListAccordingHeading();
        List<WebElement> panel = mainPage.getListAccordingPanel();


        for (int i = 0; i < heading.size();i++) {
            mainPage.waitForToBeClickable();
            heading.get(i).click();
            mainPage.waitForToBeVisible();
            String actual = panel.get(i).getText();
            String expected = expectedPanelText.get(i);
           // System.out.println("actual: " + actual);
           // System.out.println("expected: " + expected);
         Assert.assertEquals(expected,actual);

                }
        }




}
