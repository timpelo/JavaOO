package W10.E01;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jani on 3.11.2015.
 */
public class DrawArea extends JPanel {
    MyCircle circle;
    public DrawArea() {
        setBackground(Color.WHITE);
        setVisible(true);
        setFocusable(true);
        setBounds(100, 100, 860, 860);

        setLayout(new BorderLayout());
        circle = new MyCircle();

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.CYAN);

        int r = circle.getRad();
        int x = circle.getX();
        int y = circle.getY();
        g2.fillOval(x - (r/2), y - (r/2), r, r);

        repaint();
    }
}
