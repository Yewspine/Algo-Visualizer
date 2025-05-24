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
    public final Algorithm instance;
    public final AlgorithmMetadata metadata;

    public DescribedAlgorithm(Algorithm instance, AlgorithmMetadata metadata) 
    {
      this.instance = instance;
      this.metadata = metadata;
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

  public static List<DescribedAlgorithm> discover()
  {
    // Scan com.visualizer.Algorithms directory
    Reflections reflections = new Reflections("com.visualizer.DomainObject.Algorithms");
    // Get every class that inherit from Algorithm interface
    return reflections.getSubTypesOf(Algorithm.class)
      .stream()
      .map(algo_class -> 
      {
        try
        {
          // Create new context class instance
          Algorithm instance = algo_class.getDeclaredConstructor().newInstance();
          
          if ( !(instance instanceof AlgorithmMetadata) )
          {
            System.err.println("Error loading algorithm: " + algo_class.getName());
            return null;   
          }

          AlgorithmMetadata metadata = (AlgorithmMetadata) instance;
          return new DescribedAlgorithm(instance, metadata);
        } catch ( Exception exception )
        {
          exception.printStackTrace();
          return null;
        }
      })
      .filter(Objects::nonNull)
      .collect(Collectors.toList());
  }

}
