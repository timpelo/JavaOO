package W10.E01;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jani on 3.11.2015.
 */
public class DrawArea extends JPanel {

    public DrawArea() {
        setBackground(Color.WHITE);
        setVisible(true);
        setFocusable(true);
        setBounds(100, 100, 860, 860);

        setLayout(new BorderLayout());

    }

    public void draw() {

    }
}
