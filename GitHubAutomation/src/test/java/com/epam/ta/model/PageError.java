package com.epam.ta.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class PageError {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private String errorDescription;

    public PageError(String errorDescription) {
        this.errorDescription = errorDescription;
        LOGGER.info("PageError initialised");
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageError pageError = (PageError) o;
        return Objects.equals(errorDescription, pageError.errorDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorDescription);
    }
}
