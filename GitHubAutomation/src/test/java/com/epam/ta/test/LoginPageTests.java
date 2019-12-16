package com.epam.ta.test;

import com.epam.ta.model.Date;
import com.epam.ta.model.Email;
import com.epam.ta.model.Password;
import com.epam.ta.model.Guests;
import com.epam.ta.model.Place;
import com.epam.ta.page.*;
import com.epam.ta.service.DateCreator;
import com.epam.ta.service.EmailCreator;
import com.epam.ta.service.PasswordCreator;
import com.epam.ta.service.GuestsCreator;
import com.epam.ta.service.PlaceCreator;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.epam.ta.model.PageError;
import com.epam.ta.service.PageErrorCreator;
import sun.rmi.runtime.Log;

public class LoginPageTests extends CommonConditions {
    @Test(description = "Test checks signing in with empty fields")
    public void emptyFieldsSignIn(){
    LoginPage page = new LoginPage(driver).openPage();
    page.signin();
    PageError expectedError = PageErrorCreator.signInEmailError();
    Assert.assertTrue(page.getSignInEmailErrorMessage(expectedError));
    }

    @Test(description = "Test checks autocorrection when email is entered")
    public void emailCorrectionTest(){
        LoginPage page = new LoginPage(driver).openPage();
        Email testEmail = EmailCreator.withInfoFromProperty();
        page.insertEmail(testEmail);
        PageError expectedError = PageErrorCreator.signInEmailError();
        Assert.assertTrue(page.getSignInEmailErrorMessage(expectedError));
    }

    @Test(description = "Test checks redirect to homepage on header logo click")
    public void headerLogoClickTest(){
        LoginPage page = new LoginPage(driver).openPage();
        page.headerlogoclick();
        HomePage homepage = new HomePage(driver);
        Assert.assertEquals(page.getURL(), homepage.getURL());
    }

    @Test(description = "Test checks redirecting to homepage after login")
    public void loginRedirectTest(){
        LoginPage page = new LoginPage(driver).openPage();
        Email testEmail = EmailCreator.withInfoFromProperty();
        Password testPassword = PasswordCreator.withInfoFromProperty();
        page.insertEmail(testEmail);
        page.insertPassword(testPassword);
        page.signin();
        HomePage homepage = new HomePage(driver);
        Assert.assertEquals(page.getURL(), homepage.getURL());
    }
}
