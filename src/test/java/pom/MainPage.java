package pom;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class MainPage {

    private final String url = "https://qa-scooter.praktikum-services.ru";
    private final WebDriver driver;
    private final By orderButtonUp = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By orderButtonDown = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By accordingHeading = By.xpath(".//div[@class='accordion__button']");
    private final By accordingPanel = By.xpath(".//div[@class='accordion__panel']");
    private final By cookiesButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public MainPage open() {
        driver.get(url);
        return this;
    }

    public MainPage clickOrderButton(String orderButtonPosition) {
        if (orderButtonPosition.equals("up") ){
            driver.findElement(orderButtonUp).click();
        } else if (orderButtonPosition.equals("down") ){
            driver.findElement(orderButtonDown).click();
        }


        return this;

    }
    public MainPage clickCookiesButton() {
        driver.findElement(cookiesButton).click();
        return this;

    }


    public  List<WebElement> getListAccordingHeading() {

         List<WebElement> heading = driver.findElements(accordingHeading);
         return heading;
    }


    public  List<WebElement> getListAccordingPanel() {

        List<WebElement> actualPanelText = driver.findElements(accordingPanel);
         return actualPanelText;

        }

    public void waitForToBeClickable(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(accordingHeading));
    }

    public void waitForToBeVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(25))
               .until(ExpectedConditions.visibilityOfElementLocated(accordingPanel));

    }

    }









