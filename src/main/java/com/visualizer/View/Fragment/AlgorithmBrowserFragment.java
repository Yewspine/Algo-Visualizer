package com.visualizer.View.Fragment;

import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import com.visualizer.DomainObject.Coordinator;
import com.visualizer.Model.Algorithm;
import com.visualizer.Model.AlgorithmMetadata;
import com.visualizer.ViewModel.AlgorithmBrowserViewModel;

/**
 * The View constructor for the Algorithm Browser, It contain a ListView listing every algorithm 
 * and a ChoiceBox to filter Algorithm by categories.
 * @see com.visualizer.View.Fragment.FragmentView#FragmentView 
 * @author Yewspine
 * */
public class AlgorithmBrowserFragment extends FragmentView<AlgorithmBrowserViewModel> 
{
  private final ChoiceBox<String> algorithm_type = new ChoiceBox<>();
  private final Coordinator coordinator;
  private static final String DEFAULT_CHOICE = "Show All";
  private ListView<Algorithm> list_view;

  public AlgorithmBrowserFragment(AlgorithmBrowserViewModel viewModel, Coordinator coordinator) 
  {
    super(viewModel);
    this.coordinator = coordinator;
    initChoice();
    createView(); 
  }

  /**
   * Populate the choiceBox with Algorithm categories 
   * */
  private void initChoice()
  {
    ObservableList<String> algorithm_class = FXCollections.observableArrayList();
    algorithm_class.add(DEFAULT_CHOICE);

    List<String> categories = controller.getDiscoverableAlgorithms()
      .stream()
      .map(algorithm -> algorithm.getMetadata().category())
      .distinct()
      .collect(Collectors.toList());

    algorithm_class.addAll(categories);

    algorithm_type.setItems(algorithm_class);
    algorithm_type.setValue(DEFAULT_CHOICE);
  }

  /**
   * Create the LeftBar View for the BorderPane and bind the controller
   * */
  @Override
  protected void createView() 
  {
    VBox vbox = new VBox();
    vbox.setPadding(new Insets(10));
    vbox.setSpacing(10);

    HBox hbox = new HBox();
    hbox.setSpacing(6);

    algorithm_type.setOnAction(event -> 
      controller.toggleCategory(algorithm_type.getValue())
    );

    hbox.getChildren().add(algorithm_type);

    list_view = new ListView<>();
    list_view.itemsProperty().bind(controller.filteredAlgorithmsProperty());
    // Send information over Event Broker
    list_view.getSelectionModel().selectedItemProperty().addListener((obs, old, fresh) -> {
      if ( fresh != null )
      {
        coordinator.selectAlgorithm(
          // Get the name of the alogrithm in the metadata
          fresh.getMetadata().name()
        );
      }
    });

    vbox.getChildren().addAll(hbox, list_view);
    this.getChildren().add(vbox);
  }
}
