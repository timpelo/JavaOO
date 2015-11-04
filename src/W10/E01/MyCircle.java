package W10.E01;

import javafx.scene.shape.Circle;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * Created by Jani on 4/11/2015.
 */
public class MyCircle extends Circle {

    Ellipse2D collider = new Ellipse2D.Float();
    private int rad;
    private int x;
    private int y;
    private Color color;

    public MyCircle() {
        setX(430);
        setY(430);
        setRad(20);
        setCenterY(430);
        color = randomColor();
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    private Color randomColor() {

        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);

        return new Color(r,g,b);
    }
}


