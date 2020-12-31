
//Assignment #: ASU Fall 2020 #8
//Name: Pierce Renio
// StudentID:1214793827
// Lecture: MWF 9:40 - 10:30
//Description: A utility class to sort a list of Company objects based on different criterias.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Sorts {
	
	public static void sort(ArrayList<Company> companyList, Comparator<Company> xComparator) {
		//count = 0;
		//while (count < companyList.size()) {
		//	min = companyList.get(count);
		//	for (int i = 0; i < (companyList.size()-count) ;i++) {
		//	if (xComparator.compare(min,companyList.get(i)) > 0) {
		//			min = companyList.get(i);					
		//		}
		//	}
		//	companyList.remove(min);
		//	companyList.add(count, min);
		//	count++;

		if (companyList.size() == 1)
			return;
		for (int i = 0; i < companyList.size()-1; i++) {
			for (int j = i+1; j < companyList.size(); j++) {
				if (xComparator.compare(companyList.get(i),companyList.get(j)) > 0) {
					Collections.swap(companyList, i, j);
			}
			}
		}
	}
}
