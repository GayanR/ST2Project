/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Reservation.java
 *
 * Created on May 8, 2013, 12:52:57 AM
 */

package homes;

import com.mysql.jdbc.Statement;
import connections.DB_Access;
import connections.DB_connect;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Skynet
 */
public class Reservation extends javax.swing.JFrame {

    /** Creates new form Reservation */
    public Reservation() {
        
        
       initComponents();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd"); //set the Current Date
        Date date = new Date();
        CurrentDate.setText(dateformat.format(date));
       
       jButton3.setEnabled(false);
//          String da = "HH:mm:ss";
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat dateFormat = new SimpleDateFormat(da);
//        Time.setText(dateFormat.format(calendar.getTime()));
        
      //  List_Table();
       
        try {
            new Thread(new Runnable() {             //Set The Current Time

                @Override
                public void run() {
                    while(true){
                    Date d = new Date();
                    String dt = d.toString();
                    String ar[] = dt.split(" ");
                    
                    CurrentTime.setText(ar[3]);
                    
                    } //To change body of generated methods, choose Tools | Templates.
                }
            }).start();
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String Generate_Bill_No(){
            
                String bill_No="R1";
              
               Random obj= new Random(); //create object for random class
               int rgen= obj.nextInt(100); //get random number with in the range of 0-100
               // int rgen1= obj.nextInt(1000);//get random number with in the range of 0-1000
               
                bill_No=bill_No+rgen;   
               
               return bill_No;
    }
//     final void List_Table(){
//        try {
//            ResultSet rst = DB_Access.getData("select table_No, ordered_date, ordered_time from Order6");
//            
//            DefaultTableModel dtm = (DefaultTableModel) Available_Table.getModel();
//            int row = dtm.getRowCount();
//            for(int i=0;i<row;i++){
//                dtm.removeRow(i);
//            }
//            while(rst.next()){
//                Object ob[]={rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)};
//                dtm.addRow(ob);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        OrderedDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        startTime = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CustomerName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TelephoneNo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Description = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AvaTab = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        BillNo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        CurrentTime = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CurrentDate = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        TableNo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setText("Ordered Date");

        OrderedDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderedDateMouseClicked(evt);
            }
        });
        OrderedDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderedDateActionPerformed(evt);
            }
        });

        jLabel4.setText("Ordered Time");

        startTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startTimeMouseClicked(evt);
            }
        });
        startTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTimeActionPerformed(evt);
            }
        });

        jLabel5.setText("Customer Name");

        CustomerName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerNameMouseClicked(evt);
            }
        });
        CustomerName.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                CustomerNameInputMethodTextChanged(evt);
            }
        });

        jLabel6.setText("Telephone no");

        TelephoneNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TelephoneNoMouseClicked(evt);
            }
        });

        jLabel7.setText("Table no");

        jLabel8.setText("Description");

        AvaTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill No", "Table No", "Ordered Date", "Ordered Time", "Customer Name", "Telephone No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(AvaTab);
        AvaTab.getColumnModel().getColumn(0).setResizable(false);

        jLabel3.setText("Reserved Tables Details");

        jLabel9.setText("Current Date");

        jLabel10.setText("Current Time");

        jLabel12.setText("Bill No");

        jButton2.setText("Remove Selected");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Reserve The Table");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        CurrentTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CurrentTime.setText("jLabel11");

        jLabel11.setForeground(new java.awt.Color(244, 11, 11));
        jLabel11.setText("input Ordered Date As    YY-MM-DD");

        CurrentDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CurrentDate.setText("jLabel13");

        jToggleButton1.setText("generate a Bill no");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        TableNo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("RESERVATIONS");

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Desktop\\final12345 project\\src\\homes\\eeeeeeee.jpg")); // NOI18N
        jLabel14.setText("jLabel14");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BillNo)
                                .addComponent(CustomerName)
                                .addComponent(TelephoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(OrderedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TableNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(jToggleButton1))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(Refresh))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(147, 147, 147)
                                    .addComponent(jLabel8)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(85, 85, 85)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel10))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CurrentTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(startTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)
                                .addGap(54, 54, 54)
                                .addComponent(CurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(345, 345, 345)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 157, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(CurrentTime))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(CurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(startTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OrderedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(Refresh))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BillNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jToggleButton1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TelephoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TableNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startTimeActionPerformed

    private void OrderedDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderedDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderedDateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
          try {
            DefaultTableModel AvaTab2 = (DefaultTableModel) AvaTab.getModel();
            Statement s = (Statement) DB_connect.getConnection().createStatement();
            
            String Id=AvaTab2.getValueAt(AvaTab.getSelectedRow(),5).toString();
            
            s.executeUpdate("Delete from reservation where Telephone_No='"+Id+"'");
        
            AvaTab2.removeRow(AvaTab.getSelectedRow());
            
          }catch(Exception e){
          
              e.printStackTrace();
              
          }
        
             try {
//            DefaultTableModel dt = (DefaultTableModel) AvaTab.getModel();
//            dt.removeRow(AvaTab.getSelectedRow());
               
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                if(OrderedDate.getText().equals("") || TelephoneNo.getText().equals("") || CustomerName.getText().equals("") || startTime.getText().equals("")){
                  JOptionPane.showMessageDialog (this, "Input Details", "Error", JOptionPane.ERROR_MESSAGE);}
                else if(TelephoneNo.getText().length()!=10){
                    JOptionPane.showMessageDialog (this, "Check the Telephone No ", "Error", JOptionPane.ERROR_MESSAGE);
                
                }
                else{
         try {
             
            DefaultTableModel AvaTab1 = (DefaultTableModel) AvaTab.getModel();
            Vector v1 = new Vector();
            
            v1.add(BillNo.getText());
            v1.add(TableNo.getSelectedItem());
            v1.add(OrderedDate.getText());         
            v1.add(startTime.getText());
          
            
            v1.add(CustomerName.getText());
            v1.add(TelephoneNo.getText());
            
            
            AvaTab1.addRow(v1);
                   
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        try {
            DefaultTableModel AvaTab2 = (DefaultTableModel) AvaTab.getModel();
            Statement s = (Statement) DB_connect.getConnection().createStatement();
            
            for(int y=0; y<AvaTab.getRowCount();y++){
            
                String s1=AvaTab2.getValueAt(y, 0).toString();
                String s2=AvaTab2.getValueAt(y, 1).toString();
                String s3=AvaTab2.getValueAt(y, 2).toString();
                String s4=AvaTab2.getValueAt(y, 3).toString();
                String s5=AvaTab2.getValueAt(y, 4).toString();
                String s6=AvaTab2.getValueAt(y, 5).toString(); 
          
                
                
          
                s.executeUpdate("insert into Reservation values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')");
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
           
             String OrDate = OrderedDate.getText();
        try {
            
            DefaultTableModel AvaTab2 = (DefaultTableModel) AvaTab.getModel();
            AvaTab2.setRowCount(0);
            Statement s = (Statement) DB_connect.getConnection().createStatement();
            ResultSet rs =s.executeQuery("select * from Reservation where Ordered_Date='"+OrDate+"'");
            
                while(rs.next()){
                
                    Vector v =new Vector(); //Creating a vector Object
                   
                    
                  //  String rk=rs.getString(6);
                    
                  
                    
                    v.add(rs.getString(1)); // Adding Values To the Vector Class
                    v.add(rs.getString(2));
                    v.add(rs.getString(3));
                    v.add(rs.getString(4));
                    v.add(rs.getString(5));
                    v.add(rs.getString(6));
                    
                    AvaTab2.addRow(v);
                    
                    
                }
         }catch(Exception e){
             e.printStackTrace();
         
         }

    }//GEN-LAST:event_RefreshActionPerformed

    private void OrderedDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderedDateMouseClicked
        OrderedDate.setBackground(Color.YELLOW);
    }//GEN-LAST:event_OrderedDateMouseClicked

    private void CustomerNameInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_CustomerNameInputMethodTextChanged
        CustomerName.setBackground(Color.red);
    }//GEN-LAST:event_CustomerNameInputMethodTextChanged

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        BillNo.setText(Generate_Bill_No());
        jButton3.setEnabled(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void CustomerNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerNameMouseClicked
        CustomerName.setBackground(Color.YELLOW);
    }//GEN-LAST:event_CustomerNameMouseClicked

    private void TelephoneNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelephoneNoMouseClicked
        TelephoneNo.setBackground(Color.YELLOW);
    }//GEN-LAST:event_TelephoneNoMouseClicked

    private void startTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startTimeMouseClicked
        startTime.setBackground(Color.YELLOW);
    }//GEN-LAST:event_startTimeMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AvaTab;
    private javax.swing.JTextField BillNo;
    private javax.swing.JLabel CurrentDate;
    private javax.swing.JLabel CurrentTime;
    private javax.swing.JTextField CustomerName;
    private javax.swing.JTextField Description;
    private javax.swing.JTextField OrderedDate;
    private javax.swing.JButton Refresh;
    private javax.swing.JComboBox TableNo;
    private javax.swing.JTextField TelephoneNo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField startTime;
    // End of variables declaration//GEN-END:variables

}
