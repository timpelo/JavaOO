package W10.E05;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Jani on 9/11/2015.
 */
public class DbWindow extends JFrame {
    JdbcConnection database;

    BorderLayout layout = new BorderLayout();

    JPanel menu = new JPanel();
    JButton insertButton = new JButton("Add");
    JTextField name = new JTextField();
    String[] headers = {"ID", "NAME"};
    JTable table;
    JScrollPane pane;

    public DbWindow(JdbcConnection database) {
        this.database = database;

        try {
            table = new JTable(database.getNames(), headers);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pane = new JScrollPane(table);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Database");
        menu.setPreferredSize(new Dimension(600, 100));
        insertButton.setPreferredSize(new Dimension(80, 50));
        name.setPreferredSize(new Dimension(200, 50));


        menu.add(name, layout.WEST);
        menu.add(insertButton, layout.EAST);
        add(pane, layout.CENTER);
        add(menu, layout.SOUTH);

        setVisible(true);
        setResizable(false);
        setBounds(100, 100, 600, 860);

        insertButton.addActionListener(e -> addToDatabase());




    }

    public void addToDatabase() {

        try {
            database.insertName(name.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        name.setText("");
        updateDatabase();
    }

    public void updateDatabase() {
        String[][] names = null;
        boolean success = true;

        try {
            names = database.getNames();
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        }

        if(success) {
            table = new JTable(names, headers);
            System.out.println("Database Updated");

            remove(pane);
            pane = new JScrollPane(table);
            add(pane);

            revalidate();
        }
    }

    public void closeConnection() {
        if(database != null) {
            try {
                database.closeConnection();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
