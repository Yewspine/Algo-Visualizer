package com.visualizer;

import java.lang.Exception;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.visualizer.View.MainView;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception { 
      MainView view = new MainView();
      Scene scene = new Scene(view, 800, 600); 
      stage.setScene(scene);
      stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
