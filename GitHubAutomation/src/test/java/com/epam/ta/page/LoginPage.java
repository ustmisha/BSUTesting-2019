package com.epam.ta.page;

import com.epam.ta.model.Date;
import com.epam.ta.model.Email;
import com.epam.ta.model.Guests;
import com.epam.ta.model.Place;
import com.epam.ta.model.PageError;
import com.epam.ta.service.PlaceCreator;
import com.epam.ta.model.Password;
import com.epam.ta.service.PasswordCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final String LOGINPAGE_URL =
            "https://www.housetrip.com/traveler/signin?returnTo=https%3A%2F%2Fwww.housetrip.com%2F";
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(LOGINPAGE_URL);
        LOGGER.info("Log in opened");
        return this;
    }

    @FindBy(xpath = "//*[@id=\"regSignIn.email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"regSignIn.password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"regSignIn\"]/button")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"regErrors\"]/ul/li")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//*[@id=\"header\"]/a[1]")
    private WebElement headerLogo;

    public void signin() {
        signInButton.click();
    }

    public void headerlogoclick() {
        headerLogo.click();
    }

    public void insertEmail(Email email){
        emailField.sendKeys(email.getEmail());
        LOGGER.info(email.getEmail() + " email address entered");
    }

    public void insertPassword(Password password){
        emailField.sendKeys(password.getPassword());
        LOGGER.info(password.getPassword() + " password address entered");
    }

    public boolean getSignInEmailErrorMessage(PageError error) {
        return emailErrorMessage.isDisplayed()
                && emailErrorMessage.getText().
                contains(error.getErrorDescription());
    }

    public String getURL(){
        String URL = LOGINPAGE_URL;
        return URL;
    }
}
