// Assignment #: 1
//         Name: Pierce Renio	
//    StudentID: 1214793827
//      Lecture: Your Lecture Time: MWF 9:40-10:30am
//  Description: (1)This class reads an integer from a keyboard and prints it out
//               along with other messages.
//				 (2)The purpose of this assignment is let you be familiar with the assignments submission
//				 server. Make sure to modify the original program in such a way that your outputs match
//				 exactly the outputs we provided!

import java.util.Scanner;  // use the Scanner class located in the "java.util" directory
import java.io.*;

public class Assignment1 {
	
  public static void main (String[] args) {
	  
	  try {
		  System.setIn(new FileInputStream("./test/input2.txt"));
	  }catch(IOException e) {
		  e.printStackTrace();
	  }

     int number;

     Scanner console = new Scanner(System.in);

     number = console.nextInt();     // read an integer entered by a user

    // display the number with other messages
    System.out.print("This program reads an integer from a keyboard,\n"
                   + "and prints it out on the display screen.\n"
                   + "The number is " + number + ".\n"
                   + "Make sure that you get the exact same output as the expected one." + "\n");
    console.close();
  }
}