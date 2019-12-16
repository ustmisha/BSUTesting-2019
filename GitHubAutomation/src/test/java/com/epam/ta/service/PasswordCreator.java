package com.epam.ta.service;

import com.epam.ta.model.Password;

public class PasswordCreator {
    public static final String PASSWORD = "testdata.password";

    public static Password withInfoFromProperty() {
        return new Password(
                TestDataReader.getTestData(PASSWORD));
    }
}
