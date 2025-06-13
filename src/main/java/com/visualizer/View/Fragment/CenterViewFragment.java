package com.visualizer.View.Fragment;

import java.io.InputStream;
import java.lang.IllegalStateException; 
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
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
public class CenterViewFragment extends FragmentView<Coordinator>
{ 
  private GridPane grid = new GridPane();
  private ColumnConstraints code_viewer = new ColumnConstraints();
  private ColumnConstraints graph = new ColumnConstraints();
  private TextArea code_display = new TextArea();

  public CenterViewFragment(Coordinator coordinator)
  {
    super(coordinator);
    initConstraint();
    initTextAreaProperty(); 
    setupListeners();
    updateCodeView();
    createView();
  }

  private void initTextAreaProperty()
  {
    code_display.setPrefColumnCount(74);
    code_display.setPrefRowCount(50);
    code_display.setScrollTop(3d);
    code_display.setScrollLeft(3d);
    code_display.setWrapText(true);
    code_display.setEditable(false);
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
    controller.onLanguageChanged((obs, old, fresh) -> updateCodeView());
    controller.onAlgorithmChanged((obs, old, fresh) -> updateCodeView());
  }

  //@TODO Move this code to a proper controller.
  /**
   * Change the code View when ( graph + text area ) 
   * whenever a new language or algorithm is picked.
   * */
  private void updateCodeView()
  {
    String algorithm = controller.selectedAlgorithmProperty().get();
    Pair<String, String> language = controller.selectedLanguageProperty().get();
    if ( algorithm != null && language != null )
    {
      String filename = String.format("/scripts/%s/%s.txt", algorithm.replaceAll("\\s", ""), language.getValue());
      InputStream input = getClass().getResourceAsStream(filename);
      
      if ( input == null ) 
      {
        code_display.setText("File not found " + filename);
        throw new IllegalStateException("File not found " + filename);
      }

      StringBuilder text = new StringBuilder();
      try ( Scanner scanner = new Scanner(input) )
      {
        while ( scanner.hasNextLine() )
        {
          // @TODO Conver the InputStream to a BufferStream 
          text.append(scanner.nextLine()).append("\n");
        }
        code_display.setText(text.toString());
      }
    }
  }

  /**
   * Create the view for the Center View 
   * */
  protected void createView()
  {
    grid.setRowIndex(code_display, 0);
    grid.getChildren().add(code_display);
    this.getChildren().add(grid);
  }

}
