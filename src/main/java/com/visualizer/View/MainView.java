package com.visualizer.View;

import javafx.scene.layout.BorderPane;

import com.visualizer.DomainObject.Coordinator;
import com.visualizer.View.Composition.CenterViewComposition;
import com.visualizer.View.Fragment.AlgorithmBrowserFragment;
import com.visualizer.View.Fragment.SelectorFragment;
import com.visualizer.ViewModel.AlgorithmBrowserViewModel;

/**
 * The main view class It is a BorderPane to easily split the different parts
 * of the software appart, Each parts are called Fragment
 * @author Yewspine
 * */
public class MainView extends BorderPane
{
  public MainView()
  {
    Coordinator event_broker = new Coordinator();
    AlgorithmBrowserFragment algorithm_browser_fragment = new AlgorithmBrowserFragment(new AlgorithmBrowserViewModel(), event_broker); 
    SelectorFragment selector_fragment = new SelectorFragment(event_broker);
    CenterViewComposition center_view = new CenterViewComposition(event_broker);
    this.setTop(selector_fragment);
    this.setLeft(algorithm_browser_fragment);
    this.setCenter(center_view);
  }
}
