package W10.E01;

import javafx.scene.shape.Circle;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by Jani on 4/11/2015.
 */
public class CircleHandler implements Runnable {
    DrawArea host;

    public CircleHandler(DrawArea host) {
        this.host = host;
        (new Thread(this)).start();
    }

    @Override
    public void run() {
        while(true) {

            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            moveCircles();
            checkCollision();
        }
    }

    private void moveCircles() {

        for(MyCircle circle : host.circleList) {
            circle.move();
        }
    }

    private void checkCollision() {

        for(Wall wall: host.wallList) {

            for(MyCircle circle : host.circleList) {

                if(wall.getBounds().intersects(circle.getCollider().getBounds())) {
                    System.out.println("BANG!!");
                    circle.changeDirection(wall.getTag());
                }
            }
        }

    }
}
