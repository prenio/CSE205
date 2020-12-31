
//Assignment #8: ASU Fall 2020 #8
//Name:Pierce Renio
// StudentID:1214793827
// Lecture: MWF 9:40 - 10:30
//Description:

import java.io.Serializable;

public class Company implements Serializable
{
	//private instance variables accessed by only methods of this class
	private String name, nameOfCEO;
	private int numOfEmployees;
	private Address address;

	//constructor
	public Company( String companyName, int numOfEmployees, String nameOfCEO,
					String street, String city, String state)
	{
		name = companyName;
		this.nameOfCEO = nameOfCEO;
		this.numOfEmployees = numOfEmployees;
		address = new Address(street, city, state);
	}

	public String getCompanyName() {
		return name;
	}

	public int getNumOfEmployees() {
		return numOfEmployees;
	}

	//return nameOfCEO
	public String getNameOfCEO() {
		return nameOfCEO;
	}

	public Address getAddress() {
		return address;
	}

	public void setCompanyName(String a) {
		name = a;
	}

	public void setNumOfEmployees(int a) {
		numOfEmployees = a;
	}

	public void setNameOfCEO(String a) {
		nameOfCEO = a;
	}

	public void setAddress(String street, String city, String state) {
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
	}

	//return a string in a specified format
	public String toString() {
		return "\nCompany Name:\t\t" + name + "\n"
				+ "# of Employees:\t\t" + numOfEmployees + "\n" +
				"Name of CEO:\t\t" + nameOfCEO + "\n"
				+ "Address:\t\t\t" + address.toString() + "\n";
	}
}
