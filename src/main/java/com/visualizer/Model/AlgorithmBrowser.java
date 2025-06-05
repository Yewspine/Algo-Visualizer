package com.visualizer.Model;

import java.util.List;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.transformation.FilteredList;

import com.visualizer.Model.Algorithm;

/**
 * This interface define the behaviour of the AlgorithmBrowser Controller,
 * It is here to respect the contract of the FragmentView abstract class.
 * @see com.visualizer.View.Fragment.FragmentView
 * @author Yewspine
 * */
public interface AlgorithmBrowser
{
  List<Algorithm> getDiscoverableAlgorithms();
  ReadOnlyObjectProperty<FilteredList<Algorithm>> filteredAlgorithmsProperty();
  void toggleCategory(String selected_caetgory);
}
