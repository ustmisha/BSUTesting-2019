package com.epam.ta.service;

import com.epam.ta.model.Email;

public class EmailCreator {
    public static final String EMAIL = "testdata.valid.email";

    public static Email withInfoFromProperty() {
        return new Email(
                TestDataReader.getTestData(EMAIL));
    }
}
