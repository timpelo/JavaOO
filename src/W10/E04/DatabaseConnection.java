package W10.E04;

import java.sql.*;
import java.util.Scanner;

public class DatabaseConnection {

    //  You must download the mysql-connector-java.jar from MySQL
    //  homepage in order to use this driver!

    private String driverName = "com.mysql.jdbc.Driver";

    //  TODO CHANGE this!
    private String url =
            "jdbc:mysql://mydb.tamk.fi/"
                    + "dbe4jtimon1"                  // Your database
                    + "?user=e4jtimon"                 // Your login name (foo)
                    + "&password=H4Wo12H8"             // Your mysql pw (bar)
            ;

    /**
     *  Test method to demonstrate JDBC SQL SELECT statement.
     */
    public void showContent() {

        try {

            // Loads the driver
            Class.forName(driverName);

            // Gets a connection to database
            Connection con = DriverManager.getConnection(url);

            // Creates statement and executes query
            String sql = ""
                    + "SELECT    * "
                    + "FROM      employees";

            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            // See document
            // http://java.sun.com/j2se/1.5.0/docs/api/java/sql/ResultSet.html

            // Goes through "firstname" column and prints output
            while (result.next()) {
                String ename = result.getString("NAME");
                System.out.println(ename);
            }

            // Closes all the connections.
            result.close();
            stmt.close();
            con.close();
        }
        catch (Exception e) {  // If something went wrong.
            System.err.println("Exception: " + e.getMessage() );
            e.printStackTrace();
            System.exit(1);
        }
    }

    public int getIndex() {
        int index = 1;

        try {

            // Loads the driver
            Class.forName(driverName);

            // Gets a connection to database
            Connection con = DriverManager.getConnection(url);

            // Creates statement and executes query
            String sql = ""
                    + "SELECT    * "
                    + "FROM      employees";

            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            // See document
            // http://java.sun.com/j2se/1.5.0/docs/api/java/sql/ResultSet.html

            // Goes through "firstname" column and prints output
            while (result.next()) {
                index++;
            }

            // Closes all the connections.
            result.close();
            stmt.close();
            con.close();
        }
        catch (Exception e) {  // If something went wrong.
            System.err.println("Exception: " + e.getMessage() );
            e.printStackTrace();
            System.exit(1);
        }

        return index;

    }

    public void insertToDb(String name) {

        try {

            // Loads the driver
            Class.forName(driverName);

            // Gets a connection to database
            Connection con = DriverManager.getConnection(url);

            // Creates statement and executes query
            String sql = "" +
                    "INSERT INTO employees(ID, NAME)" +
                    " VALUES(" + getIndex() + ", '" + name + "')";

            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);

            System.out.println("Person added to database!");

            // Closes all the connections.
            stmt.close();
            con.close();


        }
        catch (Exception e) {  // If something went wrong.
            System.err.println("Exception: " + e.getMessage() );
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     *  Program start: the main.
     *
     *  @param  args Command line arguments.
     */
    public static void main (String args[]) {
        DatabaseConnection connection = new DatabaseConnection();
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {
            System.out.println("Welcome to emplyee database. Please give command:");
            System.out.println("1. Show employees");
            System.out.println("2. Add employee");
            System.out.println("3. Exit");
            int command = Integer.parseInt(input.nextLine());

            switch (command) {

                case 1:
                    connection.showContent();
                    break;
                case 2:
                    System.out.println("Give name of person:");
                    String name = input.nextLine();
                    connection.insertToDb(name);
                    break;
                case 3:
                    exit = true;
                default:
            }
        }

    }
}