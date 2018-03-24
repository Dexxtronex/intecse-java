package Menu;

import Clases.Panel;
import Clases.Ultimo_Numero;
import Jdbc.Conexion;
import com.sun.awt.AWTUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author anthony
 */
public class Form_Clientes extends javax.swing.JFrame {

    /**
     * Creates new form Form_Clientes
     */
    public Form_Clientes() {
        initComponents();
        setLocationRelativeTo(null);
        Codigo();
        asignar();
        deshabilitar();
        setTitle("Registro De Clientes");
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
        Cargar();
    }
    public Form_Clientes(int j, int o) {
        initComponents();
        setLocationRelativeTo(null);
        Codigo();
        asignar();
        deshabilitar();
        setTitle("Registro De Clientes");
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
            }
    public void Cargar(){
        txtApe.setEnabled(false);
        txtTel.setEnabled(false);
        txtNom.setEnabled(false);
        txtFecha.setEnabled(false);
        txtDir.setEnabled(false);
        txtCor.setEnabled(false);
        txtCod.setEnabled(false);
        txtCel.setEnabled(false);
        CmbProvincia.setEnabled(false);
        CmbSex.setEnabled(false);
        btnSave.setEnabled(false);
        
        
    }
    public Form_Clientes(int j ) {
        initComponents();
        setLocationRelativeTo(null);
        Codigo();
        asignar();
        deshabilitar();
        setTitle("Registro De Clientes");
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
        btnMod.setVisible(false);
        btnEli.setVisible(false);
        btnSave.setVisible(false);
      
    }
     public void deshabilitar()
     {
         txtCod.setEnabled(false);
         txtFecha.setEnabled(true);
         btnMod.setEnabled(false);
         btnEli.setEnabled(false);
     }
     
