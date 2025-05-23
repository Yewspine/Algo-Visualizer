package com.visualizer.ViewModel;

import java.util.function.Predicate;

import javafx.event.ActionEvent;
import javafx.scene.control.ToggleButton;

import com.visualizer.DomainObject.Algorithm;
import com.visualizer.Model.AlgorithmBrowser;

public class AlgorithmBrowserViewModel implements AlgorithmBrowser
{
  @Override
  public void toggleCategory(ActionEvent event)
  {
    ToggleButton toggled_button = (ToggleButton)event.getSource();
    Predicate<Algorithm> filter = (Predicate<Algorithm>)toggled_button.getUserData();
    // filterProperty.set(filter);
  }
}
