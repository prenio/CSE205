
//Assignment #8: ASU Fall 2020 #8
//Name:Pierce Renio
// StudentID:1214793827
// Lecture: MWF 9:40 - 10:30
//Description: //Description: Returns an integer based on if one of the two Company objects has a name that proceeds it in alphabetical order.

import java.util.Comparator;

public class CompanyNameComparator implements Comparator<Company> {

	public int compare(Company first, Company second) {
		return first.getCompanyName().compareTo(second.getCompanyName());
	}
}