     public int Codigo()
    {
        Ultimo_Numero n = new Ultimo_Numero();
        int recogedor = n.Ultimo_numero("Clientes");
        String Cli = Integer.toString(recogedor);
        Cli = "INTECSE_CL000"+Cli;
        txtCod.setText(Cli);
        recogedor = recogedor + 1;
        return recogedor;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtCi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApe = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCel = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CmbProvincia = new javax.swing.JComboBox();
        txtFecha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        CmbSex = new javax.swing.JComboBox();
        btnSave = new javax.swing.JButton();
        btnCan = new javax.swing.JButton();
        btnMod = new javax.swing.JButton();
        btnEli = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("C.I./ RUC:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtCi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiActionPerformed(evt);
            }
        });
        txtCi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCiKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCiKeyReleased(evt);
            }
        });
        getContentPane().add(txtCi, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 87, 122, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("NOMBRES:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 121, -1, -1));

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
        getContentPane().add(txtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 118, 320, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("APELLIDOS:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 152, -1, -1));

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
        getContentPane().add(txtApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 149, 320, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 153, 0));
        jLabel2.setText("CODIGO");

        txtCod.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCod, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 380, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("DIRECCIÓN:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 183, -1, -1));

        txtDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirActionPerformed(evt);
            }
        });
        txtDir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirKeyTyped(evt);
            }
        });
        getContentPane().add(txtDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 180, 320, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("TELEFONO:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

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
        getContentPane().add(txtCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 273, 130, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("PROVINCIA:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 150, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("FECHA REGISTRO:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 150, 20));

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
        getContentPane().add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 110, -1));

        txtCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorActionPerformed(evt);
            }
        });
        getContentPane().add(txtCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 211, 320, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("CELULAR:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 276, 80, -1));

        CmbProvincia.setEditable(true);
        CmbProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "……...", "Azuay", "Bolivar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja", "Los Rios", "Manabí", "Morona Santiago", "Napo", "Orellana", "Pastaza", "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua", "Zamora Chinchipe" }));
        CmbProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbProvinciaActionPerformed(evt);
            }
        });
        getContentPane().add(CmbProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 260, -1));

        txtFecha.setEditable(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 260, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("CORREO:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 214, -1, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setText("SEXO:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 245, 43, -1));

        jLabel13.setText("DÍA/MES/AÑO");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 260, -1));

        CmbSex.setEditable(true);
        CmbSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "....", "M", "F" }));
        CmbSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbSexActionPerformed(evt);
            }
        });
        getContentPane().add(CmbSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 242, 52, -1));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save me.png"))); // NOI18N
        btnSave.setText("GUARDAR");
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
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        btnCan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload me.png"))); // NOI18N
        btnCan.setText("SALIR");
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
        getContentPane().add(btnCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

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
        getContentPane().add(btnMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

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
        getContentPane().add(btnEli, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo_pedidos.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
txtFecha.setEnabled(false);
        btnSave.setEnabled(true);
        btnSave.requestFocus();                
// TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtCiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiKeyPressed

    }//GEN-LAST:event_txtCiKeyPressed

    private void txtCiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiKeyTyped
    char c = evt.getKeyChar();
 int numerocaracteres = 13;
 if((c<'0'||c>'9'))
        {          

            evt.consume();

        } 
 if(txtCi.getText().length()>= numerocaracteres){
    evt.consume(); 
 }
    }//GEN-LAST:event_txtCiKeyTyped

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

    private void txtTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelKeyTyped
            char c = evt.getKeyChar();
 int numerocaracteres = 10;
 if((c<'0'||c>'9'))
        {          

            evt.consume();

        } 
 if(txtTel.getText().length()>= numerocaracteres){
    evt.consume(); 
 }
    }//GEN-LAST:event_txtTelKeyTyped

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        dispose();
    }//GEN-LAST:event_btnCanActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Conexion co = new Conexion();
        Connection link = co.Conec();
        Ultimo_Numero num = new Ultimo_Numero();
        int n = 1;
        
        try
        {   String combo_Provincia= CmbProvincia.getSelectedItem().toString();
             String combo = CmbSex.getSelectedItem().toString();
            String sql = "INSERT INTO clientes(Codigo,Cedula,Nombres,Apellidos,Direccion,Correo,Sexo,Celular,Telefono,Fecha,Provincia)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = link.prepareStatement(sql);
            pst.setString(1, txtCod.getText());
            pst.setString(2, txtCi.getText());
            pst.setString(3, txtNom.getText());
            pst.setString(4, txtApe.getText());
            pst.setString(5, txtDir.getText());
            pst.setString(6, txtCor.getText());
            pst.setString(7, combo);
            pst.setString(8, txtCel.getText());
            pst.setString(9,txtTel.getText());
            pst.setString(10, txtFecha.getText());
            pst.setString(11,combo_Provincia);
            if(combo.equals("...."))
            {
                JOptionPane.showMessageDialog(null, "Escoja un sexo Valido");
                n = 0;
            }
            else if (txtFecha.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Asigne Fecha de Registro");
                n = 0;
            }
            
            else
                {
                    n = pst.executeUpdate();
                    if(n > 0)
                    {
                    JOptionPane.showMessageDialog(null, "Cliente registrado con exito");
                    num.Actualizar_Ultimo("Clientes", Codigo());
                    Codigo();
                    /*txtCi.setText("");
                    txtNom.setText("");
                    txtApe.setText("");
                    txtDir.setText("");
                    txtCor.setText("");
                    txtCel.setText("");
                    txtTel.setText("");
                    txtFecha.setText("");
                    txtCi.requestFocus();*/
                    dispose();
                    }
                }
                       
        }
        catch(SQLException x)
              {
                    JOptionPane.showMessageDialog(null,"LLene Correctamente todos los campos");
              }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
       Conexion cn = new Conexion();
       Connection link = cn.Conec();
       String sexo = CmbSex.getSelectedItem().toString();
       String provincia = CmbProvincia.getSelectedItem().toString();
       if(sexo.equals("...."))
       {
           JOptionPane.showMessageDialog(null,"Escoja un sexo Valido");
       }
       else
       {
          try
       {
           String cel = (txtCel.getText());
           String tel = (txtTel.getText());
           String ced = (txtCi.getText());
           PreparedStatement pst = link.prepareStatement("UPDATE clientes SET Codigo = '"+txtCod.getText()+"', Cedula = '"+ced+"', Nombres = '"+txtNom.getText()+"', Apellidos = '"+txtApe.getText()+"', Direccion = '"+txtDir.getText()+"', Correo = '"+txtCor.getText()+"', Sexo = '"+sexo+"', Celular = '"+cel+"', Telefono = '"+tel+"', Fecha = '"+txtFecha.getText()+"',Provincia ='"+provincia+"' WHERE Codigo = '"+txtCod.getText()+"'");
           int cont = pst.executeUpdate();
           if(cont > 0)
           {
               JOptionPane.showMessageDialog(null,"Datos Modificados con Exito");
               Lista_Clientes n = new Lista_Clientes();
               n.Carga_Table();
               dispose();
           }
           else
           {
               JOptionPane.showMessageDialog(null,"Error al Modificar");
           }
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,"Error");
       }
       }
    }//GEN-LAST:event_btnModActionPerformed

    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
        Conexion con = new Conexion();
        Connection link = con.Conec();
         int confirmacion;
        confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el cliente", "Eliminación", JOptionPane.YES_NO_OPTION);
        if(confirmacion == JOptionPane.YES_OPTION)
        {
             try
        {
           int cedula = Integer.parseInt(txtCi.getText());
           PreparedStatement pst = link.prepareStatement("DELETE FROM clientes WHERE Cedula = '"+cedula+"'");
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "Eliminado con Exito");
           dispose();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
        }
       
    }//GEN-LAST:event_btnEliActionPerformed

    private void txtNomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomKeyTyped

            char c=evt.getKeyChar();
            
        
          if(Character.isDigit(c)) {
              getToolkit().beep();
              
              evt.consume();
   
          }
    }//GEN-LAST:event_txtNomKeyTyped

    private void CmbProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbProvinciaActionPerformed
