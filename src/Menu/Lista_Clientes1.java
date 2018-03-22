package Menu;

import Clases.Control;
import Clases.Panel;
import Jdbc.Conexion;
import com.sun.awt.AWTUtilities;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Lista_Clientes1 extends javax.swing.JFrame {
      TableRowSorter trs;
      DefaultTableModel modelo;
    Form_Clientes1 forc  = new Form_Clientes1();
        private final String ruta = System.getProperties().getProperty("user.dir");
    public Lista_Clientes1() {
        initComponents();
        setTitle("Clientes");
        setLocationRelativeTo(null);
        Carga_Table();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
        lblPro.setVisible(false);
        CmbProvincia.setVisible(false);
    }

    public void ModDeshabilito()
    {  
       
    }
    
    public void modificar()
    {  
        Conexion cn = new Conexion();
        Connection link = cn.Conec();
       
        int fila = tabla.getSelectedRow();
        if(fila >= 0)
        {
        forc.txtCod.setText(tabla.getValueAt(fila, 0).toString());
        forc.txtCi.setText(tabla.getValueAt(fila, 1).toString());
        forc.txtNom.setText(tabla.getValueAt(fila, 2).toString());
        forc.txtApe.setText(tabla.getValueAt(fila, 3).toString());
        forc.txtDir.setText(tabla.getValueAt(fila,4).toString());
        forc.txtCor.setText(tabla.getValueAt(fila, 5).toString());
        forc.CmbSex.setSelectedItem(tabla.getValueAt(fila, 6).toString());
        forc.txtCel.setText(tabla.getValueAt(fila, 7).toString());
        forc.txtTel.setText(tabla.getValueAt(fila, 8).toString());
        forc.txtFecha.setText(tabla.getValueAt(fila,9).toString());
        forc.CmbProvincia.setSelectedItem(tabla.getValueAt(fila,10).toString());

        ModDeshabilito();
        forc.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(null,"Seleccione una fila");
    }
    public void ver()
    {   
        Conexion cn = new Conexion();
        Connection link = cn.Conec();
    
         forc.txtCod.setEnabled(false);
         forc.txtCi.setEnabled(false);
         forc.txtNom.setEnabled(false);
         forc.txtApe.setEnabled(false);
          forc.txtDir.setEnabled(false);
          forc.txtCor.setEnabled(false);
             forc.CmbSex.setEnabled(false);
             forc.txtCel.setEnabled(false);
             forc.txtTel.setEnabled(false);
             forc.txtFecha.setEnabled(false);
              forc.CmbProvincia.setEnabled(false);
        int fila = tabla.getSelectedRow();
        if(fila >= 0)
        {
        forc.txtCod.setText(tabla.getValueAt(fila, 0).toString());
        forc.txtCi.setText(tabla.getValueAt(fila, 1).toString());
        forc.txtNom.setText(tabla.getValueAt(fila, 2).toString());
        forc.txtApe.setText(tabla.getValueAt(fila, 3).toString());
        forc.txtDir.setText(tabla.getValueAt(fila,4).toString());
        forc.txtCor.setText(tabla.getValueAt(fila, 5).toString());
        forc.CmbSex.setSelectedItem(tabla.getValueAt(fila, 6).toString());
        forc.txtCel.setText(tabla.getValueAt(fila, 7).toString());
        forc.txtTel.setText(tabla.getValueAt(fila, 8).toString());
        forc.txtFecha.setText(tabla.getValueAt(fila,9).toString());
        forc.CmbProvincia.setSelectedItem(tabla.getValueAt(fila,10).toString());

        ModDeshabilito();
        forc.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(null,"Seleccione una fila");
    }
    public void eliminar()
    {
        Conexion con = new Conexion();
        Connection link = con.Conec();
        int fila = tabla.getSelectedRow();
        if(fila >=0)
        {
             try
            {
            int ced = Integer.parseInt(tabla.getValueAt(fila, 1).toString());
            PreparedStatement pst = link.prepareStatement("DELETE FROM clientes WHERE Cedula = '"+ced+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Eliminados Satisfactoriamente");
            }
           catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, "Error");
            }
        }
        else
        {
                JOptionPane.showMessageDialog(null,"Seleccione una fila");
        }
    }
    public void Carga_Table()
    {
        Conexion con = new Conexion();
        Connection link = con.Conec();
         modelo = new DefaultTableModel();
        try
        {
            String sql = "SELECT * FROM clientes";
            PreparedStatement pst = link.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            for(int j = 1;j<=col;j++)
            {
                modelo.addColumn(rsmd.getColumnLabel(j));
            }
            while(rs.next())
            {
                String fila[] = new String[col];
                for(int cont = 0; cont < col; cont++)
                {
                    fila[cont] = rs.getString(cont +1);
                }
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DerechoClick = new javax.swing.JPopupMenu();
        ElMod = new javax.swing.JMenuItem();
        Elel = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        CmbFIltro = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        CmbProvincia = new javax.swing.JComboBox();
        lblPro = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnActu = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        ElMod.setText("Modificar");
        ElMod.setName(""); // NOI18N
        ElMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ElModMouseClicked(evt);
            }
        });
        ElMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElModActionPerformed(evt);
            }
        });
        DerechoClick.add(ElMod);

        Elel.setText("Eliminar");
        Elel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ElelMouseClicked(evt);
            }
        });
        Elel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElelActionPerformed(evt);
            }
        });
        DerechoClick.add(Elel);

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImages(null);
        setUndecorated(true);
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
        tabla.setComponentPopupMenu(DerechoClick);
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 920, 330));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 153, 0));
        jLabel1.setText("LISTA DE CLIENTES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 570, 53));

        jLabel3.setText("FIltrar por:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });
        getContentPane().add(txtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 190, -1));

        CmbFIltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".....", "C.I", "Nombre", "Apellido", "Correo", "Sexo", "Provincia" }));
        CmbFIltro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CmbFIltroMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmbFIltroMouseClicked(evt);
            }
        });
        CmbFIltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbFIltroActionPerformed(evt);
            }
        });
        getContentPane().add(CmbFIltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        jLabel4.setText("FIltrar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        CmbProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "……...", "Azuay", "Bolivar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja", "Los Rios", "Manabí", "Morona Santiago", "Napo", "Orellana", "Pastaza", "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua", "Zamora Chinchipe" }));
        CmbProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbProvinciaActionPerformed(evt);
            }
        });
        getContentPane().add(CmbProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 260, -1));

        lblPro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblPro.setText("Provincia");
        getContentPane().add(lblPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 150, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        btnActu.setBackground(new java.awt.Color(255, 255, 255));
        btnActu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload me.png"))); // NOI18N
        btnActu.setText("Actualizar");
        btnActu.setBorderPainted(false);
        btnActu.setContentAreaFilled(false);
        btnActu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActu.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        btnActu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload gr.png"))); // NOI18N
        btnActu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActuActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload me.png"))); // NOI18N
        jButton4.setText("Cancelar");
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

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration me.png"))); // NOI18N
        jButton5.setText("VER");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setIconTextGap(-2);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration grande.png"))); // NOI18N
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration grande.png"))); // NOI18N
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(91, 91, 91))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 70, 110, 470));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo_clientes.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ElModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElModActionPerformed
        
    }//GEN-LAST:event_ElModActionPerformed

    private void ElelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ElelActionPerformed

    private void ElelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElelMouseClicked
        eliminar();
    }//GEN-LAST:event_ElelMouseClicked

    private void ElModMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElModMouseClicked
        modificar();
    }//GEN-LAST:event_ElModMouseClicked

    private void btnActuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActuActionPerformed
        Carga_Table();
    }//GEN-LAST:event_btnActuActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped
