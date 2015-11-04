package W10.E01;

import javafx.scene.shape.Circle;

import java.awt.geom.Ellipse2D;

/**
 * Created by Jani on 4/11/2015.
 */
public class MyCircle extends Circle {

    Ellipse2D collider = new Ellipse2D.Float();
    private int rad;
    private int x;
    private int y;

    public MyCircle() {
        setX(430);
        setY(430);
        setRad(20);
        setCenterY(430);
        collider.setFrame(getCenterX(), getCenterY(), getRadius(), getRadius());
    }


    public int getRad() {
        return rad;
    }

    public void setRad(int radius) {
        this.rad = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
