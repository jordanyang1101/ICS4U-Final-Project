package ImageToText;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConvertedUI extends javax.swing.JFrame {

    private DefaultListModel<String> listModel;

    public ConvertedUI(String filePath) {
        initComponents();
        this.setLocationRelativeTo(null);
        loadFileContents(filePath);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/CIcon.png"));
        setIconImage(icon.getImage());
        setResizable(false);
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        jButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listModel = new DefaultListModel<>();
        jList.setModel(listModel);
        jScrollPane1.setViewportView(jList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 460, 210));

        jButton.setFont(new java.awt.Font("Britannic Bold", 0, 36)); // NOI18N
        jButton.setText("Return");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });
        getContentPane().add(jButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 250, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CImage.png"))); // NOI18N
        jLabel1.setText("d");
        jLabel1.setMaximumSize(new java.awt.Dimension(640, 480));
        jLabel1.setMinimumSize(new java.awt.Dimension(640, 480));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        pack();
    }

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        new MenuUI().setVisible(true);
    }

    private void loadFileContents(String filePath) {
        listModel.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                listModel.addElement(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            listModel.addElement("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ConvertedUI("E:\\TesseractOCR\\Output\\out.txt").setVisible(true);
        });
    }

    private javax.swing.JButton jButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList;
    private javax.swing.JScrollPane jScrollPane1;
}
