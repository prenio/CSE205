
//Assignment #: ASU Fall 2020 #8
//Name: Pierce Renio
// StudentID:1214793827
// Lecture: MWF 9:40 - 10:30
//Description: //Creates a CompanyManagement object to manage the companyList ArrayList<Company>.

//import all necessary classes and interfaces
//----
import java.io.Serializable;
import java.util.ArrayList;

public class CompanyManagement implements Serializable
{
	private Company comp;
	ArrayList<Company> companyList;

	public CompanyManagement() {
		companyList = new ArrayList<Company>();
	}
	

	public int companyExists(String companyName, String companyAddress) {
		for (int i = 0; i < companyList.size(); i++) {
			if (companyName.equals(companyList.get(i).getCompanyName())) {
				if (companyAddress.equals(companyList.get(i).getAddress().toString())) {
					return i;
				}
			} 
		}
		return -1;
	}

	public int addressExists(String street, String city, String state) {
		for (int i = 0; i < companyList.size(); i++) {
			if (street.equals(companyList.get(i).getAddress().getStreet())) {
				if (city.equals(companyList.get(i).getAddress().getCity())) {
					if (state.equals(companyList.get(i).getAddress().getState())) {
						return i;
					}
				}
			}
		}
		return -1;
	}

	public boolean addCompany(String companyName, int numOfEmployees, String nameOfCEO, String street, String city, String state) {
		comp = new Company(companyName, numOfEmployees, nameOfCEO, street, city, state);
		for (int i = 0; i < companyList.size(); i++) {
			if (comp.getCompanyName().equals(companyList.get(i).getCompanyName())) {
				if (comp.getAddress().toString().equals(companyList.get(i).getAddress().toString())) {
					return false;
				}
			} 
		}
		companyList.add(comp);
		return true;
	}

	public boolean removeCompany(String companyName, String companyAddress) {
		for (int i = 0; i < companyList.size(); i++) {
			if (companyName.equals(companyList.get(i).getCompanyName())) {
				if (companyAddress.equals(companyList.get(i).getAddress().toString())) {
					companyList.remove(i);
					return true;
				}
			} 
		}
		return false;
	}

	public void sortByCompanyName() {
		Sorts.sort(companyList, new CompanyNameComparator());
	}

	public void sortByEmployeeNumbers() {
		Sorts.sort(companyList, new EmployeeNumberComparator());
	}

	public void sortByCompanyAddress() {
		Sorts.sort(companyList, new CompanyAddressComparator());
	}

	public String listCompanys() {
		String str = "\n";
		if (companyList.size() == 0) {
			System.out.print("\nNo company\n\n");
		}
		for (Company company: companyList) {
		str += company.toString();
		}
		return (str +"\n");
	} 

	public void closeCompanyManagement() {
		companyList.clear();
	}
}