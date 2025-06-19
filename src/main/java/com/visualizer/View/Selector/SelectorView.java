package com.visualizer.View.Selector;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.util.Pair;

import com.visualizer.Converter.PairStringConverter;
import com.visualizer.Model.View;
import com.visualizer.ViewModel.Selector.SelectorViewModel;

public class SelectorView extends View<SelectorViewModel>
{
    private final ChoiceBox<Pair<String, String>> language = new ChoiceBox<>();
    private final Label textLabel = new Label("");

    public SelectorView(SelectorViewModel viewModel)
    {
      super(viewModel);
      createView();
    }

    @Override
    protected void createView()
    {
      language.setItems(viewModel.getChoices());
      Pair<String, String> defaultLanguage = language.getItems().get(0);
      language.setValue(defaultLanguage);  

      viewModel.selectedPairProperty().bind(language.getSelectionModel().selectedItemProperty()); 

      textLabel.textProperty().bind(viewModel.labelTextProperty());

      language.setConverter(new PairStringConverter());

      ToolBar tools = new ToolBar(
        language,
        textLabel
      );
      
      this.getChildren().add(tools);
    }
}