String CI,Apellido,Direccion,Correo,Sexo,Celular,Telefono,Fecha_Nacimiento,Provincia;
    String combo_Filtro = CmbFIltro.getSelectedItem().toString();
    
    if(combo_Filtro.equals("C.I")){
         txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent evt){
                trs.setRowFilter(RowFilter.regexFilter(txtFiltro.getText(), 1));

            }
        }
        );

        trs = new TableRowSorter(modelo);
        tabla.setRowSorter(trs);
    }
       
if(combo_Filtro.equals("Nombre")){
         txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent evt){
                trs.setRowFilter(RowFilter.regexFilter(txtFiltro.getText(), 2));

            }
        }
        );

        trs = new TableRowSorter(modelo);
        tabla.setRowSorter(trs);
    }
if(combo_Filtro.equals("Apellido")){
         txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent evt){
                trs.setRowFilter(RowFilter.regexFilter(txtFiltro.getText(), 3));

            }
        }
        );

        trs = new TableRowSorter(modelo);
        tabla.setRowSorter(trs);
    }
if(combo_Filtro.equals("Direccion")){
         txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent evt){
                trs.setRowFilter(RowFilter.regexFilter(txtFiltro.getText(), 4));

            }
        }
        );

        trs = new TableRowSorter(modelo);
        tabla.setRowSorter(trs);
    }
if(combo_Filtro.equals("Correo")){
         txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent evt){
                trs.setRowFilter(RowFilter.regexFilter(txtFiltro.getText(), 5));

            }
        }
        );

        trs = new TableRowSorter(modelo);
        tabla.setRowSorter(trs);
    }
if(combo_Filtro.equals("Sexo")){
         txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent evt){
                trs.setRowFilter(RowFilter.regexFilter(txtFiltro.getText(), 6));

            }
        }
        );

        trs = new TableRowSorter(modelo);
        tabla.setRowSorter(trs);
    }
if(combo_Filtro.equals("Celular")){
         txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent evt){
                trs.setRowFilter(RowFilter.regexFilter(txtFiltro.getText(), 7));

            }
        }
        );

        trs = new TableRowSorter(modelo);
        tabla.setRowSorter(trs);
    }
if(combo_Filtro.equals("Provincia")){
         txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent evt){
                trs.setRowFilter(RowFilter.regexFilter(txtFiltro.getText(),10));

            }
        }
        );

        trs = new TableRowSorter(modelo);
        tabla.setRowSorter(trs);
    }
if(combo_Filtro.equals(".....")){
       JOptionPane.showMessageDialog(rootPane, "Por favor selecione un FIltro por");
    }
    }//GEN-LAST:event_txtFiltroKeyTyped

    private void CmbFIltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbFIltroActionPerformed

 



    }//GEN-LAST:event_CmbFIltroActionPerformed

    private void CmbProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbProvinciaActionPerformed

    private void CmbFIltroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbFIltroMousePressed
         // TODO add your handling code here:
    }//GEN-LAST:event_CmbFIltroMousePressed

    private void CmbFIltroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbFIltroMouseClicked

    }//GEN-LAST:event_CmbFIltroMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed


     ver();

        
    }//GEN-LAST:event_jButton5ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lista_Clientes1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbFIltro;
    public javax.swing.JComboBox CmbProvincia;
    private javax.swing.JPopupMenu DerechoClick;
    private javax.swing.JMenuItem ElMod;
    private javax.swing.JMenuItem Elel;
    private javax.swing.JButton btnActu;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblPro;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
