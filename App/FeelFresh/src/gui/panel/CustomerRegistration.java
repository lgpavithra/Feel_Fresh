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
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MYSQL;

public class CustomerRegistration extends javax.swing.JPanel {

    HashMap<String, String> statusMap = new HashMap<>();

    public CustomerRegistration() {
        initComponents();
        loadCustomer_ps("first_name", "ASC", jTextField1.getText(), jTextField1.getText());
        //loadStatus_ps();
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
//    
    private void loadCustomer_ps(String column, String orderby, String mobile, String nic) {

        try {

            ResultSet resultSet = MYSQL.executeSearch("SELECT * FROM `customer`INNER JOIN `customer_mobile` ON `customer`.`nic`=`customer_mobile`.`customer_nic` WHERE `customer_mobile`.`mobile_number` LIKE '" + mobile + "%' OR `nic` LIKE '" + nic + "%' ORDER BY `" + column + "` " + orderby + "");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("nic"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("last_name"));
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("no"));
                vector.add(resultSet.getString("line1"));
                vector.add(resultSet.getString("line2"));
                vector.add(resultSet.getString("reg_date"));
                vector.add(resultSet.getString("upd_date"));
                vector.add(resultSet.getString("customer_mobile.mobile_number"));
                vector.add(resultSet.getString("gender"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void filterName() {

        int filter = jComboBox2.getSelectedIndex();

        if (filter == 0) {
            loadCustomer_ps("first_name", "ASC", jTextField1.getText(), jTextField1.getText());
        } else if (filter == 1) {
            loadCustomer_ps("first_name", "DESC", jTextField1.getText(), jTextField1.getText());
        } else if (filter == 2) {
            loadCustomer_ps("last_name", "ASC", jTextField1.getText(), jTextField1.getText());
        } else if (filter == 3) {
            loadCustomer_ps("last_name", "ASC", jTextField1.getText(), jTextField1.getText());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panalRound1 = new desingcode.PanalRound();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        uJTextfield8 = new component.UJTextfield();
        jLabel3 = new javax.swing.JLabel();
        uJTextfield2 = new component.UJTextfield();
        uJTextfield1 = new component.UJTextfield();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        uJTextfield5 = new component.UJTextfield();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        uJTextfield6 = new component.UJTextfield();
        jLabel8 = new javax.swing.JLabel();
        uJTextfield7 = new component.UJTextfield();
        jPanel5 = new javax.swing.JPanel();
        uJTextfield3 = new component.UJTextfield();
        jLabel4 = new javax.swing.JLabel();
        uJTextfield4 = new component.UJTextfield();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panalRound1.setBackground(new java.awt.Color(209, 238, 184));
        panalRound1.setRoundTopLeft(50);

        jLabel9.setFont(new java.awt.Font("Quicksand", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Customer Registration");

        javax.swing.GroupLayout panalRound1Layout = new javax.swing.GroupLayout(panalRound1);
        panalRound1.setLayout(panalRound1Layout);
        panalRound1Layout.setHorizontalGroup(
            panalRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panalRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panalRound1Layout.setVerticalGroup(
            panalRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panalRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel10.setText("Mobile");

        jLabel3.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel3.setText("First Name");

        jLabel2.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel2.setText("NIC");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(uJTextfield1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(uJTextfield2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uJTextfield8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(uJTextfield2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(uJTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(uJTextfield8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel6.setText("No");

        jLabel7.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel7.setText("Line 1");

        uJTextfield6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJTextfield6ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel8.setText("Line 2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addGap(9, 9, 9)
                .addComponent(uJTextfield5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(uJTextfield6, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uJTextfield7, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(uJTextfield5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(uJTextfield6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(uJTextfield7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        jLabel5.setText("Email");

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jRadioButton1.setActionCommand("1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Female");
        jRadioButton2.setActionCommand("2");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(22, 22, 22)
                        .addComponent(jRadioButton2)
                        .addGap(31, 31, 31)
                        .addComponent(jComboBox1, 0, 121, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uJTextfield4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uJTextfield3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(uJTextfield3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(uJTextfield4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

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

        jButton3.setText("Clear All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First Name ASC", "First Name DESC", "Last Name ASC", "Last Name DESC" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panalRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panalRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1))))
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
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String first_name = uJTextfield2.getText().trim();
        String last_name = uJTextfield3.getText().trim();
        String nic = uJTextfield1.getText().trim();
        String email = uJTextfield4.getText().trim();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String mobile = uJTextfield8.getText().trim();
        ButtonModel gender = buttonGroup2.getSelection();
        String no = uJTextfield5.getText().trim();
        String line1 = uJTextfield6.getText().trim();
        String line2 = uJTextfield7.getText().trim();
        String status = String.valueOf(jComboBox1.getSelectedItem());

     
        if (first_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (last_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter NIC", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email address", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+"
                + "(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid Invalid email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (gender == null) {
            JOptionPane.showMessageDialog(this, "Please Select Gender.", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (status.equals("Select Position")) {
            JOptionPane.showMessageDialog(this, "Please Select Position.", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (no.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address no", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (line1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String genderId = gender.getActionCommand();
                System.out.println(gender);
                ResultSet rs = MYSQL.executeSearch("SELECT * FROM `customer`WHERE `nic`='" + nic + "'");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "you are already registered", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    MYSQL.executeIUD("INSERT INTO `customer`(`nic`,`first_name`,`last_name`,`email`,`no`,`line1`,`line2`,`reg_date`,`gender`,`status`)"
                            + " VALUES('" + nic + "','" + first_name + "','" + last_name + "','" + email + "','" + no + "','" + line1 + "','" + line2 + "','" + date + "','" + genderId + "','" + status + "')");

                    MYSQL.executeIUD("INSERT INTO `customer_mobile`(`customer_nic`,`mobile_number`,`create_at`)VALUES('" + nic + "','" + mobile + "','" + date + "')");

                    loadCustomer_ps("first_name", "ASC", jTextField1.getText(), jTextField1.getText());
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
        String up_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String no = uJTextfield5.getText().trim();
        String line1 = uJTextfield6.getText().trim();
        String line2 = uJTextfield7.getText().trim();
        String mobile = uJTextfield8.getText().trim();
        ButtonModel gender = buttonGroup2.getSelection();
        String status = String.valueOf(jComboBox1.getSelectedItem());
        int row = jTable1.getSelectedRow();

        if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter NIC", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (first_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (last_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email address", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+"
                + "(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid Invalid email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (no.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address no", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (line1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (gender == null) {
            JOptionPane.showMessageDialog(this, "Please Select Gender.", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (status.equals("Select Position")) {
            JOptionPane.showMessageDialog(this, "Please Select Position.", "WARNING", JOptionPane.WARNING_MESSAGE);

        } else {

            try {
                String genderId = gender.getActionCommand();
                MYSQL.executeIUD("UPDATE `customer` SET  `first_name`='" + first_name + "',`last_name`='" + last_name + "',`email`='" + email + "',`no`='" + no + "',`line1`='" + line1 + "',`line2`='" + line2 + "',`upd_date`='" + up_date + "', `gender`='" + genderId + "',`status`='" + status + "'WHERE `nic` = '" + String.valueOf(jTable1.getValueAt(row, 0)) + "' ");
                MYSQL.executeIUD("UPDATE `customer_mobile` SET  `mobile_number`='" + mobile + "',`update_at`='" + up_date + "' WHERE `customer_nic` = '" + String.valueOf(jTable1.getValueAt(row, 0)) + "'");

                loadCustomer_ps("first_name", "ASC", jTextField1.getText(), jTextField1.getText());
                reset_ps();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();

        String fname = String.valueOf(jTable1.getValueAt(row, 1));
        String lname = String.valueOf(jTable1.getValueAt(row, 2));
        String nic = String.valueOf(jTable1.getValueAt(row, 0));
        String email = String.valueOf(jTable1.getValueAt(row, 3));
        String mobile = String.valueOf(jTable1.getValueAt(row, 9));
        String no = String.valueOf(jTable1.getValueAt(row, 4));
        String line1 = String.valueOf(jTable1.getValueAt(row, 5));
        String line2 = String.valueOf(jTable1.getValueAt(row, 6));
        String status = String.valueOf(jTable1.getValueAt(row, 11));

        if (evt.getClickCount() == 2) {

            jButton1.setEnabled(false);

            uJTextfield2.setText(fname);
            uJTextfield3.setText(lname);
            uJTextfield1.setText(nic);
            uJTextfield4.setText(email);
            uJTextfield8.setText(mobile);
            uJTextfield5.setText(no);
            uJTextfield6.setText(line1);
            uJTextfield7.setText(line2);
            String gender = String.valueOf(jTable1.getValueAt(row, 10));
            if (gender.equals("Male")) {
                jRadioButton1.setSelected(true);
            }
            if (gender.equals("Female")) {
                jRadioButton2.setSelected(true);
            }

            jComboBox1.setSelectedItem(status);

            uJTextfield1.setEditable(false);

        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void uJTextfield6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJTextfield6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uJTextfield6ActionPerformed

    private void roundButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundButton1ActionPerformed

    }//GEN-LAST:event_roundButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        System.out.println(jRadioButton1.getActionCommand());
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        reset_ps();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        filterName();
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        filterName();
    }//GEN-LAST:event_jTextField1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private desingcode.PanalRound panalRound1;
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
        jTextField1.setText("");
        buttonGroup2.clearSelection();
        jComboBox1.setSelectedIndex(0);

        uJTextfield1.grabFocus();
        jButton1.setEnabled(true);
        uJTextfield1.setEditable(true);
        jButton2.setEnabled(false);

        int index = 0;
        jComboBox2.setSelectedIndex(index);
        loadCustomer_ps("first_name", "ASC", jTextField1.getText(), jTextField1.getText());
    }

}
