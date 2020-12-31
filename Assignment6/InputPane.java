// Assignment #: Arizona State University CSE205 #6
//         Name: Pierce Renio
//    StudentID: 1214793827
//      Lecture: MWF 9:40 AM
//  Description: InputPane generates a pane where a user can enter
//  a new order information and create a list of available Orders.
//  //---- is where you need to add your own codes

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import java.text.NumberFormat;


//import all other necessary javafx classes here
//----

public class InputPane extends HBox
{
    //components
    ArrayList < Order > orderList;

    //The relationship between InputPane and HandlePane is Aggregation
    private HandlePane handlePane;

    //declare other necessary GUI components and variables here
    private TextField nameText;
    private TextField quantityText;
    private TextField priceText;
    private Label orderStatus;
    private TextArea orderArea;

    //constructor
    public InputPane(ArrayList < Order > list, HandlePane pane)
    {
        this.orderList = list;
        this.handlePane = pane;

        //initialize each instance variable (textfields, labels, textarea, button, etc.)
        //and set up the layout
        orderStatus = new Label("");
        
        Label nameLabel = new Label("Prod. Name");
        nameText = new TextField("");
        
        Label quantityLabel = new Label("Quantity");
        quantityText = new TextField("");
        
        Label priceLabel = new Label("Price($)");
        priceText = new TextField("");
        
        Button place = new Button("Place an Order");
        ButtonHandler addOrder = new ButtonHandler();
        place.setOnAction(addOrder);
        
        //create a GridPane hold the labels & text fields.
        //you can choose to use setPadding() or setHgap(), setVgap()
        //to control the spacing and gap, etc.
        //----
        GridPane leftGrid = new GridPane();
        leftGrid.setPadding(new Insets(10,10,10,10));
        leftGrid.setVgap(8);
        leftGrid.setHgap(10);

        //Set up the layout for the left half of the InputPane
        //----
        leftGrid.add(orderStatus, 1, 0);
        leftGrid.add(nameLabel, 0, 1);
        leftGrid.add(nameText, 1, 1);
        leftGrid.add(quantityLabel, 0, 2);
        leftGrid.add(quantityText, 1, 2);
        leftGrid.add(priceLabel, 0, 3);
        leftGrid.add(priceText, 1, 3);
        leftGrid.add(place, 1, 4);

        

        //the right half of the InputPane is simply a TextArea object
        //Note: a ScrollPane will be added automatically when there are no
        //enough space
        orderArea = new TextArea("No orders");
        orderArea.setMaxWidth(330);
         
        //Add the left half and right half to the InputPane
        //Note: InputPane extends from HBox
        this.getChildren().addAll(leftGrid, orderArea);
        //register source object with event handler

        

    } //end of constructor

    //Step 2: Create a ButtonHandler class
    //ButtonHandler listen to see if the button "Place an order" is pushed or not,
    //When the event occurs, it get an order's product name, quantiy, unit price
    //from the relevant text fields, then create a new Order object and add it inside
    //the orderList. Meanwhile it will display the order's total cost and other info. inside the text area.
    //It also does error checking in case any of the textfields are empty
    private class ButtonHandler implements EventHandler < ActionEvent >
    {
        //Override the abstact method handle()
        public void handle(ActionEvent e)
        {

            //when one text field is empty and the button is pushed
            //display msg "Please fill all fields"
            if (nameText.getText().equals("") || quantityText.getText().equals("") || priceText.getText().equals(""))
                    {
                       orderStatus.setText("Please fill all fields");

                    }
			else
            {	


                //when a non-numeric value was entered for quantity or price
                //and the button is pushed
                //you will need to use try & catch block to catch
                //the NumberFormatException
                try {
                	Order orderCheck = new Order(nameText.getText(), Integer.parseInt(quantityText.getText()), Double.parseDouble(priceText.getText()));
                }
                catch (NumberFormatException e1) {
                	orderStatus.setText("Incorrect data format");
                	return;
                }

                //When a duplicated order was attempted to be added, do not
                //add it to the list. Instead displaying msg "Order not added - duplicate"
                Order tempOrder = new Order(nameText.getText(), Integer.parseInt(quantityText.getText()), Double.parseDouble(priceText.getText()));
                for (int i = 0; i < orderList.size(); i++) {
                	if (isEqual(tempOrder, orderList.get(i))) {
                		orderStatus.setText("Order not added - duplicate");
                		return;
                	}
                }
                //When everything is correct, create a new Order object and
                //add it inside orderList
                orderList.add(new Order(nameText.getText(), Integer.parseInt(quantityText.getText()), Double.parseDouble(priceText.getText())));
                if (orderArea.getText().equals("No orders")){
                	orderArea.setText("");
                }
                
                //Next, don't forget to update the new arrayList information
                //on the ListView of the handlePane
                orderArea.appendText(tempOrder.toString());
                HandlePane.updateOrderList(tempOrder);
  
               
            }
        } 
        //end of handle() method
        public boolean isEqual(Order order1, Order order2) {
        	boolean check1 = false;
        	boolean check2 = false;
        	boolean check3 = false;
        	boolean finalCheck = false;
        	
        	if (order1.getProductName().equals(order2.getProductName())) {
        		check1 = true;
        	}
        	if (order1.getQuantity() == order2.getQuantity()) {
        		check2 = true;
        	}
        	if (order1.getUnitPrice() == order2.getUnitPrice()) {
        		check3 = true;
        	}
        	if (check1 && check2  && check3) {
        		finalCheck = true;
        	}
        	return finalCheck;
        }
    }//end of ButtonHandler class
}