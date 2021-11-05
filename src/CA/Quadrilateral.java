package CA;

import java.awt.*;
import CA.interfaces.Rotatable;

/**
 * Quadrilateral Subclass extends ( based on) Shape Class as a blueprint which also implements (specify a behaviour) interface Rotatable
 */


public class Quadrilateral extends Shape implements Rotatable {
    private Point points[] = new Point[4];

    //Creating method assigning variables.
    //Method invoking parent class constructor.
    public Quadrilateral(Color color,boolean filled, Point centerPoint, Point points[]){
        super(color, filled, centerPoint.x, centerPoint.y);
        Point bottomLeft = new Point();
        Point topRight = new Point();
        Point topLeft = new Point();
        Point bottomRight = new Point();

        //Each loop, goes through each point and assign a value to the variables bottomLeft, topRight,topLeft, and bottomRight from Point Class.
        for(Point point : points){
            if( point.x <= centerPoint.x && point.y >= centerPoint.y){
                bottomLeft = point;
            }
            if(point.x >= centerPoint.x && point.y <= centerPoint.y){
                topRight = point;
            }
            //Now others
            if(point.x <= centerPoint.x && point.y <= centerPoint.y){
                topLeft = point;
            }
            if(point.x >= centerPoint.x && point.y >= centerPoint.y){
                bottomRight = point;
            }
        }

        this.points[0] = topLeft;
        this.points[1] = topRight;
        this.points[2] = bottomRight;
        this.points[3] = bottomLeft;

        //Assigning points to the bounding box.
        boundingBox(points);
    }

    //Creating method assigning variables as per requirement.
    //Method invoking parent class constructor.
    public Quadrilateral(Color color,boolean filled, Point centerPoint, Point p1, Point p2, Point p3, Point p4){
        super(color, filled, centerPoint.x, centerPoint.y);
        Point bottomLeft = new Point();
        Point topRight = new Point();
        Point topLeft = new Point();
        Point bottomRight = new Point();

        Point temp[] = {p1, p2, p3, p4};

        //Each loop, goes through each point and assign a value to the variables bottomLeft, topRight,topLeft, and bottomRight from Point Class.
        for(Point point : temp){

            if( point.x <= centerPoint.x && point.y >= centerPoint.y){
                bottomLeft = point;
            }
            if(point.x >= centerPoint.x && point.y <= centerPoint.y){
                topRight = point;
            }

            if(point.x <= centerPoint.x && point.y <= centerPoint.y){
                topLeft = point;
            }
            if(point.x >= centerPoint.x && point.y >= centerPoint.y){
                bottomRight = point;
            }
        }

        this.points[0] = topLeft;
        this.points[1] = topRight;
        this.points[2] = bottomRight;
        this.points[3] = bottomLeft;

        //Assigning points to the bounding box.
        boundingBox(points);
    }

    //Creating method assigning variables as per requirement.
    //Method invoking parent class constructor.
    public Quadrilateral(Color color,boolean filled, Rectangle rectangle){

        super(color, filled, rectangle.xCenter, rectangle.yCenter);
        int xCenter = rectangle.xCenter;
        int yCenter = rectangle.yCenter;
        int width = rectangle.width;
        int height = rectangle.height;

        this.points[0] = new Point(xCenter-width,yCenter-height);
        this.points[1] = new Point(xCenter+width,yCenter-height);
        this.points[2] = new Point(xCenter+width,yCenter+height);
        this.points[3] = new Point(xCenter-width,yCenter+height);

        getboundBox = new BoundingBox(points[3],points[1]);
    }


    // Method from abstract Shape Class used to draw the shape.
    public void drawShape(Graphics g){
        g.setColor(color);

        // Creating a new object looping to the points.
        Polygon polygon = new Polygon();
        int i=0;
        do{
            polygon.addPoint(points[i].x, points[i].y);
            i++;
        }
        while (i<points.length);

        // If Filled method is not true the method will draw the outline of the rectangle shape, otherwise 'else' it will fill the drew shape.
        if(!filled)
            g.drawPolygon(polygon);
        else
            g.fillPolygon(polygon);

    }

    private void boundingBox(Point points[]){
        // To set Bounding Box
        int x_min = points[0].x, x_max = points[1].x;
        int y_min = points[3].y, y_max = points[2].y;

        // Creating a new object looping to the points.
        int i=0;
        do{
            if(points[i].x<x_min)
                x_min = points[i].x;

            if(points[i].y<y_min)
                y_min = points[i].y;

            if(points[i].x>x_max)
                x_max = points[i].x;

            if(points[i].y>y_max)
                y_max = points[i].y;
            i++;
        }
        while (i<points.length);

        Point bottomLeft = new Point(x_min,y_max);
        Point topRight = new Point(x_max,y_min);

        //Assigning points to the bounding box.
        this.getboundBox = new BoundingBox(bottomLeft,topRight);
    }

    public boolean rClick(){
        //Calling rotateNinetyDegrees from Rotatable Interface if rClick (right click mouse) is set to true.
        rotateNinetyDegrees();
        return true;
    }


    @Override
    //Method from Rotatable interface to assign an action to a shape, in this case the object will rotate 90 degrees to the right for each right click.
    public void rotateNinetyDegrees() {
        int disX, disY;

        Point temp[] = new Point[4];

        int i=0;
        do{
            temp[i] = new Point();
            i++;
        }
        while(i<temp.length);

        int e=0;
        int p;
        do{
            p = e+1;

            disX = xCenter - points[e].x;
            disY = yCenter - points[e].y;

            if(p>3)
                p=0;

            temp[p].x = xCenter + disY;
            temp[p].y = yCenter - disX;
            e++;
        }
        while(e<temp.length);

        int a=0;
        do{
            points[a] = temp[a];
            a++;
        }
        while(a<temp.length);

        //Assigning points to the bounding box.
        boundingBox(points);

    }
    //All Shape Classes should override toString() to allow for console-based validation/debugging.
    @Override
    public String toString() {
        return "Quadrilateral{" +
                "bottomLeft=" + points[3] +
                ", topRight=" + points[1]+
                ", bottomRight=" + points[2] +
                ", topLeft=" + points[0] +

                '}';
    }

}

