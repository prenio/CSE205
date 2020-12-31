//The OrderParser class; never instantiated
public class OrderParser {
	
	public static Order parseStringToAnOrder(String lineToParse) {
		String line = lineToParse;
		String[] tokens = line.split("[/]");
		
		//Creating a boolean variable in case it is a NewOrder object
		boolean status = false;
		String word = tokens[5].toLowerCase();
		if (word.equals("yes")){
			status = true;
		}
		else{
			status = false;
		}

		//Checking the 0th element in the array for the type of object
		if (tokens[0].equals("New")) {
			return new NewOrder(tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]), tokens[4], status);
		}
		else if(tokens[0].equals("Cancelled")) {
			return new CancelledOrder(tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]), tokens[4], tokens[5]);
		}
		else if(tokens[0].equals("Shipped")) {
			return new ShippedOrder(tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]), tokens[4], tokens[5]);
		}
		else {
			return new NewOrder(tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]), tokens[4], status);
		}
	}

}
