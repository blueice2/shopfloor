/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopfloor;

import java.sql.DriverManager;

/**
 *
 * @author NNAMDI
 */
// Inserts and updates data into the various mysql tables. It's database is shopfloor.
import java.sql.*;
import static shopfloor.Shopfloor.internal_audit;

public class Insert {

    static Connection conn;
    static boolean state;
    static ResultSet rs;

    public static void main(String[] args) {
        // How to use the various methods

        /**
         * insert_store_handler("02/01/2019", "38/D","Production", "Oluwole
         * Andrew","1000", "100"
            );*
         */
        /**
         * insert_internal_audit_first("02/01/2019", "Oluwole Monday
         * Andrew","100", "100","100", "39/D", "100", "No balance","CP",
         * "1000","True", "False"
            );*
         */
        /**
         * insert_internal_audit_second("02/01/2019", "Seun Osewa","100", "100"
         * ,"100", "40/D", "Back", "1000" , "100" ,"100"
            );*
         */
        /**
         * insert_production_screen("41/D", "200" ,"10" , "Ola Osewa","Seun
         * Osewa", "Back","1000" ,"04/02/2019");
   *
         */
        insert_msc("05/02/2019", "Bian Osewa", "100",
                "Seun Olubaba", "Balanced", "200", "42/D", "CP",
                "1000", "200", "Olam Osewa");

    }

