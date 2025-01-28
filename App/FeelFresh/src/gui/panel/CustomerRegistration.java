/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.panel;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MYSQL;


public class CustomerRegistration extends javax.swing.JPanel {

   HashMap<String,String> statusMap = new HashMap<>();
   
    public CustomerRegistration() {
        initComponents();
        loadCustomer_ps();
    }

//    private void loadStatus_ps(){
//    
//    try{
//    
//    Vector vector = new Vector<>();
//    vector.add("Select");
//    
//     ResultSet resultSet = MYSQL.executeSearch("SELECT * FROM `status`");
//     
//     while(resultSet.next()){
//     vector.add(resultSet.getString("name"));
//     statusMap.put(resultSet.getString("name"),resultSet.getString("id"));
//     }
//    
//    jComboBox1.setModel(new DefaultComboBoxModel<>(vector));
//    
//    
//    }catch(Exception e){
//    e.printStackTrace();
//    
//    }
//    } 
    
    
     private void loadCustomer_ps() {
   
     try{
     
       ResultSet resultSet = MYSQL.executeSearch("SELECT * FROM `customer`INNER JOIN `customer_mobile` ON `customer`.`nic`=`customer_mobile`.`customer_nic`");
     
      DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
      model.setRowCount(0);
     
      while (resultSet.next()){
      Vector<String> vector = new Vector<>();
       vector.add(resultSet.getString("nic"));
       vector.add(resultSet.getString("first_name"));
       vector.add(resultSet.getString("last_name"));
       vector.add(resultSet.getString("email"));
       vector.add(resultSet.getString("no"));
       vector.add(resultSet.getString("line1"));
       vector.add(resultSet.getString("line2"));
       vector.add(resultSet.getString("customer_mobile.mobile_number"));
       vector.add(resultSet.getString("reg_date"));
       vector.add(resultSet.getString("upd_date"));
       vector.add(resultSet.getString("gender"));
       vector.add(resultSet.getString("status"));
        
       model.addRow(vector);
       
      }
      
     }catch(Exception e){
      e.printStackTrace();
     }
   
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uJTextfield1 = new component.UJTextfield();
        jLabel3 = new javax.swing.JLabel();
        uJTextfield2 = new component.UJTextfield();
        jLabel4 = new javax.swing.JLabel();
        uJTextfield3 = new component.UJTextfield();
        jLabel5 = new javax.swing.JLabel();
        uJTextfield4 = new component.UJTextfield();
        jLabel6 = new javax.swing.JLabel();
        uJTextfield5 = new component.UJTextfield();
        jLabel7 = new javax.swing.JLabel();
        uJTextfield6 = new component.UJTextfield();
        jLabel8 = new javax.swing.JLabel();
        uJTextfield7 = new component.UJTextfield();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        uJTextfield8 = new component.UJTextfield();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setText("Customer Registration");

        jLabel2.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel2.setText("NIC");

        jLabel3.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel6.setText("No");

        jLabel7.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel7.setText("Line 1");

        jLabel8.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel8.setText("Line 2");

        jButton1.setBackground(new java.awt.Color(0, 204, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Mobile");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(uJTextfield1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(uJTextfield2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(uJTextfield3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(uJTextfield4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(33, 33, 33)
                                .addComponent(uJTextfield5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(uJTextfield7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(uJTextfield6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(uJTextfield8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(uJTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(uJTextfield5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(uJTextfield2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(uJTextfield6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(uJTextfield3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(uJTextfield7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(uJTextfield4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(uJTextfield8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nic", "first name", "last name", "email", "no", "line1", "line2", "reg_date", "upd_date", "mobile", "gender", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String nic = uJTextfield1.getText().trim();
        String first_name = uJTextfield2.getText().trim();
        String last_name = uJTextfield3.getText().trim();
        String email = uJTextfield4.getText().trim();
        String date =  new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String no = uJTextfield5.getText().trim();
        String line1 = uJTextfield6.getText().trim();
        String line2= uJTextfield7.getText().trim();
        String mobile= uJTextfield8.getText().trim();
        

        if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter NIC", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (first_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (last_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email address", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+"
                    + "(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
                JOptionPane.showMessageDialog(this, "Please enter valid Invalid email", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (no.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address no", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (line1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
                JOptionPane.showMessageDialog(this, "Please enter valid mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
               try {
               ResultSet rs  =  MYSQL.executeSearch("SELECT * FROM `customer`WHERE `nic`='"+nic+"'");
           
                if(rs.next()){
                JOptionPane.showMessageDialog(this, "you are already registered", "Warning", JOptionPane.WARNING_MESSAGE);           
                }else{
                MYSQL.executeIUD("INSERT INTO `customer`(`nic`,`first_name`,`last_name`,`email`,`reg_date`,`no`,`line1`,`line2`)VALUES('"+ nic +"','" + first_name + "','"+ last_name +"','"+ email +"','"+ date +"','"+ no +"','"+ line1 +"','"+ line2 +"')");
                
                MYSQL.executeIUD("INSERT INTO `customer_mobile`(`customer_nic`,`mobile_number`,`create_at`)VALUES('"+nic+"','"+mobile+"','"+date+"')");
                        
                loadCustomer_ps();
                reset_ps();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          String nic = uJTextfield1.getText().trim();
        String first_name = uJTextfield2.getText().trim();
        String last_name = uJTextfield3.getText().trim();
        String email = uJTextfield4.getText().trim();
        String up_date =  new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String no = uJTextfield5.getText().trim();
        String line1 = uJTextfield6.getText().trim();
        String line2= uJTextfield7.getText().trim();
        String mobile= uJTextfield8.getText().trim();
        
           int row   =  jTable1.getSelectedRow();
        
        if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter NIC", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (first_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (last_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email address", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+"
                    + "(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
                JOptionPane.showMessageDialog(this, "Please enter valid Invalid email", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (no.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address no", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (line1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
                JOptionPane.showMessageDialog(this, "Please enter valid mobile", "Warning", JOptionPane.WARNING_MESSAGE); 
        }else {
         
            try{
                MYSQL.executeIUD("UPDATE `customer` SET  `first_name`='"+first_name+"',`last_name`='"+last_name+"',`email`='"+email+"',`no`='"+no+"',`line1`='"+line1+"',`line2`='"+line2+"',`upd_date`='"+up_date+"'WHERE `nic` = '"+String.valueOf(jTable1.getValueAt(row ,0))+"' ");
                MYSQL.executeIUD("UPDATE `customer_mobile` SET  `mobile_number`='"+mobile+"',`update_at`='"+up_date+"'");
                
                loadCustomer_ps();
                reset_ps();
            }catch(Exception e){
            e.printStackTrace();
            }
        
        
        
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         int row = jTable1.getSelectedRow();
        
        String nic = String.valueOf(jTable1.getValueAt(row ,0));
        String fname = String.valueOf(jTable1.getValueAt(row ,1));
        String lname = String.valueOf(jTable1.getValueAt(row ,2));
        String email = String.valueOf(jTable1.getValueAt(row ,3));
        String no = String.valueOf(jTable1.getValueAt(row ,4));
        String line1 = String.valueOf(jTable1.getValueAt(row ,5));
        String line2 = String.valueOf(jTable1.getValueAt(row ,6));
        String mobile = String.valueOf(jTable1.getValueAt(row ,7));
           if (evt.getClickCount() == 2) {
               
                jButton1.setEnabled(false);
               
               
                uJTextfield1.setText(nic);
                uJTextfield2.setText(fname);
                uJTextfield3.setText(lname);
                uJTextfield4.setText(email);
                uJTextfield5.setText(no);
                uJTextfield6.setText(line1);
                uJTextfield7.setText(line2);
                uJTextfield8.setText(mobile);
                uJTextfield1.setEditable(false);
                
              
              
           }
        
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private component.UJTextfield uJTextfield1;
    private component.UJTextfield uJTextfield2;
    private component.UJTextfield uJTextfield3;
    private component.UJTextfield uJTextfield4;
    private component.UJTextfield uJTextfield5;
    private component.UJTextfield uJTextfield6;
    private component.UJTextfield uJTextfield7;
    private component.UJTextfield uJTextfield8;
    // End of variables declaration//GEN-END:variables

    private void reset_ps() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        uJTextfield1.setText("");
        uJTextfield2.setText("");
        uJTextfield3.setText("");
        uJTextfield4.setText("");
        uJTextfield5.setText("");
        uJTextfield6.setText("");
        uJTextfield7.setText("");
        uJTextfield7.setText("");
        uJTextfield8.setText("");
        
        uJTextfield1.grabFocus();
    
    }

    
}
