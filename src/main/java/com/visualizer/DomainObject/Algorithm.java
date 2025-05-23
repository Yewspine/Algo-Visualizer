package com.visualizer.DomainObject;

public class Algorithm
{
  private final String algorithm_type;
  private final String algorithm_name;
  
  public Algorithm(String algorithm_type, String algorithm_name)
  {
    this.algorithm_type = algorithm_type;
    this.algorithm_name = algorithm_name;
  }
  
  public String getAlgorithmType()
  {
    return algorithm_type;
  }

  public String getAlgorithmName()
  {
    return algorithm_name;
  }

  @Override
  public String toString()
  {
    return algorithm_type + " : ( " + algorithm_type + " ) ";
  }

}
