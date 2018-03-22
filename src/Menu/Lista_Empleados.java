package Menu;
import Clases.Control;
import Clases.Panel;
import Jdbc.Conexion;
import static Menu.Buscar.*;
import com.sun.awt.AWTUtilities;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.*;
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
public class Lista_Empleados extends javax.swing.JFrame {
    private final String ruta = System.getProperties().getProperty("user.dir");
    public Lista_Empleados() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Empleados");
        tabla.setEnabled(true);
        Tablas();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }
    @SuppressWarnings("unchecked")
    
    public void UsuPass()
    {
        Conexion cn = new Conexion(); 
        Connection link = cn.Conec();
        try
            { 
                PreparedStatement usu = link.prepareStatement("SELECT * FROM formulario WHERE Nombres = '"+txtnom.getText()+"' && Apellidos = '"+txtape.getText()+"'");
                ResultSet rs = usu.executeQuery();
                if(rs.next())
                {
                String x = rs.getString(8);
                String y = rs.getString(9);
                txtusu.setText(x);
                txtcon.setText(y);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error");
            }
    }
    
    public void Tablas() 
    { 
        String sql,s;
        Conexion con = new Conexion();
        Connection cn = con.Conec();
       try
       {
           int conta = 0,repe = 0;
        Statement st = cn.createStatement();
        sql = "Select * from formulario";
        ResultSet rs = st.executeQuery(sql);
        ResultSetMetaData rsmd =  rs.getMetaData();
        int col = rsmd.getColumnCount();
        DefaultTableModel modelo = new DefaultTableModel();
        for(int j=1; j<= col;j++)
        {
            s = rsmd.getColumnLabel(j);
            if(s.equals("Usuario"))
                continue;
            if(s.equals("Contraseña"))
                continue;
            modelo.addColumn(rsmd.getColumnLabel(j));
           
            conta++;
        }
        while(rs.next())
        {
        String fila[] = new String [col];
        for(int cont=0;cont<=col ;cont++)
        {
            if(cont == 7)
            {
                fila[cont] = rs.getString(10);
                continue;
            }
            if(cont == 8)
            {
                fila[cont] = rs.getString(11);
                continue;
            }
            if(cont == 9)
            {
                fila[cont] = rs.getString(12);
                break;
            }
         fila[cont] = rs.getString(cont+1);
        }
        modelo.addRow(fila);
        }
        tabla.setModel(modelo);
        rs.close();
        cn.close();
        
    }
    catch(SQLException x)
    {
        JOptionPane.showMessageDialog(null,x);
    }  

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MEclic = new javax.swing.JPopupMenu();
        ELmod = new javax.swing.JMenuItem();
        ELel = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        btnBus = new javax.swing.JButton();
        btnCan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnActu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        ELmod.setText("Modificar");
        ELmod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELmodActionPerformed(evt);
            }
        });
        MEclic.add(ELmod);

        ELel.setText("Eliminar");
        ELel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ELelMouseClicked(evt);
            }
        });
        ELel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELelActionPerformed(evt);
            }
        });
        MEclic.add(ELel);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Iskoola Pota", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 153, 0));
        jLabel1.setText("LISTA DE EMPLEADOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 540, 46));

        btnBus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search me.png"))); // NOI18N
        btnBus.setText("Buscar");
        btnBus.setBorderPainted(false);
        btnBus.setContentAreaFilled(false);
        btnBus.setFocusPainted(false);
        btnBus.setFocusable(false);
        btnBus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBus.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search gr.png"))); // NOI18N
        btnBus.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search gr.png"))); // NOI18N
        btnBus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusActionPerformed(evt);
            }
        });
        getContentPane().add(btnBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 88, -1));

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
        getContentPane().add(btnCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombres", "Apellidos", "Cedula", "Nacimiento", "Sexo", "Correo", "Telefono", "Celular", "Direccion", "Tipo de Usuario"
            }
        ));
        tabla.setComponentPopupMenu(MEclic);
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 174, 1050, 190));

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
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 90, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 160, 120));

        btnActu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload me.png"))); // NOI18N
        btnActu.setText("Actualizar");
        btnActu.setBorderPainted(false);
        btnActu.setContentAreaFilled(false);
        btnActu.setDefaultCapable(false);
        btnActu.setFocusPainted(false);
        btnActu.setFocusable(false);
        btnActu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActu.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        btnActu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        btnActu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActuActionPerformed(evt);
            }
        });
        getContentPane().add(btnActu, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration me.png"))); // NOI18N
        jButton1.setText("Modificar");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setDefaultCapable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full me.png"))); // NOI18N
        jButton2.setText("Eliminar");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/inventario_1.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusActionPerformed
        Buscar t = new Buscar();
        t.setVisible(true);
    }//GEN-LAST:event_btnBusActionPerformed

    private void ELmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELmodActionPerformed
        Conexion cn = new Conexion(); 
        Connection link = cn.Conec();
         String usua = "", contra = "";
        Buscar b = new Buscar();
        
        b.txtci.setEnabled(true);
        b.txtnom.setEnabled(true);
        b.txtape.setEnabled(true);
        b.txtfn.setEnabled(true);
        b.txtsex.setEnabled(true);
        b.txtcor.setEnabled(true);
        b.txtdir.setEnabled(true);
        b.txtusu.setEnabled(false);
        b.txtcon.setEnabled(false);
        b.txttip_usu.setEnabled(true);
        b.txtcel.setEnabled(true);
        b.txttel.setEnabled(true);
        b.btnbus.setEnabled(false);
        b.btnEli.setEnabled(true);
        int fila = tabla.getSelectedRow();
        if(fila >=0)
        {
        b.txtnom.setText(tabla.getValueAt(fila, 0).toString());
        b.txtape.setText(tabla.getValueAt(fila, 1).toString());
        b.txtfn.setText(tabla.getValueAt(fila, 2).toString());
        b.txtci.setText(tabla.getValueAt(fila, 3).toString());
        b.txttel.setText(tabla.getValueAt(fila, 4).toString());
        b.txtcel.setText(tabla.getValueAt(fila, 5).toString());
        b.txtdir.setText(tabla.getValueAt(fila, 6).toString());
        b.txtsex.setText(tabla.getValueAt(fila, 7).toString());
        b.txttip_usu.setText(tabla.getValueAt(fila, 8).toString());
        b.txtcor.setText(tabla.getValueAt(fila, 9).toString());
        b.txtusu.setText(usua);
        b.txtcon.setText(contra);
        UsuPass();
        b.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Seleccione una fila");
        }
                          
    }//GEN-LAST:event_ELmodActionPerformed

    private void btnActuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActuActionPerformed
        Tablas();
    }//GEN-LAST:event_btnActuActionPerformed

    private void ELelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ELelMouseClicked

    }//GEN-LAST:event_ELelMouseClicked

    private void ELelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELelActionPerformed
        Conexion con = new Conexion();
        Connection link = con.Conec();
        try
        {
            int fila = tabla.getSelectedRow();
            int ced = Integer.parseInt(tabla.getValueAt(fila, 3).toString());
            PreparedStatement pst = link.prepareStatement("DELETE FROM formulario WHERE Cedula = '"+ced+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Eliminados Satisfactoriamente");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_ELelActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Conexion con = new Conexion();
        Connection link = con.Conec();
       
        int confirmacion;
        confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el proveedor?","Eliminación",JOptionPane.YES_NO_OPTION);
        if(confirmacion == JOptionPane.YES_OPTION)
        {
            try
        {
            int fila = tabla.getSelectedRow();
            int ced = Integer.parseInt(tabla.getValueAt(fila, 3).toString());
            PreparedStatement pst = link.prepareStatement("DELETE FROM formulario WHERE Cedula = '"+ced+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Eliminados Satisfactoriamente");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
            
        }       
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Conexion cn = new Conexion(); 
        Connection link = cn.Conec();
         String usua = "", contra = "";
        Buscar b = new Buscar();
        
        b.txtci.setEnabled(true);
        b.txtnom.setEnabled(true);
        b.txtape.setEnabled(true);
        b.txtfn.setEnabled(true);
        b.txtsex.setEnabled(true);
        b.txtcor.setEnabled(true);
        b.txtdir.setEnabled(true);
        b.txtusu.setEnabled(false);
        b.txtcon.setEnabled(false);
        b.txttip_usu.setEnabled(true);
        b.txtcel.setEnabled(true);
        b.txttel.setEnabled(true);
        b.btnbus.setEnabled(false);
        b.btnEli.setEnabled(true);
        int fila = tabla.getSelectedRow();
        if(fila >=0)
        {
        b.txtnom.setText(tabla.getValueAt(fila, 0).toString());
        b.txtape.setText(tabla.getValueAt(fila, 1).toString());
        b.txtfn.setText(tabla.getValueAt(fila, 2).toString());
        b.txtci.setText(tabla.getValueAt(fila, 3).toString());
        b.txttel.setText(tabla.getValueAt(fila, 4).toString());
        b.txtcel.setText(tabla.getValueAt(fila, 5).toString());
        b.txtdir.setText(tabla.getValueAt(fila, 6).toString());
        b.txtsex.setText(tabla.getValueAt(fila, 7).toString());
        b.txttip_usu.setText(tabla.getValueAt(fila, 8).toString());
        b.txtcor.setText(tabla.getValueAt(fila, 9).toString());
        b.txtusu.setText(usua);
        b.txtcon.setText(contra);
        UsuPass();
        b.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Seleccione una fila");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
     
     
        fila1.createCell(0).setCellValue("Reporte de empleados");
        fila1.createCell(1).setCellValue("Fecha de reporte:  "+x);
        fila1.createCell(2).setCellValue("Hora de reporte:  "+hora);
        
        fila.createCell(0).setCellValue("Nombre");
        fila.createCell(1).setCellValue("Apellido");
         fila.createCell(2).setCellValue("Fecha_Nacimiento");
        fila.createCell(3).setCellValue("C.I");
       fila.createCell(4).setCellValue("Telefono");
        fila.createCell(5).setCellValue("Celular");
          fila.createCell(6).setCellValue("Direccion");
        fila.createCell(7).setCellValue("Sexo");
         fila.createCell(8).setCellValue("Tipo_Usuario");
        fila.createCell(9).setCellValue("Correo");
        
      
       
        XSSFRow filas;
        Rectangle rect;
        for(int i = 0; i <tabla.getRowCount(); i++){
            rect = tabla.getCellRect(i,0 , true);
            try{
                tabla.scrollRectToVisible(rect);
            }catch(java.lang.ClassCastException e){

            }
            tabla.setRowSelectionInterval(i,i);
            filas = hoja.createRow((i+3));
            filas.createCell(0).setCellValue(tabla.getValueAt(i, 0).toString());

            filas.createCell(1).setCellValue(tabla.getValueAt(i, 1).toString());
            filas.createCell(2).setCellValue(tabla.getValueAt(i, 2).toString());
            filas.createCell(3).setCellValue(tabla.getValueAt(i, 3).toString());
            filas.createCell(4).setCellValue(tabla.getValueAt(i, 4).toString());
            filas.createCell(5).setCellValue(tabla.getValueAt(i, 5).toString());
            filas.createCell(6).setCellValue(tabla.getValueAt(i, 6).toString());
            filas.createCell(7).setCellValue(tabla.getValueAt(i, 7).toString());
            filas.createCell(8).setCellValue(tabla.getValueAt(i, 8).toString());
            filas.createCell(9).setCellValue(tabla.getValueAt(i, 9).toString());
        }
        try{
            workbook.write(new FileOutputStream(new File(ruta+"//Reporte_Lista_Empleados.xlsx")));
            Desktop.getDesktop().open(new File(ruta+"//Reporte_Lista_Empleados.xlsx"));
        }catch (Exception ex){
            Logger.getLogger(Lista_Empleados.class.getName()).log(Level.SEVERE, null,ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        dispose();
    }//GEN-LAST:event_btnCanActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lista_Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ELel;
    private javax.swing.JMenuItem ELmod;
    private javax.swing.JPopupMenu MEclic;
    private javax.swing.JButton btnActu;
    private javax.swing.JButton btnBus;
    private javax.swing.JButton btnCan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
