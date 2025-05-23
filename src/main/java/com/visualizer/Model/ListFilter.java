package com.visualizer.Model;

import java.util.Optional;
import java.util.function.Predicate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class ListFilter<T> 
{
  private final ObservableList<T> source_list;
  private final FilteredList<T> filtered_list;
  private final ObjectProperty<Predicate<? super T>> filter = new SimpleObjectProperty<>();

  public ListFilter(Optional<ObservableList<T>> source_list) 
  {
    this.source_list = source_list.orElse(FXCollections.observableArrayList());
    this.filtered_list = new FilteredList<>(this.source_list);
    filtered_list.predicateProperty().bind(filter);
  }

  public ObservableList<T> getSourceList() 
  {
    return source_list;
  }

  public FilteredList<T> getFilteredList() 
  {
    return filtered_list;
  }

  public ObjectProperty<Predicate<? super T>> filterProperty() 
  {
    return filter;
  }

  public void setFilter(Predicate<? super T> predicate) 
  {
    this.filter.set(predicate);
  }

  /*
  public ReadOnlyObjectProperty<FilteredList<T>> viewableProperty()
  {
    return new SimpleObjectProperty<FilteredList<T>>( 
        new FilteredList<>(this.source_list.get(0))
    );
  }
  */

  public Predicate<? super T> getFilter() 
  {
    return filter.get();
  }
}

