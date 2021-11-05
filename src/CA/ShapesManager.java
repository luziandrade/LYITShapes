package CA;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapesManager extends JPanel{
    //Declaring variables boolean type to have an option to display class names of the shapes and bounding box shapes
    private boolean displayName = false;
    private boolean displayBoundBox = false;

    //Declaring an array which will hold shapes objects
    private final ArrayList<Shape> shapeArrayList = new ArrayList<>();


    public boolean range(int x, int a, int b){
        if (x>=a && x<=b)
            return true;
        else
            return false;
    }

    //Adding shapes to the array declared above
    public void addShape (Shape shape){

        shapeArrayList.add(shape);
    }

    public void drawShapes(Graphics g) {

        //Each loop, goes through each shape and fetch their drawShape method
        for(Shape shape : shapeArrayList){
            shape.drawShape(g);
            if(displayBoundBox)
                shape.drawBoundingBox(g);
            if(displayName){
                shape.drawName(g);
            }
        }
    }
    //Creating method to display class name
    public void setDisplayName(boolean state){
        this.displayName = state;

    }
    //Creating method to display bounding box shape
    public void setDisplayBoundingBox(boolean state){

        this.displayBoundBox = state;
    }

    //Creating method for select shapes based on mouse pressed events
    public boolean leftClick(int targetX,int targetY){

        //Boolean type for left click , to check if it is clicked or not, true or false
        boolean click = false;

        //Each loop, goes through each shape, checking if  the click is inside the bound box wrapped around the shape
        for(Shape shape : shapeArrayList){
            Point bottomLeft = shape.getboundBox.bottomLeft;
            Point topRight = shape.getboundBox.topRight;
            if(range(targetX, bottomLeft.x, topRight.x)&& range(targetY,topRight.y, bottomLeft.y)){
                //If the click is located inside the bounding box, click variable be set to true and it will activated toggleFilled to fill shapes
                shape.Filled();
                click = true;
            }
        }
        return click;
    }

    //Creating method for select shapes based on mouse pressed events
    public boolean rightClick(int targetX,int targetY){

        //Boolean type for right click , to check if it is clicked or not, true or false
        boolean click = false;

        //Each loop, goes through each shape, checking if  the click is inside the bound box wrapped around the shape
        for(Shape shape : shapeArrayList){
            Point bottomLeft = shape.getboundBox.bottomLeft;
            Point topRight = shape.getboundBox.topRight;
            if(range(targetX, bottomLeft.x, topRight.x)&& range(targetY,topRight.y, bottomLeft.y)){
                click = shape.rClick();
            }
        }
        return click;
    }

}