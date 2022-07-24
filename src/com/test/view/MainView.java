package com.test.view;

import com.test.Launcher;
import com.test.controller.BaseController;
import com.test.controller.MainViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView {

    public void showMainView() throws IOException {
        BaseController controller= new MainViewController("MainView.fxml");
    initializeStage(controller);
    }

    private void initializeStage(BaseController baseController) throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource(baseController.getFxmlFileName()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try{
            parent=fxmlLoader.load();

        }catch(IOException e ){
            e.printStackTrace();
            return;

        }

        Scene scene= new Scene(parent);
        Stage stage= new Stage();
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();


    }
}
