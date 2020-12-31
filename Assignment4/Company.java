
public class Company {

	//private variables for this class
	private String name;
	private int numOfEmployees;
	private String nameOfCEO;
	private Address address;
	
	
	//Constructor method
	public Company() {
		name = "?";
		numOfEmployees = 0;
		nameOfCEO = "?";
		
		address = new Address();
	}
	
	//"Get" methods
	public String getCompanyName() {
		return name;
	}
	
	public int getNumOfEmployees() {
		return numOfEmployees;
	}
	
	public String getNameOfCEO() {
		return nameOfCEO;
	}
	
	public Address getAddress() {
		return address;
	}
	
	
	//"Set" methods
	public void setCompanyName(String name) {
		this.name = name;
	}
	
	public void setNumOfEmployees (int num) {
		numOfEmployees = num;
	}
	
	public void setNameOfCEO (String name) {
		nameOfCEO = name;
	}
	
	public void setAddress (String newStreet, String newCity, String newState) {
		address.setStreet(newStreet);
		address.setCity(newCity);
		address.setState(newState);
	}
	
	
	//toString method
	public String toString() {
		String partOne = ("\nCompany Name:\t\t" + getCompanyName());
		String partThree = ("\n# of Employees:\t\t" + getNumOfEmployees());
		String partFour = ("\nName of CEO:\t\t" + getNameOfCEO());
		String partFive = ("\nAddress:\t\t" + getAddress() +"\n\n");
		return(partOne + partThree + partFour + partFive);
	}
	
	
}
