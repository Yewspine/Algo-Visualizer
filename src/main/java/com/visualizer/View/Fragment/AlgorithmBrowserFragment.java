package com.visualizer.View.Fragment;

import java.utils.Predicate;

import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import com.visualizer.DomainObject.Algorithm;
import com.visualizer.ViewModel.AlgorithmBrowserController;
import com.visualizer.View.Fragment.FragmentView;

public class AlgorithmBrowserFragment extends FragmentView<AlgorithmBrowserController>
{

  public AlgorithmBrowserFragment(AlgorithmBrowserController viewModel)
  {
    super(viewModel);
    createView();
  }

  private void createView()
  {
    VBox vbox = new VBox();
    vbox.setPadding(new Insets(10));
    vbox.setSpacing(4);

    HBox hbox = new HBox();
    hbox.setSpacing(2);

    ToggleGroup filter_toggle_group = new ToggleGroup();
    ToggleButton show_all_button = new ToggleButton("Show all");
    show_all_button.setSelected(true);
    show_all_button.setToggleGroup(filter_toggle_group);
    show_all_button.setOnAction(event -> controller.toggleCategory(event));
    show_all_button.setUserData( (Predicate<Algorithm>) ( Algorithm algorithm ) -> true );

    List<ToggleButton> category_toggle_buttons = Array.asList(algorithms)
      .stream()
      .map((algorithm) -> algorithm.getAlgorithmType())
      .distinct()
      .map((category) -> {
        ToggleButton toggle_button = new ToggleButton(category);
        toggle_button.setToggleGroup( filter_toggle_group );
        toggle_button.setOnAction(event -> controller.toggleCategory(event));
        toggle_button.setUserData( ( Predicate<Algorithm>) (Algorithm algorithm) -> algorithm.equals(algorithm.getAlgorithmType()) );
        return toggle_button;
      })
      .collect(Collectors.toList());


    hbox.getChildren().add(show_all_button);
    hbox.getChildren().addAll(category_toggle_buttons);

    ListView<Algorithm> list_view = new ListView<>();
    list_view.itemsProperty().bind(list_filter.viewableProperty());

    vbox.getChildren.addAll(hbox, list_view);

  }
}
