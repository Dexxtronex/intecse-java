package Menu;
import Clases.Codigo;
import Jdbc.Conexion;
import Jdbc.Conexion_cat;
import com.sun.awt.AWTUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
public class New_Categoria extends javax.swing.JFrame {

    public New_Categoria() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Nueva Categoria");
        Cargar();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
       
        
    }

    @SuppressWarnings("unchecked")
    
    public void Añadir(String x)
    {
        Date fecha = new Date();
        int m,d,a;
        
        Conexion_cat co = new Conexion_cat();
        Connection con = co.ConecCat();
        String sql = "CREATE TABLE "+x+ 
                     "(Codigo VARCHAR(35) primary key NOT NULL, " +
                     " Nombre VARCHAR(50) NOT NULL, " +
                     " Cantidad INT(10) NOT NULL," +
                     " Proveedor VARCHAR(30) NOT NULL," +
                     " Categoria VARCHAR(30) NOT NULL," +
                     " Descripcion VARCHAR(200) NOT NULL," +
                     " Precio_Unit FLOAT(15) NOT NULL," +    //precio de venta
                     " Dia_Llegada VARCHAR(10) NOT NULL," +
                     " Hora_Llegada VARCHAR(10) NOT NULL,"+
                     " foto blob NOT NULL,"+
                     " ruta VARCHAR(60) NOT NULL,"+
                     " Precio_1 FLOAT(15) NOT NULL,"+ //precio de compra 
                     " Precio_2 FLOAT(15) NOT NULL,"+   //precio por mayor
                     " Precio_3 FLOAT(15) NOT NULL,"+ //precio por tarjeta de credito
                     " Cantidad_Minima INT(15) NOT NULL)";  //precio por tarjeta de credito
                
        try
        {       //foto,ruta,Precio_1
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Categoria Registrada exitosamente"); 
            Cargar();
        }
        catch(SQLException y)
        {
        JOptionPane.showMessageDialog(null,"ERROR AL GUARDAR CATEGORIA"); 
                  }
    }
    
    public void Cargar()
    {
        Conexion_cat co = new Conexion_cat();
        Connection link = co.ConecCat();
        Codigo c = new Codigo();
        int t = c.retornador(), cont;
        System.out.println(t);
        String arreglo[] = new String[t+1];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Categorias");
        try
        {
            PreparedStatement pst = link.prepareStatement("SHOW TABLES");
            ResultSet rs = pst.executeQuery();
            for(cont = 0 ; cont <= t ; cont++)
            {
                while(rs.next())
                {
                arreglo[cont] = rs.getString(1);
                modelo.addRow(arreglo);
                }
            }
            Tabla.setModel(modelo);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se puede Cargar la tabla "+e);
        }
    }
    
    public void Eliminar()
    {
        Conexion_cat co = new Conexion_cat();
        Connection link = co.ConecCat();
        int fila = Tabla.getSelectedRow();
        String nombre = Tabla.getValueAt(fila, 0).toString();
        System.out.println(fila);
        if(fila == -1)
        JOptionPane.showMessageDialog(null,"No selecciono ninguna fila");
        else  
        {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar esta categoria con todos sus productos?", "Advertencia", JOptionPane.WARNING_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) 
            {
                try 
                {
                    Statement st = link.createStatement();
                    st.executeUpdate("DROP TABLE " + nombre);
                    JOptionPane.showMessageDialog(null, "Eliminado con Exito");
                    Cargar();
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        }
        
            
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Eliminar_E = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnom_cat = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        Eliminar_E.setText("Eliminar");
        Eliminar_E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Eliminar_EMouseClicked(evt);
            }
        });
        Eliminar_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_EActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Eliminar_E);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 153, 0));
        jLabel1.setText("NUEVA CATEGORIA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 300, 40));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Nombre de la Categoria:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 86, 145, 24));

        txtnom_cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom_catActionPerformed(evt);
            }
        });
        getContentPane().add(txtnom_cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 88, 152, -1));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save me.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.setBorderPainted(false);
        btnSave.setContentAreaFilled(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save grande.png"))); // NOI18N
        btnSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save grande.png"))); // NOI18N
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        btnCan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload me.png"))); // NOI18N
        btnCan.setText("Cancelar");
        btnCan.setBorderPainted(false);
        btnCan.setContentAreaFilled(false);
        btnCan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCan.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        btnCan.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        btnCan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanActionPerformed(evt);
            }
        });
        getContentPane().add(btnCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Todas las Categorias"));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(Tabla);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full me.png"))); // NOI18N
        jButton2.setText("Eliminar");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full grande.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/new.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        dispose();
    }//GEN-LAST:event_btnCanActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Añadir(txtnom_cat.getText());
        txtnom_cat.setText("");
        txtnom_cat.requestFocus();
        Cargar();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Eliminar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Eliminar_EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Eliminar_EMouseClicked

    }//GEN-LAST:event_Eliminar_EMouseClicked

    private void Eliminar_EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_EActionPerformed
        Eliminar();
    }//GEN-LAST:event_Eliminar_EActionPerformed

    private void txtnom_catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom_catActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom_catActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new New_Categoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar_E;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnCan;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtnom_cat;
    // End of variables declaration//GEN-END:variables
}
