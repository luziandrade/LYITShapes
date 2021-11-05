package CA;

/**
 * BoundingBox Class as per requirement, Point Class will exist as long as shapes class(Circle, Rectangle and Quadrilateral) (Container) exist
 */


public class BoundingBox {
    //Creating variables.
    Point bottomLeft;
    Point topRight;

    //Assigning values to variables, which will be used to draw bounding box.
    public BoundingBox(Point bottomLeft,Point topRight){
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }


    //All Shape Classes should override toString() to allow for console-based validation/debugging.
    @Override
    public String toString() {
        return "BoundingBox{" +
                "bottomLeft=" + bottomLeft +
                ", topRight=" + topRight +
                '}';
    }
}
