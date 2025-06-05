package com.visualizer.Model;

import com.visualizer.Model.LanguageSelector;
import com.visualizer.Model.AlgorithmBrowser;

/**
 * The code Display interface use the LanguageSelector and AlgorithmBrowser
 * result to update it own content
 * @see com.visualizer.Model.LanguageSelector
 * @see com.visualizer.Model.AlgorithmBrowser
 * @author Yewspine
 * */
public interface CodeDisplay 
{
  void updateCodeView();
}
