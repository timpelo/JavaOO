package W10.E01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by Jani on 3.11.2015.
 */
public class DrawArea extends JPanel {
    ArrayList<MyCircle> circleList;
    ArrayList<Wall> wallList;
    Main host;

    public DrawArea(Main host) {
        this.host = host;
        circleList = new ArrayList<>();
        wallList = generateWalls();
        CircleHandler handler = new CircleHandler(this);

        setBackground(Color.GRAY);
        setFocusable(true);
        setBounds(host.getX(), host.getY(), 1280, 720);

        setLayout(new BorderLayout());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                circleList.add(new MyCircle(e.getX(), e.getY()));
            }
        });

        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);

                if(e.getWheelRotation() > 0) {

                    for(MyCircle circle : circleList) {
                        circle.setRad(circle.getRad() - 1);
                    }
                }

                if(e.getWheelRotation() < 0) {

                    for(MyCircle circle : circleList) {
                        circle.setRad(circle.getRad() + 1);
                    }
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        revalidate();
        repaint();

        for(MyCircle circle : circleList) {
            g2.setColor(circle.getColor());

            int r = circle.getRad();
            int x = circle.getX();
            int y = circle.getY();
            g2.fillOval(x - (r / 2), y - (r / 2), r, r);


        }
    }

    public ArrayList<Wall> generateWalls() {
        ArrayList<Wall> wallList = new ArrayList<>();

        Wall bottom = new Wall(0, 720, 1280, 5, "bottom");
        Wall top = new Wall(-5, 0, 1280, 5, "top");
        Wall wallLeft = new Wall(-5, 0, 5, 720, "left");
        Wall wallRight = new Wall(1280, 0, 5, 720, "right");


        wallList.add(bottom);
        wallList.add(top);
        wallList.add(wallLeft);
        wallList.add(wallRight);

        System.out.println("Bottom: " + bottom.getBounds());
        System.out.println("Top: " + top.getBounds());
        System.out.println("WallL: " + wallLeft.getBounds());
        System.out.println("WallR: " + wallRight.getBounds());

        return wallList;
    }
}
