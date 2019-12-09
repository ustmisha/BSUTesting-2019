package com.epam.ta.service;

import com.epam.ta.model.Date;

public class DateCreator {
    public static final String START_DATE = "testdata.date.start";
    public static final String END_DATE = "testdata.date.end";

    public static Date withInfoFromProperty() {
        return new Date(TestDataReader.getTestData(START_DATE),
                TestDataReader.getTestData(END_DATE));
    }
}
