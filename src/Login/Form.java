/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Jdbc.Conexion;
import com.sun.awt.AWTUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Form extends javax.swing.JFrame {

    public Form() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Formulario de Nuevo Usuario");
        deshabilitar();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
        
    }
    
    void habilitar()
    {
        txtNom.setEnabled(true);
        txtApe.setEnabled(true);
        txtCi.setEnabled(true);
        CmbSex.setEnabled(true);
        txtCor.setEnabled(true);
        txtFn.setEnabled(true);
        txtTel.setEnabled(true);
        txtCel.setEnabled(true);
        txtDir.setEnabled(true);
        txtUsu.setEnabled(true);
        txtPass.setEnabled(true);
        CmbUsu.setEnabled(true);
    }
    
    void deshabilitar()
    {
        txtNom.setText("");
        txtApe.setText("");
        txtCi.setText("");
        txtCor.setText("");
        txtFn.setText("");
        txtTel.setText("");
        txtCel.setText("");
        txtDir.setText("");
        txtUsu.setText("");
        txtPass.setText("");
        txtNom.setEnabled(false);
        txtApe.setEnabled(false);
        txtCi.setEnabled(false);
        CmbSex.setEnabled(false);
        txtCor.setEnabled(false);
        txtFn.setEnabled(false);
        txtTel.setEnabled(false);
        txtCel.setEnabled(false);
        txtDir.setEnabled(false);
        txtUsu.setEnabled(false);
        txtPass.setEnabled(false);
        CmbUsu.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        txtApe = new javax.swing.JTextField();
        txtCi = new javax.swing.JTextField();
        txtFn = new javax.swing.JTextField();
        CmbSex = new javax.swing.JComboBox();
        txtCor = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtCel = new javax.swing.JTextField();
        txtDir = new javax.swing.JTextField();
        txtUsu = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        CmbUsu = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnLim = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 153, 0));
        jLabel1.setText("FORMULARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 200, 23));

        jLabel2.setText("Nombres............");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 77, 79, -1));

        jLabel3.setText("Apellidos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 108, 67, -1));

        jLabel4.setText("C.I.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 67, -1));

        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });
        txtNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomKeyTyped(evt);
            }
        });
        getContentPane().add(txtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 74, 163, -1));

        txtApe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeActionPerformed(evt);
            }
        });
        txtApe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApeKeyTyped(evt);
            }
        });
        getContentPane().add(txtApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 105, 163, -1));

        txtCi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiActionPerformed(evt);
            }
        });
        txtCi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiKeyTyped(evt);
            }
        });
        getContentPane().add(txtCi, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 136, 163, 22));

        txtFn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFnActionPerformed(evt);
            }
        });
        getContentPane().add(txtFn, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 169, 163, -1));

        CmbSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...", "M", "F" }));
        CmbSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbSexActionPerformed(evt);
            }
        });
        getContentPane().add(CmbSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 200, -1, -1));

        txtCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorActionPerformed(evt);
            }
        });
        getContentPane().add(txtCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 231, 163, -1));

        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });
        txtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelKeyTyped(evt);
            }
        });
        getContentPane().add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 262, 85, -1));

        txtCel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelActionPerformed(evt);
            }
        });
        txtCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelKeyTyped(evt);
            }
        });
        getContentPane().add(txtCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 262, 96, -1));

        txtDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirActionPerformed(evt);
            }
        });
        getContentPane().add(txtDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 293, 162, -1));

        txtUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 324, 162, -1));

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 355, 162, -1));

        CmbUsu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "....", "Administrador", "Empleado" }));
        CmbUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbUsuActionPerformed(evt);
            }
        });
        getContentPane().add(CmbUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 386, 162, -1));

        jLabel5.setText("Fecha de Nacimiento");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 172, -1, -1));

        jLabel6.setText("Sexo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 203, 55, -1));

        jLabel7.setText("Correo");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 234, 99, -1));

        jLabel8.setText("Telefono");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 265, 63, -1));

        jLabel11.setText("Celular");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 265, 46, -1));

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, 30));

        jLabel12.setText("Direccion");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 296, 87, -1));

        jLabel9.setText("Usuario");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 327, 99, -1));

        jLabel10.setText("Contraseña");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 358, 99, -1));

        jLabel13.setText("Tipo de Usuario");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 389, 89, -1));

        btnNew.setBackground(new java.awt.Color(204, 153, 0));
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setText("Nuevo");
        btnNew.setIconTextGap(-3);
        btnNew.setMaximumSize(new java.awt.Dimension(71, 23));
        btnNew.setMinimumSize(new java.awt.Dimension(71, 23));
        btnNew.setPreferredSize(new java.awt.Dimension(71, 23));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        getContentPane().add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 80, 30));

        btnSave.setBackground(new java.awt.Color(204, 153, 0));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Guardar");
        btnSave.setIconTextGap(-3);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, 30));

        btnLim.setBackground(new java.awt.Color(204, 153, 0));
        btnLim.setForeground(new java.awt.Color(255, 255, 255));
        btnLim.setText("Limpiar");
        btnLim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimActionPerformed(evt);
            }
        });
        getContentPane().add(btnLim, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 70, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setText("* La Fecha de Nacimiento debe tener este formato AAAA/MM/DD");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 458, 304, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar1.jpg"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String Combo() 
            {
              String f = CmbSex.getSelectedItem().toString();
              return f;
            }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int n = 1;
        Conexion cn = new Conexion();
        Connection link = cn.Conec();
        
        try {
            
            String Sex = CmbSex.getSelectedItem().toString();
            String T_usu = CmbUsu.getSelectedItem().toString();
            PreparedStatement pst;
            pst = link.prepareStatement("INSERT INTO formulario (Nombres,Apellidos,Fecha_nac,Cedula,Telefono,Celular,Direccion,Usuario,Contraseña,Sexo,Tipo_Usuario,Correo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,txtNom.getText());
            pst.setString(2,txtApe.getText());
            pst.setString(3,txtFn.getText());
            pst.setString(4,(txtCi.getText()));
            pst.setString(5,(txtTel.getText()));
            pst.setString(6,(txtCel.getText()));
            pst.setString(7,txtDir.getText());
            pst.setString(8,txtUsu.getText());
            pst.setString(9,txtPass.getText());
            pst.setString(10,Sex);
            pst.setString(11,T_usu);
            pst.setString(12,txtCor.getText());
            if(Sex == "...")
                {
                    JOptionPane.showMessageDialog(null,"Escoja un sexo Válido");
                    System.out.println("Sexo no valido");
                    n = 0;
                }
            if(T_usu == "....")
                {
                   JOptionPane.showMessageDialog(null,"Escoja un Tipo de Usuario Valido");
                    System.out.println("Tipo de Usuario no valido");
                   n = 0;
                }
            if(n > 0)
               {
                  n  = pst.executeUpdate();
                  if(n>0)
                  {  
                     JOptionPane.showMessageDialog(null,"Usuario Registado");
                     System.out.println("Registro Completo");
                     dispose();
                  }
               }
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: llene Correctamentamente todos los campos");
        } 
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        txtNom.transferFocus();
    }//GEN-LAST:event_txtNomActionPerformed

    private void txtApeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeActionPerformed
        txtApe.transferFocus();
    }//GEN-LAST:event_txtApeActionPerformed

    private void txtCiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiActionPerformed
        txtCi.transferFocus();
    }//GEN-LAST:event_txtCiActionPerformed

    private void txtFnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFnActionPerformed
        txtFn.transferFocus();
    }//GEN-LAST:event_txtFnActionPerformed

    private void CmbSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbSexActionPerformed
        CmbSex.transferFocus();
        String f = (String)CmbSex.getSelectedItem();
    }//GEN-LAST:event_CmbSexActionPerformed

    private void txtCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorActionPerformed
        txtCor.transferFocus();
    }//GEN-LAST:event_txtCorActionPerformed

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        txtTel.transferFocus();
    }//GEN-LAST:event_txtTelActionPerformed

    private void txtUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuActionPerformed
        txtUsu.transferFocus();
    }//GEN-LAST:event_txtUsuActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        txtPass.transferFocus();
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        habilitar();
    }//GEN-LAST:event_btnNewActionPerformed

    private void txtNomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomKeyTyped

    }//GEN-LAST:event_txtNomKeyTyped

    private void txtCiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiKeyTyped
      char c = evt.getKeyChar();
 int numerocaracteres = 10;
 if((c<'0'||c>'9'))
        {          

            evt.consume();

        } 
 if(txtCi.getText().length()>= numerocaracteres){
    evt.consume(); }
 
    }//GEN-LAST:event_txtCiKeyTyped

    private void txtTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelKeyTyped
      char c = evt.getKeyChar();
 int numerocaracteres = 7;
 if((c<'0'||c>'9'))
        {          

            evt.consume();

        } 
 if(txtTel.getText().length()>= numerocaracteres){
    evt.consume(); 
 }
    }//GEN-LAST:event_txtTelKeyTyped

    private void txtApeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeKeyTyped

    }//GEN-LAST:event_txtApeKeyTyped

    private void txtCelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelActionPerformed

    private void txtDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirActionPerformed

    private void txtCelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelKeyTyped
        char c = evt.getKeyChar();
 int numerocaracteres = 10;
 if((c<'0'||c>'9'))
        {          

            evt.consume();

        } 
 if(txtCel.getText().length()>= numerocaracteres){
    evt.consume(); 
 }
    }//GEN-LAST:event_txtCelKeyTyped

    private void CmbUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbUsuActionPerformed
    
    /*void Limitar()
    {  
        txtCi.setDocument(new LimitarCaracteres(txtCi,11));
        txtTel.setDocument(new LimitarCaracteres(txtTel,7));
        txtCel.setDocument(new LimitarCaracteres(txtCel,10));
        
    }*/
    
    private void btnLimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimActionPerformed
        deshabilitar();
    }//GEN-LAST:event_btnLimActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CmbSex;
    private javax.swing.JComboBox CmbUsu;
    private javax.swing.JButton btnLim;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtCi;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtFn;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtUsu;
    // End of variables declaration//GEN-END:variables
}
