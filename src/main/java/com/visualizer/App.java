package com.visualizer;

import java.lang.Exception;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.visualizer.View.MainView;

/**
 * JavaFX App
 */
public class App extends Application 
{
  /**
   * Constructor the main view and the main scene then render it
   * @param stage the stage to draw the scene on
   * @throws Exception Internal Java Exception, since various Exception can be throw I goes with a generic one
   * */
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
