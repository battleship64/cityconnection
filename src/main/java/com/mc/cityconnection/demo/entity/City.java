package com.mc.cityconnection.demo.entity;

public class City {
    private String name;
    private int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public City(String name, int index) {
        this.name = name;
        this.index = index;
    }
    public City(){}

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }

}
