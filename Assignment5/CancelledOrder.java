//CancelledOrder method that extends the Order class

import java.text.DecimalFormat;

public class CancelledOrder extends Order {
	DecimalFormat dF = new DecimalFormat("$0.00");
	private String cancelledDate;
	private String cancelledReason;
	
	//Constructor method that uses super
	public CancelledOrder(String name, int quantity, double price, String date, String reason) {
		super(name, quantity, price);
		cancelledDate = date;
		cancelledReason = reason;
		
	}
	
	
	//toString method
	public String toString() {
		return ("\nCancelled Order" + "\nProd. Name:\t\t" + getProductName() + "\nQuantity:\t\t" + Integer.toString(quantity)
									+ "\nUnit Price:\t\t" + dF.format(unitPrice) + "\nTotal Cost:\t\t" 
									+ dF.format(totalCost) + "\nCancel Date:\t\t" + cancelledDate 
									+ "\nCancel Reason:\t\t" + cancelledReason);
		
	}
	
	
	//Cancellation fee 
	public void computeTotalCost() {
		totalCost = unitPrice*quantity*0.02;
	}
	
}
