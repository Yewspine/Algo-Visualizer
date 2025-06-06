package com.visualizer.Model;

import java.util.List;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.transformation.FilteredList;

import com.visualizer.Model.Algorithm;

/**
 * Define the behaviour of the AlgorithmBrowser Controller,
 * @see com.visualizer.ViewModel.AlgorithmBrowserViewModel
 * @author Yewspine
 * */
public interface AlgorithmBrowser
{
  List<Algorithm> getDiscoverableAlgorithms();
  ReadOnlyObjectProperty<FilteredList<Algorithm>> filteredAlgorithmsProperty();
  void toggleCategory(String selected_caetgory);
}
