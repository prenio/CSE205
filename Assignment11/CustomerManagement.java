// Assignment #: ASU CSE205 Fall 2020 #11
// Name: Pierce Renio
// StudentID:1214793827
// Lecture: MWF 9:40 - 10:30
// Description: This program manages customer queues, assigns customer to loan officer,
//              process and release them, etc.
//              //---- is where you should add your own code

import java.util.LinkedList;

public class CustomerManagement
{
   private LinkedList<Customer> LEQueue;
   private LinkedList<Customer> MEQueue;
   private LinkedList<Customer> SEQueue;

   private LinkedList<Customer> checkoutQueue;

   private LoanOfficer[] officerList;

   //**********************************************
   //Constructor
   public CustomerManagement(int numOfLoanOfficers)
   {
      LEQueue = new LinkedList<Customer>();
      MEQueue = new LinkedList<Customer>();
      SEQueue = new LinkedList<Customer>();
      checkoutQueue = new LinkedList<Customer>();

      //creating LoanOfficer objects
      officerList = new LoanOfficer[numOfLoanOfficers];
      for (int i=0; i< officerList.length; i++)
      {
         officerList[i] = new LoanOfficer(i);
      }
   }

   //*******************************************************************
   //add a customer to the corresponding queue based on its category
   //return true if added to a queue successfully; otherwise return false
   boolean addCustomer(int id, String category)
   {
      if (category.equals("LE")) {
    	  LEQueue.add(new Customer(id, category));
    	  return true;
      }else if (category.equals("ME")) {
    	  MEQueue.add(new Customer(id, category));
    	  return true;
      }else if (category.equals("SE")) {
    	  SEQueue.add(new Customer(id, category));
    	  return true;
      }
      return false;
      }
   //*******************************************************************
   //assign a customer to a loan officer with large enterprise (LE) queues
   //going first; return null if there are no customers in the queues or if
   //there are no loan officer are available
   public Customer assignCustomerToLoanOfficer()
   {
	  boolean available = false;
	  int officer = 0;
	  for (int i = 0; i < officerList.length;i++)
		  if (!officerList[i].hasCustomer()) {
			  officer = i;
			  available = true;
			  break;
		  }
	  if (!available)
		  return null;
      if (LEQueue.peek() != null) {
    	  Customer temp = LEQueue.poll();
    	  officerList[officer].assignCustomer(temp);
    	  return temp;
      }else if (MEQueue.peek() != null) {
    	  Customer temp = MEQueue.poll();
    	  officerList[officer].assignCustomer(temp);
    	  return temp;
      }else if (SEQueue.peek() != null) {
    	  Customer temp = SEQueue.poll();
    	  officerList[officer].assignCustomer(temp);
    	  return temp;
      }
      return null;
   }

   //***************************************************************
   //check if officer with the officerID has a customer, and release
   //that customer if they do. Then add that customer to checkout queue
   //and return the Customer object; otherwise return null
   Customer releaseCustomerFromOfficer(int officerID)
   {
      if (officerList[officerID].hasCustomer()) {
    	  Customer releasedCustomer = officerList[officerID].handleCustomer();
    	  checkoutQueue.add(releasedCustomer);
    	  return releasedCustomer;
      }
      return null;
   }

   //**************************************************************
   //remove the first Customer from the checkoutQueue and return it;
   //otherwise the method return null.
   public Customer checkoutCustomer()
   {
      if (checkoutQueue.peek() != null)
    	  return checkoutQueue.poll();
      return null;
   }

   //************************************************
   //The printQueue prints out the content
   //of the queues and the array of loan officers
   public void printQueues()
   {
      System.out.print("\nLarge Enterprise Queue:\n" + LEQueue.toString() + "\n");
      System.out.print("\nMedium Enterprise Queue:\n" + MEQueue.toString() + "\n");
      System.out.print("\nSmall Enterprise Queue:\n" + SEQueue.toString() + "\n\n");
      for (int i = 0; i < officerList.length; i++)
      {
         System.out.print(officerList[i].toString());
      }
      System.out.print("\nCheckout Customer Queue:\n" + checkoutQueue.toString() + "\n\n");
   }}