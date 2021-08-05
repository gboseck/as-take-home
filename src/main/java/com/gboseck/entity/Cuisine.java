package com.gboseck.entity;

import com.opencsv.bean.CsvBindByName;

/**
 * Created by garrettboseck on 8/4/21.
 */
public class Cuisine {

    @CsvBindByName(column = "id")
    private Long id;

    @CsvBindByName(column = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cuisine{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
