package CA;

import java.awt.*;
import CA.interfaces.Moveable;

/**
 * Rectangle Subclass extends ( based on) Shape Class as a blueprint which also implements (specify a behaviour) interface Moveable
 */

public class Rectangle  extends Shape implements Moveable {
    // Required variables requirements.
     int width;
     int height;

    //Creating method assigning variables
    //Method invoking parent class constructor
    public Rectangle(Color color, boolean filled, int xCenter, int yCenter, int width, int height) {
        super(color, filled, xCenter, yCenter);
        this.width = width;
        this.height = height;

        //Assigning values to Bounding and Point Class , creating two Points to get shape of the bounding box.
        this.getboundBox = new BoundingBox(new Point(xCenter-(width/2),
                yCenter+(height/2)),
                new Point(xCenter+(width/2),
                        yCenter-(height/2)));

    }

    @Override
    // Method from abstract Shape Class used to draw the shape.
    public void drawShape(Graphics g) {
        g.setColor(color);

        // If Filled method is not true the method will draw the outline of the rectangle shape, otherwise 'else' it will fill the drew shape.
        if(!filled)
            g.drawRect(xCenter-width/2,yCenter - height/2,width,height);
        else
            g.fillRect(xCenter - width/2,yCenter - height/2,width,height);
    }


    public boolean rClick(){
        //Calling MoveTenUnits from Moveable Interface if rClick (right click mouse) is set to true.
        moveTenUnits();
        return true;
    }



    @Override
    public void moveTenUnits() {
        //Method from  Moveable interface to assign an action to a shape, in this case the object will move 10 units to the right for each right click.
        xCenter = xCenter + 10;
        getboundBox.bottomLeft.x += 10;
        getboundBox.topRight.x += 10;

    }
    //All Shape Classes should override toString() to allow for console-based validation/debugging.
    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }

}
