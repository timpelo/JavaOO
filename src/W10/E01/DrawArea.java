package W10.E01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

/**
 * Created by Jani on 3.11.2015.
 */
public class DrawArea extends JPanel {
    MyCircle circle;
    ArrayList<MyCircle> circleList;
    public DrawArea() {
        circleList = new ArrayList<>();

        setBackground(Color.GRAY);
        setVisible(true);
        setFocusable(true);
        setBounds(0, 0, 860, 860);

        setLayout(new BorderLayout());
        circleList.add(circle = new MyCircle());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                circleList.add(new MyCircle());
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
}
