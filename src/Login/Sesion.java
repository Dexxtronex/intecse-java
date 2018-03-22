package Login;
import Clases.Control;
import Menu.Menu_Admin;
import javax.swing.JOptionPane;
import Jdbc.Conexion;
import Menu.Menu_Empleado;
import UpperEssential.UpperEssentialLookAndFeel;
import com.sun.awt.AWTUtilities;
import java.sql.*;
import java.util.logging.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
//import org.jvnet.substance.SubstanceLookAndFeel;

public class Sesion extends javax.swing.JFrame {

    public Sesion() {
        
        initComponents();
        setTitle("Arovi S.A.");
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }

    Control p = new Control();

    @SuppressWarnings("unchecked")

    Conexion cn = new Conexion();
    Connection cc = cn.Conec();
  
    
    
     void iniciar(String usu, String con) {
        
        String sql = "SELECT * FROM formulario WHERE Usuario = '" + usu + "' && Contraseña = '" + con + "'";
        String x,y,z,w;
        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) 
                {
                   x = rs.getString(11);
                   y = rs.getString(1);
                   z = rs.getString(2);
                   w = y+" "+z;
                        if(x.equals("Administrador"))
                    {
                           dispose();
                           
                           Menu_Admin n = new Menu_Admin();
                           n.setVisible(true);
                           n.lblUsu.setText(w);
                           
                    }
                    else
                    {
                        dispose();
                        
                        Menu_Empleado n = new Menu_Empleado();
                        n.setVisible(true);
                        n.lblUsu.setText(w);
                        
                    }
                }
            else if ((usu.equals("")) || (con.equals("")))
                {
                JOptionPane.showMessageDialog(null, "Indique su Usuario y su Contraseña");
                }
            else
                {
                JOptionPane.showMessageDialog(null, "Su cuenta no existe");
                }
            } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Contraseña = new javax.swing.JLabel();
        btnIni = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 11, -1, 216));

        jLabel2.setBackground(new java.awt.Color(254, 254, 254));
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 70, -1));

        Contraseña.setBackground(new java.awt.Color(254, 254, 254));
        Contraseña.setForeground(new java.awt.Color(254, 254, 254));
        Contraseña.setText("Contraseña:");
        getContentPane().add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 90, -1));

        btnIni.setBackground(new java.awt.Color(56, 38, 25));
        btnIni.setFont(new java.awt.Font("Harvest", 0, 14)); // NOI18N
        btnIni.setForeground(new java.awt.Color(254, 254, 254));
        btnIni.setText("Iniciar Sesion");
        btnIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniActionPerformed(evt);
            }
        });
        btnIni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIniKeyPressed(evt);
            }
        });
        getContentPane().add(btnIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 150, 30));

        btnExit.setBackground(new java.awt.Color(56, 38, 25));
        btnExit.setFont(new java.awt.Font("Harvest", 0, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(254, 254, 254));
        btnExit.setText("Salir");
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 130, 30));

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 180, -1));

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 180, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio_Sesion.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked

    }//GEN-LAST:event_btnExitMouseClicked

    private void btnIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniActionPerformed
        String usua = txtUser.getText();
        String pass = new String(txtPass.getPassword());
        iniciar(usua, pass);
    }//GEN-LAST:event_btnIniActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        txtUser.transferFocus();
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        String usua = txtUser.getText();
        String pass = new String(txtPass.getPassword());
        iniciar(usua, pass);
        txtPass.transferFocus();
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnIniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIniKeyPressed
        String usua = txtUser.getText();
        String pass = new String(txtPass.getPassword());
        iniciar(usua, pass);
    }//GEN-LAST:event_btnIniKeyPressed

    public static void main(String args[]) {
                new Thread(new Cargar()).start();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
       
           new Sesion().setVisible(false);
            }
        }
        );
    }
   
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contraseña;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnIni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
