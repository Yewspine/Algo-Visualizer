package com.visualizer.View.Fragment;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import com.visualizer.Model.Algorithm;
import com.visualizer.ViewModel.AlgorithmBrowserViewModel;

public class AlgorithmBrowserFragment extends FragmentView<AlgorithmBrowserViewModel> 
{

  private final ChoiceBox<String> algorithm_type = new ChoiceBox<>();
  private static final String DEFAULT_CHOICE = "Show All";
  private ListView<Algorithm> list_view;

  public AlgorithmBrowserFragment(AlgorithmBrowserViewModel viewModel) 
  {
    super(viewModel);
    initChoice();
    createView(); 
  }

  private void initChoice()
  {
    ObservableList<String> algorithm_class = FXCollections.observableArrayList();
    algorithm_class.add(DEFAULT_CHOICE);

    List<String> categories = controller.getDiscoverableAlgorithms()
      .stream()
      .map(Algorithm::getAlgorithmType)
      .distinct()
      .collect(Collectors.toList());

    for (String category : categories) 
    {
      algorithm_class.add(category);
    }

    algorithm_type.setItems(algorithm_class);
    algorithm_type.setValue(algorithm_type.getItems().get(0));
  }

  @Override
  protected void createView() 
  {

    VBox vbox = new VBox();
    vbox.setPadding(new Insets(10));
    vbox.setSpacing(10);

    HBox hbox = new HBox();
    hbox.setSpacing(6);

    //toggle_button.setUserData((Predicate<Algorithm>) algo -> category.equals(algo.getAlgorithmType()));
    //toggle_button.setOnAction(controller::toggleCategory);
    hbox.getChildren().add(algorithm_type);

    list_view = new ListView<>();
    list_view.itemsProperty().bind(controller.filteredAlgorithmsProperty());

    vbox.getChildren().addAll(hbox, list_view);
    this.getChildren().add(vbox);
  }
}

