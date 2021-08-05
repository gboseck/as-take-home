package com.gboseck;

import com.gboseck.entity.Cuisine;
import com.gboseck.entity.Restaurant;
import com.gboseck.entity.RestaurantCuisine;
import com.gboseck.service.RestaurantService;
import com.gboseck.util.FileUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by garrettboseck on 8/4/21.
 */
public class ASTakeHomeApp {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        RestaurantService restaurantService = new RestaurantService();

        //get cuisines.csv contents as a map to combine with restaurants.csv
        Map<Long, String> cuisineMap = fileUtil.getCuisineFromCsv();

        List<Restaurant> restaurantList = fileUtil.getRestaurantFromCsv();

        //combine both csv's to have cuisine name in same object as restaurant (could be done with a SQL query if data
        // was normalized in a sql database)
        List<RestaurantCuisine> restaurantCuisineList = restaurantList
                .stream()
                .map(x -> new RestaurantCuisine(x, cuisineMap.get(x.getCuisineId())))
                .collect(Collectors.toList());

        //main search function, edit here to change output!
        //(input <- don't change!, restaurant name, customer rating, distance, price, cuisine)
        List<RestaurantCuisine> output = restaurantService.search(restaurantCuisineList, null, 5, 5,
                25,
                "russ");

        if(output.size() == 0) {
            System.out.print("No results found! Try expanding your search criteria");
        } else {
            for(RestaurantCuisine rc : output) {
                System.out.println(rc);
            }
        }
    }
}
