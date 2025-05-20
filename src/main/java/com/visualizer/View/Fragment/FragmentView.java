package com.visualizer.View.Fragment;

import javafx.scene.layout.Region;

public abstract class FragmentView<T> extends Region
{
  protected final T controller;

  public FragmentView(T controller)
  {
    this.controller = controller;
  }

  protected abstract void createView();
}
