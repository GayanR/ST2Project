/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homes;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import connections.DB_Access;
import connections.DB_connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Skynet
 */
public  class Delivery extends javax.swing.JFrame {
    
    int tableNo=1;
    int billNO;
    double total=0;
    public static String ch;;
   public static String Cus;;
   public static String Addr;;
   public static String Dat;;
   public static String bill;;
   public static String deliveryboy;
   
    /**
     * Creates new form Delivery
     */
    public Delivery() throws SQLException, Exception {
        initComponents();
        jLabel12.setVisible(false);
         
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd"); //set the Current Date
        Date date = new Date();
        Date.setText(dateformat.format(date));
        
         try{
//             DefaultTableModel AvaTab2= (DefaultTableModel) ItemDetails.getModel();
//             ResultSet RS=DB_Access.getData("select * from menu6");
//             while(RS.next()){
//                // RS.getString("");
//             }
             
          ResultSet RS=DB_Access.getData("Select distinct Bill_no from Order6 order by Bill_no desc");
        RS.next();
        billNO=Integer.parseInt(RS.getString(1))+1;
        BillNo.addItem(Integer.toString(billNO));
         RS=DB_Access.getData("Select distinct Bill_no from Order6 order by Bill_no desc");
        while(RS.next()){
            BillNo.addItem(RS.getString(1));
        }
        RS=DB_Access.getData("select Menu_code from menu6");
        while(RS.next()){
            ItemCO.addItem(RS.getString("Menu_code"));
        }
        
       
        String ss="Delivery";
        RS=DB_Access.getData("Select name from employee6 where post='"+ss+"'");
        while(RS.next()){
            DeliveryBoy.addItem(RS.getString(1));
        }
        }
        catch(ClassNotFoundException cnfe){
            
        }
        catch(SQLException sql){
        
        }
         refreshitems();
         resetTable();
    }
    public void refreshitems(){
     String selection=ItemCO.getSelectedItem().toString();
        try{
        ResultSet RS=DB_Access.getData("Select portion,item from Menu6 where Menu_code='"+selection+"' ");
        
        RS.next();
            Portion.setText(RS.getString(1));
            Itname.setText(RS.getString(2));
        RS=DB_Access.getData("Select Quantity from menu6 where Menu_code='"+selection+"' and portion='"+Portion.getText()+"'");
        Quantity.removeAllItems();
        RS.next();
        ResultSet rst=DB_Access.getData("Select order6.Quantity,Menu_code from order6,Menu6 where Bill_no='"+billNO+"' and table_No='"+tableNo+"' and portion='"+Portion.getText()+"' and code=Menu_code");
        if(rst.next()){
            for(int a=-Integer.parseInt(rst.getString(1))+1;a<=Integer.parseInt(RS.getString(1));a++){
                Quantity.addItem(Integer.toString(a));
            }
        }
        else{
            for(int i=1;i<=Integer.parseInt(RS.getString(1));i++){
                Quantity.addItem(Integer.toString(i));
            }
        
        }
           Quantity.addItem(RS.getString(1));
        
        }
        catch(ClassNotFoundException cfne){
        
        }
        catch(SQLException se){
        
        }
    }
    public void deleteItems(String itemSelected){
     try{
        ResultSet RS=DB_Access.getData("Select Quantity from order6 where code='"+itemSelected+"'and Bill_No='"+billNO+"' ");
        RS.next();
        int updateQty=Integer.parseInt(RS.getString(1));
        RS=DB_Access.getData("Select Quantity from menu6 where Menu_code='"+itemSelected+"'");
        RS.next();
        updateQty+=Integer.parseInt(RS.getString(1));
        
        DB_Access.setData("Update menu6 set Quantity='"+updateQty+"' where Menu_code='"+itemSelected+"'");
        DB_Access.setData("Delete from order6 where code='"+itemSelected+"'and Bill_No='"+billNO+"'");
        }
        catch(ClassNotFoundException cfne){
        }
        catch(SQLException se){
            se.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CUstomeName = new javax.swing.JTextField();
        CustomerPhoneNo = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InsertItems = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        DeliveryBoy = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Quantity = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        ItemCO = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        Portion = new javax.swing.JLabel();
        Itname = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        BillNo = new javax.swing.JComboBox();
        Date = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("DELIVERY");

        jLabel2.setText("Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Customer Phone No");

        jLabel5.setText("Address");

        jLabel8.setText("Item Name");

        jLabel9.setText(" Portion");

        jLabel10.setText("Quantity");

        InsertItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "item_code", "unit_price", "quantity", "name", "Portion", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(InsertItems);

        jLabel11.setText("Total :");

        Total.setText("0.00");

        jLabel13.setText("Delivery Boy");

        jButton1.setText("Generate Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add Items");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityActionPerformed(evt);
            }
        });

        jLabel6.setText("Inserted Items");

        jButton3.setText("Remove Selected");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ItemCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCOActionPerformed(evt);
            }
        });

        jLabel7.setText("Item Code");

        Portion.setText("jLabel12");

        Itname.setText("jLabel12");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(93, 93, 93))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(ItemCO, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(Itname)))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(Portion))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(58, 58, 58))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jButton2)
                .addGap(40, 40, 40))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DeliveryBoy, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(jLabel11)
                        .addGap(57, 57, 57)
                        .addComponent(Total))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Portion)
                    .addComponent(Itname)
                    .addComponent(ItemCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(DeliveryBoy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addGap(90, 90, 90))
        );

        jLabel14.setText("Bill No");

        BillNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillNoActionPerformed(evt);
            }
        });

        Date.setText("jLabel12");

        jLabel12.setText("jLabel12");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(BillNo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Address, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(CustomerPhoneNo)
                                    .addComponent(CUstomeName))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(110, 110, 110)
                        .addComponent(Date)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Date)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(BillNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CUstomeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CustomerPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Desktop\\final12345 project\\src\\homes\\eeeeeeee.jpg")); // NOI18N
        jLabel16.setText("jLabel16");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(55, 55, 55)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BillNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillNoActionPerformed
          billNO=Integer.parseInt(BillNo.getSelectedItem().toString());
        Total.setText("0.00");
//       // resetTable();
        
    }//GEN-LAST:event_BillNoActionPerformed
