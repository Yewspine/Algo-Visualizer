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

/**
 * Event Broker making sure multiple fragment and view communicating between each other
 * @author Yewspine
 * */
public class Coordinator
{
  private final StringProperty selected_algorithm = new SimpleStringProperty();
  private final ObjectProperty<Pair<String, String>> selected_language = new SimpleObjectProperty();

  private final List<ChangeListener<String>> algorithm_listener = new ArrayList<>();
  private final List<ChangeListener<Pair<String, String>>> selector_listener = new ArrayList<>();

  /**
   * Update the selected Algorithm in the ListView
   * @param algorithm The name of the new algorithm
   * */
  public void selectAlgorithm(String algorithm)
  {
    selected_algorithm.set(algorithm);
    // Don't care about what was, focus on what's now 
    algorithm_listener.forEach(listener -> listener.changed(null, null, algorithm));
  }

  /**
   * Update the selecte programming language
   * @param language A Pair containing the language name as key and it extension as a value 
   * */
  public void selectLanguage(Pair<String, String> language)
  {
    selected_language.set(language);
    // Don't care about what was, focus on what's now
    selector_listener.forEach(listener -> listener.changed(null, null, language));
  }

  /**
   * Add a listener for the Algorithm Change
   * Useful for views that want to react dynamically when the user switches algorithm
   * @param listener the view listener 
   * */
  public void onAlgorithmChanged(ChangeListener<String> listener)
  {
    algorithm_listener.add(listener);
  }

  /**
   * Add a listener for the language change
   * Useful for views that want to react dynamically when the user switches language
   * @param listener the view listener 
   * */
  public void onLanguageChanged(ChangeListener<Pair<String, String>> listener)
  {
    selector_listener.add(listener);
  }

  /**
   * A Getter for the selected algorithm property
   * @return A <pre>ReadOnlyStringProperty</pre> representing the current algorithm 
   * */
  public ReadOnlyStringProperty selectedAlgorithmProperty()
  {
    return selected_algorithm;
  }

  /**
   * A Getter for the selected language property
   * @return A <pre>ReadOnlyObjectProperty</pre> representing the current selected language 
   * */
  public ReadOnlyObjectProperty<Pair<String, String>> selectedLanguageProperty()
  {
    return selected_language;
  }

}
