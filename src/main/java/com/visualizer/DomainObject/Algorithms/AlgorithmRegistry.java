package com.visualizer.DomainObject.Algorithms;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.ServiceLoader;

import com.visualizer.Model.Algorithm;
import com.visualizer.Model.AlgorithmMetadata;

/**
 * ServiceLoader pattern used to list every Algorithm created
 * @see com.visualizer.View.Fragment.AlgorithmBrowserFragment
 * @author Yewspine
 * */
public class AlgorithmRegistry 
{

  /** 
   * A Described algorithm is an Algorithm with a runnable instance and 
   * Its metadata. 
   * @see com.visualizer.Model.Algorithm
   * @see com.visualizer.Model.AlgorithmMetadata
   * @author Yewspine
   */
  public static class DescribedAlgorithm implements Algorithm 
  {
    public Algorithm instance;
    public AlgorithmMetadata metadata;

    public DescribedAlgorithm(Algorithm instance) 
    {
      this.instance = instance;
      this.metadata = instance.getClass().getAnnotation(AlgorithmMetadata.class);
    }

    @Override
    public AlgorithmMetadata getMetadata()
    {
      return metadata;
    }

    /**
     * Return the name of the algorithm stored in the Decorator
     * @return The name of the algorithm
     * */
    public String getAlgorithmName()
    {
      return metadata.name();
    }

    /**
     * Return the category of the algorithm stored in the decorator, 
     * to sort them in the ListView
     * @return The type of algorithm ( e.g : Sort, Pathfinding, etc... )
     * */
    public String getAlgorithmCategory() 
    {
      return metadata.category();
    }

    /**
     * Return the description of the algorithm, It's not used for the moment, 
     * @return the description of the algorithm 
     * */
    public String getAlgorithmDescription()
    {
      // @TODO Add a History or Further Pane in the main view, listing information about the algorithm
      return metadata.description();
    }

    /**
     * The execute method from the Algorithm interface
     * @see com.visualizer.Model.Algorithm
     * */
    @Override
    public void execute() 
    {
      instance.execute();
    }

    /**
     * This method exists because by default <pre>{@code List<>}</pre> Call of <code>toString()</code> display the
     * reflected name of the class, however, I needed the Algorithm Name I set in the Metadata.
     * @see DescribedAlgorithm#getAlgorithmName
     * @return The algorithm name from <pre>getAlgorithmName</pre>
     * */
    @Override
    public String toString() 
    {
      return getAlgorithmName();
    }

  }

  /**
   * Discover valid algorithm under <pre>algorithms</pre> subfolder 
   * @return A list of <pre>DescribedAlgorithm</pre>, if metadata are missing it return <code>null</code> 
   * @see DescribedAlgorithm
   * */
  public static List<DescribedAlgorithm> discover()
  {
    // Scan every Services listed under the META-INF/services folder
    // Get every class that inherit from Algorithm interface
    return ServiceLoader.load(Algorithm.class)
      .stream()
      .map(ServiceLoader.Provider::get)
      .map(DescribedAlgorithm::new)
      .filter(Objects::nonNull)
      .collect(Collectors.toList());
  }
}
