package com.visualizer.View.Composition;

import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import com.visualizer.DomainObject.Coordinator;
import com.visualizer.View.Fragment.FragmentView;

/**
 * The CenterViewComposition a grid with two side, One containing the code viewer 
 * and the other the graph
 * @author Yewspine
 * */
public class CenterViewComposition extends FragmentView<Coordinator>
{ 
  private GridPane grid = new GridPane();
  private ColumnConstraints code_viewer = new ColumnConstraints();
  private ColumnConstraints graph = new ColumnConstraints();

  public CenterViewComposition(Coordinator coordinator)
  {
    super(coordinator);
    initConstraint();
    setupListeners();
    createView();
  }

  /**
   * Create constraints, split the center view in the middle 
   * */
  private void initConstraint()
  {
    code_viewer.setPercentWidth(50);
    graph.setPercentWidth(50);
    grid.getColumnConstraints().addAll(graph, code_viewer);
  }

  /**
   * Listen to the signal sent by the Coordinator and update the view Accordingly
   * */
  private void setupListeners()
  {
    controller.onAlgorithmChanged((obs, old, fresh) -> updateCodeView());
    controller.onAlgorithmChanged((obs, old, fresh) -> updateCodeView());
  }

  /**
   * At the moment, just some fancy prints are done here
   * Should be move in the Controller and a proper view should be changed
   * */
  private void updateCodeView()
  {
    String algorithm = controller.selectedAlgorithmProperty().get();
    Pair<String, String> language = controller.selectedLanguageProperty().get();
    if ( algorithm != null && language != null )
    {
      String filename = String.format("%s.txt", language.getValue());
      // For debugging purpose
      System.out.println(String.format("%s/%s", algorithm, filename));
    }
  }

  /**
   * Create the view for the Center View 
   * */
  protected void createView()
  {
    this.getChildren().add(grid);
  }

}
