package com.visualizer.View;

import javafx.scene.layout.BorderPane;

import com.visualizer.ViewModel.SelectorFragmentViewModel;
import com.visualizer.View.Fragment.SelectorFragment;

public class MainView extends BorderPane
{
  public MainView()
  {
    SelectorFragmentViewModel selector_fragment_controller = new SelectorFragmentViewModel();
    SelectorFragment selectorFragment = new SelectorFragment(selector_fragment_controller);
    this.setTop(selectorFragment);
  }
}
