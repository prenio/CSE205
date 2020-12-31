// Assignment #: Arizona State University CSE205 #7
//         Name: Pierce Renio
//    StudentID: 1214793827
//      Lecture: Your lecture time MWF 9:40am
//  Description: The DrawPane class creates a canvas where we can use
//               mouse key to draw either a Rectangle, a Circle or an Arc with different
//               colors. We can also use the the two buttons to erase the last
//				 drawn shape or clear them all.

//import any classes necessary here
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class DrawPane extends BorderPane
{
   private Button undoBtn, eraseBtn;
   private ComboBox<String> colorCombo;
   private RadioButton rbRect, rbCircle, rbArc;
   private ArrayList<Shape> shapeList;
   private Pane canvas;
   private BorderPane borderPane;
   //declare any other necessary instance variables here
   private double x1, y1, x2, y2,dx,dy;
   //ShapeInd for shapes (rectangle-1,circle-2,arc-3)
   private String shape;
   private String colorString;
   private Rectangle rect;
   private Circle circ;
   private Arc arc;
   //Constructor
   public DrawPane()
   {
      //Step #1: initialize each instance variable and set up layout
      undoBtn = new Button("Undo");
      eraseBtn = new Button("Erase");
      undoBtn.setMinWidth(80.0);
      eraseBtn.setMinWidth(80.0);
      x1 = y1 = x2 = y2 = 0.0;
      shape = "Rectangle";
      colorString = "Black";

      //Create the color comboBox and initial its default color
      colorCombo = new ComboBox<String>();
      colorCombo.getItems().addAll("Black","Red","Blue","Green","Yellow","Orange","Pink");
      colorCombo.setValue("Black");
      
      
      //Create the three radio buttons and also a ToggleGroup
      //so that the three radio buttons can be selected
      //mutually exclusively. Otherwise they are indepedant of each other
      rbRect = new RadioButton("Rectangle");
      rbCircle = new RadioButton("Circle");
      rbArc = new RadioButton("Arc");
      ToggleGroup group = new ToggleGroup();
      rbRect.setToggleGroup(group);
      rbCircle.setToggleGroup(group);
      rbArc.setToggleGroup(group);
      
      rbRect.setSelected(true);
      
      //initialize shapeList, it is a data structure we used
      //to track the shape we drew
      shapeList = new ArrayList<Shape>();

      //canvas is a Pane where we will draw rectagles, circles and arcs on it
      canvas = new Pane();
      canvas.setStyle("-fx-background-color: Azure;");

      borderPane = new BorderPane();

      //initialize the remaining instance variables and set up the layout
      VBox leftPane = new VBox(75);
      leftPane.setPadding(new Insets(10,0,20,0));


      leftPane.getChildren().addAll(colorCombo, rbRect, rbCircle, rbArc);
      leftPane.setAlignment(Pos.CENTER);
      leftPane.setStyle("-fx-border-style: solid; -fx-border-width: 1;");
      leftPane.setMinWidth(125);
 
      HBox bottomPane = new HBox(30);
      bottomPane.getChildren().addAll(undoBtn, eraseBtn);
      bottomPane.setStyle("-fx-border-style: solid; -fx-border-width: 1;");
      bottomPane.setMinWidth(600);
      bottomPane.setMinHeight(70);
      bottomPane.setAlignment(Pos.CENTER);
      
      //canvas.getChildren().addAll(leftPane,bottomPane);
      borderPane.setBottom(bottomPane);
      borderPane.setLeft(leftPane);
      borderPane.setCenter(canvas);
      this.getChildren().addAll(borderPane);
      
      

      //Step #3: Register the source nodes with its handler objects
      canvas.setOnMousePressed(new MouseHandler());
      canvas.setOnMouseDragged(new MouseHandler());
      canvas.setOnMouseReleased(new MouseHandler());
      rbRect.setOnAction(new ShapeHandler());
      rbCircle.setOnAction(new ShapeHandler());
      rbArc.setOnAction(new ShapeHandler());
      colorCombo.setOnAction(new ColorHandler());
      undoBtn.setOnAction(new ButtonHandler());
      eraseBtn.setOnAction(new ButtonHandler());
    }

   //Step #2(A) - MouseHandler
   private class MouseHandler implements EventHandler<MouseEvent>
   {
      public void handle(MouseEvent event)
      {
		 if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			 x1 = x2 = event.getX();
			 y1 = y2 = event.getY();
			 if (shape.equals("Rectangle")) {
				 rect = new Rectangle(x1,y1,0,0);
				 rect.setFill(Color.WHITE);
				 rect.setStroke(Color.BLACK);
				 shapeList.add(rect);
			 }
			 
			 else if (shape.equals("Circle")) {
				 circ = new Circle(x1,y1,0);
				 circ.setFill(Color.WHITE);
				 circ.setStroke(Color.BLACK);
				 shapeList.add(circ);
			 }
			 
			 else if (shape.equals("Arc")) {
				 arc = new Arc(x1,y1,0.0,0.0,0.0,0.0);
				 arc.setFill(Color.WHITE);
				 arc.setStroke(Color.BLACK);
				 arc.setType(ArcType.ROUND);
				 shapeList.add(arc);
			 }
		 }
		 
		 else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			 if (shape.equals("Rectangle")) {
				 x2 = event.getX();
				 y2 = event.getY();
				 if (y2 > 320)
					 y2 = 333;
				 if (x2 > 475)
					 x2 = 475;
				 rect.setWidth(x2-x1);
				 rect.setHeight(y2-y1);
			 }
			 else if (shape.equals("Circle")) {
				 x2 = event.getX();
				 y2 = event.getY();
				 circ.setRadius(Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2)));
			 }
			 else if (shape.equals("Arc")) {
				 x2 = event.getX();
				 y2 = event.getY();
				 dy = y2-y1;
				 dx = x2-x1;
				 arc.setRadiusX(x2);
				 arc.setRadiusY(x2/2);
				 arc.setStartAngle(Math.atan2(-dy,dx));
				 arc.setLength(Math.toDegrees(Math.atan2(-dy,dx)));
				 
			 }
		 }
		 
		 else if(event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			 if (shape.equals("Rectangle")) {
				 rect.setWidth(x2-x1);
				 rect.setHeight(y2-y1);
				 rect.setFill(getColor());
			 }
			 else if (shape.equals("Circle")) {
				 circ.setRadius(Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2)));
				 circ.setFill(getColor());
			 }
			 else if (shape.equals("Arc")) {
				 dy = y2-y1;
				 dx = x2-x1;
				 arc.setRadiusX(x2);
				 arc.setRadiusY(x2/2);
				 arc.setStartAngle(Math.atan2(-dy,dx));
				 arc.setLength(Math.toDegrees(Math.atan2(-dy,dx)));
				 arc.setFill(getColor());
			 }
		 }
		 refresh();

      }//end handle()
   }//end MouseHandler

   //Step #2(B)- A handler class used to handle events from Undo & Erase buttons
   private class ButtonHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent event)
      {
    	  Object source = event.getSource();
		  if (source == eraseBtn && shapeList.size() != 0) {
			  shapeList.clear();
			  }
		  else if (source == undoBtn && shapeList.size() != 0) {
			  shapeList.remove(shapeList.size()-1);
		  }
		  refresh();


      }
   }//end ButtonHandler

   //Step #2(C)- A handler class used to handle events from the three radio buttons
   private class ShapeHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent event)
      {
    	  if (rbRect.isSelected()) 
    		  shape = "Rectangle";
    	  else if (rbCircle.isSelected())
    		  shape = "Circle";
    	  else if (rbArc.isSelected())
    		  shape = "Arc";
      }
   }//end ShapeHandler

   //Step #2(D)- A handler class used to handle colors from the combo box
   private class ColorHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent event)
      {
		  colorString = colorCombo.getValue();
      }     
      
   }//end ColorHandler

   public void refresh() {
	   canvas.getChildren().clear();
	   for (Shape shape: shapeList) {
		   canvas.getChildren().add(shape);
	   }
   }
	   public Color getColor() {
		   Color color = Color.BLACK;
		   switch(colorString) {
		      case "Black":
		    	  color = Color.BLACK;
		    	  break;
		      case "Red":
		    	  color = Color.RED;
		    	  break;
		      case "Blue":
		    	  color = Color.BLUE;
		    	  break;
		      case "Green":
		    	  color = Color.GREEN;
		    	  break;
		      case "Yellow":
		    	  color = Color.YELLOW;
		    	  break;
		      case "Orange":
		    	  color = Color.ORANGE;
		    	  break;
		      case "Pink":
		    	  color = Color.PINK;
		    	  break;
		      }
		      return color;
	   }
}//end class DrawPane