package CA;

import java.awt.*;

/**
 * Circle Subclass extends ( based on) Shape Class as a blueprint
 */

public class Circle extends Shape {
    // Required variables requirements
    private int radius;

    //Creating method assigning variables
    // Method invoking parent class constructor
    public Circle (Color color, boolean filled, int xCenter, int yCenter, int radius){
        super(color, filled, xCenter, yCenter);
        this.radius = radius;

        //Assigning values to Bounding and Point Class , creating two Points to get shape of the bounding box
        this.getboundBox = new BoundingBox(new Point(xCenter-(radius/2),
                yCenter+(radius/2)),
                new Point(xCenter+(radius/2),
                        yCenter-(radius/2)));

    }


    @Override
    // Method from abstract Shape Class used to draw the shape
    public void drawShape(Graphics g) {
        g.setColor(color);

        // If Filled method is set to true it will fill the drew shape, otherwise 'else' draw the outline of the circle shape
        if (filled) {
            g.fillOval(xCenter - radius/2,
                    yCenter - radius /2,
                    radius ,
                    radius );
        }else {
            g.drawOval(xCenter- radius/2,
                    yCenter - radius/2,
                    radius ,
                    radius );
        }


    }

    //All Shape Classes should override toString() to allow for console-based validation/debugging.
    @Override
    public String toString() {
        return "Rectangle{" +
                ", color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }

}