    // Creates the connection to the database
    public static void create_mysql_connection() {
        try {
            //Select a jdbc driver which was added to the class path
            Class.forName("com.mysql.jdbc.Driver");

            //select the database - shop_floor
            String myUrl = "jdbc:mysql://localhost/shop_floor";

            //Create the connection
            conn = DriverManager.getConnection(myUrl, "root", "");

        } catch (Exception e) {
            System.err.println("Got an exception");
            System.err.println(e.getMessage());
        }

    }// End of create_mysql_connection()

    
    //Retrieve all the dates in internal audit
    public static ResultSet retrieve_internal_audit_date() {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `audit_second` group by date having date = max(date) ";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all the dates in internal audit
    
        // Retrieve all internal audit data
    public static ResultSet retrieve_all_internal_audit_data(String date) {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `audit_second` where date = ? order by batch_number";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, date);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all internal audit data 
    
    // Retrieve all internal audit data using batch number
    public static ResultSet retrieve_all_internal_audit_data_using_batch_number(String batch_number) {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `audit_second` where batch_number = ? order by batch_number";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, batch_number);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all internal audit data using batch number
    
    
    //Retrieve all the dates in audit
    public static ResultSet retrieve_audit_date() {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `audit_first` group by date having date = max(date) ";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all the dates in audit

    // Retrieve all audit data
    public static ResultSet retrieve_all_audit_data(String date) {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `audit_first` where date = ? order by batch_number";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, date);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all audit data 

        // Retrieve all audit data
    public static ResultSet retrieve_all_audit_data_using_batch_number(String batch_number) {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `audit_first` where batch_number = ? order by batch_number";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, batch_number);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all audit data 
    
    
    public static void insert_internal_audit_first(String date, String audit_personnel, String waste_verified_removed,
            String quantity_to_counter, String production_reamage_claimed, String batch_number,
            String count_number, String reason_for_count, String print_type,
            String denomination, String balanced, String unbalanced
    ) {
        // For inserting from the first audit form into the database i.e. audit_screen
        try {
            //create a mysql connection
            create_mysql_connection();

            String dates = date;
            String audit_personnels = audit_personnel;
            String waste_verified_removeds = waste_verified_removed;
            String quantity_to_counters = quantity_to_counter;
            String production_reamage_claimeds = production_reamage_claimed;
            String batch_numbers = batch_number;

            String count_numbers = count_number;
            String reason_for_counts = reason_for_count;
            String print_types = print_type;
            String denominations = denomination;
            String balanceds = balanced;
            String unbalanceds = unbalanced;
            //create a mysql connection

            // Sql query
            String query = "insert into audit_first (date,audit_personnel,waste_verified_removed,quantity_to_counter,production_reamage_claimed,batch_number,count_number,reason_for_count,print_type,denomination,balanced,unbalanced)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, dates);
            preparedStmt.setString(2, audit_personnels);
            preparedStmt.setString(3, waste_verified_removeds);
            preparedStmt.setString(4, quantity_to_counters);
            preparedStmt.setString(5, production_reamage_claimeds);
            preparedStmt.setString(6, batch_numbers);

            preparedStmt.setString(7, count_numbers);
            preparedStmt.setString(8, reason_for_counts);
            preparedStmt.setString(9, print_types);
            preparedStmt.setString(10, denominations);
            preparedStmt.setString(11, balanceds);
            preparedStmt.setString(12, unbalanceds);

            preparedStmt.execute();
            conn.close();

        } catch (Exception e) {
            System.err.println("Got an exception");
            System.err.println(e.getMessage());
        }

    } //End of insert_internal_audit_first

    //Retrieve all the dates in store
    public static ResultSet retrieve_store_date() {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `store_handler` group by date having date = max(date) ";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all the dates in store

    // Retrieve all store data
    public static ResultSet retrieve_all_store_data(String date) {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `store_handler` where date = ? order by batch_number";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, date);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all store data 

    public static boolean insert_internal_audit_second(String date, String audit_staff, String actual_quantity,
            String removed, String reason_for_count, String batch_number,
            String print_type, String denomination, String count_number, String reamage_from_msc_claimed
    ) {
        // For inserting from the second audit form into the database i.e. internal_audit_screen

        // For inserting from the first audit form into the database i.e. audit_screen
        try {
            //create a mysql connection
            create_mysql_connection();

            String dates = date;
            String audit_staffs = audit_staff;
            String actual_quantitys = actual_quantity;
            String removeds = removed;
            String reason_for_counts = reason_for_count;
            String batch_numbers = batch_number;

            String print_types = print_type;
            String denominations = denomination;
            String count_numbers = count_number;
            String reamage_from_msc_claimeds = reamage_from_msc_claimed;

            // Sql query
            String query = "insert into audit_second (date,audit_staff,actual_quantity,removed,reason_for_count,batch_number,print_type, denomination, count_number,reamage_from_msc_claimed)"
                    + "values (?,?,?,?,?,?,?,?,?,?)";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, dates);
            preparedStmt.setString(2, audit_staffs);
            preparedStmt.setString(3, actual_quantitys);
            preparedStmt.setString(4, removeds);
            preparedStmt.setString(5, reason_for_counts);
            preparedStmt.setString(6, batch_numbers);

            preparedStmt.setString(7, print_types);
            preparedStmt.setString(8, denominations);
            preparedStmt.setString(9, count_numbers);
            preparedStmt.setString(10, reamage_from_msc_claimeds);

            preparedStmt.execute();
            conn.close();

            state = true;

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());
            internal_audit.jTextArea2.setText(date + "  " + e.getMessage());
            state = false;
        }
        return state;
    } //End of insert_internal_audit_second

    public static boolean insert_store_handler(String date, String batch_number, String department,
            String staff_name, String denomination, String batch_quantity
    ) {
        // For inserting from the store handler form into the database i.e. store_handler 
        try {
            //create a mysql connection
            create_mysql_connection();

            String dates = date;
            String batch_numbers = batch_number;
            String departments = department;
            String staff_names = staff_name;
            String denominations = denomination;
            String batch_quantitys = batch_quantity;

            // Sql query
            String query = "insert into store_handler (date,batch_number,department,staff_name,denomination,batch_quantity)"
                    + "values (?,?,?,?,?,?)";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, dates);
            preparedStmt.setString(2, batch_numbers);
            preparedStmt.setString(3, departments);
            preparedStmt.setString(4, staff_names);
            preparedStmt.setString(5, denominations);
            preparedStmt.setString(6, batch_quantitys);

            preparedStmt.execute();
            conn.close();

            state = true;
        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());
            internal_audit.jTextArea2.setText(date + "  " + e.getMessage());
            state = false;
        }
        return state;
    }// End of insert_store_handler()

    //Retrieve batch number available
    public static ResultSet retrieve_batch_number() {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `store_handler` ";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve batch number

    public static boolean insert_production_screen(String batch_number, String quantity_reamage, String waste_generated,
            String head_minder, String production_supervisor, String print_type, String denomination, String date) {
        // For inserting from the production screen form into the database i.e. production_screen
        try {
            //create a mysql connection
            create_mysql_connection();

            String batch_numbers = batch_number;
            String quantity_reamages = quantity_reamage;
            String waste_generateds = waste_generated;
            String head_minders = head_minder;
            String production_supervisors = production_supervisor;
            String print_types = print_type;

            String denominations = denomination;
            String dates = date;

            // Sql query
            String query = "insert into production (batch_number,quantity_reamage,waste_generated,head_minder,production_supervisor,print_type,denomination,date)"
                    + "values (?,?,?,?,?,?,?,?)";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, batch_numbers);
            preparedStmt.setString(2, quantity_reamages);
            preparedStmt.setString(3, waste_generateds);
            preparedStmt.setString(4, head_minders);
            preparedStmt.setString(5, production_supervisors);
            preparedStmt.setString(6, print_types);
            preparedStmt.setString(7, denominations);
            preparedStmt.setString(8, dates);

            preparedStmt.execute();
            conn.close();

            state = true;

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());
            internal_audit.jTextArea2.setText(date + "  " + e.getMessage());
            state = false;
        }
        return state;
    } // End of insert_production_screen

    public static void insert_msc(String date, String counter_name, String qty_counted,
            String officer_name, String reason_for_count, String reamage_from_audit_claimed, String batch_number, String print_type,
            String denomination, String count_number, String production_supervisor) {
        // For inserting from the first audit form into the database i.e. audit_screen

        try {
            //create a mysql connection
            create_mysql_connection();

            String dates = date;
            String counter_names = counter_name;
            String qty_counteds = qty_counted;
            String officer_names = officer_name;
            String reason_for_counts = reason_for_count;
            String reamage_from_audit_claimeds = reamage_from_audit_claimed;

            String batch_numbers = batch_number;
            String print_types = print_type;
            String denominations = denomination;
            String count_numbers = count_number;
            String production_supervisors = production_supervisor;

            // Sql query
            String query = "insert into msc (date,counter_name,qty_counted,officer_name,reason_for_count,reamage_from_audit_claimed,batch_number,print_type,denomination,count_number,production_supervisor)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, dates);
            preparedStmt.setString(2, counter_names);
            preparedStmt.setString(3, qty_counteds);
            preparedStmt.setString(4, officer_names);
            preparedStmt.setString(5, reason_for_counts);
            preparedStmt.setString(6, reamage_from_audit_claimeds);
            preparedStmt.setString(7, batch_numbers);
            preparedStmt.setString(8, print_types);

            preparedStmt.setString(9, denominations);
            preparedStmt.setString(10, count_numbers);
            preparedStmt.setString(11, production_supervisors);

            preparedStmt.execute();
            conn.close();

        } catch (Exception e) {
            System.err.println("Got an exception");
            System.err.println(e.getMessage());
        }
    }

    
    
    //Retrieve all the dates in msc
    public static ResultSet retrieve_msc_date() {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `msc` group by date having date = max(date) ";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all the dates in msc
    
        // Retrieve all  msc data
    public static ResultSet retrieve_all_msc_data(String date) {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `msc` where date = ? order by batch_number";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, date);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all msc
    
    // Retrieve all msc data using batch number
    public static ResultSet retrieve_all_msc_data_using_batch_number(String batch_number) {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `msc` where batch_number = ? order by batch_number";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, batch_number);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all msc data using batch number
    
    
    //Retrieve all the dates in production
    public static ResultSet retrieve_production_date() {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `production` group by date having date = max(date) ";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all the dates in production
    
        // Retrieve all production data
    public static ResultSet retrieve_all_production_data(String date) {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `production` where date = ? order by batch_number";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, date);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all production data 
    
    // Retrieve all production data using batch number
    public static ResultSet retrieve_all_production_data_using_batch_number(String batch_number) {

        try {
            //create a mysql connection
            create_mysql_connection();

            // Sql query
            String query = "SELECT * FROM `production` where batch_number = ? order by batch_number";

            // Use prepared statement to set the ball roling
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, batch_number);

            rs = preparedStmt.executeQuery();
            state = true;
            //conn.close();

        } catch (Exception e) {

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

            state = false;
        };
        return rs;

    } //End of retrieve all production data using batch number
    
    
}
