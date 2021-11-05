package CA;

/**
 * Point Class as per requirement, Point Class will exist as long as shapes class(Circle, Rectangle and Quadrilateral) (Container) exist
 */

//Creating variables.
public class Point {
    int x=0;
     int y=0;

    public Point(){

    }
    //Assigning values to variables, which will be used to draw shapes and bounding box, it will help us to set the shape on the Panel.
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }


    //All Shape Classes should override toString() to allow for console-based validation/debugging.
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
