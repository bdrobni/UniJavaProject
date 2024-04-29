/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author B
 */
public class DBConnection {
     private static Connection single_db_instance = null;
    private final static String url = "jdbc:mysql://localhost:3306/hotel";
    private final static String user = "root";
    private final static String password = "";

    private static Connection getSingle_db_instance() {
        return single_db_instance;
    }

    private DBConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            single_db_instance = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getInstance() {
        if (single_db_instance == null) {
            DBConnection d = new DBConnection();
            single_db_instance = d.getSingle_db_instance();
            
        }
        return single_db_instance;
    }
}
