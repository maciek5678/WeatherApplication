package com.test.controller.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoadLocations {


    private Gson gson;

    public LoadLocations() {
        this.gson = new Gson();
    }

    public Map<String, String> getCities() {
        return loadListFromJson();
    }

    private Map<String, String> loadListFromJson() {

        Type LOCATION_TYPE = new TypeToken<List<Place>>() {}.getType();
        InputStreamReader inputStreamReader = new InputStreamReader(Place.class.getResourceAsStream("city.list.min.json"), StandardCharsets.UTF_8);
        List<Place> jsonListOfCities = gson.fromJson(inputStreamReader, LOCATION_TYPE);
        return jsonListOfCities.stream()
                .collect(Collectors.toMap(
                        Place::getCity,
                        p -> p.getCity() + ", " + p.getCountry(),
                        (a1, a2) -> a1
                ));
    }
}
