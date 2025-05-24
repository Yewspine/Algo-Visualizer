package com.visualizer.ViewModel;

import java.util.List;
import java.util.function.Predicate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.ToggleButton;

import com.visualizer.DomainObject.Algorithms.AlgorithmRegistry;
import com.visualizer.Model.Algorithm;
import com.visualizer.Model.AlgorithmBrowser;

public class AlgorithmBrowserViewModel implements AlgorithmBrowser
{

  private final ObservableList<Algorithm> discovered_algorithms;
  private final FilteredList<Algorithm> filtered_algorithm;

  public AlgorithmBrowserViewModel()
  {
    this.discovered_algorithms = FXCollections.observableArrayList(AlgorithmRegistry.discover());
    this.filtered_algorithm = new FilteredList<>(discovered_algorithms, algorithm -> true);
  }

  @Override
  public List<Algorithm> getDiscoverableAlgorithms()
  {
    return discovered_algorithms;
  }

  @Override
  public ObjectProperty<ObservableList<Algorithm>> filteredAlgorithmsProperty()
  {
    return new SimpleObjectProperty<>(filtered_algorithm);
  }

  @Override
  public void toggleCategory(ActionEvent event)
  {
    ToggleButton toggled_button = (ToggleButton)event.getSource();
    Predicate<Algorithm> filter = (Predicate<Algorithm>)toggled_button.getUserData();
    filtered_algorithm.setPredicate(filter);
  }
}
