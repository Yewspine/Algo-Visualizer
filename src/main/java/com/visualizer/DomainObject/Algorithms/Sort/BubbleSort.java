package com.visualizer.DomainObject.Algorithms.Sort;

import com.visualizer.Model.Algorithm;
import com.visualizer.Model.AlgorithmMetadata;


/*
 * This class implement the bubble sort algorithm with it's executor and it's metadata
 * The algorithm metadata are stored into the decorator, and the executor is in 
 * the body of the class
 * @author Yewspine
 * */
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
  public String getAlgorithmCategory()
  {
    return "Sort";
  }

  /*
   * The method to execute the algorithm, does nothing for now
   * */
  @Override
  public void execute()
  {
    return;
  }
}
