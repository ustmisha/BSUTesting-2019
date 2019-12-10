package com.epam.ta.test;

import com.epam.ta.model.Date;
import com.epam.ta.model.Guests;
import com.epam.ta.model.Place;
import com.epam.ta.page.*;
import com.epam.ta.service.DateCreator;
import com.epam.ta.service.GuestsCreator;
import com.epam.ta.service.PlaceCreator;
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
        Assert.assertEquals(currentAdultsNumber+1, newAdultsNumber);
    }

}
