/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Clases.Control;
import Clases.Panel;
import Jdbc.Conexion;
import com.sun.awt.AWTUtilities;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author anthony
 */
public class Lista_Pedidos extends javax.swing.JFrame implements Printable {

    /**
     * Creates new form Lista_Pedidos
     */
        private final String ruta = System.getProperties().getProperty("user.dir");

    public Lista_Pedidos() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Pedidos");
        Cargar();
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Modificar_ = new javax.swing.JMenuItem();
        Eliminar_ = new javax.swing.JMenuItem();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        Modificar_.setText("Detalle");
        Modificar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modificar_ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Modificar_);

        Eliminar_.setText("Eliminar");
        jPopupMenu1.add(Eliminar_);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura.jpg"))); // NOI18N
        jLabel8.setText("jLabel7");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 130, 90));

        Tablas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tablas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 870, 340));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 153, 0));
        jLabel1.setText("PEDIDOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 730, 86));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ID me.png"))); // NOI18N
        jButton1.setText("Ver Detalle");
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

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full me.png"))); // NOI18N
        jButton4.setText("Eliminar");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full grande.png"))); // NOI18N
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full grande.png"))); // NOI18N
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/excel.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setDefaultCapable(false);
        jButton6.setFocusPainted(false);
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(26, 26, 26)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 120, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/inventario_1.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 490));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modificar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Modificar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar_ActionPerformed
        modificar();
    }//GEN-LAST:event_Modificar_ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int confirmacion;
        confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el pedido?", "Eliminación", JOptionPane.YES_NO_OPTION);
        if(confirmacion == JOptionPane.YES_OPTION)
        {
            Eliminar();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        XSSFWorkbook  workbook = new XSSFWorkbook ();
        XSSFSheet hoja = workbook.createSheet();
         XSSFRow fila1 = hoja.createRow(0);
        XSSFRow fila = hoja.createRow(2);
 String x;
      Panel y = new Panel();
      x = y.Fecha();
     
      
        Control p = new Control();
        Calendar hour = new GregorianCalendar();
        int h,m,s;
        String hora;
        h = hour.get(Calendar.HOUR_OF_DAY);
        m = hour.get(Calendar.MINUTE);
        s = hour.get(Calendar.SECOND);
        hora = h+":"+m+":"+s;
     
     
        fila1.createCell(0).setCellValue("Reporte Pedidos");
        fila1.createCell(1).setCellValue("Fecha de reporte:  "+x);
        fila1.createCell(2).setCellValue("Hora de reporte:  "+hora);
        fila.createCell(0).setCellValue("Codigo");
        fila.createCell(1).setCellValue("Nombre");
        fila.createCell(2).setCellValue("Proveedor");
        fila.createCell(3).setCellValue("Descripcion");
        fila.createCell(4).setCellValue("Fecha_Pedido");
        fila.createCell(5).setCellValue("Fecha_Entrega");


        XSSFRow filas;
        Rectangle rect;
        for(int i = 0; i <Tablas.getRowCount(); i++){
            rect = Tablas.getCellRect(i,0 , true);
            try{
                Tablas.scrollRectToVisible(rect);
            }catch(java.lang.ClassCastException e){

            }
            Tablas.setRowSelectionInterval(i,i);
            filas = hoja.createRow((i+3));
            filas.createCell(0).setCellValue(Tablas.getValueAt(i, 0).toString());

            filas.createCell(1).setCellValue(Tablas.getValueAt(i, 1).toString());
            filas.createCell(2).setCellValue(Tablas.getValueAt(i, 2).toString());
            filas.createCell(3).setCellValue(Tablas.getValueAt(i, 3).toString());
            filas.createCell(4).setCellValue(Tablas.getValueAt(i, 4).toString());
            filas.createCell(5).setCellValue(Tablas.getValueAt(i, 5).toString());
           

        }
        try{
            workbook.write(new FileOutputStream(new File(ruta+"//Reporte_Lista_Pedidos.xlsx")));
            Desktop.getDesktop().open(new File(ruta+"//Reporte_Lista_Pedidos.xlsx"));
        }catch (Exception ex){
            Logger.getLogger(Lista_Pedidos.class.getName()).log(Level.SEVERE, null,ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    public void Cargar()
    {
        String arreglo[] = new String[7];
        Conexion cn = new Conexion();
        Connection link = cn.Conec();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Fecha de Pedido");
        modelo.addColumn("Fecha de Entrega");
        try
        {
            PreparedStatement pst = link.prepareStatement("SELECT * FROM Pedidos");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
                arreglo[2] = rs.getString(4);
                arreglo[3] = rs.getString(5);
                arreglo[4] = rs.getString(6);
                arreglo[5] = rs.getString(7);
                modelo.addRow(arreglo);
            }
            Tablas.setModel(modelo);
            pst.close();
            rs.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
    }
    
    public void modificar()
    {
        Form_Pedidos form = new Form_Pedidos();
        DefaultTableModel modelo = new DefaultTableModel();
        int fila = Tablas.getSelectedRow();
        form.txtCod.setText(Tablas.getValueAt(fila, 0).toString());
        form.txtPed.setText(Tablas.getValueAt(fila, 1).toString());
        form.CmbProv.setSelectedItem(Tablas.getValueAt(fila, 2).toString());
        form.txtDes.setText(Tablas.getValueAt(fila, 3).toString());
        form.txtFe_Pe.setText(Tablas.getValueAt(fila, 4).toString());
        form.lblDia_llegada.setText(Tablas.getValueAt(fila,5).toString());
        form.CmbDia.setEnabled(false);
        form.Jaño.setEnabled(false);
        form.Jmes.setEnabled(false);
        form.btnAceptar.setEnabled(false);
        form.CmbProv.setEnabled(false);
        form.setVisible(true);
    }
    
    public void Eliminar()
    {
        Conexion cn = new Conexion();
        Connection link = cn.Conec();
        int confirma = JOptionPane.showConfirmDialog(null, "¿Seguro Desea eliminar el pedido?","Confirmacion",JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION)
        {
        int fila = Tablas.getSelectedRow();
        if(fila >= 0)
        {
            String codigo = Tablas.getValueAt(fila, 0).toString();
           try
           {
             PreparedStatement pst = link.prepareStatement("DELETE FROM Pedidos WHERE Codigo = '"+codigo+"'");
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Pedido Eliminado");
             Cargar();
           }
           catch(Exception e)
           {
             e.printStackTrace();
           }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione un Pedido");
        }
        }
    }
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
            java.util.logging.Logger.getLogger(Lista_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lista_Pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar_;
    private javax.swing.JMenuItem Modificar_;
    private javax.swing.JTable Tablas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
public int print(Graphics graphics, PageFormat pageFormat, int index) throws PrinterException 
 {
        if (index > 0)
        {
            
            return NO_SUCH_PAGE;
        }
        Graphics2D hub =    (Graphics2D) graphics;
        hub.translate(pageFormat.getImageableX()+30, pageFormat.getImageableY()+30);
        hub.scale(0.5, 0.5);
        Sistema_Ventas oe = new Sistema_Ventas();
   printAll(graphics);
        return PAGE_EXISTS;
    }
}
