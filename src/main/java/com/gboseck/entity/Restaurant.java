package com.gboseck.entity;

import com.opencsv.bean.CsvBindByName;

/**
 * Created by garrettboseck on 8/4/21.
 */
public class Restaurant {

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "customer_rating")
    private int customerRating;

    @CsvBindByName(column = "distance")
    private int distance;

    @CsvBindByName(column = "price")
    private int price;

    @CsvBindByName(column = "cuisine_id")
    private Long cuisineId;

    public String getName() {
        return name;
    }

    public int getCustomerRating() {
        return customerRating;
    }

    public int getDistance() {
        return distance;
    }

    public int getPrice() {
        return price;
    }

    public Long getCuisineId() {
        return cuisineId;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", customerRating=" + customerRating +
                ", distance=" + distance +
                ", price=" + price +
                ", cuisineId=" + cuisineId +
                '}';
    }
}
