//Assignment #8: ASU Fall 2020 #8
//Name: Pierce Renio
// StudentID:1214793827
// Lecture: MWF 9:40 - 10:30
//Description: Returns an integer based on if one of the two Company objects has an address that proceeds it in alphabetical order.

import java.util.Comparator;

public class CompanyAddressComparator implements Comparator<Company>
{
	//First we compare the state info., if they are same, we then compare their city info.
	//If the two company addresses have the same state AND city info. then we should compare
	//their street info. The companies should be listed in the alphabetical order of their addresses!
	
	private int check;
	private Address add1;
	private Address add2;
	
	public int compare(Company first, Company second)
	{
		add1 = first.getAddress();
		add2 = second.getAddress();
		
		check = add1.getState().toLowerCase().compareTo(add2.getState().toLowerCase());

		if (check == 0) {
			check = add1.getCity().toLowerCase().compareTo(add2.getCity().toLowerCase());
			if (check == 0) {
				check = add1.getStreet().toLowerCase().compareTo(add2.getStreet().toLowerCase());
			}
		}
		return check;
	}
}
