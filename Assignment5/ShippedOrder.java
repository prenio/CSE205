//The ShippedOrder class which extends the Order class

import java.text.DecimalFormat;

public class ShippedOrder extends Order {
	DecimalFormat dF = new DecimalFormat("$0.00");
	private String shippingAddress;
	private String wayOfShipping;
	private double shippingFee;
	//Constructor method
	public ShippedOrder(String name, int quantity, double price, String address, String way) {
		super(name, quantity, price);
		shippingAddress = address;
		wayOfShipping = way;
		shippingFee = 0.00;
		
	}

	public void setShippingFee() {
		if(wayOfShipping.equals("Economy")) {
			shippingFee = 0.06;
		} 
		else if (wayOfShipping.equals("Regular")) {
			shippingFee = 0.08;
		}
		else if (wayOfShipping.equals("Express")) {
			shippingFee = 0.12;
		}
	}
	
	
	
	
	//toString method
	public String toString() {
		return ("\nShipped Order" + "\nProd. Name:\t\t" + getProductName() + "\nQuantity:\t\t" + Integer.toString(quantity)
									+ "\nUnit Price:\t\t" + dF.format(unitPrice) + "\nTotal Cost:\t\t" 
									+ dF.format(totalCost) + "\nShipping Adrs.:\t\t" + shippingAddress 
									+ "\nShipping Way:\t\t" + wayOfShipping
									+ "\nShipping Fee:\t\t" + dF.format(shippingFee));
	}

	
	
	public void computeTotalCost() {
			totalCost = unitPrice*quantity;
			setShippingFee();
			shippingFee = totalCost * shippingFee;
			totalCost = totalCost + shippingFee;
		}
	
	}
