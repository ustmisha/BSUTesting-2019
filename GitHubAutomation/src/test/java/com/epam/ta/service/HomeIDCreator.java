package com.epam.ta.service;

import com.epam.ta.model.HomeID;

public class HomeIDCreator {
    public static final String ID = "testdata.home.id";

    public static HomeID withInfoFromProperty() {
        return new HomeID(
                TestDataReader.getTestData(ID));
    }
}