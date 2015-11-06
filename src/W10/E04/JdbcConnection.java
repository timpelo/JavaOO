package W10.E04;

import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Jani on 6/11/2015.
 */
public class JdbcConnection{

    JdbcRowSet jdbcRs;
    Connection con;

    public JdbcConnection() throws SQLException, ClassNotFoundException{
        String driverName = "com.mysql.jdbc.Driver";

        //  url info for db connection
        String url =
                "jdbc:mysql://mydb.tamk.fi/"
                        + "dbe4jtimon1"                  // Your database
                        + "?user=e4jtimon"                 // Your login name (foo)
                        + "&password=H4Wo12H8"             // Your mysql pw (bar)
                ;

        // Loads the driver
        Class.forName(driverName);

        // Gets a connection to database
        con = DriverManager.getConnection(url);

        // Creates JdbcRowset
        jdbcRs = new JdbcRowSetImpl(con);
    }

    public void printNames() throws SQLException{

        jdbcRs.setCommand("SELECT * FROM employees");
        jdbcRs.execute();

        while (jdbcRs.next()) {
            System.out.println(jdbcRs.getString(2));
        }

    }

    public void insertName(String name) throws SQLException{
        int index = getIndex();

        jdbcRs.moveToInsertRow();
        jdbcRs.updateInt("ID", index);
        jdbcRs.updateString("NAME", name);
        jdbcRs.insertRow();
    }

    private int getIndex() throws SQLException{
        int index = 1;

        jdbcRs.setCommand("SELECT * FROM employees");
        jdbcRs.execute();

        while (jdbcRs.next()) {
            index++;
        }

        return index;
    }

    public void closeConnection() throws SQLException{
        jdbcRs.close();
        con.close();
    }
}
