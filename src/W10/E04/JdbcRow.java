package W10.E04;


import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

/**
 * Created by Jani on 6/11/2015.
 */
public class JdbcRow {

    public static void main(String[] args) {
        boolean exit = false;
        Scanner input = new Scanner(System.in);
        JdbcConnection database = null;

        try {
            database = new JdbcConnection();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        while(!exit && database != null) {
            System.out.println("Welcome to emplyee database. Please give command:");
            System.out.println("1. Show employees");
            System.out.println("2. Add employee");
            System.out.println("3. Exit");
            int command = Integer.parseInt(input.nextLine());

            try {
                switch (command) {

                    case 1:
                        database.printNames();
                        break;
                    case 2:
                        System.out.println("Give name of person:");
                        String name = input.nextLine();
                        database.insertName(name);
                        break;
                    case 3:
                        exit = true;
                    default:
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }
}
