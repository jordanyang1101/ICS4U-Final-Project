package ImageToText;

import javax.swing.*;
import java.awt.*;

public class MenuUI extends javax.swing.JFrame {

    public MenuUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/Icon.png"));
        setIconImage(icon.getImage());
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton = new javax.swing.JButton();
        textField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton.setFont(new java.awt.Font("Britannic Bold", 0, 18));
        jButton.setText("Convert");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });
        getContentPane().add(jButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 240, 60));

        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });
        getContentPane().add(textField, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 235, 290, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu.png")));
        jLabel1.setText("d");
        jLabel1.setMaximumSize(new java.awt.Dimension(640, 480));
        jLabel1.setMinimumSize(new java.awt.Dimension(640, 480));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 480));

        pack();
    }

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String text1 = textField.getText();
        Main.setText1(text1);
        Main.startConversion(this);
    }

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUI().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField textField;
}
