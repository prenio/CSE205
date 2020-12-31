//This program demonstrate Text, Line, Rectangle, Circle, Arc, etc
//When you test on this program, just run one part of the codes
//otherwise all shapes (text, line, rectangle, etc) will be
//tanggled together

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class ShapeDemo extends Application
{
   public void start(Stage primaryStage)
   {
      Pane pane = new Pane();
      pane.setPrefSize(200,200);
      pane.setPadding(new Insets(5, 5, 5, 5));

      //************Part I - demonstrate Text class************
     /* Text text1 = new Text(20, 20, "Programming is fun\nDisplay text");
      text1.setFill(Color.RED);
      text1.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.ITALIC, 15));
      pane.getChildren().add(text1); */

      //************Part II - demonstrate Line class************
     /* Line line1 = new Line(10, 10, 190, 190);
      line1.setStrokeWidth(5);
      line1.setStroke(Color.RED);

      Line line2 = new Line(10, 190, 190, 10);
      line2.setStrokeWidth(5);
      line2.setStroke(Color.YELLOW);
      pane.getChildren().addAll(line1, line2); */

      //************Part III - demonstrate Rectangle class************
	/*  Rectangle r1 = new Rectangle(20, 10, 60, 30);
	  r1.setStroke(Color.BLACK);
	  r1.setFill(Color.WHITE);
	  Rectangle r2 = new Rectangle(60, 70, 30, 60);
	  r2.setFill(Color.BLUE);
      pane.getChildren().addAll(r1, r2);

      //You can change a rectangle's uppler left corner
      //and its width & height by using mutators
	  r1.setX(10);
 	  r1.setY(30);
 	  r1.setWidth(40);
 	  r1.setHeight(60); */

 	  //************Part IV - demonstrate Circle class************
 	/*  Circle c1 = new Circle(50, 50, 50);
 	  c1.setStroke(Color.BLACK);
	  c1.setFill(null);

 	  Circle c2 = new Circle();
	  c2.setCenterX(150);
	  c2.setCenterY(150);
	  c2.setRadius(50);
 	  c2.setStroke(Color.BLACK);
 	  c2.setFill(Color.BLUE);
      pane.getChildren().addAll(c1, c2); */

 	  //************Part V - demonstrate Ellipse class************
 	/*Ellipse e1 = new Ellipse(100, 100, 80, 40);
 	  e1.setStroke(Color.BLACK);
 	  e1.setFill(Color.WHITE);

 	  Ellipse e2 = new Ellipse(100, 100, 80, 40);
 	  e2.setStroke(Color.BLACK);
 	  e2.setFill(Color.BLUE);
 	  e2.setRotate(90);	//rotate 90 degree
 	  pane.getChildren().addAll(e1, e2); */

 	  //************Part VI - demonstrate Arc class************
 	  Arc arc1 = new Arc(100, 100, 80, 80, 0, 45);
      arc1.setFill(Color.RED); // Set fill color
      arc1.setStroke(Color.BLACK);
      arc1.setType(ArcType.ROUND); //set arc type

      Arc arc2 = new Arc(100, 100, 80, 80, 90, 45);
      arc2.setFill(Color.BLUE);
      arc2.setStroke(Color.BLACK);
      arc2.setType(ArcType.CHORD); //set arc type

      Arc arc3 = new Arc(100, 100, 80, 80, 180, 45);
      arc3.setFill(Color.YELLOW);
      arc3.setStroke(Color.BLACK);
      arc3.setType(ArcType.OPEN); //set arc type
 	  pane.getChildren().addAll(arc1, arc2, arc3);

    //Create a scene and place it in the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("ShapeDemo");
    primaryStage.setScene(scene);
    primaryStage.show(); // Display the stage
  }

  public static void main(String[] args)
  {
    launch(args);
  }
}
