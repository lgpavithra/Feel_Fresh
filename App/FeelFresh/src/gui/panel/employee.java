/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.panel;

import gui.dialog.Mobile;
import gui.dialog.UserEmployee;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.MYSQL;
import model.jasper.Report;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

/**
 *
 * @author Sandun
 */
public class employee extends javax.swing.JPanel {

    /**
     * Creates new form employee
     */
    private final UpdateEmployee updateEmployee_HS;
    HashMap<String, Integer> UserPositionMap_HS = new HashMap();

    public employee() {
        initComponents();
        jButton1.putClientProperty("JButton.buttonType", "roundRect");
        jButton4.putClientProperty("JButton.buttonType", "roundRect");
        LoadEmployee_HS("fname", "ASC", jTextField1.getText(), jTextField1.getText());
        LoadPosition();
        jButton4.setVisible(false);
        jComboBox1.setEnabled(false);
        updateEmployee_HS = new UpdateEmployee(this);
    }

    public void setMoblie(String mobile[]) {
        jLabel13.setText(mobile[0]);
        jLabel14.setText(mobile[1]);
        jLabel15.setText(mobile[2]);
    }

    private void LoadPosition() {
        try {
            ResultSet re_HS = MYSQL.executeSearch("SELECT * FROM `position`");
            Vector vector = new Vector();
            vector.add("Select Position");
            while (re_HS.next()) {
                vector.add(re_HS.getString("position_name"));
                UserPositionMap_HS.put(re_HS.getString("position_name"), re_HS.getInt("id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadEmployee_HS(String column, String orderby, String nic, String FName_HS) {
        try {
            ResultSet resultSet_HS = MYSQL.executeSearch("SELECT \n"
                    + "    e.nic,\n"
                    + "    e.fname,\n"
                    + "    e.lname,\n"
                    + "    e.email,\n"
                    + "    e.gender,\n"
                    + "    e.status,\n"
                    + "    e.employment_type,\n"
                    + "    e.position_id,\n"
                    + "    p.position_name AS position,\n"
                    + "    e.line_1,\n"
                    + "    e.line_2,\n"
                    + "    e.no,\n"
                    + "    MIN(em.mobile) AS primary_mobile\n"
                    + "FROM employee e\n"
                    + "LEFT JOIN employee_mobile em \n"
                    + "    ON e.nic = em.employee_nic\n"
                    + "LEFT JOIN position p\n"
                    + "    ON e.position_id = p.id\n"
                    + " WHERE `nic` LIKE '" + nic + "%' OR `fname` LIKE '" + FName_HS + "%'  ORDER BY `" + column + "` " + orderby + "GROUP BY e.nic;");

            DefaultTableModel Tablemodel_HS = (DefaultTableModel) jTable2.getModel();
            Tablemodel_HS.setRowCount(0);
            while (resultSet_HS.next()) {
                Vector v = new Vector<>();
                v.add(resultSet_HS.getString("nic"));
                v.add(resultSet_HS.getString("fname"));
                v.add(resultSet_HS.getString("lname"));
                v.add(resultSet_HS.getString("email"));
                v.add(resultSet_HS.getString("gender"));
                v.add(resultSet_HS.getString("employment_type"));
                v.add(resultSet_HS.getString("position"));
                v.add(resultSet_HS.getString("status"));
                v.add(resultSet_HS.getString("line_1"));
                v.add(resultSet_HS.getString("line_2"));
                v.add(resultSet_HS.getString("no"));
                if (resultSet_HS.getString("primary_mobile") != null) {
                    v.add(resultSet_HS.getString("primary_mobile"));
                } else {
                    v.add("Empty");
                }
                Tablemodel_HS.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void filterName() {

        int filter = jComboBox4.getSelectedIndex();

        if (filter == 0) {
            LoadEmployee_HS("fname", "ASC", jTextField1.getText(), jTextField1.getText());
        } else if (filter == 1) {
            LoadEmployee_HS("fname", "DESC", jTextField1.getText(), jTextField1.getText());
        } else if (filter == 2) {
            LoadEmployee_HS("lname", "ASC", jTextField1.getText(), jTextField1.getText());
        } else if (filter == 3) {
            LoadEmployee_HS("lname", "DESC", jTextField1.getText(), jTextField1.getText());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uJTextfield1 = new component.UJTextfield();
        jLabel4 = new javax.swing.JLabel();
        uJTextfield3 = new component.UJTextfield();
        jLabel6 = new javax.swing.JLabel();
        uJTextfield5 = new component.UJTextfield();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        uJTextfield6 = new component.UJTextfield();
        jLabel10 = new javax.swing.JLabel();
        uJTextfield7 = new component.UJTextfield();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        uJTextfield2 = new component.UJTextfield();
        uJTextfield4 = new component.UJTextfield();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        roundButton2 = new component.RoundButton();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Employee");

        jLabel2.setText("First Name");

        uJTextfield1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel4.setText("NIC");

        uJTextfield3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel6.setText("Employee Type");

        uJTextfield5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel8.setText("Address Line 1");

        jLabel9.setText("Address Line 2");

        uJTextfield6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel10.setText("NO");

        uJTextfield7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acitive", "Inactive" }));

        jLabel11.setText("Position");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("User Status");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Last Name");

        jLabel5.setText("Email");

        uJTextfield2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        uJTextfield4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel7.setText("Gender");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jRadioButton1.setActionCommand("1");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        jRadioButton2.setActionCommand("2");

        jButton1.setText("Add Mobiles");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uJTextfield4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uJTextfield2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(22, 22, 22)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(70, 70, 70)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uJTextfield2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(uJTextfield4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full Time", "Part Time" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jButton4.setText("System Access");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uJTextfield3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uJTextfield1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(uJTextfield5, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                .addGap(13, 13, 13))
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(uJTextfield6, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(uJTextfield7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(uJTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(uJTextfield3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uJTextfield5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(uJTextfield6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(uJTextfield7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        uJTextfield1.getAccessibleContext().setAccessibleName("");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIC", "FIrst Name", "Last Name", "Email", "Gender", "Employee_Type", "Position", "Status", "Line 1", "Line 2", "no", "mobile"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(30);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(11).setMinWidth(0);
            jTable2.getColumnModel().getColumn(11).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(11).setMaxWidth(0);
        }

        jComboBox4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First Name ASC", "First Name DESC", "Last Name ASC", "Last Name DESC" }));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        roundButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/print-26.png"))); // NOI18N
        roundButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(roundButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1))
                    .addComponent(roundButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jButton2.setText("Clear All");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel5.setLayout(new java.awt.BorderLayout());

        jButton3.setBackground(new java.awt.Color(9, 183, 38));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void EmployeeUpdate_HS(String EmpADDAndUpdate_HS) {
        String Fname_HS = uJTextfield1.getText();
        String lname_HS = uJTextfield2.getText();
        String NIC_HS = uJTextfield3.getText().trim();
        String email_HS = uJTextfield4.getText();
        ButtonModel gender_HS = buttonGroup1.getSelection();
        String line1_HS = uJTextfield5.getText();
        String Line2_HS = uJTextfield6.getText();
        String NO_HS = uJTextfield7.getText();
        String user_status_HS = String.valueOf(jComboBox1.getSelectedItem());
        String Position_HS = String.valueOf(jComboBox2.getSelectedItem());
        String Employee_type_HS = String.valueOf(jComboBox3.getSelectedItem());
        String number1 = jLabel13.getText();
        String number2 = jLabel14.getText();
        String number3 = jLabel15.getText();
//                String Fname_HS = uJTextfield1.getText();
//        String lname_HS = uJTextfield2.getText();
//        String NIC_HS = uJTextfield3.getText().trim();
//        String email_HS = uJTextfield4.getText();
//        ButtonModel gender_HS = buttonGroup1.getSelection();
//        String genderId_HS = gender_HS.getActionCommand();
//        String line1_HS = uJTextfield5.getText();
//        String Line2_HS = uJTextfield6.getText();
//        String NO_HS = uJTextfield7.getText();
//        String user_status_HS = String.valueOf(jComboBox1.getSelectedItem());
//        String UserType_HS = String.valueOf(jComboBox2.getSelectedItem());
//        String Position_HS = String.valueOf(jComboBox3.getSelectedItem());
//        String number1 = jLabel13.getText();
//        String number2 = jLabel14.getText();
//        String number3 = jLabel15.getText();
//        System.out.println(Fname_HS);
//        System.out.println(lname_HS);
//        System.out.println(NIC_HS);
//        System.out.println(email_HS);
//        System.out.println(Password_HS);
////        System.out.println(gender_HS);
////        System.out.println(genderId_HS);
//        System.out.println(line1_HS);
//        System.out.println(Line2_HS);
//        System.out.println(NO_HS);
//        System.out.println(user_status_HS);
        if (Fname_HS.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Employee First name.", "WARNING", JOptionPane.WARNING_MESSAGE);
            uJTextfield1.grabFocus();
        } else if (lname_HS.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Last Name.", "WARNING", JOptionPane.WARNING_MESSAGE);
            uJTextfield2.grabFocus();
        } else if (NIC_HS.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter NIC.", "WARNING", JOptionPane.WARNING_MESSAGE);
            uJTextfield3.grabFocus();
        } else if (!NIC_HS.matches("^[0-9]{9}[Vv]$") & !NIC_HS.matches("^[0-9]{12}$")) {
            JOptionPane.showMessageDialog(this, "The NIC number is invalid.", "WARNING", JOptionPane.WARNING_MESSAGE);
            uJTextfield3.grabFocus();
        } else if (email_HS.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Email.", "WARNING", JOptionPane.WARNING_MESSAGE);
            uJTextfield4.grabFocus();
        } else if (!email_HS.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Invalid Email.", "WARNING", JOptionPane.WARNING_MESSAGE);
            uJTextfield4.grabFocus();
        } else if (gender_HS == null) {
            JOptionPane.showMessageDialog(this, "Please Select Gender.", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (line1_HS.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Address Line 1.", "WARNING", JOptionPane.WARNING_MESSAGE);
            uJTextfield5.grabFocus();
        } else if (Line2_HS.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Address Line 2.", "WARNING", JOptionPane.WARNING_MESSAGE);
            uJTextfield6.grabFocus();
        } else if (NO_HS.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Address Number.", "WARNING", JOptionPane.WARNING_MESSAGE);
            uJTextfield7.grabFocus();
        } else if (Position_HS.equals("Select Position")) {
            JOptionPane.showMessageDialog(this, "Please Select Position.", "WARNING", JOptionPane.WARNING_MESSAGE);
            jComboBox2.grabFocus();
        } else if (number1.isEmpty() & number2.isEmpty() & number3.isEmpty()) {
            MobileViwe();
        } else {
            try {
                String genderId_HS = gender_HS.getActionCommand();
                int UserPositionId_HS = UserPositionMap_HS.get(Position_HS);
                if (EmpADDAndUpdate_HS.equals("EmpAdd")) {
                    ResultSet resultSet_HS = MYSQL.executeSearch("SELECT * FROM `employee` WHERE `nic`='" + NIC_HS + "'");
                    if (resultSet_HS.next()) {
                        JOptionPane.showMessageDialog(this, "This Employee Already Registered.", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else {
                        MYSQL.executeIUD("INSERT INTO employee (nic,fname,lname,email,gender,`no`,line_1,line_2,`status`,position_id,employment_type) "
                                + "VALUES ('" + NIC_HS + "','" + Fname_HS + "','" + lname_HS + "','" + email_HS + "','" + genderId_HS + "','" + NO_HS + "','" + line1_HS + "',"
                                + "'" + Line2_HS + "','" + user_status_HS + "','" + UserPositionId_HS + "','" + Employee_type_HS + "');");

                        ///query responsive
                        String query_mobile = "";
                        if (!number1.isBlank()) {
                            query_mobile = "    ('" + number1 + "','" + NIC_HS + "') ";
                        }
                        if (!number2.isBlank()) {
                            query_mobile += " , ('" + number2 + "','" + NIC_HS + "') ";
                        }
                        if (!number3.isBlank()) {
                            query_mobile += " , ('" + number3 + "','" + NIC_HS + "') ";
                        }
                        MYSQL.executeIUD("INSERT INTO `employee_mobile` (`mobile`,`employee_nic`) VALUES "
                                + query_mobile);
                        LoadEmployee_HS("fname", "ASC", jTextField1.getText(), jTextField1.getText());
                        Clean_All_HS();
                        ///query responsive
                    }
                }
                if (EmpADDAndUpdate_HS.equals("EmpUpdate")) {
                    MYSQL.executeIUD("UPDATE `employee` SET `fname`='" + Fname_HS + "',`lname`='" + lname_HS + "',`email`='" + email_HS + "',"
                            + "`gender`='" + genderId_HS + "',`no`='" + NO_HS + "',`line_1`='" + line1_HS + "',`line_2`='" + Line2_HS + "',"
                            + "`status`='" + user_status_HS + "',`position_id`='" + UserPositionId_HS + "',`employment_type`='" + Employee_type_HS + "' "
                            + "WHERE `nic`='" + NIC_HS + "'");

                    ResultSet resultSet_HS = MYSQL.executeSearch("SELECT * FROM `employee_mobile` WHERE `employee_nic`='" + NIC_HS + "'");

                    if (resultSet_HS.next()) {
                        String mobile1_HS = resultSet_HS.getString("mobile");
                        if (!number1.isEmpty() & !mobile1_HS.equals(number1)) {
                            UpdateMoible_HS(NIC_HS, number1, mobile1_HS);
                        }
                    } else if (!number1.isEmpty()) {
                        insert_HS(NIC_HS, number1);
                    }
                    if (resultSet_HS.next()) {
                        String mobile2_HS = resultSet_HS.getString("mobile");
                        if (!number2.isEmpty() & !mobile2_HS.equals(number2)) {
                            UpdateMoible_HS(NIC_HS, number2, mobile2_HS);
                        } else if (number2.isEmpty() & !mobile2_HS.isEmpty()) {
                            DeleteMoible_HS(NIC_HS, mobile2_HS);
                        }
                    } else if (!number2.isEmpty()) {
                        insert_HS(NIC_HS, number2);
                    }
                    if (resultSet_HS.next()) {
                        String mobile3_HS = resultSet_HS.getString("mobile");
                        if (!number3.isEmpty() & !mobile3_HS.equals(number3)) {
                            UpdateMoible_HS(NIC_HS, number3, mobile3_HS);
                        } else if (number3.isEmpty() & !mobile3_HS.isEmpty()) {
                            DeleteMoible_HS(NIC_HS, mobile3_HS);
                        }
                    } else if (!number3.isEmpty()) {
                        insert_HS(NIC_HS, number3);
                    }
                    LoadEmployee_HS("fname", "ASC", jTextField1.getText(), jTextField1.getText());
                    Clean_All_HS();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void MobileViwe() {
        String NIC_HS = uJTextfield3.getText().trim();
        if (NIC_HS.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select or Enter NIC.", "WARNING", JOptionPane.WARNING_MESSAGE);
            uJTextfield3.grabFocus();
        } else if (!NIC_HS.matches("^[0-9]{9}[Vv]$") & !NIC_HS.matches("^[0-9]{12}$")) {
            JOptionPane.showMessageDialog(this, "The NIC number is invalid.", "WARNING", JOptionPane.WARNING_MESSAGE);
            uJTextfield3.grabFocus();
        } else {
//            new Mobile(1,jLabel13.getText(); ).setVisible(true);

            Mobile mo = new Mobile(this, null, null);
            mo.setVisible(true);
            mo.loadMobile(jLabel13.getText(), jLabel14.getText(), jLabel15.getText());
        }
    }

    private void insert_HS(String nic, String Mobile) {
        try {
            MYSQL.executeIUD("INSERT INTO `employee_mobile` (`mobile`,`employee_nic`) VALUES ('" + Mobile + "','" + nic + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void UpdateMoible_HS(String nic, String Mobile, String AlreadyMobile) {
        try {
            MYSQL.executeIUD("UPDATE `employee_mobile` SET `mobile`='" + Mobile + "' WHERE employee_nic='" + nic + "' AND mobile='" + AlreadyMobile + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void DeleteMoible_HS(String nic, String Mobile) {
        try {
            MYSQL.executeIUD("DELETE FROM `employee_mobile` WHERE `mobile`='" + Mobile + "' AND `employee_nic`='" + nic + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Clean_All_HS() {
        uJTextfield1.setText("");
        uJTextfield2.setText("");
        uJTextfield3.setText("");
        uJTextfield4.setText("");
        uJTextfield5.setText("");
        uJTextfield6.setText("");
        uJTextfield7.setText("");
        buttonGroup1.clearSelection();
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jTable2.clearSelection();
        jTable2.setEnabled(true);
        jComboBox1.setEnabled(false);
        uJTextfield3.setEnabled(true);
        jLabel13.setText("");
        jLabel14.setText("");
        jLabel15.setText("");
        jPanel5.removeAll();
        jButton4.setVisible(false);
        jPanel5.add(jButton3, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel5);

        jComboBox4.setSelectedIndex(0);
        LoadEmployee_HS("fname", "ASC", jTextField1.getText(), jTextField1.getText());
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Clean_All_HS();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if (evt.getClickCount() == 2) {
            jPanel5.removeAll();
            jPanel5.add(updateEmployee_HS);
            SwingUtilities.updateComponentTreeUI(jPanel5);
            uJTextfield3.setEnabled(false);
            jComboBox1.setEnabled(true);
            jTable2.setEnabled(false);
            jButton4.setVisible(true);
            int Selectedrow_HS = jTable2.getSelectedRow();
            String NIC_HS = String.valueOf(jTable2.getValueAt(Selectedrow_HS, 0));
            uJTextfield3.setText(NIC_HS);
            try {
                ResultSet resultSet_HS = MYSQL.executeSearch("SELECT * FROM `employee_mobile` WHERE `employee_nic`='" + NIC_HS + "'");
                if (resultSet_HS.next()) {
                    jLabel13.setText(resultSet_HS.getString("mobile"));
                }
                if (resultSet_HS.next()) {
                    jLabel14.setText(resultSet_HS.getString("mobile"));
                }
                if (resultSet_HS.next()) {
                    jLabel15.setText(resultSet_HS.getString("mobile"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String Fname_HS = String.valueOf(jTable2.getValueAt(Selectedrow_HS, 1));
            uJTextfield1.setText(Fname_HS);
            String lname_HS = String.valueOf(jTable2.getValueAt(Selectedrow_HS, 2));
            uJTextfield2.setText(lname_HS);
            String Email_HS = String.valueOf(jTable2.getValueAt(Selectedrow_HS, 3));
            uJTextfield4.setText(Email_HS);
            String gender_HS = String.valueOf(jTable2.getValueAt(Selectedrow_HS, 4));
            if (gender_HS.equals("Male")) {
                jRadioButton1.setSelected(true);
            }
            if (gender_HS.equals("Female")) {
                jRadioButton2.setSelected(true);
            }
            String EmployeeType_HS = String.valueOf(jTable2.getValueAt(Selectedrow_HS, 5));
            jComboBox3.setSelectedItem(EmployeeType_HS);
            String Position_HS = String.valueOf(jTable2.getValueAt(Selectedrow_HS, 6));
            jComboBox2.setSelectedItem(Position_HS);
            String status_HS = String.valueOf(jTable2.getValueAt(Selectedrow_HS, 7));
            jComboBox1.setSelectedItem(status_HS);
            String Line1_HS = String.valueOf(jTable2.getValueAt(Selectedrow_HS, 8));
            uJTextfield5.setText(Line1_HS);
            String Line2_HS = String.valueOf(jTable2.getValueAt(Selectedrow_HS, 9));
            uJTextfield6.setText(Line2_HS);
            String No_HS = String.valueOf(jTable2.getValueAt(Selectedrow_HS, 10));
            uJTextfield7.setText(No_HS);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        EmployeeUpdate_HS("EmpAdd");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MobileViwe();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int Selectedrow_HS = jTable2.getSelectedRow();
        String NIC_HS = String.valueOf(jTable2.getValueAt(Selectedrow_HS, 0));
        new UserEmployee(null, true, NIC_HS).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        Clean_All_HS();

    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        Clean_All_HS();

    }//GEN-LAST:event_jPanel2MouseClicked

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        filterName();
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        filterName();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void roundButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundButton2ActionPerformed
        try {
            HashMap <String, Object> map = new HashMap<>();
            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable2.getModel());
            JasperPrint print = JasperFillManager.fillReport("src/reports/employee/EmployeeReport.jasper", map, dataSource);
            Report.execute(print);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_roundButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private component.RoundButton roundButton2;
    private component.UJTextfield uJTextfield1;
    private component.UJTextfield uJTextfield2;
    private component.UJTextfield uJTextfield3;
    private component.UJTextfield uJTextfield4;
    private component.UJTextfield uJTextfield5;
    private component.UJTextfield uJTextfield6;
    private component.UJTextfield uJTextfield7;
    // End of variables declaration//GEN-END:variables
}
