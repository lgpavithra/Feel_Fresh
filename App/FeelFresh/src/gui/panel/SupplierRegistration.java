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

/**
 *
 * @author Shanaka
 */
public class SupplierRegistration extends javax.swing.JPanel {

    /**
     * Creates new form SupplierRegistration
     */
      HashMap<String, String> statusMap = new HashMap<>();
    
    public SupplierRegistration() {
        initComponents();
        loadSupplier_ps("first_name", "ASC",jTextField1.getText(),jTextField1.getText());
        jComboBox1.setEnabled(false);
        jButton2.setEnabled(false);
    }

    private void loadSupplier_ps(String column, String orderby,String mobile,String first_name) {

        try {

            ResultSet resultSet = MYSQL.executeSearch("SELECT * FROM `supplier` INNER JOIN `supplier_mobile` ON `supplier`.`id`=`supplier_mobile`.`supplier_id` WHERE `mobile` LIKE '" + mobile + "%'  OR `first_name` LIKE '" + first_name + "%' ORDER BY `" + column + "` " + orderby + "");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("last_name"));
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("supplier_mobile.mobile"));
                vector.add(resultSet.getString("reg_date"));
                vector.add(resultSet.getString("no"));
                vector.add(resultSet.getString("line1"));
                vector.add(resultSet.getString("line2"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
     private void loadStatus_ps(){
    
    try{
    
    Vector vector = new Vector<>();
    vector.add("Select");
    
     ResultSet resultSet = MYSQL.executeSearch("SELECT * FROM `supplier` ");
     
     while(resultSet.next()){
     vector.add(resultSet.getString("status"));
     statusMap.put(resultSet.getString("status"),resultSet.getString("id"));
     }
    
    jComboBox1.setModel(new DefaultComboBoxModel<>(vector));
    
    
    }catch(Exception e){
    e.printStackTrace();
    
    }
    } 
  
   private void filterName() {
      
        int filter = jComboBox2.getSelectedIndex();
        
        if (filter == 0){
          loadSupplier_ps("first_name", "ASC",jTextField1.getText(),jTextField1.getText());
        } else if (filter == 1){
           loadSupplier_ps("first_name", "DESC",jTextField1.getText(),jTextField1.getText());
        } else if (filter == 2){
           loadSupplier_ps("first_name", "ASC",jTextField1.getText(),jTextField1.getText());
        } else if (filter == 3){
           loadSupplier_ps("first_name", "DESC",jTextField1.getText(),jTextField1.getText());
        }
      
      }
         
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        uJTextfield1 = new component.UJTextfield();
        jLabel3 = new javax.swing.JLabel();
        uJTextfield2 = new component.UJTextfield();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        uJTextfield3 = new component.UJTextfield();
        uJTextfield4 = new component.UJTextfield();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        uJTextfield7 = new component.UJTextfield();
        jLabel6 = new javax.swing.JLabel();
        uJTextfield6 = new component.UJTextfield();
        jLabel5 = new javax.swing.JLabel();
        uJTextfield5 = new component.UJTextfield();
        jLabel11 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setText("Supplier Registration");

        jLabel8.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N
        jLabel8.setText("Status");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        jLabel2.setText("First Name");

        uJTextfield1.setBorderColor(new java.awt.Color(153, 153, 153));
        uJTextfield1.setBottom(2);

        jLabel3.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        jLabel3.setText("Last Name");

        uJTextfield2.setBorderColor(new java.awt.Color(153, 153, 153));
        uJTextfield2.setBottom(2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uJTextfield1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uJTextfield2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(uJTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(uJTextfield2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First name", "Last name", "Email", "Mobile", "Regstert", "No", "Line 1", "Line 2", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
        jScrollPane1.setViewportView(jTable1);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(102, 102, 102));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First Name ASC", "First Name DESC", "Last Name ASC", "Last Name DESC" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(242, 242, 242));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        jLabel10.setText("Search By (First Name/Hotline) :");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(3, 0, 10, 10));

        jButton1.setBackground(new java.awt.Color(0, 204, 153));
        jButton1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        jButton2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);

        jButton3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 102));
        jButton3.setText("Clean");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        jLabel4.setText("Email");

        uJTextfield3.setBorderColor(new java.awt.Color(153, 153, 153));
        uJTextfield3.setBottom(2);

        uJTextfield4.setBorderColor(new java.awt.Color(153, 153, 153));
        uJTextfield4.setBottom(2);

        jLabel9.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        jLabel9.setText("Mobile");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(uJTextfield3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uJTextfield4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(uJTextfield3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(uJTextfield4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Address", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        jLabel7.setText("Line 2");

        uJTextfield7.setBorderColor(new java.awt.Color(153, 153, 153));
        uJTextfield7.setBottom(2);

        jLabel6.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        jLabel6.setText("Line 1");

        uJTextfield6.setBorderColor(new java.awt.Color(153, 153, 153));
        uJTextfield6.setBottom(2);

        jLabel5.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        jLabel5.setText("No");

        uJTextfield5.setBorderColor(new java.awt.Color(153, 153, 153));
        uJTextfield5.setBottom(2);
        uJTextfield5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJTextfield5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(uJTextfield5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uJTextfield6, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uJTextfield7, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(uJTextfield5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(uJTextfield6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uJTextfield7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(22, 22, 22))
        );

        jLabel11.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        jLabel11.setText("Order By");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rows = jTable1.getRowCount();
        int id = rows + 1;
        String first_name = uJTextfield1.getText().trim();
        String last_name = uJTextfield2.getText().trim();
        String email = uJTextfield3.getText().trim();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String mobile = uJTextfield4.getText().trim();
        String no = uJTextfield5.getText().trim();
        String line1 = uJTextfield6.getText().trim();
        String line2 = uJTextfield7.getText().trim();

        if (first_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (last_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email address", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+"
                + "(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (no.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address no", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (line1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {

              //  MYSQL.executeIUD("INSERT INTO `supplier`(`first_name`,`last_name`,`email`,`reg_date`,`no`,`line1`,`line2`,`reg_date`,`upd_date`,`status`)VALUES('" + first_name + "','" + last_name + "','" + email + "','" + no + "','" + line1 + "','" + line2 + "','" +date+ "','"+date+"','')");
              //  MYSQL.executeIUD("INSERT INTO `supplier`(`first_name`,`last_name`,`email`,`reg_date`,`no`,`line1`,`line2`,`reg_date`,`status`)VALUES('" + first_name + "','" + last_name + "','" + email + "','" + no + "','" + line1 + "','" + line2 + "','" +date+ "','')");
              MYSQL.executeIUD("INSERT INTO `supplier`(`first_name`,`last_name`,`email`,`no`,`line1`,`line2`,`status`)VALUES('" + first_name + "','" + last_name + "','" + email + "','" + no + "','" + line1 + "','" + line2 + "','Active')");

                MYSQL.executeIUD("INSERT INTO `supplier_mobile`(`supplier_id`,`mobile`)VALUES('" + id + "','" + mobile + "')");
                loadSupplier_ps("first_name", "ASC",jTextField1.getText(),jTextField1.getText());
                reset_ps();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void uJTextfield5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJTextfield5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uJTextfield5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String first_name = uJTextfield1.getText().trim();
        String last_name = uJTextfield2.getText().trim();
        String email = uJTextfield3.getText().trim();
        String mobile = uJTextfield4.getText().trim();
        String no = uJTextfield5.getText().trim();
        String line1 = uJTextfield6.getText().trim();
        String line2 = uJTextfield7.getText().trim();
        String status = String.valueOf(jComboBox1.getSelectedItem());
//        System.out.println(status);

        int row = jTable1.getSelectedRow();

        if (first_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (last_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email address", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+"
                + "(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (no.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address no", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (line1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {

                MYSQL.executeIUD("UPDATE `supplier` SET `first_name`='" + first_name + "',`last_name`='" + last_name + "',`email`='" + email + "',`no`='" + no + "',`line1`='" + line1 + "',`line2`='" + line2 + "',`status`='" + status + "' WHERE `id` = '" + String.valueOf(jTable1.getValueAt(row, 0)) + "'");
                // MYSQL.executeIUD("UPDATE `supplier_mobile` SET `supplier_id`='"+id+"',`mobiler`='"+mobile+"'");
                MYSQL.executeIUD("UPDATE `supplier_mobile` SET `mobile`='" + mobile + "' WHERE `supplier_id` = '" + String.valueOf(jTable1.getValueAt(row, 0)) + "'");
              loadSupplier_ps("first_name", "ASC",jTextField1.getText(),jTextField1.getText());
                reset_ps();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.getClickCount() == 2) {
            jButton2.setEnabled(true);
            jButton1.setEnabled(false);
            jComboBox1.setEnabled(true);
            int row = jTable1.getSelectedRow();
            jTable1.setEnabled(false);

            String first_name = String.valueOf(jTable1.getValueAt(row, 1));
            String last_name = String.valueOf(jTable1.getValueAt(row, 2));
            String email = String.valueOf(jTable1.getValueAt(row, 3));
            String mobile = String.valueOf(jTable1.getValueAt(row, 4));
            String no = String.valueOf(jTable1.getValueAt(row, 6));
            String line1 = String.valueOf(jTable1.getValueAt(row, 7));
            String line2 = String.valueOf(jTable1.getValueAt(row, 8));
            String status = String.valueOf(jTable1.getValueAt(row, 9));

            uJTextfield1.setText(first_name);
            uJTextfield2.setText(last_name);
            uJTextfield3.setText(email);
            uJTextfield4.setText(mobile);
            uJTextfield5.setText(no);
            uJTextfield6.setText(line1);
            uJTextfield7.setText(line2);
            jComboBox1.setSelectedItem(status);
        }

//        if (evt.getClickCount() == 1) {
//            reset_ps();
//        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        reset_ps();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
      //  reset_ps();

    }//GEN-LAST:event_jPanel1MouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
       filterName();
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
         filterName();
         
    }//GEN-LAST:event_jTextField1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private component.UJTextfield uJTextfield1;
    private component.UJTextfield uJTextfield2;
    private component.UJTextfield uJTextfield3;
    private component.UJTextfield uJTextfield4;
    private component.UJTextfield uJTextfield5;
    private component.UJTextfield uJTextfield6;
    private component.UJTextfield uJTextfield7;
    // End of variables declaration//GEN-END:variables

    private void reset_ps() {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        jButton1.setEnabled(true);
        jComboBox1.setEnabled(false);
        jButton2.setEnabled(false);
        jTable1.setEnabled(true);
        uJTextfield1.setText("");
        uJTextfield2.setText("");
        uJTextfield3.setText("");
        uJTextfield4.setText("");
        uJTextfield5.setText("");
        uJTextfield6.setText("");
        uJTextfield7.setText("");
        jComboBox1.setSelectedIndex(0);
        uJTextfield1.grabFocus();
        jTable1.clearSelection();
        jTextField1.setText("");
         loadSupplier_ps("first_name", "ASC",jTextField1.getText(),jTextField1.getText());
         int index = 0;
          jComboBox2.setSelectedIndex(index);
         
    }
}
