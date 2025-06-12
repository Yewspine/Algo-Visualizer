package com.visualizer.DomainObject.Algorithms.PathFinding;

import com.visualizer.Model.Algorithm;
import com.visualizer.Model.AlgorithmMetadata;

/**
 * This class implement the Djikstra algorithm with it's executor and it's metadata
 * The algorithm metadata are stored into the decorator, and the executor is in 
 * the body of the class
 * @author Yewspine
 * */
@AlgorithmMetadata(
  name="Djikstra",
  category="PathFinding",
  description="A Pathfinding algorithm for graphs"
)
public class Djikstra implements Algorithm
{

  public Djikstra()
  {}
 
  @Override
  public AlgorithmMetadata getMetadata()
  {
    return this.getClass().getAnnotation(AlgorithmMetadata.class);
  }

  /*
   * The executor of the algorithm, empty for now
   * */
  @Override
  public void execute()
  {
    return;
  }
}

