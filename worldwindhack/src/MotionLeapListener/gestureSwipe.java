/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotionLeapListener;

//import java.util.Vector;
import com.leapmotion.leap.Vector;
/**
 *
 * @author gondd
 */
public class gestureSwipe {
    Vector start = new Vector();
    Vector stop = new Vector();
    int id;
    double speed;
    
    public Direction returnDirectionAndSpeed() {
        // Which direction are we going? Let's compare x and y.
        double startX = start.getX();
        double endX = stop.getX();
        double startY = start.getY();
        double endY = stop.getY();
        double differenceX;
        if (startX > endX)
            differenceX = startX - Math.abs(endX);
        else
            differenceX = endX - Math.abs(startX);
        double differenceY;
        if (startY > endY)
            differenceY = startY - Math.abs(endY);
        else
            differenceY = endY - Math.abs(startY);
        
        // Reset gesture values to 0
        for(int i = 0; i < 3; i++) {
            start.setX(0);
            start.setY(0);
            stop.setX(0);
            stop.setY(0);
        }
        // First of all: are we moving in the X axis or the Y?
        if (Math.abs(differenceX) >= Math.abs(differenceY))
        {
            // We are moving in the X axis. Are we moving left or right?
            if (differenceX > 0)
            {
                return Direction.RIGHT;
            }
            else
            {
                return Direction.LEFT;
            }
        }
        else
        {
            // We are moving in the Y axis. Are we moving up or down?
            if (differenceY > 0)
            {
                return Direction.UP;
            }
            else
            {
                return Direction.DOWN;
            }
        }
    }
}
