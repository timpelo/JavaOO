package W10.E01;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jani on 3/11/2015.
 */
public class Main extends JFrame{

    public Main() {
        //setBounds(100, 100, 860, 860);
        setResizable(false);
        setTitle("BallApp");
        setFocusable(true);
        setVisible(true);
        setLayout(new BorderLayout());

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        Main window = new Main();
        DrawArea panel = new DrawArea(window);
        window.add(panel, BorderLayout.CENTER);
        window.setBounds(100, 100, 1280, 720);
        panel.setVisible(true);

    }
}
