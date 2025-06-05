package com.visualizer.Model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This interface define a decorator to set Algorithm Metadata 
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
