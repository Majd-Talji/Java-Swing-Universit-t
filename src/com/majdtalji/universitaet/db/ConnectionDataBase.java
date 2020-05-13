
package com.majdtalji.universitaet.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Majd
 */
public class ConnectionDataBase {
    public static Connection getConnection() throws Exception{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/universität", "root", "rootadmin");
        if (con != null) {
            return con;
        }
        return null;
    }
    
    public void closeConnection(Connection con) throws Exception{
        if (con != null) {
            con.close();
        }
    }
}
