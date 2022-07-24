module WeatherApplication {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires com.google.gson;
    requires controlsfx;


    opens com.test to javafx.fxml;
    exports com.test;
    exports com.test.controller;
    opens com.test.controller to javafx.fxml;
    exports com.test.view;
    opens com.test.view to javafx.fxml;
    opens com.test.controller.services to com.google.gson;







}