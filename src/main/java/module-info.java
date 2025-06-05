module com.visualizer {
  requires javafx.controls;
  requires org.reflections; 
  exports com.visualizer.Converter;
  exports com.visualizer.DomainObject;
  exports com.visualizer.DomainObject.Algorithms;
  exports com.visualizer.Model;
  exports com.visualizer.View;
  exports com.visualizer.View.Fragment;
  exports com.visualizer.ViewModel;
}
