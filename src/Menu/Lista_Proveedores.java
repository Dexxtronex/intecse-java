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
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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

public class Lista_Proveedores extends javax.swing.JFrame {

    String recogedor = "";
    String añadido = "";
    String tabla_Codigo;
    private final String ruta = System.getProperties().getProperty("user.dir");
    public Lista_Proveedores() {
        initComponents();
        txtBus.setEnabled(false);
        setLocationRelativeTo(null);
        setTitle("Lista de Proveedores");
        Tablas();
    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }

    public void Tablas() {
        String sql;
        Conexion con = new Conexion();
        Connection cn = con.Conec();
        try {
            Statement st = cn.createStatement();
            sql = "Select * from proveedores";
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int j = 1; j <= col; j++) {
                modelo.addColumn(rsmd.getColumnLabel(j));
            }
            while (rs.next()) {
                String fila[] = new String[col];
                for (int cont = 0; cont < col; cont++) {
                    fila[cont] = rs.getString(cont + 1);
                }
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            rs.close();
            cn.close();

        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, x);
        }

    }
    public String getTabla_Codigo()
    {
        return tabla_Codigo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clasifican = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        btnCan = new javax.swing.JButton();
        txtBus = new javax.swing.JTextField();
        rdioCod = new javax.swing.JRadioButton();
        rdioNom = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 153, 0));
        jLabel1.setText("LISTA DE PROVEEDORES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 360, 34));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 680, 240));

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
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));

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
        getContentPane().add(btnCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, -1, -1));

        txtBus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusKeyReleased(evt);
            }
        });
        getContentPane().add(txtBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 291, -1));

        rdioCod.setBackground(new java.awt.Color(255, 255, 255));
        clasifican.add(rdioCod);
        rdioCod.setText("Por Codigo");
        rdioCod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdioCodMouseClicked(evt);
            }
        });
        rdioCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdioCodActionPerformed(evt);
            }
        });
        getContentPane().add(rdioCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        rdioNom.setBackground(new java.awt.Color(255, 255, 255));
        clasifican.add(rdioNom);
        rdioNom.setText("Por Nombre");
        rdioNom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdioNomMouseClicked(evt);
            }
        });
        getContentPane().add(rdioNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/Lista de Proveedores.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 720, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void txtBusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusKeyReleased
        String m,Clasificacion;
        m = txtBus.getText();
        recogedor = añadido+m;
        System.out.println(recogedor);
        Control co = new Control();
        Conexion con = new Conexion();
        Connection link = con.Conec();
        Clasificacion = getTabla_Codigo();
        System.out.println(Clasificacion);
        try
        {
            String sql = "SELECT * FROM proveedores WHERE "+Clasificacion+" like "+"'"+recogedor+"%\'";
            System.out.println(sql);
            PreparedStatement pst = link.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int j = 1; j <= col; j++) {
                modelo.addColumn(rsmd.getColumnLabel(j));
            }
            while (rs.next()) {
                String fila[] = new String[col];
                for (int cont = 0; cont < col; cont++) {
                    fila[cont] = rs.getString(cont + 1);
                }
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            rs.close();
            link.close();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
        
    }//GEN-LAST:event_txtBusKeyReleased

    private void rdioCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdioCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdioCodActionPerformed

    private void rdioCodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdioCodMouseClicked
        txtBus.setEnabled(true);
        Control co = new Control();
        tabla_Codigo = rdioCod.getText();
        if(tabla_Codigo.equals("Por Codigo"))
            tabla_Codigo = "Codigo";
        co.Clasifica(tabla_Codigo);
        añadido = "JAM_PROV000";
    }//GEN-LAST:event_rdioCodMouseClicked

    private void rdioNomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdioNomMouseClicked
        txtBus.setEnabled(true);
        Control co = new Control();
        tabla_Codigo = rdioNom.getText();
        if(tabla_Codigo.equals("Por Nombre"))
            tabla_Codigo = "Nombre";
        co.Clasifica(tabla_Codigo);
        añadido = "";
    }//GEN-LAST:event_rdioNomMouseClicked

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
     
     
        fila1.createCell(0).setCellValue("Reporte de Proveedoress");
        fila1.createCell(1).setCellValue("Fecha de reporte:  "+x);
        fila1.createCell(2).setCellValue("Hora de reporte:  "+hora);
        fila.createCell(0).setCellValue("Codigo");
        fila.createCell(1).setCellValue("Nombre");
        fila.createCell(2).setCellValue("Direccion");
        fila.createCell(3).setCellValue("Telefono");
        fila.createCell(4).setCellValue("Correo");
        fila.createCell(5).setCellValue("Productos");
        fila.createCell(6).setCellValue("Celular");
      
        
        
      

        XSSFRow filas;
        Rectangle rect;
        for(int i = 0; i <tabla.getRowCount(); i++){
            rect = tabla.getCellRect(i,0 , true);
            try{
                tabla.scrollRectToVisible(rect);
            }catch(java.lang.ClassCastException e){

            }
            tabla.setRowSelectionInterval(i,i);
            filas = hoja.createRow((i+1));
            filas.createCell(0).setCellValue(tabla.getValueAt(i, 0).toString());

            filas.createCell(1).setCellValue(tabla.getValueAt(i, 1).toString());
            filas.createCell(2).setCellValue(tabla.getValueAt(i, 2).toString());
            filas.createCell(3).setCellValue(tabla.getValueAt(i, 3).toString());
            filas.createCell(4).setCellValue(tabla.getValueAt(i, 4).toString());
            filas.createCell(5).setCellValue(tabla.getValueAt(i, 5).toString());
            filas.createCell(6).setCellValue(tabla.getValueAt(i, 6).toString());
            
        }
        try{
            workbook.write(new FileOutputStream(new File(ruta+"//Reporte_Lista_Proveedores.xlsx")));
            Desktop.getDesktop().open(new File(ruta+"//Reporte_Lista_Proveedores.xlsx"));
        }catch (Exception ex){
            Logger.getLogger(Lista_Proveedores.class.getName()).log(Level.SEVERE, null,ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        dispose();
       
    }//GEN-LAST:event_btnCanActionPerformed

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
            java.util.logging.Logger.getLogger(Lista_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lista_Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCan;
    public static javax.swing.ButtonGroup clasifican;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdioCod;
    private javax.swing.JRadioButton rdioNom;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBus;
    // End of variables declaration//GEN-END:variables
}
