package com.gboseck.service;

import com.gboseck.entity.RestaurantCuisine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by garrettboseck on 8/4/21.
 */
public class RestaurantService {

    private static final Integer CUSTOMER_RATING_MIN = 1;
    private static final Integer CUSTOMER_RATING_MAX = 5;

    private static final Integer DISTANCE_MIN = 1;
    private static final Integer DISTANCE_MAX = 10;

    private static final Integer PRICE_MIN = 10;
    private static final Integer PRICE_MAX = 50;

    private static final Long RESULTS_SIZE = 5L;
    public List<RestaurantCuisine> search(List<RestaurantCuisine> input, String restaurantName, Integer customerRating,
                                          Integer distance, Integer price, String cuisine) {

        /*
        Begin with doing some checks and validations. Any of the 5 criteria can be null, but the input can not. While
        we can guarantee that input will be non-null for this assignment, if we think of extending this as part of a
        web application/REST API then validations make sense
        */
        if(input == null) {
            System.out.println("Input to search function can not be null!");
            System.exit(1);
        }

        List<Predicate<RestaurantCuisine>> searchPredicates = new ArrayList<>();

        //for any nullable criteria that must fall within a range, we'll follow this same pattern
        if(customerRating != null) {
            if(customerRating < CUSTOMER_RATING_MIN || customerRating > CUSTOMER_RATING_MAX) {
                System.out.println("Customer rating must be a whole number between "+ CUSTOMER_RATING_MIN +" - "+
                        CUSTOMER_RATING_MAX+"! Please enter a valid customer rating");
                System.exit(1);
            } else {
                searchPredicates.add(rs -> rs.getCustomerRating() >= customerRating);
            }
        }

        if(distance != null) {
            if(distance < DISTANCE_MIN || distance > DISTANCE_MAX) {
                System.out.println("Distance must be a whole number between "+ DISTANCE_MIN +" - "+
                        DISTANCE_MAX+"! Please enter a valid distance!");
                System.exit(1);
            } else {
                searchPredicates.add(rs -> rs.getDistance() <= distance);
            }
        }

        if(price != null) {
            if(price < PRICE_MIN || price > PRICE_MAX) {
                System.out.println("Price must be a whole number between "+ PRICE_MIN +" - "+
                        PRICE_MAX+"! Please enter a valid price!");
                System.exit(1);
            } else {
                searchPredicates.add(rs -> rs.getPrice() <= price);
            }
        }

        if(restaurantName != null) {
            searchPredicates.add(rs -> rs.getName().toLowerCase().contains(restaurantName.toLowerCase()));
        }

        if(cuisine != null) {
            searchPredicates.add(rs -> rs.getCuisineName().toLowerCase().contains(cuisine.toLowerCase()));
        }

        //apply all given search predicates to the input list. If no parameters are provided, then original input is
        // returned
        List<RestaurantCuisine> filteredResults = input.stream().filter(searchPredicates.stream().reduce(x->true,
                Predicate::and))
                .collect(Collectors.toList());

        //Create a comparator for sort, from the prompt, our order should be shortest distance, then highest rating,
        // and lastly lowest price
        Comparator<RestaurantCuisine> c = Comparator.comparing(RestaurantCuisine::getDistance).reversed()
                .thenComparing(RestaurantCuisine::getCustomerRating).reversed()
                .thenComparing(RestaurantCuisine::getPrice);

        //Apply sort criteria to filtered list to get final output
        List<RestaurantCuisine> sortedResults = filteredResults.stream()
                .sorted(c)
                .collect(Collectors.toList());

        //Return first (5) results to calling class
        return sortedResults.stream().limit(RESULTS_SIZE).collect(Collectors.toList());
    }


}
