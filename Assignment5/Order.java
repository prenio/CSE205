//Order class

import java.text.DecimalFormat;

public abstract class Order {
	DecimalFormat dF = new DecimalFormat("#.00");
	
	protected String productName;
	protected int quantity;
	protected double unitPrice;
	protected double totalCost;
	
	//Constructor method
	public Order(){
		productName = "?";
		quantity = 0;
		unitPrice = 0.0;
		totalCost = 0.0;
		
	}
	
	//Overloaded constructor method
	public Order(String name, int quantity, double price) {

		productName = name;
		this.quantity = quantity;
		unitPrice = price;
		totalCost = 0.0;
	}
	
	//"Get" method
	public String getProductName() {
		return productName;
	}
	
	
	//toString method
	public String toString() {
		return ("\nProd. Name:\t\t" + getProductName() + "\nQuantity:\t\t" + Integer.toString(quantity)
									+ "\nUnit Price:\t\t$" + dF.format(Double.toString(unitPrice)) + "\nTotal Cost:\t\t$" 
									+ dF.format(Double.toString(totalCost)));
	}

	public abstract void computeTotalCost();

}
