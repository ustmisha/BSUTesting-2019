package com.epam.ta.page;

import com.epam.ta.model.Date;
import com.epam.ta.model.Guests;
import com.epam.ta.model.Place;
import com.epam.ta.service.PlaceCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final String HOMEPAGE_URL =
            "https://www.housetrip.com/";
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @Override
    public HomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        LOGGER.info("Home page opened");
        return this;
    }

    @FindBy(xpath = "//*[@id=\"destination\"]")
    private WebElement locationSelect;

    @FindBy(xpath = "//*[@id=\"arriveDate\"]")
    private WebElement startdateSelect;

    @FindBy(xpath = "//*[@id=\"departDate\"]")
    private WebElement enddateSelect;

    @FindBy(xpath = "//*[@id=\"guestsAdults\"]")
    private WebElement adultsSelect;

    @FindBy(xpath = "//*[@id=\"guestsChildren\"]")
    private WebElement childrensSelect;

    @FindBy(xpath = "//*[@id=\"quickSearchSubmit\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"quickSearch\"]/div[4]/div/div[1]/div/button[2]")
    private WebElement adultsIncrement;

    public void search() {
        searchButton.click();
    }

    public void adultsInremention() {
        adultsIncrement.click();
    }

    public void insertLocation(Place place){
        locationSelect.sendKeys(place.getLocation());
        LOGGER.info(place.getLocation() + " selected");
    }

    public void insertStartDate(Date date){
        startdateSelect.sendKeys(date.getStartDate());
        LOGGER.info(date.getStartDate() + " selected");
    }

    public void insertEndDate(Date date){
        enddateSelect.sendKeys(date.getEndDate());
        LOGGER.info(date.getEndDate() + " selected");
    }

    public void insertGuestsAdults(Guests guests){
        adultsSelect.sendKeys(guests.getAdults());
        LOGGER.info(guests.getAdults() + " selected");
    }

    public void insertGuestsChildren(Guests guests){
        adultsSelect.sendKeys(guests.getChildren());
        LOGGER.info(guests.getChildren() + " selected");
    }

    public boolean checkCurrentLocation(Place expectedPlace){
        WebElement element = locationSelect;
        String text = element.getAttribute("value");
        if(text == expectedPlace.getLocation())
            return true;
        return false;
    }

    public String getAdultsNumber(){
        WebElement element = adultsSelect;
        String adultsNumber = element.getAttribute("value");
        return adultsNumber;
    }

}
