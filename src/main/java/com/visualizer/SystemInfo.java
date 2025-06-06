package com.visualizer;

/**
 * A debugging class giving basic system information, 
 * useful to have when reporting issues
 * @author Maven Generated code
 * */
public class SystemInfo {

  /**
   * Return the java version used by the program
   * @return The java version
   * */
  public static String javaVersion() 
  {
    return System.getProperty("java.version");
  }

  /**
   * Return the current version of javafx, should be the same as the one in the pom.xml file
   * @return The javafx Version
   * */
  public static String javafxVersion() 
  {
    return System.getProperty("javafx.version");
  }

  /** 
   * Gives information about the parent OS
   * @return A formatted string containing OS name, version and architecture
   * */
  public static String osInfo()
  {
    return String.format("OS: %s\nVersion: %s\nArchitecture: %s", 
        System.getProperty("os,name"),
        System.getProperty("os.version"),
        System.getProperty("os.arch")
      );
  }

}
