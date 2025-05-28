package com.visualizer.View.Fragment;

import java.lang.Exception;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.util.Pair;

import com.visualizer.Converter.PairStringConverter;
import com.visualizer.View.Fragment.FragmentView;
import com.visualizer.ViewModel.SelectorFragmentViewModel;

/*
 * Create the SelectorFragment, which will evolve in a complete toolbar 
 * to let user interact with the software 
 * @author Yewspine
 * */
public class SelectorFragment extends FragmentView<SelectorFragmentViewModel> 
{
  private final ChoiceBox<Pair<String, String>> language = new ChoiceBox<>();

  public SelectorFragment(SelectorFragmentViewModel viewModel)
  {
    super(viewModel);
    initChoice();
    createView();
  }

  /*
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
    language.setValue(language.getItems().get(0)); 
  }

  /*
   * Create the view for the toolbar and bind the controller to it
   * */
  @Override
  protected void createView()
  {
    try
    { 
      Label language_label = new Label("Change language implementation");  
      language.setOnAction(event -> controller.apply_language(language.getValue()));

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
