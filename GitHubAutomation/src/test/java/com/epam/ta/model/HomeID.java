package com.epam.ta.model;

import java.util.Objects;

public class HomeID {
    private String homeid;

    public HomeID(String homeid) {
        this.homeid = homeid;
    }

    public String getHomeID() {
        return homeid;
    }

    public void setHomeID(String homeid) {
        this.homeid = homeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeID homeid = (HomeID) o;
        return homeid.equals(homeid.homeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeid);
    }

    @Override
    public String toString() {
        return "HomeID = " + homeid;
    }
}
