package com.ohgiraffers.common;

import java.util.Date;

public class Bread extends Product{

    private java.util.Date bakedDate;

    public Bread() {}

    public Bread(String name, int price, java.util.Date bakedDate) {
        super(name, price);
        this.bakedDate = bakedDate;
    }

    public Date getBakedDate() {
        return bakedDate;
    }

    public void setBakedDate(Date bakedDate) {
        this.bakedDate = bakedDate;
    }

    @Override
    public String toString() {
        // toString()만작성시 this가 붙고 재귀로 돈다 super.toString()으로 super를 붙혀줘야함
        return super.toString() + " " + this.bakedDate;

        //return this.getName() + " " + this.getPrice() + " " + this.bakedDate;
    }
}
