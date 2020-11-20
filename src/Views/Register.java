/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.UserController;
import javax.swing.JOptionPane;

/**
 *
 * @author 1styrGroupB
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        SignUpMessage = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        firstnameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        loginFormHeaderPanel = new javax.swing.JPanel();
        loginText = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        firstnameLabel1 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        lastnameLabel1 = new javax.swing.JLabel();
        lastnameField1 = new javax.swing.JTextField();
        passwordLabel1 = new javax.swing.JLabel();
        positionField = new javax.swing.JComboBox<>();
        HeaderPanel = new javax.swing.JPanel();
        Titletext = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SignUpMessage.setFont(new java.awt.Font("Cambria Math", 3, 18)); // NOI18N
        SignUpMessage.setForeground(new java.awt.Color(102, 102, 102));
        SignUpMessage.setText("Please sign up here!");
        jPanel2.add(SignUpMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 218, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/image1.jpg"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 432));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 548, -1, -1));

        emailLabel.setFont(new java.awt.Font("Cambria Math", 3, 18)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(0, 51, 255));
        emailLabel.setText("Email:");
        jPanel2.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 60, -1));

        firstnameField.setBackground(new java.awt.Color(255, 204, 255));
        firstnameField.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        firstnameField.setText("Enter Firstname");
        firstnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameFieldActionPerformed(evt);
            }
        });
        jPanel2.add(firstnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 190, 28));

        passwordLabel.setFont(new java.awt.Font("Cambria Math", 3, 18)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(0, 51, 255));
        passwordLabel.setText("Position:");
        jPanel2.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 90, -1));

        passField.setBackground(new java.awt.Color(255, 204, 255));
        passField.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        passField.setText("jPasswordField1");
        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        jPanel2.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 190, -1));

        loginFormHeaderPanel.setBackground(new java.awt.Color(248, 148, 6));

        loginText.setFont(new java.awt.Font("Cambria Math", 3, 36)); // NOI18N
        loginText.setForeground(new java.awt.Color(0, 51, 51));
        loginText.setText("Registration Form");

        javax.swing.GroupLayout loginFormHeaderPanelLayout = new javax.swing.GroupLayout(loginFormHeaderPanel);
        loginFormHeaderPanel.setLayout(loginFormHeaderPanelLayout);
        loginFormHeaderPanelLayout.setHorizontalGroup(
            loginFormHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginFormHeaderPanelLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(loginText)
                .addContainerGap(212, Short.MAX_VALUE))
        );
        loginFormHeaderPanelLayout.setVerticalGroup(
            loginFormHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginFormHeaderPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginText)
                .addGap(23, 23, 23))
        );

        jPanel2.add(loginFormHeaderPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 685, -1));

        registerButton.setBackground(new java.awt.Color(0, 153, 51));
        registerButton.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        jPanel2.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, -1, 36));

        firstnameLabel1.setFont(new java.awt.Font("Cambria Math", 3, 18)); // NOI18N
        firstnameLabel1.setForeground(new java.awt.Color(0, 51, 255));
        firstnameLabel1.setText("Firstname:");
        jPanel2.add(firstnameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

        emailField.setBackground(new java.awt.Color(255, 204, 255));
        emailField.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        emailField.setText("Enter Lastname");
        jPanel2.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 190, -1));

        lastnameLabel1.setFont(new java.awt.Font("Cambria Math", 3, 18)); // NOI18N
        lastnameLabel1.setForeground(new java.awt.Color(0, 51, 255));
        lastnameLabel1.setText("Lastname:");
        jPanel2.add(lastnameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        lastnameField1.setBackground(new java.awt.Color(255, 204, 255));
        lastnameField1.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        lastnameField1.setText("Enter Lastname");
        jPanel2.add(lastnameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 190, -1));

        passwordLabel1.setFont(new java.awt.Font("Cambria Math", 3, 18)); // NOI18N
        passwordLabel1.setForeground(new java.awt.Color(0, 51, 255));
        passwordLabel1.setText("Password:");
        jPanel2.add(passwordLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        positionField.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        positionField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "librarian" }));
        positionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionFieldActionPerformed(evt);
            }
        });
        jPanel2.add(positionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 190, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 640, 460));

        HeaderPanel.setBackground(new java.awt.Color(248, 148, 6));

        Titletext.setFont(new java.awt.Font("Cambria Math", 3, 48)); // NOI18N
        Titletext.setForeground(new java.awt.Color(0, 51, 51));
        Titletext.setText("Library Management System");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img2.jpg"))); // NOI18N

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Titletext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(545, 545, 545))
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titletext)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel1.add(HeaderPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 100));

        backgroundImage.setBackground(new java.awt.Color(255, 255, 255));
        backgroundImage.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        backgroundImage.setForeground(new java.awt.Color(255, 255, 255));
        backgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Webp.net-resizeimage.jpg"))); // NOI18N
        backgroundImage.setText("Library Management System");
        jPanel1.add(backgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 90, 790, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameFieldActionPerformed

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

    private void positionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionFieldActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
        String firstname = firstnameField.getText();
        String lastname = lastnameField1.getText();
        String email = emailField.getText();
        String password = passField.getText();
        String position =  (String) positionField.getSelectedItem();
        LoginView login = new LoginView();
        login.setVisible(UserController.createUser(firstname, lastname, email, position, password));
        this.setVisible(false);
        JOptionPane.showMessageDialog(null, "Please login!");
    }//GEN-LAST:event_registerButtonActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Register().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JLabel SignUpMessage;
    private javax.swing.JLabel Titletext;
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField firstnameField;
    private javax.swing.JLabel firstnameLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField lastnameField1;
    private javax.swing.JLabel lastnameLabel1;
    private javax.swing.JPanel loginFormHeaderPanel;
    private javax.swing.JLabel loginText;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JComboBox<String> positionField;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}