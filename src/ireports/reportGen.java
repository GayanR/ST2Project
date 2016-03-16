/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ireports;

import connections.DB_connect;
import java.awt.Container;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import org.apache.commons.collections.map.HashedMap;

/**
 *
 * @author Dell
 */
public class reportGen extends JFrame {
   public reportGen(String filename, HashMap sh) throws JRException {
       if(sh==null)
       {
           try {
           Connection con = DB_connect.getConnection();
           JasperPrint print = JasperFillManager.fillReport(filename,null,con);
           JRViewer jr = new JRViewer(print);
           Container contain = getContentPane();
           contain.add(jr);
           setVisible(true);
           setBounds(10, 10, 800,600);
           
           
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(reportGen.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(reportGen.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
       else{
           
           try {
           Connection con = DB_connect.getConnection();
           JasperPrint print = JasperFillManager.fillReport(filename,sh,con);
           JRViewer jr = new JRViewer(print);
           Container contain = getContentPane();
           contain.add(jr);
           setVisible(true);
           setBounds(10, 10, 800,600);
           
           
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(reportGen.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(reportGen.class.getName()).log(Level.SEVERE, null, ex);
       }
     }
   } 
   
   public void nreport(String filename) throws JRException
   {
       try {
           Connection con = DB_connect.getConnection();
           JasperPrint print = JasperFillManager.fillReport(filename,null,con);
           JRViewer jr = new JRViewer(print);
           Container contain = getContentPane();
           contain.add(jr);
           setVisible(true);
           setBounds(10, 10, 800,600);
           
           
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(reportGen.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(reportGen.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public void reportComGen(String filename, HashMap type) throws JRException {
       try {
           Connection con = DB_connect.getConnection();
           JasperPrint print = JasperFillManager.fillReport(filename,type,con);
           JRViewer jr = new JRViewer(print);
           Container contain = getContentPane();
           contain.add(jr);
           setVisible(true);
           setBounds(10, 10, 800,600);
           
           
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(reportGen.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(reportGen.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
}
