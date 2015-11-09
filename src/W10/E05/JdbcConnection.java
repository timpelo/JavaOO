package W10.E05;

import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

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
                        + "dbe4jtimon1"                //database
                        + "?user=e4jtimon"             //user
                        + "&password=H4Wo12H8"         //password
                ;

        // Loads the driver
        Class.forName(driverName);

        // Gets a connection to database
        con = DriverManager.getConnection(url);

        // Creates JdbcRowset
        jdbcRs = new JdbcRowSetImpl(con);
    }

    public String[][] getNames() throws SQLException{
        String[][] nameArray = new String[getIndex()][getIndex()];
        int index = 0;

        jdbcRs.setCommand("SELECT * FROM employees");
        jdbcRs.execute();

        while (jdbcRs.next()) {
            nameArray[index][0] = jdbcRs.getString(1);
            nameArray[index][1] = jdbcRs.getString(2);
            index++;
        }

        return  nameArray;

    }

    public void insertName(String name) throws SQLException{
        int index = getIndex();

        if(name.trim().length() > 3) {
            jdbcRs.moveToInsertRow();
            jdbcRs.updateInt("ID", index);
            jdbcRs.updateString("NAME", name);
            jdbcRs.insertRow();
        }
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
