package com.epam.ta.service;

import com.epam.ta.model.PageError;

public class PageErrorCreator {
    private static final String EMAIL_ERROR =
            "testdata.email.error";
    private static final String SIGNIN_EMAIL_ERROR =
            "testdata.signin.email.error";
    private static final String ID_ERROR =
            "testdata.id.error";

    public static PageError emailError() {
        return new PageError(TestDataReader.getTestData(EMAIL_ERROR));
    }

    public static PageError signInEmailError() {
        return new PageError(TestDataReader.getTestData(SIGNIN_EMAIL_ERROR));
    }

    public static PageError idError() {
        return new PageError(TestDataReader.getTestData(ID_ERROR));
    }
}
