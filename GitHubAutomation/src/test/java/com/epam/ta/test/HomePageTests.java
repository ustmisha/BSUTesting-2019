package com.epam.ta.test;

import com.epam.ta.model.*;
import com.epam.ta.page.*;
import com.epam.ta.service.*;
import org.testng.annotations.Test;
import org.testng.Assert;

public class HomePageTests extends CommonConditions {
    @Test(description = "Test searches accomodation with only location specified")
    public void locationSpecifiedTest() {
        Place testPlace = PlaceCreator.withInfoFromProperty();
        HomePage page = new HomePage(driver).openPage();
        page.insertLocation(testPlace);
        page.search();
        Place expectedPlace = PlaceCreator.withInfoFromProperty();
        Assert.assertTrue(page.checkCurrentLocation(expectedPlace));
    }

    @Test(description = "Test checks incrementing of Adults field by pushing '+' button")
    public void incrementTest(){
        HomePage page = new HomePage(driver).openPage();
        page.adultsClick();
        int currentAdultsNumber = Integer.parseInt(page.getAdultsNumber());
        page.adultsInremention();
        int newAdultsNumber = Integer.parseInt(page.getAdultsNumber());
        Assert.assertEquals(currentAdultsNumber + 1, newAdultsNumber);
    }

    @Test(description = "Test checks if you can subscribe to newsletter without entering email address")
    public void withoutEmailTest(){
        HomePage page = new HomePage(driver).openPage();
        page.subscribe();
        PageError expectedError = PageErrorCreator.emailError();
        Assert.assertTrue(page.getEmailErrorMessage(expectedError));
    }

    @Test(description = "Test checks search with invalid Home id")
    public void invalidIdTest(){
        HomePage page = new HomePage(driver).openPage();
        HomeID id = HomeIDCreator.withInfoFromProperty();
        page.insertId(id);
        page.search();
        PageError expectedError = PageErrorCreator.idError();
        Assert.assertTrue(page.getTitle(expectedError));
    }

    @Test(description = "Test checks redirecting to login page upon clicking sign in button")
    public void redirectSignInTest(){
        HomePage page = new HomePage(driver).openPage();
        page.signInDropdownClick();
        page.signInTravellersClick();
        LoginPage loginPage = new LoginPage(driver).openPage();
        String loginPageURL = loginPage.getURL();
        String expectedURL = "https://www.housetrip.com/traveler/signin?returnTo=https%3A%2F%2Fwww.housetrip.com%2F";
        Assert.assertEquals(expectedURL, loginPageURL);
    }

    @Test(description = "Test checks currency changing to Euro")
    public void changeCurrencyToEuro(){
        HomePage page = new HomePage(driver).openPage();
        page.currencyChangeDropdownClick();
        page.currencyChangeEuroClick();
        String expectedCurrency = "null";
        Assert.assertEquals(page.getSelectedCurrency(), expectedCurrency);
    }
}
