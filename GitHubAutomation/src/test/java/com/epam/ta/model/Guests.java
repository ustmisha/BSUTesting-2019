package com.epam.ta.model;

import java.util.Objects;

public class Guests {
    private String adults;
    private String children;

    public Guests(String adults, String children){
        this.adults = adults;
        this.children = children;
    }

    public String getAdults(){
        return adults;
    }

    public void setAdults(String adults){
        this.adults = adults;
    }

    public String getChildren(){
        return children;
    }

    public void setChildren(String children){
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guests guests = (Guests) o;
        return adults.equals(guests.adults) &&
                children.equals(guests.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adults, children);
    }

    @Override
    public String toString() {
        return "Guests{" +
                "adults='" + adults + '\'' +
                ", children='" + children + '\'' +
                '}';
    }

}
