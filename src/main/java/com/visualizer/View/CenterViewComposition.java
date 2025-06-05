package com.visualizer.View;

import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The CenterViewComposition constructor for the Algorithm Browser It contain 
 * a grid with two side, One containing the code viewer and the other the graph
 * @author Yewspine
 * */
public class CenterViewComposition extends GridPane
{
  private GridPane grid = new GridPane();
  private ColumnConstraints code_viewer = new ColumnConstraints();
  private ColumnConstraints graph = new ColumnConstraints();

  private void initConstraint()
  {
    code_viewer.setPercentWidth(50);
    graph.setPercentWidth(50);
    grid.getColumnConstraints().addAll(graph, code_viewer);
  }
}
