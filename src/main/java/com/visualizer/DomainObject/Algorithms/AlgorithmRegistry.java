package com.visualizer.DomainObject.Algorithms;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import com.visualizer.Model.Algorithm;
import com.visualizer.Model.AlgorithmMetadata;

public class AlgorithmRegistry 
{
  public static class DescribedAlgorithm implements Algorithm 
  {
    public Algorithm instance;
    public AlgorithmMetadata metadata;

    public DescribedAlgorithm()
    {}

    public DescribedAlgorithm(Algorithm instance, AlgorithmMetadata metadata) 
    {
      this.instance = instance;
      this.metadata = metadata;
    }
 
    public String getAlgorithmName()
    {
      return metadata.name();
    }

    @Override
    public String getAlgorithmType() 
    {
      return metadata.category();
    }

    @Override
    public void execute() 
    {
      instance.execute();
    }
  }

  // Reflection Algorithm
  public static List<DescribedAlgorithm> discover()
  {
    // Scan com.visualizer.Algorithms directory
    Reflections reflections = new Reflections("com.visualizer.DomainObject.Algorithms");
    // Get every class that inherit from Algorithm interface
    return reflections.getSubTypesOf(Algorithm.class)
      .stream()
      // Remove internal class 
      .filter(algo_class -> !algo_class.getName().contains("$"))
      // Should be uncommented if Abstract class are found in the reflection
      //.filter(algo_class -> !java.lang.reflect.Modifier.isAbstract(algo_class.getModifiers()))
      .map(algo_class -> 
      {
        try
        {
          // Create new context class instance
          Algorithm instance = algo_class.getDeclaredConstructor().newInstance();
          AlgorithmMetadata metadata = algo_class.getAnnotation(AlgorithmMetadata.class);
          if ( metadata == null )
          {
            System.err.println("Error loading algorithm: " + algo_class.getName());
            return null;   
          }
 
          return new DescribedAlgorithm(instance, metadata);
        } catch ( Exception exception )
        {
          System.err.println("Handled Exception");
          exception.printStackTrace();
          return null;
        }
      })
      .filter(Objects::nonNull)
      .collect(Collectors.toList());
  }

}
