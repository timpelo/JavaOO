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
    private int direcionX;
    private int direcionY;

    public MyCircle(int x, int y) {
        Random rand = new Random();
        setX(x);
        setY(y);

        setRad(20);
        setCenterY(430);
        direcionX = rand.nextInt(10)-5;
        direcionY = rand.nextInt(10)-5;
        color = randomColor();
        collider.setFrame(getX(), getY(), getRadius(), getRadius());
    }


    public int getRad() {
        return rad;
    }

    public void setRad(int radius) {
        this.rad = radius;
        collider.setFrame(getX(), getY(), getRad(), getRad());
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

    public Ellipse2D getCollider() {
        return collider;
    }

    public void setCollider(Ellipse2D collider) {
        this.collider = collider;
    }

    private Color randomColor() {

        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);

        return new Color(r,g,b);
    }

    public void move() {
        setX(getX() + direcionX);
        setY(getY() + direcionY);
        collider.setFrame(getX(), getY(), getRad(), getRad());
    }

    public void changeDirection(String wallTag) {

        switch (wallTag) {

            case "top":
                direcionY = -direcionY;
                break;
            case "bottom":
                direcionY = -direcionY;
                break;
            case "left":
                direcionX = -direcionX;
                break;
            case "right":
                direcionX = -direcionX;
                break;

        }
    }
}


