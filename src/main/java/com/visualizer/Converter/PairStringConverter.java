package com.visualizer.Converter;

import java.lang.UnsupportedOperationException;

import javafx.util.Pair;
import javafx.util.StringConverter;

/**
 * This class is used to convert a Pair of String to a common String.
 * @author Yewspine
 * */
public class PairStringConverter extends StringConverter<Pair<String, String>> 
{
  public PairStringConverter()
  {}

  
  /**
   * The overriden <pre>toString()</pre> method extract the key of the pair and return it
   * In case the pair or the key is null, an empty String is sent
   * Personnal note here, I should change this method return value 
   * for an <pre>{@code Optionnal<String>}</pre>.
   * @param pair the string pair to convert to a string
   * @return If the key of the pair if the pair and the key are not <code>null</code> Else it return an empty String
   * */
  @Override
  public String toString(Pair<String, String> pair)
  {
    boolean pairContainValue = ( pair != null && pair.getKey() != null ); 
    return pairContainValue ? pair.getKey() : "";
  }

    /**
   * Normally it should create a <pre>{@code Pair<String, String>}</pre> from a 
   * <pre>String</pre> However in this context, this is useless and wil always throw an Exception
   * @param string the <pre>String</pre> value to convert to a Pair of String 
   * @throws UnsupportedOperationException Java internal Exception meaning this operation is not supported and that will never be
   * @return while the signature assure it would return a <pre>{@code Pair<String, String>}</pre> this will never happens
   * */
  @Override
  public Pair<String, String> fromString(String string)
  {
    throw new UnsupportedOperationException();
  }
}
