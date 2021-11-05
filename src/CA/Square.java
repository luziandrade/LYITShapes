package CA;

import java.awt.*;

/**
 * Square Subclass extends (based on) Rectangle Class as a blueprint
 */

public class Square extends Rectangle {

    // Method invoking parent class constructor
    public Square(Color color, boolean filled, int xCenter, int yCenter, int side){
        super(color, filled,xCenter,yCenter,side,side);

    }

}
