package W10.E05;


import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Scanner;


/**
 * Created by Jani on 6/11/2015.
 */
public class JdbcRow{

    public static void main(String[] args) {
        boolean exit = false;
        JdbcConnection database = null;

        try {
            database = new JdbcConnection();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        DbWindow window = new DbWindow(database);
    }
}
