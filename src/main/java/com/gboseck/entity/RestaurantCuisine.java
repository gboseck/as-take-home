package com.gboseck.entity;

import com.opencsv.bean.CsvBindByName;

/**
 * Created by garrettboseck on 8/4/21.
 */
public class RestaurantCuisine {

    private String name;

    private int customerRating;

    private int distance;

    private int price;

    private String cuisineName;

    public RestaurantCuisine(Restaurant restaurant, String cuisineName) {
        this.name = restaurant.getName();
        this.customerRating = restaurant.getCustomerRating();
        this.distance = restaurant.getDistance();
        this.price = restaurant.getPrice();
        this.cuisineName = cuisineName;
    }

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

    public String getCuisineName() {
        return cuisineName;
    }

    @Override
    public String toString() {
        return "RestaurantCuisine{" +
                "name='" + name + '\'' +
                ", customerRating=" + customerRating +
                ", distance=" + distance +
                ", price=" + price +
                ", cuisineName='" + cuisineName + '\'' +
                '}';
    }
}
