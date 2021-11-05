package CA;

import java.awt.*;

/**
 * Abstract Shape Class that we serve as base for square, circle, rectangle and quadrilateral.
 */

public abstract class Shape {
    Color color; //The Color class is in java.awt
    // Required variables requirements.
    boolean filled;
    int xCenter;
    int yCenter;

    protected BoundingBox getboundBox;

    //Creating method assigning variables
    public Shape(Color color, boolean filled, int xCenter, int yCenter) {
        this.color = color;
        this.filled = filled;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    //If statement to set Filled method true or false, method called on ShapesManager Class when LeftClick is set to true.
    public void Filled(){
        if(filled)
            filled = false;
        else
            filled = true;
    }

    //Empty method which will be called on each shape class individually to draw shapes.
    public abstract void drawShape(Graphics g);

    //Method setting rightClick false by default, method called on ShapesManager Class when RightClick is actioned.
    public boolean rClick(){

        return false;
    }

    //Creating method to wrap shapes into a bounding box
    public void drawBoundingBox(Graphics g){
        //Assigning color to the bounfing box
        g.setColor(Color.lightGray);
        //Drawing Bounding Box based on variables from BoundingBox Class and Point Class which will be hold a value.
        g.drawRect(getboundBox.bottomLeft.x,
                getboundBox.topRight.y,
                getboundBox.topRight.x- getboundBox.bottomLeft.x,
                getboundBox.bottomLeft.y- getboundBox.topRight.y);
    }


    public void drawName(Graphics g){
        //Setting color of the Class Name
        g.setColor(Color.black);
        Font tFont = new Font("Arial", Font.BOLD, 12);
        g.setFont(tFont);
        //Using getSimpleName function to fetch class name
        g.drawString(this.getClass().getSimpleName(),xCenter,yCenter);
    }

    //All Shape Classes should override toString() to allow for console-based validation/debugging.
    @Override
    public String toString() {
        return "Shape{" +
                "color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }

}
