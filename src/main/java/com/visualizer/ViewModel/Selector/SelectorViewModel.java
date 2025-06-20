package com.visualizer.ViewModel.Selector;

import java.lang.IllegalStateException;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.util.Pair;

import com.visualizer.ViewModel.Contract.SelectorService;

public class SelectorViewModel implements SelectorService
{

  private final ObservableList<Pair<String, String>> choices = FXCollections.observableArrayList();
  private final ObjectProperty<Pair<String, String>> selectedPair = new SimpleObjectProperty<>();
  private final StringProperty labelText = new SimpleStringProperty("");

  public SelectorViewModel()
  {
    populateChoiceBox();
    setupListener();
  }

  private void populateChoiceBox()
  {
    choices.addAll(
      new Pair("Pascal", "pas"),
      new Pair("C++", "cpp"),
      new Pair("C", "c"),
      new Pair("JavaScript", "js"),
      new Pair("C#", "cs"),
      new Pair("Java", "java"),
      new Pair("Haskell", "hs"),
      new Pair("Python", "py"),
      new Pair("PHP", "php")
    );
  }

  private void setupListener()
  {
    selectedPair.addListener((obs, old, fresh) -> {
      if ( fresh == null )
      {
        throw new IllegalStateException();
      }

      labelText.set(String.format("%s Selected, language extension is : %s", fresh.getKey(), fresh.getValue()));
    });
  }

  @Override
  public ObservableList<Pair<String, String>> getChoices()
  {
    return choices;
  }

  @Override
  public ObjectProperty<Pair<String, String>> selectedPairProperty()
  {
    return selectedPair;
  }

  public StringProperty labelTextProperty()
  {
    return labelText;
  }
}
