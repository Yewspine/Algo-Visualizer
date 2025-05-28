package com.visualizer.Converter;

import java.lang.UnsupportedOperationException;
import javafx.util.Pair;
import javafx.util.StringConverter;

/*
 * This class is used to convert a Pair of String <code>Pair<String, String></code> 
 * To A String by Overriding the native toString method.
 * @author Yewspine
 * */
public class PairStringConverter extends StringConverter<Pair<String, String>>
{
  
  public PairStringConverter()
  {}

  /*
   * The overriden toString() method extract the key of the pair and return it
   * In case the pair or the key is null, an empty String is sent.
   * Personnal note here, I should change this method return value 
   * for an Optionnal<String>.
   * @param pair the string pair to convert to a string
   * @return If the key of the pair if the pair and the key are not <code>null</code> Else it return an empty String
   * */
  @Override
  public String toString(Pair<String, String> pair)
  {
    return pair != null && pair.getKey() != null ? pair.getKey() : ""; 
  }

  /*
   * Normally it should create a <code>Pair<String, String></code> from a 
   * <code>String</code> However on this context, this is useless and wil always throw an Exception
   * @param string the <code>String</code> value to convert to a Pair of String 
   * @throw UnsupportedOperationException Abort the operation with an error message
   * @return while the signature assure it would return a <code>Pair<String, String></code> this will never happens
   * */
  @Override
  public Pair<String, String> fromString(String string)
  {
    throw new UnsupportedOperationException("Operation not supported in this context");
  }
}
