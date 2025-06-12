package com.visualizer.View.Fragment;

import java.lang.Exception;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.util.Pair;

import com.visualizer.Converter.PairStringConverter;
import com.visualizer.DomainObject.Coordinator;
import com.visualizer.View.Fragment.FragmentView;

/**
 * Create the SelectorFragment, which will evolve in a complete toolbar 
 * to let user set his preferences in the software 
 * @author Yewspine
 * */
public class SelectorFragment extends FragmentView<Coordinator> 
{
  private final ChoiceBox<Pair<String, String>> language = new ChoiceBox<>();
 
  public SelectorFragment(Coordinator coordinator)
  {
    super(coordinator); 
    initChoice();
    createView();
  }

  /**
   * Poplate the ChoiceBox with hardcoded languages to choose from.
   * */
  private void initChoice()
  {
    ObservableList<Pair<String, String>> language_classes = FXCollections.observableArrayList();
    language_classes.addAll( 
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
    
    language.setConverter(new PairStringConverter()); 

    language.setItems(language_classes);
    // Initialize default selection for controller and choiceBox
    Pair<String, String> default_language = language.getItems().get(0);
    language.setValue(default_language); 
    controller.selectLanguage(default_language);
  }

  /**
   * Create the view for the toolbar and bind the controller to it
   * */
  @Override
  protected void createView()
  {
    try
    { 
      Label language_label = new Label("Change language implementation");  
      language.setOnAction(event -> controller.selectLanguage(language.getValue()));

      ToolBar bar = new ToolBar(      
        language_label, 
        language
      );
      this.getChildren().add(bar);
    } catch ( Exception exception )
    {
      exception.printStackTrace();
      throw exception;
    }
  }
}
