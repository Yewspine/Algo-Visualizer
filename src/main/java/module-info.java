module com.visualizer {
  requires javafx.controls;
  exports com.visualizer;
  exports com.visualizer.Converter;
  exports com.visualizer.DomainObject;
  exports com.visualizer.DomainObject.Algorithms;
  exports com.visualizer.Model;
  exports com.visualizer.View;
  exports com.visualizer.View.Fragment;
  exports com.visualizer.ViewModel;

  uses com.visualizer.Model.Algorithm;
  provides com.visualizer.Model.Algorithm with
    com.visualizer.DomainObject.Algorithms.Sort.BubbleSort,
    com.visualizer.DomainObject.Algorithms.PathFinding.Djikstra;


}
