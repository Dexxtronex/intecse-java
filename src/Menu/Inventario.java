package Menu;

import Clases.Carga_ComboBox;
import Clases.Codigo;
import Jdbc.Conexion_cat;
import Login.Sesion;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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

public class Inventario extends javax.swing.JFrame implements Printable{

    Conexion_cat cn = new Conexion_cat();
    Connection link = cn.ConecCat();
    private final String ruta = System.getProperties().getProperty("user.dir");
    
    public Inventario() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Inventario");
        Columnas();
        Cargar();
        Combo();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }
public Inventario(int j) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Inventario");
        Columnas();
        Cargar();
        Combo();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Modificar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        CmbCat = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lblTip_Pro = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Modificar);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tabla.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 156, 930, 333));

        CmbCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "......" }));
        CmbCat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbCatItemStateChanged(evt);
            }
        });
        CmbCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbCatActionPerformed(evt);
            }
        });
        getContentPane().add(CmbCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 173, 20));

        jLabel3.setText("TIPO DE PRODUCTO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 509, 190, -1));
        getContentPane().add(lblTip_Pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 510, 62, 14));

        jLabel8.setText("CANTIDAD DE PRODUCTOS:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 509, 260, -1));

        jLabel10.setText("FILTRAR POR CATEGORIA");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 120, 230, -1));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, 67, 14));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration me.png"))); // NOI18N
        jButton1.setText("MODIFICAR");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration grande.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration grande.png"))); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full me.png"))); // NOI18N
        jButton2.setText("ELIMINAR");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full grande.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full grande.png"))); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/excel.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setDefaultCapable(false);
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload me.png"))); // NOI18N
        jButton4.setText("CANCELAR");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(236, 201, 111));
        jButton5.setText("ACTUALIZAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration me.png"))); // NOI18N
        jButton3.setText("VER");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration grande.png"))); // NOI18N
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration grande.png"))); // NOI18N
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 60, 110, 490));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 153, 0), 1, true));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 153, 0));
        jLabel2.setText("INVENTARIO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel2)
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 780, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, 100));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/inventario_1.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Cantidades() {
        int num_filas = tabla.getRowCount(), acum = 0, c;
        String converter = Integer.toString(num_filas);
        lblTip_Pro.setText(converter);
        for (int cont = 0; cont < num_filas; cont++) {
            converter = tabla.getValueAt(cont, 2).toString();
            c = Integer.parseInt(converter);
            acum = acum + c;
        }
        converter = Integer.toString(acum);
        jLabel6.setText(converter);
    }

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        modificar();
    }//GEN-LAST:event_ModificarActionPerformed

    public void modificar()
    {  try {
        int fila = tabla.getSelectedRow();
            if (fila >= 0) {
       
            New_Mercaderia merc = new New_Mercaderia((tabla.getValueAt(fila, 4).toString()),tabla.getValueAt(fila, 1).toString());
            merc.btnSave.setEnabled(false);
            merc.btnMod.setEnabled(true);
            merc.btnEli.setEnabled(true);

           
                merc.txtCod.setText(tabla.getValueAt(fila, 0).toString());
                merc.txtNom_Pro.setText(tabla.getValueAt(fila, 1).toString());
                merc.txtCanti.setText(tabla.getValueAt(fila, 2).toString());
                merc.CmbPro1.setSelectedItem(tabla.getValueAt(fila, 3).toString());               
                merc.CmbCat.setSelectedItem(tabla.getValueAt(fila, 4).toString());
                merc.tare_desc.setText(tabla.getValueAt(fila, 5).toString());
                merc.txtPre_uni.setText(tabla.getValueAt(fila, 6).toString());
                merc.txtDia_lle.setText(tabla.getValueAt(fila, 7).toString());
                merc.txtHora_lle.setText(tabla.getValueAt(fila, 8).toString());
                 merc.txtCompra.setText(tabla.getValueAt(fila, 9).toString());
                 merc.txtPrecioMayor.setText(tabla.getValueAt(fila, 10).toString());
                merc.txtPrecioTar.setText(tabla.getValueAt(fila, 11).toString());
                merc.txtCantiMini.setText( tabla.getValueAt(fila, 12).toString());
           
                merc.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    public void ver()
    {
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
            New_Mercaderia merc = new New_Mercaderia((tabla.getValueAt(fila, 4).toString()),tabla.getValueAt(fila, 1).toString());
            merc.btnSave.setEnabled(false);
            merc.btnMod.setEnabled(true);
            merc.btnFechaHora.setEnabled(false);
            merc.btnEli.setEnabled(true);
            merc.txtCod.setEnabled(false);
            merc.txtNom_Pro.setEnabled(false);
            merc.txtCanti.setEnabled(false);
            merc.CmbPro1.setEnabled(false);
            merc.CmbCat.setEnabled(false);
            merc.tare_desc.setEnabled(false);
            merc.txtPre_uni.setEnabled(false);
            merc.txtDia_lle.setEnabled(false);
            merc.txtCompra.setEnabled(false);
            merc.txtCompra.setText("");
            merc.txtPrecioMayor.setEnabled(false);
            merc.txtPrecioTar.setEnabled(false);
            merc.CmbV.setEnabled(false);
            merc.CmbM.setEnabled(false);
            merc.CmbPorcTC1.setEnabled(false);
            merc.txtHora_lle.setEnabled(false);
            merc.btnMod.setEnabled(false);
            merc.btnEli.setEnabled(false);
           
                merc.txtCod.setText(tabla.getValueAt(fila, 0).toString());
                merc.txtNom_Pro.setText(tabla.getValueAt(fila, 1).toString());
                merc.txtCanti.setText(tabla.getValueAt(fila, 2).toString());
                merc.CmbPro1.setSelectedItem(tabla.getValueAt(fila, 3).toString());               
                merc.CmbCat.setSelectedItem(tabla.getValueAt(fila, 4).toString());
                merc.tare_desc.setText(tabla.getValueAt(fila, 5).toString());
                merc.txtPre_uni.setText(tabla.getValueAt(fila, 6).toString());
                merc.txtDia_lle.setText(tabla.getValueAt(fila, 7).toString());
                merc.txtHora_lle.setText(tabla.getValueAt(fila, 8).toString());
                   merc.txtPrecioMayor.setText(tabla.getValueAt(fila, 10).toString());
                merc.txtPrecioTar.setText(tabla.getValueAt(fila, 11).toString());

                merc.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    public void Eliminar()
    {
        Conexion_cat cn = new Conexion_cat();
        Connection link = cn.ConecCat();
        int fila = tabla.getSelectedRow();
        String cod = tabla.getValueAt(fila, 0).toString();
        if (fila >= 0) {
            String Cate = tabla.getValueAt(fila, 4).toString();
            if (Cate.equals("....")) {
                JOptionPane.showMessageDialog(null, "Escoja una Categoria");
            }
            try {
                PreparedStatement pst = link.prepareStatement("DELETE FROM " + Cate + " WHERE Codigo = '" + cod + "'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Eliminado con Exito");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una Fila");
        }
    }
    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        Eliminar();
    }//GEN-LAST:event_EliminarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        XSSFWorkbook  workbook = new XSSFWorkbook ();
        XSSFSheet hoja = workbook.createSheet();
        XSSFRow fila = hoja.createRow(0);

        fila.createCell(0).setCellValue("Codigo");
        fila.createCell(1).setCellValue("Nombre");
        fila.createCell(2).setCellValue("Cantidad");
        fila.createCell(3).setCellValue("Proveedor");
        fila.createCell(4).setCellValue("Categoria");
        fila.createCell(5).setCellValue("Descripcion");
        fila.createCell(6).setCellValue("Precio_Unit");
        fila.createCell(7).setCellValue("Dia_Llegada");
        fila.createCell(8).setCellValue("Hora_Llegada");

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
            filas.createCell(7).setCellValue(tabla.getValueAt(i, 7).toString());
            filas.createCell(8).setCellValue(tabla.getValueAt(i, 8).toString());
        }
        try{
            workbook.write(new FileOutputStream(new File(ruta+"//Reporte_Inventario.xlsx")));
            Desktop.getDesktop().open(new File(ruta+"//Reporte_Inventario.xlsx"));
        }catch (Exception ex){
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null,ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void CmbCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbCatActionPerformed
        
    }//GEN-LAST:event_CmbCatActionPerformed

    private void CmbCatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbCatItemStateChanged
        filtrar();
        Cantidades();
    }//GEN-LAST:event_CmbCatItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Cargar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int confirmacion;
        confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar ese articulo?", "Eliminación de producto", JOptionPane.YES_NO_OPTION);
        if(confirmacion == JOptionPane.YES_OPTION)
        {
            Eliminar();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modificar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
ver();    }//GEN-LAST:event_jButton3ActionPerformed

    public void Combo() {
        ResultSet rs;
        Carga_ComboBox combo = new Carga_ComboBox();
        try {
            rs = combo.Categoria();
               while (rs.next()) {
                CmbCat.addItem(rs.getString(1));
                 }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
    
   

    public void filtrar() {
        String combo = CmbCat.getSelectedItem().toString();
        if (combo.equals("......")) {
            Cargar();
        }
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Categoria");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Pr Unitario");
        modelo.addColumn("Dia_Llegada");
        modelo.addColumn("Hora_Llegada");
         modelo.addColumn("Pr Compra");
        modelo.addColumn("Pr Por Mayor");
        modelo.addColumn("Pr Tarjeta Cr.");
        String vector[] = new String[12];
        if (!(combo.equals("......"))) {
            try {
                // 1 2 3 4 6 7 89 5
                PreparedStatement pst = link.prepareStatement("SELECT * FROM " + combo);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    vector[0] = rs.getString(1);
                    vector[1] = rs.getString(2);
                    vector[2] = rs.getString(3);
                    vector[3] = rs.getString(4);
                    vector[4] = rs.getString(5);
                    vector[5] = rs.getString(6);
                    vector[6] = rs.getString(7);
                    vector[7] = rs.getString(8);
                    vector[8] = rs.getString(9);
                    vector[9] = rs.getString(12);
                    vector[10] = rs.getString(13);
                     vector[11] = rs.getString(14);
                    modelo.addRow(vector);
                }
                pst.close();
                rs.close();
                tabla.setModel(modelo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }
    }

    public void Columnas()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Categoria");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Pr Unitario");
        modelo.addColumn("Dia_Llegada");
        modelo.addColumn("Hora_Llegada");
        tabla.setModel(modelo);
    }
    
    public void Cargar()  {
        int limite,tables;
        Codigo co = new Codigo();
        String arreglo[] = co.Codigos();
        limite = co.retornador();
        DefaultTableModel modelo = new DefaultTableModel();
        
        //Se agregan etiquetas a las tablas
         modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Proveedor");
                modelo.addColumn("Categoria");

        modelo.addColumn("Descripcion");
        modelo.addColumn("Pr Unitario");
        modelo.addColumn("Dia_Llegada");
        modelo.addColumn("Hora_Llegada");
        modelo.addColumn("Pr Compra");
        modelo.addColumn("Pr Por Mayor");
        modelo.addColumn("Pr Tarjeta Cr.");
        modelo.addColumn("Stock Min");

        //Se llenan las filas con los datoas de los productos
        
        for(tables = 1; tables <= limite; tables++)
        { 
          try
          {
            String sql = "SELECT * FROM "+arreglo[tables];
            PreparedStatement pst = link.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            int desplazar=0;
            while (rs.next()) 
            {   
                String fila[] = new String[col];
                for (int cont = 0; cont < 9; cont++) 
                {   
                    System.out.println("CONTADOR "+cont+"desplazar"+desplazar);
                   
                    fila[cont] = rs.getString(cont + 1);
                   
                  
                }
                  fila[9] = rs.getString(12);
                    fila[10] = rs.getString(13);
                      fila[11] = rs.getString(14);
                      fila[12] = rs.getString(15);
                modelo.addRow(fila); 
            }   
          }

          
          catch(SQLException e)
          {
            JOptionPane.showMessageDialog(null,e);
          }
          catch(Exception ex)
          {
            JOptionPane.showMessageDialog(null, ex);
          }
        }
        tabla.setModel(modelo);
        Cantidades();
    }
        
    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CmbCat;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JMenuItem Modificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTip_Pro;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graf, PageFormat pagfor, int index) throws PrinterException {
       if(index>0){
       return NO_SUCH_PAGE;
       }
       Graphics2D hub=( Graphics2D) graf;
       hub.translate(pagfor.getImageableX()+ 30,pagfor.getImageableY()+30);
       jPanel1.printAll(graf);
        return PAGE_EXISTS;
    }
}
