package pom;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderPage {

    private final WebDriver driver;
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    private final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By inputMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By inputMobile = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By orderDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By orderPeriod = By.xpath(".//div[@class='Dropdown-placeholder']" );
    //private final By orderPeriod = By.xpath(".//div[@class='Dropdown-placeholder']" );
    private final By orderTimeDay = By.xpath(".//div[@role='option' and text()='сутки']" );
    private final By orderTime2Day = By.xpath(".//div[@role='option' and text()='двое сутки']" );
    private final By black = By.id("black");
    private final By grey = By.id("grey");
    private final By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By finalButtonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By modalOrderButtonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']" );
    private final By modalOrdered = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']" );




    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    public OrderPage getInputName(String name) {
        driver.findElement(inputName).sendKeys(name);
        return this;
    }

    public OrderPage getInputSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
        return this;
    }

    public OrderPage getInputAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
        return this;
    }

    public OrderPage getInputMetro(String metro) {
        WebElement element = driver.findElement(inputMetro);
        element.sendKeys(metro);
        element.sendKeys(Keys.DOWN);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public OrderPage getInputMobile(String mobile) {
        driver.findElement(inputMobile).sendKeys(mobile);

        return this;
    }

    public OrderPage clickNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }

    public OrderPage getOrderDate(String date) {
        WebElement element = driver.findElement(orderDate);
        element.sendKeys(date);
        element.sendKeys(Keys.ENTER);

        return this;
    }

    public OrderPage getOrderPeriod(String period) {


            WebElement element = driver.findElement(orderPeriod);
            element.click();
            driver.findElement(orderTimeDay).click();





        return this;
    }

    public OrderPage clickCheckBoxColor(String color) {
        if (color == "черный"){
            driver.findElement(black).click();
        } else {
            driver.findElement(grey).click();
        }

        return this;
    }



    public OrderPage getComment(String comment) {
        driver.findElement(inputComment).sendKeys(comment);
        return this;
    }

    public OrderPage clickFinalButtonOrder() {
        driver.findElement(finalButtonOrder).click();
        return this;
    }


    public OrderPage clickModalOrderButtonYes() {

        return this;
    }

    public Boolean checkModalOrdered() {

    try {
        driver.findElement(modalOrderButtonYes).click();

    } catch (NoSuchElementException e) {
        return false;
    }
    return true;
    }
}
