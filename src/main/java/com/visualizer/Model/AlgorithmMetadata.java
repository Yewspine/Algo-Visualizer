package com.visualizer.Model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Algorithm Metadata Decorator, Way easier to deal with when it comes to reflection
 * @author Yewspine
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AlgorithmMetadata
{
  String name();
  String category();
  String description();
}
