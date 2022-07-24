package com.test.controller.services;

import java.io.*;
import java.net.URL;

public class OpenWeatherMapDownloader {
    public OpenWeatherMap openWeatherMap;

    public OpenWeatherMapDownloader(String location){
    this.openWeatherMap= new OpenWeatherMap(location);

    }

    private static String writeProviderResponseAsDataString(Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int integerValue;
        while ((integerValue = reader.read()) >= 0) {
            stringBuilder.append((char) integerValue);
        }
        return stringBuilder.toString();
    }

    public static String getWeatherData(String url) throws IOException {
        InputStream weatherStream = new URL(url).openStream();
        String data;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(weatherStream));
        data = writeProviderResponseAsDataString(bufferedReader);
        weatherStream.close();

        return data;
    }
    public String getActualWeaterDataInJson() throws IOException{
        String data;
        data = getWeatherData(openWeatherMap.getActualWeather());
        return data;
    }


    public String getForecastWeaterDataInJson() throws IOException{
        String data;
        data = getWeatherData(openWeatherMap.getForecastWeather());
        return data;
    }


}
