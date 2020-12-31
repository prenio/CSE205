// Assignment #: Arizona State University CSE205 #6
//         Name: Pierce Renio
//    StudentID: 1214793827
//      Lecture: MWF 9:40 AM
//  Description: HandlePane displays a list of available new Orders
//  and cancelled order. It also shows their total amounts

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import

import java.util.ArrayList;



import java.text.DecimalFormat;

//import all other necessary javafx classes here
import javafx.scene.layout.TilePane;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
 
public class HandlePane extends HBox
{
    //One for the new Order list, one for the cancelled list
    private static ArrayList < Order > orderedList;
    private static ObservableList<Order> orderedData;
	private ArrayList < Order > cancelledList;
	private ObservableList<Order> cancelledData;
    private ListView < Order > orderedLV, cancelledLV;
    private int orderedIndex;
    private int cancelledIndex;
    private Order orderedSelection;
    private Order cancelledSelection;
    private static Label newAmount;
    private Label cancelledAmount;
    private Button rightButton;
    private Button leftButton;

    //declare other necessary GUI components and variables here
    //----

    static DecimalFormat fmt1 = new DecimalFormat("##,###.00");

    //Constructor
    public HandlePane(ArrayList < Order > list)
    {
        this.orderedList = list;

        //The right hand side cancelled list is empty at beginnig
        cancelledList = new ArrayList < Order > ();

        //initialize other GUI components and set up the layout here
        Label newOrder = new Label("New Order");
        newAmount = new Label("Ordered Amt: .00");
        Label cancelledOrder = new Label("Cancelled Order");
        cancelledAmount = new Label("Ordered Amt: .00");



        //Create the two ListView objects. The left one is for new order
        //and the right one is for cancelled order. Study our sample codes
        //to learn how
        orderedData = FXCollections.observableArrayList(orderedList);
        orderedLV = new ListView<>(orderedData);
        orderedLV.setItems(orderedData);
        
        cancelledData = FXCollections.observableArrayList(cancelledList);
        cancelledLV = new ListView<>(cancelledData);
        cancelledLV.setItems(cancelledData);
        
        orderedLV.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        cancelledLV.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        
        //Initializing selected indexes and selected orders
        //orderedIndex = 0;
  	    //orderedSelection = orderedList.get(orderedIndex);
        //cancelledIndex = 0;
  	    //cancelledSelection = cancelledList.get(cancelledIndex);


        //set up the layout of the left pane, leftPane contains label, ListView
        //for new orders and total ordered amounts.
        GridPane leftGrid = new GridPane();
        leftGrid.setPadding(new Insets(10,10,10,10));
        leftGrid.setVgap(8);
        leftGrid.setHgap(10);
        
        leftGrid.add(newOrder, 0, 0);
        leftGrid.add(orderedLV, 0, 1);
        leftGrid.add(newAmount, 0, 2);

        //set up the layout of the right pane, rightPane contains label, ListView
        //for cancelled orders and total cancelled amounts.
        GridPane rightGrid = new GridPane();
        rightGrid.setPadding(new Insets(10,10,10,10));
        rightGrid.setVgap(8);
        rightGrid.setHgap(10);
        
        rightGrid.add(cancelledOrder, 0, 0);
        rightGrid.add(cancelledLV, 0, 1);
        rightGrid.add(cancelledAmount, 0, 2);

        //create a vertical TitlePane that hold the two buttons, set up the layout
        TilePane middlePane = new TilePane(Orientation.VERTICAL); 
        middlePane.setAlignment(Pos.CENTER);
        middlePane.setPadding(new Insets(10, 10, 10, 10));
        rightButton = new Button("=>");
        leftButton = new Button("<=");
        rightButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    	leftButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    	middlePane.setVgap(10.0);
    	middlePane.getChildren().addAll(leftButton, rightButton);
    	
        //HandlePane is a HBox, add sub components inside HandlePane
        this.getChildren().addAll(leftGrid, middlePane, rightGrid);
        
        

        //Step #3: Register the button with its handler class
        rightButton.setOnAction(new ButtonHandler2());
        leftButton.setOnAction(new ButtonHandler2());

    } //end of constructor

    //This method refresh the new order ListView whenever there's new Order added
    //in InputPane. It will (1)update the underline ObservableList object; (2)
    //update the total ordered amount.
    public static void updateOrderList(Order newOrder)
    {

        orderedData.add(new Order(newOrder.getProductName(), newOrder.getQuantity(), newOrder.getUnitPrice()));
        
        double sum = 0.0;
        double num = 0;
        for (int i = 0; i < orderedList.size();i++) {
        	num = orderedList.get(i).getTotalCost();
        	sum += num;
        }
        newAmount.setText("Ordered Amt: " + fmt1.format(sum));
    }

    //Step #2: Create a ButtonHandler class
    private class ButtonHandler2 implements EventHandler < ActionEvent >
    {
        //Override the abstact method handle()
        public void handle(ActionEvent e)
        {
        	Object source = e.getSource();
        	
        	if (source == rightButton && orderedList.size() != 0 && orderedLV.getSelectionModel().getSelectedItem() != null) {
        		Order temp = orderedLV.getSelectionModel().getSelectedItem();
                cancelledList.add(temp);
                cancelledData.add(temp);
                int selectedIndex = 0;
                for (int i = 0; i < orderedList.size();i++)
                	if (isEqual(temp, orderedList.get(i))){
                		selectedIndex = i;
                	}
                orderedList.remove(selectedIndex);
                orderedData.remove(selectedIndex);
                
                double sum = 0.0;
                double num = 0;
                for (int i = 0; i < orderedList.size();i++) {
                	num = orderedList.get(i).getTotalCost();
                	sum += num;
                }
                newAmount.setText("Ordered Amt: " + fmt1.format(sum));
                sum = 0.0;
                num = 0;
                for (int i = 0; i < cancelledList.size();i++) {
                	num = cancelledList.get(i).getTotalCost();
                	sum += num;
                }
                cancelledAmount.setText("Ordered Amt: " + fmt1.format(sum));
        	}
        	
        	else if(source == leftButton && cancelledList.size() != 0 && cancelledLV.getSelectionModel().getSelectedItem() != null) {
        		Order temp = cancelledLV.getSelectionModel().getSelectedItem();
        		orderedList.add(temp);
        		orderedData.add(temp);

                int selectedIndex = 0;
                for (int i = 0; i < cancelledList.size();i++)
                	if (isEqual(temp, cancelledList.get(i))){
                		selectedIndex = i;
                	}
                cancelledList.remove(selectedIndex);
                cancelledData.remove(selectedIndex);
                
                double sum = 0.0;
                double num = 0;
                for (int i = 0; i < orderedList.size();i++) {
                	num = orderedList.get(i).getTotalCost();
                	sum += num;
                }
                newAmount.setText("Ordered Amt: " + fmt1.format(sum));
				sum = 0.0;
				num = 0;
                for (int i = 0; i < cancelledList.size();i++) {
                	num = cancelledList.get(i).getTotalCost();
                	sum += num;
                }
                cancelledAmount.setText("Ordered Amt: " + fmt1.format(sum));
                
        	}
        }

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
    } //end of ButtonHandler class
} //end of HandlePane class
