
public class Address {
	
	//Private variables for this class
	private String street;
	private String city;
	private String state;

	//Constructor
	public Address() {
		street = "?";
		city = "?";
		state = "?";
	}	
	
	
	//"Get" methods

	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	//"Set" methods
	
	public void setStreet(String newStreet) {
		street = newStreet;
	}
	
	public void setCity(String newCity) {
		city = newCity;
	}
	
	public void setState(String newState) {
		state = newState;
	}
	
	
	//toString method
	public String toString() {
		return (street + ", " + city + ", " + state);
	}
	
	
	
	
}
