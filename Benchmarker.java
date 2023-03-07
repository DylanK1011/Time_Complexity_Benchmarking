//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P03 Benchmarking - Compares the runtime of two methods
//								and prints the values to a file
// Course:   CS 300 Fall 2020
//
// Author:   Dylan Krejci
// Email:    dkrejci@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         N/A
// Online Sources:  N/A
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Benchmarker {
  
  /**
   * Compares the run time for bruteForce and constantTime on a given number
   * 
   * @param n: value inputed to each method to be compared
   * @return String of formatted data displaying the number n, 
   * 	the run time for bruteForce, and the run time for constantTime
   * @throws NoSuchElementException: if the return values of bruteForce and constantTime are not equal, this is thrown
   */
  public static String compare(long n) throws NoSuchElementException, IOException {
	  
	// If n is out of range (negative, greater than maximum allowed value for long), an IOException will be caught  
	if (n < 0 || n > Math.pow(2, 63) - 1) {
	  System.out.println("IOException in compare();"
			  		   + "invalid input for n");
	throw new IOException();
	}
	
	// Checks that the return values of each method are equal. If not, NoSuchElementException is thrown
	if (ComparisonMethods.bruteForce(n) != ComparisonMethods.constantTime(n)) {
      System.out.println("NoSuchElementException in compare();"
    		  		   + "Output for bruteForce(n) does not equal output for constantTime(n)");
	  throw new NoSuchElementException();
	}
	
	// Calls bruteForce and determines run time by subtracting the method's start time from its end time
	long a = System.currentTimeMillis();
	ComparisonMethods.bruteForce(n);  
	long b = System.currentTimeMillis();
	long bruteForceDuration = b - a;
	
	// Calls constantTime and determines run time by subtracting the method's start time from its end time
	long c = System.currentTimeMillis();
	ComparisonMethods.constantTime(n);
	long d = System.currentTimeMillis();
	long constantTimeDuration = d - c;	
	
	// Formats the data into a readable String
	String formattedData = String.format("%-10d",n) + "\t" + bruteForceDuration + "\t" + constantTimeDuration + "\n";
	System.out.println(formattedData);
	return formattedData;
  }
  
  /**
   * Prints data gathered from compare() to a file
   * 
   * @param f File: passed into a new FileWriter, where data will be written
   * @param queryNs: Array of long values that will be passed to compare()
   * @throws NoSuchElementException: Thrown if return value of bruteForce and constantTime are not equal
   * @throws IOException: Thrown if values passed to method are invalid (n is negative, too large, etc)
   */
  public static void createResultsFile(File f, long[] queryNs) throws NoSuchElementException, IOException {
	FileWriter results = new FileWriter(f);
	results.write(String.format("%-10s", "Number") + "\tBrute Force\tConstant");
	try {
	  for (int i = 0; i < queryNs.length; i++) {
	    results.write(compare(queryNs[i]));
	  }
	  results.close();
	} catch (IOException e1) {
      System.out.println("IOException in createResultsFile();"
		  		       + "invalid input for n");
	} catch (NoSuchElementException e2) {
	  System.out.println("NoSuchElementException in createResultsFile(); "
	  		           + "bruteForce(n) and constantTime(n) did not yield same results");
	} 
  }

  /**
   * Main method
   * 
   * @param args
   * @throws NoSuchElementException: Thrown if return value of bruteForce and constantTime are not equal
   * @throws IOException: Thrown if values passed to method are invalid (n is negative, too large, etc)
   */
  public static void main(String[] args) throws NoSuchElementException, IOException {

	System.out.println(String.format("%-10s", "Number") + "\tBF\tCnst");
	File test = new File("values.png");
	long[] vals = {9, 999, 99999, 9999999, 999999999};
	createResultsFile(test, vals);
  }

}
