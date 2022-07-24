package com.test.controller.services;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Place {
    private String name;
    private String country;
    private String locationData;
    private static final Pattern PATTERN = Pattern.compile("([A-z])\\w+, [A-Z]\\w+");
    private boolean emptyFlag = false;


    public Place(String locationData){
        this.locationData= locationData;
        if(locationData !="" && locationData.contains(",")) {
            setCity();
            setCountry();
        }
    }
    private void setCity(){

        name=locationData.substring(0, locationData.indexOf(","));

    }

    private void setCountry(){
        country=locationData.substring(locationData.indexOf(",")+1, locationData.length()).toUpperCase();

    }

    public String getCity() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLocationData() {
        return locationData;
    }

    private boolean entryValidation(){

            if(locationData.equals("")){
                emptyFlag = true;
            }

            Matcher matcher = PATTERN.matcher(locationData);

            if(matcher.find()){
                return true;
            }
        return false;
    }

    public boolean isValidEntry(){
        return entryValidation();
    }
}
