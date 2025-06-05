package com.visualizer.Model;

import javafx.util.Pair;

/**
 * The interface for the language selector in the toolbar.
 * @author Yewspine 
 * */
public interface LanguageSelector
{
  String selectLanguage(Pair<String, String> selected_language);
}

