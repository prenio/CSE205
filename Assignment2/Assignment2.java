// Assignment #: 1
//         Name: Pierce Renio	
//    StudentID: 1214793827
//      Lecture: Your Lecture Time: MWF 9:40-10:30am
//  Description: (1)This class reads in an unspecified number of integers from standard input
//					performs some calculations on the input numbers, and outputs the results 
//					of those calculations to standard output. 

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;  // use the Scanner class located in the "java.util" directory

public class Assignment2 {

	
	
	  public static void main (String[] args) {
		  int largest;
		  int negative_count = 0;
		  int largest_even = 0;
		  int sum = 0;
		  int number;
		  
		  try {
			  System.setIn(new FileInputStream("./test/input3.txt"));
		  }catch(IOException e) {
			  e.printStackTrace();
		  }


	     Scanner console = new Scanner(System.in);
	     
	     number = console.nextInt();     // read an integer entered by a user
	     largest = number;
	     
	     while (number != 0) {          //will perform these conditional statements on every number
	    	 if (number > largest) {
	    		 largest = number;
	    	 }
	    	 
	    	 if (number < 0) {
	    		 negative_count++;
	    	 }
	    	 
	    	 if ((number % 2 == 0) && (number > largest_even)) {
	    		 largest_even = number;
	    	 }
	    	 
	    	 if (number % 3 == 0) {
	    		 sum += number;
	    	 }
	    	 
	    	 number = console.nextInt(); 
	     }
	     
	     
	     
	     

	    // display the number with other messages
	    System.out.println("The largest integer is " + largest );
	    System.out.println("The number of negative integers in the sequence is " + negative_count);
	    System.out.println("The largest even integer in the sequence is " + largest_even);
	    System.out.println("The sum of numbers divisible by 3 is " + sum);
	    console.close();
	  }
	}