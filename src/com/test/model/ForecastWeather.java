package com.test.model;

import com.test.controller.services.OpenWeatherMapDownloader;
import com.test.controller.services.Place;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ForecastWeather {

    public String toomorowDate=  String.valueOf(LocalDate.now().plusDays(1));
    public String secondDate=  String.valueOf(LocalDate.now().plusDays(2));
    public String thirdDate=  String.valueOf(LocalDate.now().plusDays(3));
    public String fourthDate=  String.valueOf(LocalDate.now().plusDays(4));
    public String toomorowForecast;
    public String secondForecast;
    public String thirdForecast;
    public String fourthForecast;
    public String place;



    private OpenWeatherMapDownloader openWeatherMapDownloader;
    public ForecastWeather(String location)  {
        openWeatherMapDownloader = new OpenWeatherMapDownloader(location);

        try {
            fourthForecast = getWeatherForecastForDay(fourthDate);
            toomorowForecast = getWeatherForecastForDay(toomorowDate);
            secondForecast = getWeatherForecastForDay(secondDate);
            thirdForecast = getWeatherForecastForDay(thirdDate);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getWeatherForecastForDay(String day) throws IOException {
       String data= openWeatherMapDownloader.getForecastWeaterDataInJson();

       return data.substring(data.indexOf(day + " 09:00:00") + 22,data.indexOf(day + " 12:00:00") + 21);
    }

    public String getDayForecastForDay(int dayForecast){
        if(dayForecast == 1){
            return toomorowForecast;
        } else if (dayForecast == 2){
            return secondForecast;
        } else if (dayForecast == 3){
            return thirdForecast;
        } else if (dayForecast == 4){
            return fourthForecast;
        }
        return "";
    }


}
