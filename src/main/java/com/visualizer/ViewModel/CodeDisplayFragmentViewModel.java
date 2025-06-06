package com.visualizer.ViewModel;

import java.util.List;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ListView;
import javafx.util.Pair;

import com.visualizer.Model.CodeDisplay;

public class CodeDisplayFragmentViewModel implements CodeDisplay
{
  private final String selected_algorithm = "";
  private final String selected_language = "";

  @Override
  public void updateCodeView()
  {
    System.out.println(selected_algorithm + '.' + selected_language);
  }

}
