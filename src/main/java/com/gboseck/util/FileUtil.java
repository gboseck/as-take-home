package com.gboseck.util;

import com.gboseck.entity.Cuisine;
import com.gboseck.entity.Restaurant;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.logging.impl.Log4JLogger;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by garrettboseck on 8/4/21.
 */
public class FileUtil {

    public Map<Long, String> getCuisineFromCsv() {
        Map<Long, String> output = new HashMap<>();

        try {
            Reader reader = new InputStreamReader(FileUtil.class.getResourceAsStream("/cuisines.csv"));

            CsvToBean csvToBean = new CsvToBeanBuilder<>(reader)
                    .withType(Cuisine.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            for(Cuisine c : (Iterable<Cuisine>) csvToBean) {
                output.put(c.getId(), c.getName());
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return output;
    }

    public List<Restaurant> getRestaurantFromCsv() {
        List<Restaurant> output = new ArrayList<>();
        try {
            Reader reader = new InputStreamReader(FileUtil.class.getResourceAsStream("/restaurants.csv"));

            CsvToBean csvToBean = new CsvToBeanBuilder<>(reader)
                    .withType(Restaurant.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            for(Restaurant r : (Iterable<Restaurant>) csvToBean) {
                output.add(r);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return output;
    }
}
