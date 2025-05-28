package com.visualizer.ViewModel;

import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import com.visualizer.DomainObject.Algorithms.AlgorithmRegistry;
import com.visualizer.Model.Algorithm;
import com.visualizer.Model.AlgorithmBrowser;

public class AlgorithmBrowserViewModel implements AlgorithmBrowser
{
  private final ObservableList<Algorithm> discovered_algorithms;
  private final FilteredList<Algorithm> filtered_algorithm;
  private final ReadOnlyObjectWrapper<FilteredList<Algorithm>> filtered_algorithm_property;

  public AlgorithmBrowserViewModel()
  {
    this.discovered_algorithms = FXCollections.observableArrayList(AlgorithmRegistry.discover());
    this.filtered_algorithm = new FilteredList<>(discovered_algorithms, algorithm -> true);
    this.filtered_algorithm_property = new ReadOnlyObjectWrapper<>(filtered_algorithm);
  }

  @Override
  public List<Algorithm> getDiscoverableAlgorithms()
  {
    return discovered_algorithms;
  }

  @Override
  public ReadOnlyObjectProperty<FilteredList<Algorithm>> filteredAlgorithmsProperty() 
  {
    return filtered_algorithm_property.getReadOnlyProperty();
  }
  @Override
  public void toggleCategory(String selected_category)
  {
    if (selected_category.equals("Show All")) 
    { 
      filtered_algorithm.setPredicate(algorithm -> true);
    } 
    else 
    {
      filtered_algorithm.setPredicate(algo -> selected_category.equals(algo.getAlgorithmType()));
    } 
  }
}
