package Menu;

import Clases.Panel;
import Clases.Control;
import Jdbc.Conexion;
import com.sun.awt.AWTUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Buscar extends javax.swing.JFrame {
    Panel mipanel ;
    public Buscar() {
        initComponents();
        setLocationRelativeTo(null);
        deshabilitar();
        setTitle("Buscar por Cedula");
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtape = new javax.swing.JTextField();
        txtci = new javax.swing.JTextField();
        txtfn = new javax.swing.JTextField();
        txtsex = new javax.swing.JTextField();
        txtcor = new javax.swing.JTextField();
        txtcel = new javax.swing.JTextField();
        txttel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtdir = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtusu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtcon = new javax.swing.JTextField();
        txttip_usu = new javax.swing.JTextField();
        btnbus = new javax.swing.JButton();
        btncan = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        btnMod = new javax.swing.JButton();
        btnEli = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("APELLIDOS:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 149, 90, 17));

        jLabel4.setText("C.I. / RUC");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 16));

        jLabel5.setText("FECHA NACIMIENTO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 20));

        jLabel6.setText("SEXO:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 208, 90, 19));

        jLabel7.setText("CORREO:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 239, 90, 21));

        jLabel8.setText("TELF:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 274, 57, 17));

        jLabel9.setText("CEL:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 50, 20));
        getContentPane().add(txtape, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 220, -1));

        txtci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtciActionPerformed(evt);
            }
        });
        txtci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtciKeyTyped(evt);
            }
        });
        getContentPane().add(txtci, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 220, -1));
        getContentPane().add(txtfn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 200, -1));
        getContentPane().add(txtsex, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 220, -1));
        getContentPane().add(txtcor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 220, -1));

        txtcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcelActionPerformed(evt);
            }
        });
        getContentPane().add(txtcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 120, 23));
        getContentPane().add(txttel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 120, -1));

        jLabel10.setText("DIRECCION:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 308, 99, -1));
        getContentPane().add(txtdir, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 220, -1));

        jLabel11.setText("USUARIO:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 339, 90, -1));
        getContentPane().add(txtusu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 220, -1));

        jLabel12.setText("CONTRASEÑA:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 120, -1));

        jLabel13.setText("TIPO DE USUARIO:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 401, 130, -1));
        getContentPane().add(txtcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 220, -1));
        getContentPane().add(txttip_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 220, -1));

        btnbus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search me.png"))); // NOI18N
        btnbus.setText("BUSCAR");
        btnbus.setBorderPainted(false);
        btnbus.setContentAreaFilled(false);
        btnbus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbus.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search gr.png"))); // NOI18N
        btnbus.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search gr.png"))); // NOI18N
        btnbus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusActionPerformed(evt);
            }
        });
        getContentPane().add(btnbus, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 436, -1, -1));

        btncan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload me.png"))); // NOI18N
        btncan.setText("SALIR");
        btncan.setBorderPainted(false);
        btncan.setContentAreaFilled(false);
        btncan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncan.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        btncan.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload me.png"))); // NOI18N
        btncan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncanActionPerformed(evt);
            }
        });
        getContentPane().add(btncan, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 436, -1, -1));

        jLabel14.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 153, 0));
        jLabel14.setText("BUSCAR USUARIO");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 250, 45));

        jLabel2.setText("NOMBRES:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 118, 90, -1));

        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });
        getContentPane().add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 220, -1));

        btnMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration me.png"))); // NOI18N
        btnMod.setText("MODIFICAR");
        btnMod.setBorderPainted(false);
        btnMod.setContentAreaFilled(false);
        btnMod.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMod.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration grande.png"))); // NOI18N
        btnMod.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration grande.png"))); // NOI18N
        btnMod.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });
        getContentPane().add(btnMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 436, -1, -1));

        btnEli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full me.png"))); // NOI18N
        btnEli.setText("ELIMINAR");
        btnEli.setBorderPainted(false);
        btnEli.setContentAreaFilled(false);
        btnEli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEli.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full grande.png"))); // NOI18N
        btnEli.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full grande.png"))); // NOI18N
        btnEli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliActionPerformed(evt);
            }
        });
        getContentPane().add(btnEli, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusActionPerformed
        mipanel = new Panel();
        habilitar();
        Control x = mipanel.buscarnombre(Integer.parseInt(txtci.getText()));
        txtnom.setText(x.getNombres());
        txtape.setText(x.getApellidos());
        txtfn.setText(x.getFn());
        txtsex.setText(x.getSex());
        txtcor.setText(x.getCor());
        txtdir.setText(x.getDir());
        txtusu.setText(x.getUsu());
        txtcon.setText(x.getCon());
        txttip_usu.setText(x.getTi_usu());
        txttel.setText(Integer.toString(x.getTel()));
        txtcel.setText(Integer.toString(x.getCel()));
    }//GEN-LAST:event_btnbusActionPerformed

    private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomActionPerformed

    private void txtcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcelActionPerformed

    private void btncanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncanActionPerformed
        dispose();
    }//GEN-LAST:event_btncanActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
     try
     {
         Conexion con = new Conexion();
         Connection link = con.Conec();
         int ced = Integer.parseInt(txtci.getText());
         int tel = Integer.parseInt(txttel.getText());
         int cel = Integer.parseInt(txtcel.getText());
         PreparedStatement pst = link.prepareStatement("UPDATE formulario SET Nombres= '"+txtnom.getText()+"',Apellidos = '"+txtape.getText()+"',Fecha_Nac = '"+txtfn.getText()+"' , Telefono = '"+tel+"', Correo = '"+txtcor.getText()+"', Sexo = '"+txtsex.getText()+"' , Celular = '"+cel+"', Direccion = '"+txtdir.getText()+"', Usuario = '"+txtusu.getText()+"', Contraseña = '"+txtcon.getText()+"', Tipo_Usuario = '"+txttip_usu.getText()+"' WHERE Cedula = '"+ced+"'");
         int cont = pst.executeUpdate();
         if(cont > 0)
         {
             JOptionPane.showMessageDialog(null,"Datos Modificados");
             dispose();
         }
         else
         {
             JOptionPane.showMessageDialog(null,"Error");
         }
     }
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(null, e);
     }
    }//GEN-LAST:event_btnModActionPerformed

    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
        Conexion con = new Conexion();
        Connection link = con.Conec();
        try
        {
           int cedula = Integer.parseInt(txtci.getText());
           PreparedStatement pst = link.prepareStatement("DELETE FROM formulario WHERE Cedula = '"+cedula+"'");
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "Eliminado con Exito");
           dispose();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }//GEN-LAST:event_btnEliActionPerformed

    private void txtciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtciActionPerformed
        mipanel = new Panel();
        Control x = mipanel.buscarnombre(Integer.parseInt(txtci.getText()));
        txtnom.setText(x.getNombres());
        txtape.setText(x.getApellidos());
        txtfn.setText(x.getFn());
        txtsex.setText(x.getSex());
        txtcor.setText(x.getCor());
        txtdir.setText(x.getDir());
        txtusu.setText(x.getUsu());
        txtcon.setText(x.getCon());
        txttip_usu.setText(x.getTi_usu());
        txttel.setText(Integer.toString(x.getTel()));
        txtcel.setText(Integer.toString(x.getCel()));
    }//GEN-LAST:event_txtciActionPerformed

    private void txtciKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtciKeyTyped
 char c = evt.getKeyChar();
 int numerocaracteres = 10;
 if((c<'0'||c>'9'))
        {          

            evt.consume();

        } 
 if(txtci.getText().length()>= numerocaracteres){
    evt.consume(); 
 }

    }//GEN-LAST:event_txtciKeyTyped

    public void deshabilitar()
    {
        txtnom.setEnabled(false);
        txtape.setEnabled(false);
        txtfn.setEnabled(false);
        txtsex.setEnabled(false);
        txtcor.setEnabled(false);
        txtdir.setEnabled(false);
        txtusu.setEnabled(false);
        txtcon.setEnabled(false);
        txttip_usu.setEnabled(false);
        txtcel.setEnabled(false);
        txttel.setEnabled(false);
    }
public void habilitar()
    {
        txtnom.setEnabled(true);
        txtape.setEnabled(true);
        txtfn.setEnabled(true);
        txtsex.setEnabled(true);
        txtcor.setEnabled(true);
        txtdir.setEnabled(true);
        txtusu.setEnabled(false);
        txtcon.setEnabled(false);
        txttip_usu.setEnabled(true);
        txtcel.setEnabled(true);
        txttel.setEnabled(true);
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnEli;
    public static javax.swing.JButton btnMod;
    public static javax.swing.JButton btnbus;
    public static javax.swing.JButton btncan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField txtape;
    public static javax.swing.JTextField txtcel;
    public javax.swing.JTextField txtci;
    public static javax.swing.JTextField txtcon;
    public static javax.swing.JTextField txtcor;
    public static javax.swing.JTextField txtdir;
    public static javax.swing.JTextField txtfn;
    public static javax.swing.JTextField txtnom;
    public static javax.swing.JTextField txtsex;
    public static javax.swing.JTextField txttel;
    public static javax.swing.JTextField txttip_usu;
    public static javax.swing.JTextField txtusu;
    // End of variables declaration//GEN-END:variables
}
