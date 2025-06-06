/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.panel;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MYSQL;

/**
 *
 * @author Shanaka
 */
public class addProduct extends javax.swing.JPanel {

    HashMap<String, String> brandMap = new HashMap<>();
    HashMap<String, String> categoryMap = new HashMap<>();

    public addProduct() {
        initComponents();
        loadCategories();
        loadBrand();
        loadProducts_PS("product`.`name", "ASC");
      
    }

    private void loadCategories() {

        try {

            Vector vector = new Vector<>();
            vector.add("Select");

            ResultSet resultSet = MYSQL.executeSearch("SELECT * FROM `category`");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                categoryMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            jComboBox2.setModel(new DefaultComboBoxModel<>(vector));

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void loadBrand() {

        try {

            Vector vector = new Vector<>();
            vector.add("Select");

            ResultSet resultSet = MYSQL.executeSearch("SELECT * FROM `brand`");
            //ResultSet resultSet = MYSQL.executeSearch("SELECT * FROM `brand` ");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                brandMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            jComboBox1.setModel(new DefaultComboBoxModel<>(vector));

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
//   

   
    private void loadProducts_PS(String column, String orderby) {
        try {

            ResultSet resultSet = MYSQL.executeSearch("SELECT * FROM `product` INNER JOIN `category` ON `product`.`category_id`=`category`.`id` "
                    + "LEFT JOIN `brand` ON `brand`.`id`=`product`.`brand_id`  ORDER BY `"+ column +"` " + orderby + "");
           

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("product.name"));
                vector.add(resultSet.getString("category.name"));
                vector.add(resultSet.getString("brand.name"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void filterName() {

        int filter = jComboBox3.getSelectedIndex();

        if (filter == 0) {
            loadProducts_PS("product`.`name", "ASC");
          
        } else if (filter == 1) {
             loadProducts_PS("product`.`name", "DESC");
           
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        uJTextfield1 = new component.UJTextfield();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(594, 241));

        jLabel2.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel3.setText("Brand");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel4.setText("Category");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        uJTextfield1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJTextfield1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setText("Product Registration");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addGap(27, 27, 27)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(uJTextfield1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(19, 19, 19)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(uJTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "category", "brand"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name ASC", "Name DESC", " " }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = uJTextfield1.getText();
        String brand = String.valueOf(jComboBox1.getSelectedItem());
        String category = String.valueOf(jComboBox2.getSelectedItem());

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter roduct name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (brand.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select brand", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (category.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select category", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {

                MYSQL.executeIUD("INSERT INTO `product`(`name`,`brand_id`,`category_id`)VALUES('" + name + "','" + brandMap.get(brand) + "','" + categoryMap.get(category) + "')");
                  loadProducts_PS("product`.`name", "ASC");
               
              
                reset_PS();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void uJTextfield1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJTextfield1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uJTextfield1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String name = uJTextfield1.getText();
        String category = String.valueOf(jComboBox2.getSelectedItem());
        String brand = String.valueOf(jComboBox1.getSelectedItem());
        int row = jTable1.getSelectedRow();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter roduct name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (brand.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select brand", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (category.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select category", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {

                MYSQL.executeIUD("UPDATE `product` SET `name`='" + name + "',`category_id`='" + categoryMap.get(category) + "',`brand_id`='" + brandMap.get(brand) + "' WHERE `id` = '" + String.valueOf(jTable1.getValueAt(row, 0)) + "'  ");
//                loadProducts_PS(product`.`name, brand);
                reset_PS();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jButton1.setEnabled(false);
        int row = jTable1.getSelectedRow();

        // String id = String.valueOf(jTable1.getValueAt(row ,0));
        String name = String.valueOf(jTable1.getValueAt(row, 1));
        String category = String.valueOf(jTable1.getValueAt(row, 2));
        String brand = String.valueOf(jTable1.getValueAt(row, 3));

        uJTextfield1.setText(name);
        //uJTextfield1.setEditable(false);
        jComboBox2.setSelectedItem(category);
        jComboBox1.setSelectedItem(brand);


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset_PS();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        filterName();
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
    
    }//GEN-LAST:event_jComboBox3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private component.UJTextfield uJTextfield1;
    // End of variables declaration//GEN-END:variables
private void reset_PS() {
        jButton1.setEnabled(true);
        uJTextfield1.setText("");
        jComboBox2.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);
        uJTextfield1.grabFocus();
        uJTextfield1.setEditable(true);
        loadProducts_PS("product`.`name", "ASC");
       
    }

}
