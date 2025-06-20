module com.visualizer {
  requires javafx.controls;
  /*
  requires org.fxmisc.richtext;
  requires org.fxmisc.flowless;
  */
  exports com.visualizer;
  exports com.visualizer.Converter;
  /*
  exports com.visualizer.DomainObject;
  exports com.visualizer.DomainObject.Algorithms;
  */
  exports com.visualizer.Model;
  exports com.visualizer.View.Selector;
  exports com.visualizer.ViewModel.Selector;

  /*
  uses com.visualizer.Model.Algorithm;
  provides com.visualizer.Model.Algorithm with
    com.visualizer.DomainObject.Algorithms.Sort.BubbleSort,
    com.visualizer.DomainObject.Algorithms.PathFinding.Djikstra;
*/

}
