package com.visualizer.View.Fragment;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import com.visualizer.Model.Algorithm;
import com.visualizer.ViewModel.AlgorithmBrowserViewModel;

public class AlgorithmBrowserFragment extends FragmentView<AlgorithmBrowserViewModel> 
{

  private ListView<Algorithm> list_view;

  public AlgorithmBrowserFragment(AlgorithmBrowserViewModel viewModel) 
  {
    super(viewModel);
    createView(); 
  }

  @Override
  protected void createView() 
  {

    VBox vbox = new VBox();
    vbox.setPadding(new Insets(10));
    vbox.setSpacing(10);

    HBox hbox = new HBox();
    hbox.setSpacing(6);

    ToggleGroup filter_toggle_group = new ToggleGroup();

    ToggleButton show_all_button = new ToggleButton("Show All");
    show_all_button.setSelected(true);
    show_all_button.setToggleGroup(filter_toggle_group);
    show_all_button.setUserData((Predicate<Algorithm>) algo -> true);
    show_all_button.setOnAction(controller::toggleCategory);
    hbox.getChildren().add(show_all_button);

    List<String> categories = controller.getDiscoverableAlgorithms()
      .stream()
      .map(Algorithm::getAlgorithmType)
      .distinct()
      .collect(Collectors.toList());

    for (String category : categories) 
    {
      ToggleButton toggle_button = new ToggleButton(category);
      toggle_button.setToggleGroup(filter_toggle_group);
      toggle_button.setUserData((Predicate<Algorithm>) algo -> category.equals(algo.getAlgorithmType()));
      toggle_button.setOnAction(controller::toggleCategory);
      hbox.getChildren().add(toggle_button);
    }

    list_view = new ListView<>();
    list_view.itemsProperty().bind(controller.filteredAlgorithmsProperty());

    vbox.getChildren().addAll(hbox, list_view);
    this.getChildren().add(vbox);
  }
}

