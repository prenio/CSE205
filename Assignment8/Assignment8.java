// Assignment #8: ASU Fall 2020 #8
//Name:Pierce Renio
// StudentID:1214793827
// Lecture: MWF 9:40 - 10:30
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered. //--- is where you need to add your own code.

import java.io.*;
import java.util.Scanner;

public class Assignment8
{
	public static void main(String[] args)
	{
		char input1;
		String companyName, numOfEmployeesStr, nameOfCEO;
		String street, city, state;
		String address;
		int numOfEmployees;

		boolean operation = false;
		int operation2 = 0;
		String line;
		String filename;

		// create a CompanyManagement object. This is used throughout this class.
		CompanyManagement companyManage1 = new CompanyManagement();

		File file;

		try {
			// print out the menu
			printMenu();

			// create a BufferedReader object to read input from a keyboard
			InputStreamReader isr = new InputStreamReader(System. in );
			BufferedReader stdin = new BufferedReader(isr);

			do {
				System.out.print("\nWhat action would you like to perform?\n");
				line = stdin.readLine().trim(); //read a line
				input1 = line.charAt(0);
				input1 = Character.toUpperCase(input1);

				if (line.length() == 1) //check if a user entered only one character
				{
					switch (input1) {
					case 'A':
						//Add Company
						System.out.print("Please enter the company information:\n");
						System.out.print("Enter its name:\n");
						companyName = stdin.readLine().trim();
						System.out.print("Enter its number of employees:\n");
						numOfEmployeesStr = stdin.readLine().trim();
						numOfEmployees = Integer.parseInt(numOfEmployeesStr);
						System.out.print("Enter its CEO name:\n");
						nameOfCEO = stdin.readLine().trim();
						System.out.print("Enter its street info.:\n");
						street = stdin.readLine().trim();
						System.out.print("Enter its city info.:\n");
						city = stdin.readLine().trim();
						System.out.print("Enter its state info.:\n");
						state = stdin.readLine().trim();
/************************************************************************************
***  Complete the follwing statement, if the company is added successfully, show
"Company added\n" on screen, otherwise show "Company NOT added\n"
***********************************************************************************/
						if(companyManage1.addCompany(companyName, numOfEmployees, nameOfCEO, street, city, state)) {
							System.out.print("Company added\n");
						} else {
							System.out.print("Company NOT added\n");
						}
						break;
						
					case 'C':
						//Create a new company management
						    companyManage1 = new CompanyManagement();
						break;

					case 'D':
						//Search by company name and address
						System.out.print("Please enter the company name to search:\n");
						companyName = stdin.readLine().trim();
						System.out.print("Please enter the company address to search:\n");
						address = stdin.readLine().trim();
/************************************************************************************
***  Complete the follwing statement, if the company with above name and address is found
show companyName + " at " + address + " is found\n"; otherwise show
companyName + " at " + address + " is NOT found\n"
***********************************************************************************/
						if (companyManage1.companyExists(companyName, address) >= 0) {
							System.out.print(companyName + " at " + address + " is found\n");
						} else {
							System.out.print(companyName + " at " + address + " is NOT found\n");
						}
						break;
						   
					case 'E':
						//Search by address
						System.out.print("Please enter the street info. to search:\n");
						street = stdin.readLine().trim();
						System.out.print("Please enter the city info. to search:\n");
						city = stdin.readLine().trim();
						System.out.print("Please enter the state info. to search:\n");
						state = stdin.readLine().trim();
/************************************************************************************
***  Complete the follwing statement, if the company with above street, city, state info. is found
show "Address: " + street + ", " + city + ", " + state + " is found\n"; otherwise show
"Address: " + street + ", " + city + ", " + state + " is NOT found\n"
***********************************************************************************/
						if (companyManage1.addressExists(street, city, state) >= 0) {
							System.out.print("Address: " + street + ", " + city + ", " + state + " is found\n");
						} else {
							System.out.print("Address: " + street + ", " + city + ", " + state + " is NOT found\n");
						}
						break;

					case 'L':
						//List companys
						System.out.print(companyManage1.listCompanys());
						break;

					case 'N':
/************************************************************************************
***  Complete the follwing statement. Sort by company names in alphabetical order
***********************************************************************************/
						companyManage1.sortByCompanyName();
						System.out.print("sorted by company names\n");
						break;

					case 'O':
/************************************************************************************
***  Complete the follwing statement. Sort by employee numbers
***********************************************************************************/
						companyManage1.sortByEmployeeNumbers();
						System.out.print("sorted by employee numbers\n");
						break;
						
					case 'P':
/************************************************************************************
***  Complete the follwing statement. Sort by company addresses
***********************************************************************************/
						companyManage1.sortByCompanyAddress();
						System.out.print("sorted by company addresses\n");
						break;
						
					case 'Q':
						//Quit
						break;
						
					case 'R':
						//Remove a company
						System.out.print("Please enter the company name to remove:\n");
						companyName = stdin.readLine().trim();
						System.out.print("Please enter the company address to remove:\n");
						address = stdin.readLine().trim();
/************************************************************************************
***  Complete the follwing statement, if the company with above name and address is found
remove it and show companyName + " at " + address + " is removed\n"; otherwise show
companyName + " at " + address + " is NOT removed\n"
***********************************************************************************/
						if (companyManage1.removeCompany(companyName, address)) {
							System.out.print(companyName + " at " + address + " is removed\n");
						}else {
							System.out.print(companyName + " at " + address + " is NOT removed\n");
						}
						break;
						
					case 'T':
						//Close CompanyManagement
						companyManage1.closeCompanyManagement();
						System.out.print("Company management system closed\n");
						break;
						
					case 'U':
						//Write Text to a File
						System.out.print("Please enter a file name to write:\n");
						filename = stdin.readLine().trim();
						try {
							file = new File(filename);
							System.out.print("Please enter a string to write inside the file:\n");
							String s = stdin.readLine().trim() + "\n";
/************************************************************************************
***  Complete the follwing statement, write above string inside the relevant file
***********************************************************************************/
							FileWriter  fw = new FileWriter(file);
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(s);
							bw.close();
							System.out.print(filename + " is written\n");
						}
						catch(IOException e)
						{
							System.out.print("Write string inside the file error\n");
						}
						break;
						
					case 'V':
						//Read Text from a File
						System.out.print("Please enter a file name to read from:\n");
						filename = stdin.readLine().trim();
						try {
							file = new File(filename);
/************************************************************************************
***  Complete the follwing statement, read from above text file
***********************************************************************************/
							FileReader fr = new FileReader(file);
							BufferedReader br = new BufferedReader(fr);
							line = br.readLine();
							System.out.print(filename + " was read\n");
							System.out.print("The first line of the file is:\n" + line + "\n");
							br.close();
						}
						catch(FileNotFoundException exception) {
							System.out.print(filename + " not found error\n");
						}
						catch(IOException exception) {
							System.out.print("Read string from the file error\n");
						}
						break;
						
					case 'W':
						//Serialize CompanyManagement to a File
						System.out.print("Please enter a file name to write:\n");
						filename = stdin.readLine().trim();
						try {
/************************************************************************************
***  Complete the follwing statement, write object companyManage1 inside the data file
***********************************************************************************/
							FileOutputStream file1 = new FileOutputStream(filename);
							ObjectOutputStream out = new ObjectOutputStream(file1);
							out.writeObject(companyManage1);
							out.close();
							file1.close();
						}
						catch(NotSerializableException e) {
							System.out.print("Not serializable exception\n");
						}
						catch(IOException ex) {
							System.out.print("Data file written exception\n");
						}
						break;
						
					case 'X':
						//Deserialize CompanyManagement from a File
						System.out.print("Please enter a file name to read from:\n");
						filename = stdin.readLine().trim();
						try {
/************************************************************************************
***  Complete the follwing statement, read object from the data file and save the object
as companyManage1
***********************************************************************************/
							FileInputStream file2 = new FileInputStream(filename);
							ObjectInputStream in = new ObjectInputStream(file2);
							companyManage1 = (CompanyManagement)in.readObject();
							in.close();
							file2.close();
							System.out.print(filename + " was read\n");
						}
						catch(ClassNotFoundException ex) {
							System.out.print("Class not found exception\n");
						}

						catch(NotSerializableException e) {
							System.out.print("Not serializable exception\n");
						}
						catch(IOException exc) {
							System.out.print("Data file read exception\n");
						}
						break;
						
						case '?':
						//Display Menu
						printMenu();
						break;
						
					default:
						System.out.print("Unknown action\n");
						break;
				}
					
		}
				else {
					System.out.print("Unknown action\n");
				}
			} while ( input1 != 'Q' || line . length () != 1);
		}
		catch(IOException exception) {
			System.out.print("IO Exception\n");
		}
	}

		
	/** The method printMenu displays the menu to a user **/
	public static void printMenu() {
		System.out.print("Choice\t\tAction\n" +
						 "------\t\t------\n" +
						 "A\t\tAdd a company\n" +
						 "C\t\tCreate a CompanyManagement\n" +
						 "D\t\tSearch a company\n" +
						 "E\t\tSearch by address\n" +
						 "L\t\tList companies\n" +
						 "N\t\tSort by company names\n" +
						 "O\t\tSort by company employee numbers\n" +
						 "P\t\tSort by company address\n" +
						 "Q\t\tQuit\n" +
						 "R\t\tRemove a company\n" +
						 "T\t\tClose CompanyManagement\n" +
						 "U\t\tWrite strings to a text file\n" +
						 "V\t\tRead strings from a text file\n" +
						 "W\t\tSerialize CompanyManagement to a data file\n" +
						 "X\t\tDeserialize CompanyManagement from a data file\n" +
						 "?\t\tDisplay Help\n");
	}
}