public void resetTable(){
    try{
        total=0;
        ResultSet rst=DB_Access.getData("Select code,Total_price as unitprice,Order6.Quantity,item,portion from Order6,menu6 where Bill_No='"+billNO+"'and code=Menu_Code");
        Vector<String> oneRow ;
            Vector<Vector<String>> allData = new Stack<Vector<String>>();
            Vector<String> Header = new Vector<String>();

            ResultSetMetaData rsmd = (ResultSetMetaData) rst.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            

                Header.add("item_code");
                Header.add("unit_price");
                Header.add("Quantity");
                Header.add("name");
                Header.add("Portion");
               Header.add("sub_total");
           


            while (rst.next()) {

                oneRow = new Stack<String>();
                for (int i = 1; i <= columnsNumber; i++) {

                    oneRow.add(rst.getString(i));
                }
                total+=Integer.parseInt(rst.getString(2))*Integer.parseInt(rst.getString(3));
                oneRow.add(Double.toString(Integer.parseInt(rst.getString(2))*Integer.parseInt(rst.getString(3))));
                
                
                allData.add(oneRow);
                
            }
           // rst=DB_Access.getData("Select SUM(Quantity*Total_price)from order6 where Bill_No='"+billNO+"'");
           // total=Double.parseDouble(rst.getString(1));
            Total.setText(Double.toString(total));
       
           InsertItems.setModel(new javax.swing.table.DefaultTableModel(allData, Header));
        }
        catch(ClassNotFoundException e){
            
        }
        catch(SQLException e){
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         try {
//            DefaultTableModel AvaTabA= (DefaultTableModel) InsertItems.getModel();
//            Vector vs1 = new Vector();
//            vs1.add(ItemCO.getSelectedItem().toString());
//            vs1.add(Itname.getText().toString());         
//            vs1.add(Portion.getText().toString());
//            vs1.add(Quantity.getSelectedItem().toString());
//         
//            AvaTabA.addRow(vs1);
          // resetTable();
           //  refreshitems();
            
       
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
         try{
         ResultSet RS;
          DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
         Date date = new Date();
        String curdate=dateformat.format(date);
        String da = "HH:mm:ss";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(da);
        String curtime=dateFormat.format(calendar.getTime());
           RS=DB_Access.getData("Select price,Quantity from Menu6 where Menu_code='"+ItemCO.getSelectedItem().toString()+"'");
        RS.next();
        int quantity=Integer.parseInt(RS.getString(2));
        double price=Double.parseDouble(RS.getString(1));
        RS=DB_Access.getData("Select Quantity from order6 where code='"+ItemCO.getSelectedItem().toString()+"' and Bill_no='"+billNO+"'");
        if(RS.next()){
            
           DB_Access.setData("Update order6 set Quantity='"+(Integer.parseInt(Quantity.getSelectedItem().toString())+Integer.parseInt(RS.getString(1)))+"' where code='"+ItemCO.getSelectedItem().toString()+"' and Bill_no='"+billNO+"' ");
        }
         else{
        DB_Access.setData("Insert into order6 (code,Bill_No,Total_price,Quantity,table_No,ordered_date,ordered_time) values('"+ItemCO.getSelectedItem().toString()+"','"+billNO+"','"+Double.toString(price)+"','"+Integer.parseInt(Quantity.getSelectedItem().toString())+"','"+tableNo+"','"+curdate+"','"+curtime+"')");
        }
        
        DB_Access.setData("Update menu6 set Quantity='"+(quantity-Integer.parseInt(Quantity.getSelectedItem().toString()))+"' where Menu_code='"+ItemCO.getSelectedItem().toString()+"'");
      
//          
             } catch (Exception e) {
                 e.printStackTrace();
             }
         resetTable();
         refreshitems();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          deleteItems(ItemCO.getSelectedItem().toString());
        resetTable();
        refreshitems();
        resetTable();
        refreshitems();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityActionPerformed


    }//GEN-LAST:event_QuantityActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
//        try {
//            ch=CUstomeName.getText();
//            Cus=CustomerPhoneNo.getText();
//             Addr=Address.getText();
//             Dat=Date.getText();
//             deliveryboy=DeliveryBoy.getSelectedItem().toString();
//            new Generate_BillDelivery().setVisible(true);
//        } catch (SQLException ex) {
//            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
//        }
        if(CUstomeName.getText().equals("") && CustomerPhoneNo.getText().equals("") && Address.getText().equals("") ){
                  JOptionPane.showMessageDialog (this, "Input Details", "Error", JOptionPane.ERROR_MESSAGE);}
        else if(Total.getText().equals("0.0")){
                JOptionPane.showMessageDialog (this, "Please Insert Items", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
//        ItemCO.setVisible(false);
//        Itname.setVisible(false);
//        Portion.setVisible(false);
//        Quantity.setVisible(false);
//        jLabel7.setVisible(false);
//        jLabel8.setVisible(false);
//        jLabel9.setVisible(false);
//        jLabel10.setVisible(false);
//        jButton2.setVisible(false);
//        jLabel13.setVisible(false);
//        jLabel12.setText(BillNo.getSelectedItem().toString());
//        DeliveryBoy.setVisible(false);
//        BillNo.setVisible(false);
            
     //   ItemDetails.setVisible(false);
            
         JOptionPane.showMessageDialog (this, "The Bill is Generated\n Total Price"+total, "Bill", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ItemCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCOActionPerformed
              refreshitems();
    }//GEN-LAST:event_ItemCOActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Delivery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Delivery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Delivery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Delivery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Delivery().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JComboBox BillNo;
    private javax.swing.JTextField CUstomeName;
    private javax.swing.JTextField CustomerPhoneNo;
    private javax.swing.JLabel Date;
    private javax.swing.JComboBox DeliveryBoy;
    private javax.swing.JTable InsertItems;
    private javax.swing.JComboBox ItemCO;
    private javax.swing.JLabel Itname;
    private javax.swing.JLabel Portion;
    private javax.swing.JComboBox Quantity;
    private javax.swing.JLabel Total;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
