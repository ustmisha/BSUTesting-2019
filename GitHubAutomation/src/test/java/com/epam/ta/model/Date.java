package com.epam.ta.model;

import java.util.Objects;

public class Date {
    private String datestart;
    private String dateend;

    public Date(String datestart, String dateend){
        this.datestart = datestart;
        this.dateend = dateend;
    }

    public String getStartDate(){
        return datestart;
    }

    public void setStartDate(String datestart){
        this.datestart = datestart;
    }

    public String getEndDate(){
        return dateend;
    }

    public void setEndDate(String dateend){
        this.dateend = dateend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return datestart.equals(date.datestart) &&
                dateend.equals(date.dateend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datestart, dateend);
    }

    @Override
    public String toString() {
        return "Date{" +
                "Start date='" + datestart + '\'' +
                ", end date='" + dateend + '\'' +
                '}';
    }
}
