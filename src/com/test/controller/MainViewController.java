package com.test.controller;

import com.test.controller.services.LoadLocations;
import com.test.controller.services.Place;
import com.test.model.CurrentWeather;
import com.test.model.ForecastWeather;
import com.test.model.UniversalMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;
import org.controlsfx.control.textfield.TextFields;


public class MainViewController extends BaseController implements Initializable {
    CurrentWeather currentWeather;
    ForecastWeather forecastWeather;
    Place place;
   private  LoadLocations loadLocations;

    @FXML
    private ImageView myCityImage;


    @FXML
    private Label MyCityName;


    @FXML
    private VBox myCityForecast;

    @FXML
    private VBox destinationCityForecast;

    @FXML
    private TextField destinationCity;

    @FXML
    private TextField myCity;


    @FXML
    private Label myCityTemperature;

    @FXML
    private Label mycityFeelsTemperature;

    @FXML
    private Label myCityHumidity;

    @FXML
    private Label myCityWind;

    @FXML
    private Label destinationCityHumidity;

    @FXML
    private ImageView destinationCityImage;

    @FXML
    private Label destinationCityName;

    @FXML
    private Label destinationCityTemperature;

    @FXML
    private Label destinationCityWind;

    @FXML
    private Label destinationcityFeelsTemperature;

    @FXML
    private Label myCityDescription;

    @FXML
    private Label destinationDescription;

    @FXML
    private Label destinationDateInfo;

    @FXML
    private Label myCityDateInfo;

    @FXML
    private Label errorInfoDestinationCity;

    @FXML
    private Label errorInfoMyCity;


    public MainViewController(String fxmlFileName) {
        super(fxmlFileName);
        loadLocations= new LoadLocations();

    }


    @FXML
    public void showMyForecast(){

        place= new Place(myCity.getText());
        errorInfoMyCity.setText("");
        if(place.isValidEntry()) {
            setForecastWeatherParameters(myCityForecast, place);
            setCurrentWeatherMyCity(place);
        }else {
            errorInfoMyCity.setText("Error");
        }

    }

    @FXML
    public void showDestinationForecast(){

        place= new Place(destinationCity.getText());
        errorInfoDestinationCity.setText("");
        if(place.isValidEntry()) {
            setForecastWeatherParameters(destinationCityForecast, place);
            setCurrentWeatherDestinationCity(place);
        }else {
            errorInfoDestinationCity.setText("Error");
        }


    }

    private void setCurrentWeatherMyCity(Place place){
            currentWeather = new CurrentWeather(place.getLocationData());
            myCityImage.setImage(UniversalMethods.getImage(currentWeather.getData()));
            MyCityName.setText(place.getCity() + ", " + place.getCountry());
            myCityTemperature.setText("Temperature: " + UniversalMethods.getTemperature(currentWeather.getData()));
            mycityFeelsTemperature.setText("Feels like: " + UniversalMethods.getFeelsLike(currentWeather.getData()));
            myCityHumidity.setText("Humidity: " + UniversalMethods.getPressure(currentWeather.getData()));
            myCityWind.setText("Wind: " + UniversalMethods.getWindSpeed(currentWeather.getData()));
            myCityDescription.setText(UniversalMethods.getDescription(currentWeather.getData()));
            myCityDateInfo.setText(UniversalMethods.getTodayDate());
    }

    private void setCurrentWeatherDestinationCity(Place place){
        currentWeather= new CurrentWeather(place.getLocationData());
        destinationCityImage.setImage(UniversalMethods.getImage(currentWeather.getData()));
        destinationCityName.setText(place.getCity()+", "+ place.getCountry());
        destinationCityTemperature.setText("Temperature: " + UniversalMethods.getTemperature(currentWeather.getData()));
        destinationcityFeelsTemperature.setText("Feels like: " +UniversalMethods.getFeelsLike(currentWeather.getData()));
        destinationCityHumidity.setText("Humidity: " +UniversalMethods.getPressure(currentWeather.getData()));
        destinationCityWind.setText("Wind: " +UniversalMethods.getWindSpeed(currentWeather.getData()));
        destinationDescription.setText(UniversalMethods.getDescription(currentWeather.getData()));
        destinationDateInfo.setText(UniversalMethods.getTodayDate());

    }

    private void setForecastWeatherParameters(VBox forecast, Place place) {
            forecastWeather= new ForecastWeather(place.getLocationData());
            forecast.getChildren().clear();
        for (int i = 1; i <= 4; i++) {

            String oneDayData = forecastWeather.getDayForecastForDay(i);
            HBox dataHBox = new HBox();
            Label data= new Label(UniversalMethods.getForecastDate(i));
            data.setFont(new Font("Comic Sans MS", 12));
            dataHBox.getChildren().addAll(data
            );
            dataHBox.setAlignment(Pos.CENTER);
            forecast.getChildren().add(dataHBox);
            HBox dayHBox = new HBox();

            ImageView forecastImage = new ImageView(UniversalMethods.getImage(oneDayData));
            forecastImage.setFitWidth(30);
            forecastImage.setFitHeight(30);
            forecastImage.pickOnBoundsProperty();
            Region region1 = new Region();
            Region region2 = new Region();
            HBox.setHgrow(region1, Priority.ALWAYS);
            HBox.setHgrow(region2, Priority.ALWAYS);
            Label temperatureLabel = new Label(UniversalMethods.getTemperature(oneDayData));
            temperatureLabel.setFont(new Font("Comic Sans MS", 12));
            Label descriptionLabel= new Label(UniversalMethods.getDescription(oneDayData));
            descriptionLabel.setFont(new Font("Comic Sans MS", 12));
            Label pressureLabel = new Label(UniversalMethods.getPressure(oneDayData));
            pressureLabel.setFont(new Font("Comic Sans MS", 12));
            dayHBox.setBackground(new Background(new BackgroundFill(Color.color(1,1,1,1),
                    new CornerRadii(10) , Insets.EMPTY)));
            dayHBox.getChildren().addAll(forecastImage, temperatureLabel,region1,descriptionLabel,region2,pressureLabel
            );
            forecast.getChildren().add(dayHBox);
            dayHBox.setAlignment(Pos.TOP_LEFT);
            forecast.setSpacing(5);

        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myCity.setText("Warsaw, PL");
        Place myplaceDefault= new Place("Warsaw,pl");
        setForecastWeatherParameters(myCityForecast,myplaceDefault);
        setCurrentWeatherMyCity(myplaceDefault);
        destinationCity.setText("Manila, PH");
        Place destinationplaceDefault= new Place("Manila,ph");
        setForecastWeatherParameters(destinationCityForecast,destinationplaceDefault);
        setCurrentWeatherDestinationCity(destinationplaceDefault);
        TextFields.bindAutoCompletion(myCity, loadLocations.getCities().values());
        TextFields.bindAutoCompletion(destinationCity, loadLocations.getCities().values());



    }
}
