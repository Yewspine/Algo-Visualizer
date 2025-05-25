package com.visualizer.DomainObject.Algorithms.PathFinding;

import com.visualizer.Model.Algorithm;
import com.visualizer.Model.AlgorithmMetadata;

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
  public String getAlgorithmType()
  {
    return "PathFinding";
  }

  @Override
  public void execute()
  {
    return;
  }
}

