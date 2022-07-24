package com.test.model;

import com.test.controller.services.OpenWeatherMapDownloader;

import java.io.IOException;

public class CurrentWeather {
    String location;

    private OpenWeatherMapDownloader openWeatherMapDownloader;
    String data;
    public CurrentWeather(String location){
        openWeatherMapDownloader= new OpenWeatherMapDownloader(location);
        try {
            data= openWeatherMapDownloader.getActualWeaterDataInJson();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getData(){
        return data;

    }

}
