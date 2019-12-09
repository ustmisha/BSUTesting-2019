package com.epam.ta.service;

import com.epam.ta.model.Place;

public class PlaceCreator {
    public static final String LOCATION = "testdata.location";

    public static Place withInfoFromProperty() {
        return new Place(
                TestDataReader.getTestData(LOCATION));
    }

}
