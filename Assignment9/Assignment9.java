// Assignment #: ASU CSE205 Fall #9
//         Name: Pierce Renio
// StudentID:1214793827
// Lecture: MWF 9:40 - 10:30
//  Description: this program reads in a sequence of numbers from standard
//  input until 0 is read and stores the numbers in an array, it then
//  compute the maximum number, the total sum of even numbers (includes both postive and negative),
//  the number of -1 inside the array, and compute the sum of numbers at odd indexes
//  (i.e. 1, 3, 5, ...), using recursion.

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment9
{
	//Creating scanner 
	static Scanner scan = new Scanner(System.in);
	
	//Initailizing variables
	private static int num;
	private static int index;
	static int[] numList;
	
/******************************************************************************
  ***Complete the main() method. See program description for details.
******************************************************************************/
  public static void main (String[] args) throws IOException
  {
	  numList = new int[100];
	  index = 0;
	  do{
		  num = scan.nextInt();
		  if (num == 0)
			  break;
		  numList[index] = num;
		  index++;
	  }
	  while (num != 0);
	  System.out.print("The maximum number is " + findMax(numList, 0,index) + "\n");
	  System.out.print("The total sum of all even integers is " + computeEvenSum(numList,0,index) + "\n");
	  System.out.print("The total number of -1 is " + countNegativeOne(numList, 0) + "\n");
	  System.out.print("The sum of numbers at odd indexes is " + computeSumAtOddIndexes(numList, 0) + "\n");
  }

/*************************************************************************************
***(1)Complete the method. The method finds the maximum number in the partial array
***range from startIndex to endIndex
*************************************************************************************/
public static int findMax(int[ ] numbers, int startIndex, int endIndex)
{
	if (startIndex == endIndex) {
		return numbers[startIndex];
	}
	else {
		if (Math.max(numbers[startIndex],numbers[endIndex]) == numbers[startIndex]) {
			return findMax(numbers, startIndex, endIndex-1);
		}
		else {
			return findMax(numbers, startIndex+1,endIndex);
		}
	}
}

/**************************************************************************************
***(2)Complete the method. The method counts the sum of all even integers in the
// partial array range from startIndex to endIndex
*************************************************************************************/
public static int computeEvenSum(int[ ] numbers, int startIndex, int endIndex)
{
	if (startIndex == endIndex) {
		if (numbers[startIndex]%2 == 0) {
			return numbers[startIndex];
		}else {
		return 0;
		}	
	}else {
		if (numbers[startIndex]%2 == 0) {
			return numbers[startIndex] + computeEvenSum(numbers,startIndex+1,endIndex);
		}else {
			 return computeEvenSum(numbers, startIndex+1,endIndex);
		}
	}

}

/*************************************************************************************
***(3)Complete the method. The method counts the number of -1 inside an array with
***   "count" numbers, index ranges from 0 to count-1
*************************************************************************************/
public static int countNegativeOne(int[ ] numbers, int count)
{
	if (numbers.length == 0) {
		return count;
	}
	if (numbers[0] == -1) {
		return countNegativeOne(Arrays.copyOfRange(numbers,1,numbers.length), count+1);
	}
	else {
		return countNegativeOne(Arrays.copyOfRange(numbers,1,numbers.length), count);
	}
}


/**************************************************************************************
***(4)Complete the method. The method computes the sum of numbers at index 1, 3, 5, ...
***  inside a partial array with "count" numbers, index ranges from 0 to count-1
***************************************************************************************/
public static int computeSumAtOddIndexes(int[ ] numbers, int count)
{
	if (numbers.length == 0) {
		return 0;
	}
	if (count == 0) {
		return computeSumAtOddIndexes(Arrays.copyOfRange(numbers,1,numbers.length), 1);
	}
	else {
		return numbers[0] + computeSumAtOddIndexes(Arrays.copyOfRange(numbers,1,numbers.length), 0);
	}
}
}// end of class Assignment9