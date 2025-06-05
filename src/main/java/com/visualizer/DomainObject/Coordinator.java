package com.visualizer.DomainObject;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.util.Pair;
import javafx.scene.control.ListView;

public class Coordinator
{
  private final StringProperty selected_algorithm = new SimpleStringProperty();
  private final ObjectProperty<Pair<String, String>> selected_language = new SimpleObjectProperty();

  private final List<ChangeListener<String>> algorithm_listener = new ArrayList<>();
  private final List<ChangeListener<Pair<String, String>>> selector_listener = new ArrayList<>();

  public void selectAgorithm(String algorithm)
  {
    selected_algorithm.set(algorithm);
    algorithm_listener.forEach(listener -> listener.changed(null, null, algorithm));
  }

  public void selectLanguage(Pair<String, String> language)
  {
    selected_language.set(language);
    selector_listener.forEach(listener -> listener.changed(null, null, language));
  }

  public void onAlgorithmChanged(ChangeListener<String> listener)
  {
    algorithm_listener.add(listener);
  }

  public void onLanguageChanged(ChangeListener<Pair<String, String>> listener)
  {
    selector_listener.add(listener);
  }

  public ReadOnlyStringProperty selectedAlgorithmProperty()
  {
    return selected_algorithm;
  }

  public ReadOnlyObjectProperty<Pair<String, String>> selectedLanguageProperty()
  {
    return selected_language;
  }

}