if((CmbProvincia.getSelectedItem().toString().equals("……...")==false ))
        {
        CmbProvincia.setEnabled(false);
        txtFecha.setEnabled(true);
        txtFecha.requestFocus();    
        }
        else{
            CmbProvincia.requestFocus();
             JOptionPane.showMessageDialog(rootPane,"ERROR, CAMPO PROVINCIA ESCOJA PROVINCIA");
        }
        
        
            

// TODO add your handling code here:
    }//GEN-LAST:event_CmbProvinciaActionPerformed

    private void txtCiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiKeyReleased
      
        
        
    }//GEN-LAST:event_txtCiKeyReleased

    private void txtCiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiActionPerformed
     
        int resultado =0;
        int repetida=0;
        Panel y = new Panel();
      repetida =   y.buscarnombre1(Integer.parseInt(txtCi.getText()));
      if(repetida ==1){
          JOptionPane.showMessageDialog(rootPane,"ERROR, CEDULA/RUC EXISTENTE");
           txtCi.requestFocus();
      }
      else{
          if((txtCi.equals(""))||(txtCi.getText().length()==10)||(txtCi.getText().length()==13))
        {
            
            
             txtCi.setEnabled(false);
        
        txtNom.setEnabled(true);
        txtNom.requestFocus();
        }
        else{
             txtCi.requestFocus();
             if((txtCi.getText().length()<10))
             resultado = 1;
             if((txtCi.getText().length()>10)&&(txtCi.getText().length()<13))
             resultado = 2;
            
             
             
             if(resultado ==0)
             JOptionPane.showMessageDialog(rootPane,"ERROR, CAMPO VACIO DE CI/RUC");
             if(resultado ==1)
             JOptionPane.showMessageDialog(rootPane,"ERROR, CAMPO INSUFICIENTE DE CI/RUC");
             if(resultado ==2)
             JOptionPane.showMessageDialog(rootPane,"ERROR, CAMPO INSUFICIENTE PARA RUC");
        }
      }
        

        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiActionPerformed

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        if((txtNom.getText().length()>3 ))
        {
              txtNom.setEnabled(false);
         txtNom.setText(txtNom.getText().toUpperCase());
        txtApe.setEnabled(true);
        txtApe.requestFocus();
        }
        else{
            txtNom.requestFocus();
             JOptionPane.showMessageDialog(rootPane,"ERROR, CAMPO   NOMBRE");
        }
        
       

        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomActionPerformed

    private void txtApeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeActionPerformed
 if((txtApe.getText().length()>3 ))
        {
                txtApe.setEnabled(false);
   txtApe.setText(txtApe.getText().toUpperCase());
        txtDir.setEnabled(true);
        txtDir.requestFocus();
        }
        else{
            txtApe.requestFocus();
             JOptionPane.showMessageDialog(rootPane,"ERROR, CAMPO APELLIDO");
        }
        
      
    }//GEN-LAST:event_txtApeActionPerformed

    private void txtApeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeKeyTyped
 
            char c=evt.getKeyChar();
            
        
          if(Character.isDigit(c)) {
              getToolkit().beep();
              
              evt.consume();
   
          }        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeKeyTyped

    private void txtDirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirKeyTyped
 
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirKeyTyped

    private void txtDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirActionPerformed
 if((txtDir.getText().length()>3 ))
        {
              
 txtDir.setEnabled(false);
   txtDir.setText(txtDir.getText().toUpperCase());
        txtCor.setEnabled(true);
        txtCor.requestFocus();
        }
        else{
            txtDir.requestFocus();
             JOptionPane.showMessageDialog(rootPane,"ERROR, CAMPO DIRECCION");
        }
    }//GEN-LAST:event_txtDirActionPerformed

    private void txtCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorActionPerformed
 Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        // El email a validar
        String email = txtCor.getText();
 
        Matcher mather = pattern.matcher(email);
 
       
        
        
        
        if((txtCor.getText().length()>3 && mather.find()==true))
        {
  txtCor.setEnabled(false);
        CmbSex.setEnabled(true);
        CmbSex.requestFocus();
        }
        else{
            txtCor.requestFocus();
             JOptionPane.showMessageDialog(rootPane,"ERROR, CAMPO CORREO INGRESE UN CORREO ELECTRONICO VALIDO");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorActionPerformed

    private void CmbSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbSexActionPerformed
     if((CmbSex.getSelectedItem().toString().equals("....")==false ))
        {
         CmbSex.setEnabled(false);
        txtCel.setEnabled(true);
        txtCel.requestFocus();
        }
        else{
            CmbSex.requestFocus();
             JOptionPane.showMessageDialog(rootPane,"ERROR, CAMPO DIRECCION ESCOJA SEXO");
        }
      
        
    }//GEN-LAST:event_CmbSexActionPerformed

    private void txtCelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelActionPerformed
      if((txtCel.getText().length()==10 ))
        {
         txtCel.setEnabled(false);
        txtTel.setEnabled(true);
        txtTel.requestFocus();
        
        }
        else{
            txtCel.requestFocus();
             JOptionPane.showMessageDialog(rootPane,"ERROR, CAMPO CELULAR");
        }
        
      
        
// TODO add your handling code here:
    }//GEN-LAST:event_txtCelActionPerformed

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
 if((txtTel.getText().length()>3 ))
        {
        txtTel.setEnabled(false);
        CmbProvincia.setEnabled(true);
        CmbProvincia.requestFocus();
        }
        else{
            txtTel.requestFocus();
             JOptionPane.showMessageDialog(rootPane,"ERROR, CAMPO TELEFONO");
        }
        
       
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    
    public void asignar()
    {
        Panel pa = new Panel();
        String fecha;
        fecha = pa.Fecha();
        txtFecha.setText(fecha);
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
            java.util.logging.Logger.getLogger(Form_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox CmbProvincia;
    public javax.swing.JComboBox CmbSex;
    public javax.swing.JButton btnCan;
    public javax.swing.JButton btnEli;
    public javax.swing.JButton btnMod;
    public javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtApe;
    public javax.swing.JTextField txtCel;
    public javax.swing.JTextField txtCi;
    public javax.swing.JTextField txtCod;
    public javax.swing.JTextField txtCor;
    public javax.swing.JTextField txtDir;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtNom;
    public javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
