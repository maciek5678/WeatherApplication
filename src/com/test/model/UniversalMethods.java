package com.test.model;

import javafx.scene.image.Image;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UniversalMethods {

    public static String FORECAST_SIGN = "dt_txt";

    public static String getTemperature(String data) {
        try {

            return Integer.toString((int) Math.round(Double.parseDouble(data.substring(data.indexOf("temp_max") + 10, data.indexOf("pressure") - 2)))) + "\u00B0" + "C";


        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getWindSpeed(String data) {

        return Integer.toString((int) Math.round(Double.parseDouble(data.substring(data.indexOf("speed") + 7, data.indexOf("deg") - 2)))) + " m/s";
    }

    public static String getPressure(String data) {
        if (data.contains(FORECAST_SIGN)) {

           return data.substring(data.indexOf("pressure") + 10, data.indexOf("sea_level") - 2) + " hPA";
        } else {

            return data.substring(data.indexOf("pressure") + 10, data.indexOf("humidity") - 2) + " hPA";
        }


    }

    public static Image getImage(String data)  {
        if (data.contains(FORECAST_SIGN)) {
            return new Image("http://openweathermap.org/img/w/" + data.substring(data.indexOf("icon") + 7, data.indexOf("icon") + 10) + ".png");
        } else {
            return new Image("http://openweathermap.org/img/w/" + data.substring(data.indexOf("icon") + 7, data.indexOf("base") - 5) + ".png");
        }
    }

    public static String getFeelsLike(String data) {
        return Integer.toString((int) Math.round(Double.parseDouble(data.substring(data.indexOf("feels_like") + 12, data.indexOf("temp_min") - 2)))) + "\u00B0" + "C";
    }

    public static String getDescription(String data){
            return data.substring(data.indexOf("description") + 14, data.indexOf("icon") - 3);
    }

    public static String getTodayDate(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("E dd MMM"));

    }

    public static String getForecastDate(int days){
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("E dd"));

    }

}

