package com.visualizer.Model;

import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import com.visualizer.Model.Algorithm;

public interface AlgorithmBrowser
{
  List<Algorithm> getDiscoverableAlgorithms();
  ObjectProperty<ObservableList<Algorithm>> filteredAlgorithmsProperty();
  void toggleCategory(ActionEvent event);
}
