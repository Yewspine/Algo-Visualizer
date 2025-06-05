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
  
  /**
   * This class read the chosen language to display the code using this 
   * programming language
   * @author Yewspine
   * */
  protected static class GetSelectorValue 
  { 
    /**
    * @param selected_language a Pair of String with the programming language name
    * as a key and its extension name as a value
    * @return A string value representing the the extension name of the selected 
    * language
    * */
    public String selectLanguage(Pair<String, String> selected_language)
    {
      return selected_language.getValue();
    }
  }

  protected static class GetListViewValue
  {
    public String selectAlgorithm(ListView view)
    {
      return view.getSelectionModel().getSelectedItem().toString();
    }
  }

  @Override
  public void updateCodeView()
  {
    System.out.println(selected_algorithm + '.' + selected_language);
  }

}
