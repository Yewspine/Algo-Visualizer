package com.visualizer.View.Fragment;

import javafx.scene.layout.Region;

/*
 * Abstract class defining a FragmentView. The <T> generic type attend the Controller
 * interface. For granularity and because of Interface Segregation, the T type is not 
 * narrowed to a particular Controller Interface.
 * @author Yewspine
 * */
public abstract class FragmentView<T> extends Region
{
  protected final T controller;

  // Basic Depedency injection 
  public FragmentView(T controller)
  {
    this.controller = controller;
  }

  /*
   * This method construct the View of the Fragment, this is present in every Fragment
   * */
  protected abstract void createView();
}
