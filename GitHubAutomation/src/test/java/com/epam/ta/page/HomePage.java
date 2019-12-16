package com.epam.ta.page;

import com.epam.ta.model.*;
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

    @FindBy(xpath = "//*[@id=\"totalGuestsLbl\"]")
    private WebElement adultsSelect;

    @FindBy(xpath = "//*[@id=\"guestsChildren\"]")
    private WebElement childrensSelect;

    @FindBy(xpath = "//*[@id=\"quickSearchSubmit\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"quickSearch\"]/div[4]/div/div[1]/div/button[2]")
    private WebElement adultsIncrement;

    @FindBy(xpath = "//*[@id=\"guestsAdults\"]")
    private WebElement adultsNumber;

    @FindBy(xpath = "//*[@id=\"optInEmail\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"submitOptInEmail\"]")
    private WebElement emailSubscribeButton;

    @FindBy(xpath = "//*[@id=\"frmOptInEmail\"]/p/span/span")
    private WebElement emailError;

    @FindBy(xpath = "//*[@id=\"frmOptInEmail\"]/p/i")
    private WebElement subscribeTick;

    @FindBy(xpath = "//*[@id=\"searchBanner\"]/div[1]/div")
    private WebElement titleText;

    @FindBy(xpath = "//*[@id=\"nav-menu\"]/ul/li[5]/button")
    private WebElement signInDropdown;

    @FindBy(xpath = "//*[@id=\"nav-menu\"]/ul/li[5]/div/ul/li[1]")
    private WebElement signInTravellersButton;

    @FindBy(xpath = "//*[@id=\"nav-menu\"]/ul/li[2]/button")
    private WebElement currencyChangeDropdown;

    @FindBy(xpath = "//*[@id=\"nav-menu\"]/ul/li[2]/button/span/span")
    private WebElement selectedCurrencyMark;

    @FindBy(xpath = "//*[@id=\"nav-menu\"]/ul/li[2]/div/ul/li[4]")
    private WebElement currencyChangeButtonEuro;

    public void search() {
        searchButton.click();
    }

    public void signInDropdownClick() {
        signInDropdown.click();
    }

    public void currencyChangeDropdownClick() {
        currencyChangeDropdown.click();
    }

    public void currencyChangeEuroClick() {
        currencyChangeButtonEuro.click();
    }

    public void signInTravellersClick() {
        signInTravellersButton.click();
    }

    public void adultsInremention() {
        adultsIncrement.click();
    }

    public void adultsClick() {
        adultsSelect.click();
    }

    public void insertLocation(Place place){
        locationSelect.sendKeys(place.getLocation());
        LOGGER.info(place.getLocation() + " selected");
    }

    public void insertId(HomeID id){
        locationSelect.sendKeys(id.getHomeID());
        LOGGER.info(id.getHomeID() + " id entered");
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
        WebElement element = adultsNumber;
        String adultsNumber = element.getAttribute("value");
        LOGGER.info(adultsNumber);
        return adultsNumber;
    }

    public String getSelectedCurrency(){
        WebElement element = selectedCurrencyMark;
        String selectedCurrency = element.getAttribute("value");
        LOGGER.info(selectedCurrency);
        return selectedCurrency;
    }

    public void insertEmail(Email email){
        locationSelect.sendKeys(email.getEmail());
        LOGGER.info(email.getEmail() + " email address selected");
    }

    public boolean getEmailErrorMessage(PageError error) {
        return emailError.isDisplayed()
                && emailError.getText().
                contains(error.getErrorDescription());
    }

    public String getURL(){
        String URL = HOMEPAGE_URL;
        return URL;
    }

    public boolean getTitle(PageError error) {
        return titleText.isDisplayed()
                && titleText.getText().
                contains(error.getErrorDescription());
    }

    public void subscribe() {
        emailSubscribeButton.click();
    }

    public WebElement getAdultsIncrement() {
        return adultsIncrement;
    }

}