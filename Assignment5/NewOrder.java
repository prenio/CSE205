//NewOrder class that extends the Order class
import java.text.DecimalFormat;

public class NewOrder extends Order{
	DecimalFormat dF = new DecimalFormat("$0.00");
	private String salesName;
	private boolean refundableStatus;
	
	//Constructor that uses Super
	public NewOrder(String name, int quantity, double cost, String salesName, boolean status) {
		 super(name, quantity, cost);
		 this.salesName = salesName;
		 refundableStatus = status;
	}
	
	//Method to compute total cost
	public void computeTotalCost() {
		totalCost = unitPrice*quantity*1.086;
		if (refundableStatus) {
			totalCost = totalCost*1.02;
		}
	}
		
	//toString method
		public String toString() {
			return ("\nNew Order" + "\nProd. Name:\t\t" + getProductName() + "\nQuantity:\t\t" 
										+ Integer.toString(quantity)
										+ "\nUnit Price:\t\t" 
										+ dF.format(unitPrice) 
										+ "\nTotal Cost:\t\t" 
										+ dF.format(totalCost) 
										+ "\nSales Name:\t\t" + salesName 
										+ "\nRefund Status:\t\t" + Boolean.toString(refundableStatus));
		}
		
	}
	
	//toString() + 