//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P03 Benchmarking - ComparisonMethods; Two methods for finding the 
//			 sum of all integers from 1 to n, each with a different runtime
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

public class ComparisonMethods {
  /**
   * 
   * @param n: value the method will calculate sum of, from 1 to n
   * @return total sum of the values
   */
  public static long bruteForce(long n) {

	long total = 0;
	// Loops through every value from 1 to n, creating a cumulative sum
	for (int i = 1; i <= n; i++) {
	  total = total + i;
	}
	return total;
  }
  
  /**
   * 
   * @param n: value the method will calculate sum of, from 1 to n
   * @return total sum of the values
   */
  public static long constantTime(long n) {
	
	// Instead of using a loop, this formula automatically calculates the sum from 1 to n in a single step
	long total = ((n*n) + n)/2;
	return total;
  }
}
