package com.visualizer.DomainObject.Algorithms;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import com.visualizer.Model.Algorithm;
import com.visualizer.Model.AlgorithmMetadata;

/*
 * This class handle the reflections algorithm used to list every 
 * Algorithm created, they will be displayed and their interface linked in the 
 * ListView of the AlgorithmBrowserFragment
 * @see AlgorithmBrowserFragment
 * @author Yewspine
 * */
public class AlgorithmRegistry 
{

  /* 
   * A Described algorithm is an Algorithm with a runnable instance and 
   * It metadata. 
   * @see com.visualizer.Model.Algorithm
   * @see com.visualizer.Model.AlgorithmMetadata
   * @author Yewspine
   */
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
 
    /*
     * Return the name of the algorithm stored in the Decorator
     * @return The name of the algorithm
     * */
    public String getAlgorithmName()
    {
      return metadata.name();
    }

    /*
     * Return the category of the algorithm stored in the decorator, 
     * to sort them in the ListView
     * @return The category of the algorithm
     * */
    public String getAlgorithmCategory() 
    {
      return metadata.category();
    }

    /*
     * Return the description of the algorithm. It's not used for the moment,
     * but I plan to split it in multiple parts
     * @return the description of the algorithm 
     * */
    public String getAlgorithmDescription()
    {
      return metadata.description();
    }

    /*
     * The execute method from the Algorithm interface
     * @see com.visualizer.Model.Algorithm
     * */
    @Override
    public void execute() 
    {
      instance.execute();
    }

    /*
     * This method exists because by default List<> Call of toString() display the
     * reflected name of the class, however, I needed the Algorithm Name.
     * @see DescribedAlgorithm#getAlgorithmName
     * @return The algorithm name from <code>getAlgorithmName</code>
     * */
    @Override
    public String toString() 
    {
      return getAlgorithmName();
    }

  }

  /*
   * Discover valid algorithm under the com.visualizer.DomainObject.Algorithms 
   * package. It already handle internal class and not activated yet, can handle
   * abstract classes too.
   * @return It return a list of DescribedAlgorithm, if metadata are missing it return <code>null</code> 
   * @see DescribedAlgorithm
   * */
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
            // Will add a real logging system later
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
