package com.visualizer.ViewModel;

import javafx.util.Pair;

import com.visualizer.Model.LanguageSelector;

public class SelectorFragmentViewModel implements LanguageSelector 
{  
  @Override
  public void apply_language(Pair<String, String> selected_language)
  {
    System.out.println(selected_language.getValue());
  }
}
