package com.visualizer.ViewModel.Contract;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.util.Pair;

public interface SelectorService
{
  ObservableList<Pair<String, String>> getChoices();
  ObjectProperty<Pair<String, String>> selectedPairProperty();
}
