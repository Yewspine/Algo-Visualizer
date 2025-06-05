package com.visualizer.ViewModel;

import javafx.util.Pair;

import com.visualizer.Model.LanguageSelector;

/**
 * This class read the chosen language to display the code using this 
 * programming language
 * @see com.visualizer.Model.LanguageSelector
 * @author Yewspine
 * */
public class SelectorFragmentViewModel implements LanguageSelector 
{ 
  /**
   * This override the <code>selectLanguage</code> method and return the chosen value in the ChoiceBox
   * @param selected_language a Pair of String using the language name as a key and its extension as a value
   * @return A string value representing the extension name of the selected 
   * language
   * */
  @Override
  public String selectLanguage(Pair<String, String> selected_language)
  {
    return selected_language.getValue();
  }
}
