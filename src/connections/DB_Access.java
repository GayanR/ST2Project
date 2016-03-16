/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connections;
import java.sql.*;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class DB_Access {
         public static ResultSet getData(String query) throws ClassNotFoundException, SQLException{
             Connection con = DB_connect.getConnection();
             Statement stm = con.createStatement();
             ResultSet rst = stm.executeQuery(query);
             return rst;
             
         }
          public static void setData(String query) throws ClassNotFoundException, SQLException{
             Connection con = DB_connect.getConnection();
             Statement stm = con.createStatement();
             stm.executeUpdate(query);
             
             
         }
         
}
