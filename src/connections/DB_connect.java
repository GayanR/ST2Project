/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connections;
import java.sql.*;

//import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class DB_connect    {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "root");
        return conn;
    }
}
