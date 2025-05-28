package com.visualizer.Model;

/*
 * The algorithm interface it's the base interface that define the functionnal
 * Behavior a given algorithm.
 * This is NOT defining the metadata of an algorithm, this is AlgorithmMetadata
 * role
 * @see: AlgorithmMetadata
 * @author: Yewspine
 * */
public interface Algorithm 
{
  String getAlgorithmCategory();
  void execute();
}
