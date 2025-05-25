package com.visualizer.DomainObject.Algorithms.Sort;

import com.visualizer.Model.Algorithm;
import com.visualizer.Model.AlgorithmMetadata;

@AlgorithmMetadata(
  name="Bubble Sort",
  category="Sort",
  description="A O(n^2) Sorting algorithm"
)
public class BubbleSort implements Algorithm
{

  public BubbleSort()
  {}

  @Override
  public String getAlgorithmType()
  {
    return "Sort";
  }

  @Override
  public void execute()
  {
    return;
  }
}
