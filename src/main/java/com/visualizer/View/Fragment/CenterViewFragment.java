package com.visualizer.View.Fragment;

import java.io.InputStream;
import java.lang.IllegalStateException;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import javafx.scene.layout.StackPane;
import javafx.util.Pair;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.flowless.VirtualizedScrollPane;

import com.visualizer.DomainObject.Coordinator;
import com.visualizer.View.Fragment.FragmentView;

/**
 * The CenterViewComposition a grid with two side, One containing the code viewer 
 * and the other the graph
 * @author Yewspine
 * */
public class CenterViewFragment extends FragmentView<Coordinator>
{ 
  private final CodeArea code_display = new CodeArea();
  private final VirtualizedScrollPane<CodeArea> scroll_pane = new VirtualizedScrollPane<>(code_display);
  private final StackPane stack_pane = new StackPane(scroll_pane);

  public CenterViewFragment(Coordinator coordinator)
  {
    super(coordinator); 
    initCodeAreaProperty(); 
    setupListeners();
    updateCodeView();
    createView();
  }


  /**
   * Set Properties for CodeArea
   * */
  private void initCodeAreaProperty()
  {
    // Add code-area style from the stylesheet 
    code_display.getStyleClass().add("code-area");
    code_display.setParagraphGraphicFactory(LineNumberFactory.get(code_display));
    // Break line when Column Count is reached
    code_display.setWrapText(true);
    // Prevent user from editing
    code_display.setEditable(false);
    scroll_pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
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
        code_display.replaceText("File not found " + filename);
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
        code_display.replaceText(text.toString());
      }
    }
  }

  /**
   * Create the view for the Center View 
   * */
  protected void createView()
  {
    stack_pane.setPrefWidth(1000);
    stack_pane.setPrefHeight(1000);
    
    this.getChildren().add(stack_pane);
  }
}
