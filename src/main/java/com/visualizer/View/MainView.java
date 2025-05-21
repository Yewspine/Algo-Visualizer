package com.visualizer.View;

import javafx.scene.layout.BorderPane;

import com.visualizer.ViewModel.AlgorithmBrowserViewModel;
import com.visualizer.ViewModel.SelectorFragmentViewModel;
import com.visualizer.View.AlgorithmBrowserFragment;
import com.visualizer.View.Fragment.SelectorFragment;

public class MainView extends BorderPane
{
  public MainView()
  {
    AlgorithmBrowserFragment algorithm_browser_fragment = new AlgorithmBrowserFragment(new AlgorithmBrowserViewModel()); 
    SelectorFragment selector_fragment = new SelectorFragment(new SelectorFragmentViewModel());
    this.setTop(selector_fragment);
    this.setLeft(algorithm_browser_fragment);
  }
}
