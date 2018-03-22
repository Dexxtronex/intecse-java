/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Jdbc.Conexion;
import com.sun.awt.AWTUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anthony
 */
public class Facturas extends javax.swing.JFrame {

    /**
     * Creates new form Facturas
     */
    public Facturas() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Facturas");
        
        setDefaultCloseOperation(Facturas.DISPOSE_ON_CLOSE);
        cargar_datos();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        
        JLabel fondo= new JLabel();   nom.setVisible(false);
        ape.setVisible(false);
        correo.setVisible(false);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }

    
    
    public void cargar_datos()
    {
        String arreglo[] = new String[7];
       Conexion n = new Conexion();
       Connection link = n.Conec();
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn("FACTURA N°");
       modelo.addColumn("CEDULA");
       modelo.addColumn("FECHA");
       modelo.addColumn("HORA");
       modelo.addColumn("SUBTOTAL");
       modelo.addColumn("IVA");
       modelo.addColumn("TOTAL");
       try
       {
           PreparedStatement pst = link.prepareStatement("SELECT * FROM facturas");
           ResultSet rs = pst.executeQuery();
           while(rs.next())
           {
               arreglo[0] = rs.getString(1);
               arreglo[1] = rs.getString(2);
               arreglo[2] = rs.getString(3);
               arreglo[3] = rs.getString(4);
               arreglo[4] = rs.getString(5);
               arreglo[5] = rs.getString(6);
               arreglo[6] = rs.getString(7);
               modelo.addRow(arreglo);
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       tabla.setModel(modelo);
       num_ventas();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        correo = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        ape = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CmbMes = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lblnum_ven = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbltot_ven = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jMenuItem1.setText("Comprobante");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Cancelar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, -1));

        nom.setEditable(false);
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        getContentPane().add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, -1));

        ape.setEditable(false);
        ape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apeActionPerformed(evt);
            }
        });
        getContentPane().add(ape, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 620, 353));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("FACTURAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, 51));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, 80));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ID me.png"))); // NOI18N
        jButton1.setText("Ver Comprobante");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ID gr.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ID gr.png"))); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, -1, 59));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload me.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 540, -1, 59));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Filtrar por Mes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 86, -1));

        CmbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "......", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        CmbMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbMesItemStateChanged(evt);
            }
        });
        getContentPane().add(CmbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 120, 20));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Numero de Ventas: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 126, -1));

        lblnum_ven.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        getContentPane().add(lblnum_ven, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 56, 14));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Total de Ventas:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 101, -1));

        lbltot_ven.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        getContentPane().add(lbltot_ven, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, 73, 14));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/facturas_1.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 670, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Comprobante();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Comprobante();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CmbMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbMesItemStateChanged
        filtrar();
    }//GEN-LAST:event_CmbMesItemStateChanged

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void apeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apeActionPerformed

    public void filtrar()
    {
        Conexion con = new Conexion();
        Connection link = con.Conec();
        String recogedor = CmbMes.getSelectedItem().toString();
        if(recogedor.equals("......"))
        {
            cargar_datos();
        }
        else
        {
            String arreglo[] = new String[7];
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("FACTURA N°");
            modelo.addColumn("CEDULA");
            modelo.addColumn("FECHA");
            modelo.addColumn("HORA");
            modelo.addColumn("SUBTOTAL");
            modelo.addColumn("IVA");
            modelo.addColumn("TOTAL");
            try
            {
                PreparedStatement pst = link.prepareStatement("SELECT * FROM facturas WHERE Fecha LIKE '%/"+recogedor+"/%'");
                ResultSet rs = pst.executeQuery();
                while(rs.next())
                {
                  arreglo[0] = rs.getString(1);
                  arreglo[1] = rs.getString(2);
                  arreglo[2] = rs.getString(3);
                  arreglo[3] = rs.getString(4);
                  arreglo[4] = rs.getString(5);
                  arreglo[5] = rs.getString(6);
                  arreglo[6] = rs.getString(7);
                  modelo.addRow(arreglo);
                }
                pst.close();
                rs.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error" +e);
            }
            tabla.setModel(modelo);
            num_ventas();
        }
    }
    
    public void num_ventas()
    {
        int num_filas = tabla.getRowCount();
        String n = Integer.toString(num_filas);
        lblnum_ven.setText(n);
        float acum = 0;
        for(int cont = 0 ; cont <num_filas; cont++)
        {
            String usado = tabla.getValueAt(cont, 6).toString();
            float converter  = Float.parseFloat(usado);
            acum = acum + converter;
        }
      
        n = Float.toString((acum));
        
        lbltot_ven.setText(n);
    }
    
    public void Comprobante()
    {
        Comprobante_Factura factu = new Comprobante_Factura();
        Conexion c = new Conexion();
        Connection link = c.Conec();
        int fila = tabla.getSelectedRow();
        if(fila >= 0)
        {
        String num_factura = tabla.getValueAt(fila, 0).toString();
        String cedula = tabla.getValueAt(fila, 1).toString();
        String fecha = tabla.getValueAt(fila, 2).toString();
        String Hora = tabla.getValueAt(fila, 3).toString();
        String Subtotal = tabla.getValueAt(fila, 4).toString();
        String Iva = tabla.getValueAt(fila, 5).toString();
        String Total = tabla.getValueAt(fila, 6).toString();          
        factu.txtFecha.setText(fecha);
        factu.txtHora.setText(Hora);
        factu.txtSub.setText(Subtotal);
        factu.txtIva.setText(Iva);
        factu.txtTot.setText(Total);
        factu.txtCi.setText(cedula);
        factu.lblNum_Fac.setText(num_factura);
        try
        {
            PreparedStatement pst = link.prepareStatement("SELECT * FROM clientes WHERE Cedula = '"+cedula+"'");
            ResultSet rs = pst.executeQuery();
            rs.next();
            factu.txtNom.setText(rs.getString(3)+" "+rs.getString(4));
            factu.txtDir.setText(rs.getString(5));
            factu.txtTel.setText(rs.getString(9));
            factu.txtCel.setText(rs.getString(8));
            factu.correo.setText(correo.getText());
             factu.nom.setText(nom.getText());
        factu.ape.setText(ape.getText());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
            String arreglo[] = new String[5];
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("CODIGO");
            modelo.addColumn("DESCRIPCION");
            modelo.addColumn("CANTIDAD");
            modelo.addColumn("P.UNIT");
            modelo.addColumn("TOTAL");     
            PreparedStatement pst = link.prepareStatement("SELECT * FROM detalle_factura WHERE Num_Factura = '"+num_factura+"'");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                arreglo[0] = rs.getString(2);
                arreglo[1] = rs.getString(3);
                arreglo[2] = rs.getString(4);
                arreglo[3] = rs.getString(5);
                arreglo[4] = rs.getString(6);
                modelo.addRow(arreglo);
            }
            factu.tabla.setModel(modelo);
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        factu.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Venta");
        }
    }
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
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Facturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CmbMes;
    public static transient javax.swing.JTextField ape;
    public static transient javax.swing.JTextField correo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblnum_ven;
    private javax.swing.JLabel lbltot_ven;
    public static transient javax.swing.JTextField nom;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
