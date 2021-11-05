package CA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This allows us to create a panel which we can add to a frame/window
 * Oftentimes, you would then add standard GUI components, e.g. JButton, JLabel, to the
 * panel.
 * In our case, though, we will want to draw shapes, so we override the paintComponent() method
 * that we inherit from the javax.swing.JPanel class.
 * The graphics system passes us a java.awt.Graphics object and this has methods which allows us
 * to draw shapes.
 */


public class CustomPanel extends JPanel implements MouseListener {
    ShapesManager shapesManager;

    //Creating method assigning variables
    public CustomPanel(ShapesManager shapesManager){
        this.shapesManager = shapesManager;

        //Event Listener mousePressed will detect mouse pressed to calls methods leftClick and rightClick and it will change the status of the click and repaint the shapes after action.
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent me) {
                int targetX = me.getX();
                int targetY = me.getY();
                int button = me.getButton();

                boolean condition = false;
                if (button == 1) {
                    condition = shapesManager.leftClick(targetX, targetY);
                }else if (button == 3) {
                    condition = shapesManager.rightClick(targetX, targetY);
                }
                if(condition)
                    repaint();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        //The superclass does some important work in the method we've overridden, so we
        //should invoke it.
        super.paintComponent(g);
        shapesManager.drawShapes(g);


    }
    //The superclass does some important work in the method we've overridden, so we
    //should invoke it.
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
