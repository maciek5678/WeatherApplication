package com.test.controller.services;


import com.test.Config;

public class OpenWeatherMap {

    private String actualWeatherUrl = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String forecastWeatherUrl = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private String units = "&units=metric";
    private String APPID = "&appid=";
    private String location;
    public OpenWeatherMap(String location){
         this.location=getWeatherCityAndCountry(location);

    }


    public String getWeatherCityAndCountry(String location){


            return location.replace(", ", ",").replace(" ", "%2C");

    }

    public String getActualWeather(){
        return actualWeatherUrl + location + units + APPID + Config.getAPI_KEY();


    }
    public String getForecastWeather(){
        return forecastWeatherUrl + location + units + APPID + Config.getAPI_KEY();


    }

}
