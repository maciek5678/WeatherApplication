package com.test;


import com.test.controller.services.OpenWeatherMapDownloader;
import com.test.model.CurrentWeather;
import com.test.model.UniversalMethods;
import com.test.view.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;

public class Launcher extends Application {



    public static void main(String args[]) throws IOException {
        launch(args);

    }


    @Override
    public void start(Stage stage) throws Exception {

        MainView mainView = new MainView();
        mainView.showMainView();



    }
}
