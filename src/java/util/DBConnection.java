/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dev
 */
public class DBConnection {
    private static final String user = "student_sys";
    private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private final static String password = "123";
    private static Connection conn;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn == null || conn.isClosed()) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }
   
}
