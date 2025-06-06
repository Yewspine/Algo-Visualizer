package com.visualizer.Model;

/**
 * Base interface that define the functionnal behavior of a given algorithm, 
 * This is NOT defining the metadata of an algorithm, this is AlgorithmMetadata role
 * @see com.visualizer.Model.AlgorithmMetadata
 * @author Yewspine
 * */
public interface Algorithm 
{
  void execute();
  AlgorithmMetadata getMetadata();
}
