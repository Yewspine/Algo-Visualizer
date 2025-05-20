package com.visualizer.Converter;

import java.lang.UnsupportedOperationException;
import javafx.util.Pair;
import javafx.util.StringConverter;

public class PairStringConverter extends StringConverter<Pair<String, String>>
{
  
  public PairStringConverter()
  {}

  @Override
  public String toString(Pair<String, String> pair)
  {
    return pair != null && pair.getKey() != null ? pair.getKey() : ""; 
  }

  @Override
  public Pair<String, String> fromString(String string)
  {
    throw new UnsupportedOperationException("Operation not implemented");
  }
}
