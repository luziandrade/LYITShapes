package CA;

import javax.swing.*;
import java.awt.*;

/**
 * WindowCreator Class to start execution of the project
 */
public class WindowCreator {
    public static void main(String[] args) {
        ShapesManager shapesManager = new ShapesManager();


        // Creating shapes objects
        // Rectangle
        Rectangle rectangle = new Rectangle(Color.red, true,70,114,80, 100);
        //Rectangle rectangle = new Rectangle(Color.red,true,50+20,20+30,80,90);

        // Square
        Square square = new Square(Color.blue, false,150,350,100);

        // Circle
        Circle circle = new Circle(Color.yellow,true,400,100,80);


        // Quadrilateral  1
        Point centerPoint = new Point(450,285);
        Point points[] = new Point[4];

        points[2] = new Point(400,220);
        points[0] = new Point(510,210);
        points[1] = new Point(490,320);
        points[3] = new Point(420,380);

        Quadrilateral quad = new Quadrilateral(Color.white,false, centerPoint, points);

        // Quadrilateral  2
        Point p1,p2,p3,p4, centerPoint2;
        p1 = new Point(200,170);
        p2 = new Point(360,150);
        p3 = new Point(330,200);
        p4 = new Point(190,250);
        centerPoint2 = new Point(270,195);

        Quadrilateral quad1 = new Quadrilateral(Color.lightGray,false, centerPoint2, p3,p2,p1,p4);

        // Quadrilateral  3
        Rectangle rec = new Rectangle(Color.white,true,530,100,30,60);
        Quadrilateral quad2 = new Quadrilateral(Color.magenta,false, rec);


        //Assigning objects to methods
        shapesManager.addShape(rectangle);
        shapesManager.addShape(square);
        shapesManager.addShape(circle);
        shapesManager.addShape(quad);
        shapesManager.addShape(quad1);
        shapesManager.addShape(quad2);


        //creating the window with basic information
        shapesManager.setDisplayBoundingBox(false); //true
        shapesManager.setDisplayName(true);
        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("Shaper Manager LYIT");
        customWindow.setVisible(true);


    }
}
