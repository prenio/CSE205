
//Assignment #8a: ASU Fall 2020 #8
//Name: Pierce Renio
// StudentID:1214793827
// Lecture: MWF 9:40 - 10:30
//Description:

import java.io.Serializable;

public class Address implements Serializable
{
	//private instance variables
	private String street, city, state;

	//constructor
	public Address(String street, String city, String state)
	{
		this.street = street;
		this.city = city;
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	//returns
	public String getCity() {
		return city;
	}

	//returns
	public String getState() {
		return state;
	}

	//sets street to the specified string
	public void setStreet(String a) {
		street = a;
	}

	//sets city to the specified string
	public void setCity(String a) {
		city = a;
	}

	//sets state to the specified string
	public void setState(String a) {
		state = a;
	}

	//return a string in the specified format
	public String toString() {
		return street + ", " + city + ", " + state;
	}
}
