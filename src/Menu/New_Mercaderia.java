package Menu;

import Clases.Carga_ComboBox;
import Clases.Asignacion_Provee;
import Clases.Codigo;
import Clases.Panel;
import Clases.Control;
import Clases.Ultimo_Numero;
import Jdbc.Conexion;
import Jdbc.Conexion_cat;
import static Menu.Buscar.btnMod;
import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class New_Mercaderia extends javax.swing.JFrame {

    Conexion_cat con_cat = new Conexion_cat();
    Connection link2 = con_cat.ConecCat();
    public New_Mercaderia()  {
        initComponents();
        setLocationRelativeTo(null);
        Codigo();
        proveedores();
        Categoria();
        deshabilitar();
        setTitle("Nueva Mercaderia");
       btnEli.setEnabled(false);
           btnMod.setEnabled(false);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }

    public New_Mercaderia(String tabla, String seleccionado)  {
        initComponents();
        setLocationRelativeTo(null);
        Codigo();
        proveedores();
        Categoria();
        deshabilitar();
        setTitle("Nueva Mercaderia");
       btnEli.setEnabled(false);
           btnMod.setEnabled(false);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/pruebass.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(fal­se);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/pruebass.png"));
        JLabel fondo= new JLabel(); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
        
         try {
                    PreparedStatement pst = link2.prepareStatement("SELECT * FROM " + tabla + " WHERE Nombre = '" + seleccionado + "'");
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                    
                       Image i=null;
                       Blob blob=rs.getBlob("foto");
                       i=javax.imageio.ImageIO.read(blob.getBinaryStream());
                       ImageIcon image=new ImageIcon(i);
                    jLabel14.setIcon(image);


                    } else if (!rs.next()) {
                        System.out.println("No se encuentra");
                    }
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Error " + x);
                }
        
        
        
    }
    public void proveedores()
    {
        ResultSet rs;
        Carga_ComboBox combo = new Carga_ComboBox();
        try
        {
            rs = combo.Combo("proveedores");
            while(rs.next())
            {
                CmbPro1.addItem(rs.getString(1));
            }
        }
                catch(Exception x)
        {
            JOptionPane.showMessageDialog(null,x);
        }
    }
    public void Categoria()
    {
        ResultSet rs;
        Carga_ComboBox combo = new Carga_ComboBox();
        try
        {
            rs = combo.Categoria();
            while(rs.next())
            {
                CmbCat.addItem(rs.getString(1));
            }
        }
        catch(Exception x)
        {
            JOptionPane.showMessageDialog(null, x);
        }
    }
    
  public void deshabilitar()
  {
      txtCod.setEnabled(false);
      txtDia_lle.setEnabled(true);
      txtHora_lle.setEnabled(true);
  }
  public void fecha()
  {
      String x;
      Panel y = new Panel();
      x = y.Fecha();
      System.out.println(x);
      txtDia_lle.setText(x); 
  }
  public void hora()
  {
      Control p = new Control();
        Calendar hour = new GregorianCalendar();
        int h,m,s;
        String x;
        h = hour.get(Calendar.HOUR_OF_DAY);
        m = hour.get(Calendar.MINUTE);
        s = hour.get(Calendar.SECOND);
        x = h+":"+m+":"+s;
        System.out.println(x);
        txtHora_lle.setText(x);
  }
  
  
  
  
  public void Mercaderia(String x) throws FileNotFoundException
  {
        Conexion_cat cn = new Conexion_cat();
        Connection link = cn.ConecCat();
        try
        {
            int contador = 1;
            String combo = CmbPro1.getSelectedItem().toString();
            String categoria = CmbCat.getSelectedItem().toString();
            String fecha = txtDia_lle.getText();
            String hora = txtHora_lle.getText();
            String textarea = tare_desc.getText();
                    
            PreparedStatement pst;
            pst = link.prepareStatement("INSERT INTO "+x+"(Codigo,Nombre,Cantidad,Proveedor,Categoria,Descripcion,Precio_Unit,Dia_Llegada,Hora_Llegada,foto,ruta,Precio_1,Precio_2,Precio_3,Cantidad_Minima) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           
            pst.setString(1, txtCod.getText());
            pst.setString(2, txtNom_Pro.getText());
            pst.setString(3, txtCanti.getText());
            pst.setString(4, combo);
            pst.setString(5, categoria);
            pst.setString(6, textarea);
           
            pst.setString(7, txtPre_uni.getText());
            pst.setString(8, fecha);
            pst.setString(9, hora);
            
            FileInputStream archivoFoto;
            archivoFoto= new FileInputStream(jTextField2.getText());
           pst.setBinaryStream(10, archivoFoto);
           pst.setString(11,jLabel14.getText());
           pst.setString(12,txtCompra.getText());
           pst.setString(13,txtPrecioMayor.getText());
           pst.setString(14,txtPrecioTar.getText());
           pst.setString(15,txtCantiMini.getText());

           
                if(fecha.equals(" "))
            {
                JOptionPane.showMessageDialog(null,"Asigne Dia y Hora");
                contador = 0;
            }
            
            if(hora.equals(" "))
            {
                JOptionPane.showMessageDialog(null,"Asigne Dia y Hora");
                contador = 0;
            }

            if(combo == "....")
            {
                JOptionPane.showMessageDialog(null,"Escoja un Proveedor");
                contador = 0;
            }
            if(contador > 0)
            {
                contador = pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Mercaderia Registrada con Exito");
                txtNom_Pro.setText(null);
                txtCanti.setText(null);
                tare_desc.setText(null);
                txtPre_uni.setText(null);
                txtDia_lle.setText(null);
                txtHora_lle.setText(null);
                txtCompra.setText(null);
                txtPrecioMayor.setText(null);
                txtPrecioTar.setText(null);
                
                txtNom_Pro.requestFocus();
                Ultimo_Numero num = new Ultimo_Numero();
                num.Actualizar_Ultimo("Mercaderia", Codigo());
                Codigo();
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: llene Correctamentamente todos los campos");
        } 
  }
  public int Codigo()
  {
    Ultimo_Numero num = new Ultimo_Numero();
    int recogedor = num.Ultimo_numero("Mercaderia");
    String Conver = Integer.toString(recogedor);
    Conver = "1001000"+Conver;
    txtCod.setText(Conver);
    recogedor++;
    return recogedor;
  }
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCanti = new javax.swing.JTextField();
        txtNom_Pro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CmbV = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCompra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tare_desc = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtPre_uni = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtPrecioMayor = new javax.swing.JTextField();
        txtPrecioTar = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtDia_lle = new javax.swing.JTextField();
        txtHora_lle = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CmbCat = new javax.swing.JComboBox();
        CmbPorcTC1 = new javax.swing.JComboBox();
        CmbM = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        CmbPro1 = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtCantiMini = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnEli = new javax.swing.JButton();
        btnMod = new javax.swing.JButton();
        btnFechaHora = new javax.swing.JButton();
        btnCan = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel13.setText("jLabel13");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 153, 0));
        jLabel1.setText("NUEVA MERCADERIA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 340, 42));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 56, 15));

        txtCod.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        getContentPane().add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 250, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Nombre del Producto");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 121, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Cantidad");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 74, -1));

        txtCanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantiActionPerformed(evt);
            }
        });
        txtCanti.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantiKeyTyped(evt);
            }
        });
        getContentPane().add(txtCanti, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 250, -1));

        txtNom_Pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNom_ProActionPerformed(evt);
            }
        });
        getContentPane().add(txtNom_Pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 250, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Proveedor");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 74, 30));

        CmbV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "…", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110", "120", "130", "140", "150", "160", "170", "180", "190", "200" }));
        CmbV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmbVMouseClicked(evt);
            }
        });
        CmbV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbVActionPerformed(evt);
            }
        });
        getContentPane().add(CmbV, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 70, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setText("Descripcion del Producto");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 156, -1));

        jLabel16.setText("$");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel17.setText("Precio Compra");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 108, -1));

        txtCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompraActionPerformed(evt);
            }
        });
        getContentPane().add(txtCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 120, -1));

        tare_desc.setColumns(20);
        tare_desc.setRows(5);
        tare_desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tare_descKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tare_desc);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 410, 40));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel7.setText("Precio Venta");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 108, -1));

        txtPre_uni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPre_uniActionPerformed(evt);
            }
        });
        getContentPane().add(txtPre_uni, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 120, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel9.setText("Hora de Llegada");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 119, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel10.setText("Dia de llegada");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 119, -1));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel18.setText("Precio Tarjeta Credito");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 130, -1));

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel19.setText("Precio Por Mayor");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 108, -1));

        txtPrecioMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioMayorActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrecioMayor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 120, -1));

        txtPrecioTar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioTarActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrecioTar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 120, -1));

        jLabel20.setText("%");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, -1, -1));

        jLabel21.setText("$");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, -1, -1));

        txtDia_lle.setText(" ");
        txtDia_lle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDia_lleActionPerformed(evt);
            }
        });
        getContentPane().add(txtDia_lle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 260, -1));

        txtHora_lle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHora_lleActionPerformed(evt);
            }
        });
        getContentPane().add(txtHora_lle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 260, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel11.setText("Categoria");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        CmbCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...." }));
        CmbCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CmbCatMouseEntered(evt);
            }
        });
        CmbCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbCatActionPerformed(evt);
            }
        });
        getContentPane().add(CmbCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 237, 250, -1));

        CmbPorcTC1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "…", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110", "120", "130", "140", "150", "160", "170", "180", "190", "200" }));
        CmbPorcTC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmbPorcTC1MouseClicked(evt);
            }
        });
        CmbPorcTC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbPorcTC1ActionPerformed(evt);
            }
        });
        getContentPane().add(CmbPorcTC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 70, -1));

        CmbM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "…", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110", "120", "130", "140", "150", "160", "170", "180", "190", "200" }));
        CmbM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmbMMouseClicked(evt);
            }
        });
        CmbM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbMActionPerformed(evt);
            }
        });
        getContentPane().add(CmbM, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 70, -1));

        jLabel12.setText("$");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jLabel15.setText("INSERTAR IMAGEN");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, -1, -1));

        CmbPro1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...." }));
        CmbPro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmbPro1MouseClicked(evt);
            }
        });
        CmbPro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbPro1ActionPerformed(evt);
            }
        });
        getContentPane().add(CmbPro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 201, 250, -1));

        jLabel23.setText("%");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, -1, -1));

        jLabel24.setText("%");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, -1, -1));

        jLabel22.setText("$");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, -1, -1));

        jLabel25.setText("hora:minuto:segundo   00:00:00");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, -1, -1));

        jLabel26.setText("dia/mes/año         00/00/0000");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, -1, -1));

        txtCantiMini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantiMiniActionPerformed(evt);
            }
        });
        txtCantiMini.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantiMiniKeyTyped(evt);
            }
        });
        getContentPane().add(txtCantiMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 250, -1));

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel27.setText("Cantidad Minima");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 100, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        btnSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveKeyPressed(evt);
            }
        });

        btnEli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full me.png"))); // NOI18N
        btnEli.setText("Eliminar");
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

        btnMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration me.png"))); // NOI18N
        btnMod.setText("Modificar");
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

        btnFechaHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calendar me.png"))); // NOI18N
        btnFechaHora.setText("Asignar Tiempo");
        btnFechaHora.setBorderPainted(false);
        btnFechaHora.setContentAreaFilled(false);
        btnFechaHora.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFechaHora.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calendar gr.png"))); // NOI18N
        btnFechaHora.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calendar gr.png"))); // NOI18N
        btnFechaHora.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFechaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaHoraActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFechaHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMod, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnCan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechaHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 124, 410));

        jLabel14.setFocusCycleRoot(true);
        jLabel14.setFocusTraversalPolicy(null);
        jLabel14.setFocusTraversalPolicyProvider(true);
        jLabel14.setOpaque(true);
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 140, 120));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/new_mer.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDia_lleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDia_lleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDia_lleActionPerformed

    private void txtHora_lleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHora_lleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHora_lleActionPerformed

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        dispose();
    }//GEN-LAST:event_btnCanActionPerformed

    private void btnFechaHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaHoraActionPerformed
        fecha();
        hora();
    }//GEN-LAST:event_btnFechaHoraActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            Mercaderia(CmbCat.getSelectedItem().toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(New_Mercaderia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void CmbVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbVMouseClicked
   
    }//GEN-LAST:event_CmbVMouseClicked

    private void CmbCatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbCatMouseEntered

    }//GEN-LAST:event_CmbCatMouseEntered

    private void CmbCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbCatActionPerformed

    private void txtCantiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantiKeyTyped
      char c = evt.getKeyChar();
 int numerocaracteres = 10;
 if((c<'0'||c>'9'))
        {          

            evt.consume();

        } 
 if(txtCanti.getText().length()>= numerocaracteres){
    evt.consume(); 
 }
    }//GEN-LAST:event_txtCantiKeyTyped

    private void txtNom_ProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNom_ProActionPerformed
        txtNom_Pro.transferFocus();
    }//GEN-LAST:event_txtNom_ProActionPerformed

    private void txtCantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantiActionPerformed
        txtCanti.transferFocus();
    }//GEN-LAST:event_txtCantiActionPerformed

    private void tare_descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tare_descKeyPressed

    }//GEN-LAST:event_tare_descKeyPressed

    private void txtPre_uniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPre_uniActionPerformed
        txtPre_uni.transferFocus();
    }//GEN-LAST:event_txtPre_uniActionPerformed

    private void btnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveKeyPressed
        try {
            Mercaderia(CmbCat.getSelectedItem().toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(New_Mercaderia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveKeyPressed
      
     
    private void CmbVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbVActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        JFileChooser archivo=new      JFileChooser();
        int ventana=archivo.showOpenDialog(null);
        if(ventana==JFileChooser.APPROVE_OPTION){
            File file=archivo.getSelectedFile();
            jTextField2.setText(String.valueOf(file));
            Image foto=getToolkit().getImage(jTextField2.getText());
            jLabel14.setIcon(new ImageIcon(foto));
        }
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
        Conexion_cat cn = new Conexion_cat();
        Connection link = cn.ConecCat();
        String Cate = CmbCat.getSelectedItem().toString();
        if(Cate.equals("...."))
        {
            JOptionPane.showMessageDialog(null,"Escoja una Categoria");
        }
        try
        {
            PreparedStatement pst = link.prepareStatement("DELETE FROM "+Cate+" WHERE Codigo = '"+txtCod.getText()+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Eliminado con Exito");
            dispose();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }//GEN-LAST:event_btnEliActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        Conexion_cat Conexion = new Conexion_cat();
        Connection link = Conexion.ConecCat();
        String Prov = CmbV.getSelectedItem().toString();
        String cate = CmbCat.getSelectedItem().toString();
        float Pre_uni = Float.parseFloat(txtPre_uni.getText());
        int cant = Integer.parseInt(txtCanti.getText());
        if(Prov.equals("...."))
        {
            JOptionPane.showMessageDialog(null,"Escoja un proveedor");
        }
        else if(cate.equals("...."))
        {
            JOptionPane.showMessageDialog(null,"Escoja una categoria");
        }

        else
        {

            try
            {
                PreparedStatement pst = link.prepareStatement("UPDATE "+cate+" SET Codigo = '"+txtCod.getText()+"', Nombre = '"+txtNom_Pro.getText()+"',Cantidad = '"+txtCanti.getText()+"', Dia_Llegada = '"+txtDia_lle.getText()+"', Hora_Llegada = '"+txtHora_lle.getText()+"', Categoria = '"+cate+"',Cantidad_Minima ='"+txtCantiMini.getText()+"' WHERE Codigo = '"+txtCod.getText()+"'");
                int cont = pst.executeUpdate();
                if(cont > 0)
                {
                    JOptionPane.showMessageDialog(null,"Datos Modificados");
                    dispose();
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error");
            }
        }

    }//GEN-LAST:event_btnModActionPerformed

    private void txtCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompraActionPerformed
 
cargarPrecioVenta();
cargarPrecioMayor();
CargarPrecioTarjetaCredito();







    }//GEN-LAST:event_txtCompraActionPerformed

    private void txtPrecioMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioMayorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioMayorActionPerformed

    private void txtPrecioTarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioTarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioTarActionPerformed

    private void CmbPro1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbPro1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPro1MouseClicked

    private void CmbPro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbPro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPro1ActionPerformed

    private void CmbPorcTC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbPorcTC1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPorcTC1MouseClicked

    private void CmbPorcTC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbPorcTC1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPorcTC1ActionPerformed

    private void CmbMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbMMouseClicked

    private void CmbMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbMActionPerformed

    private void txtCantiMiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantiMiniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantiMiniActionPerformed

    private void txtCantiMiniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantiMiniKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantiMiniKeyTyped
       
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
            java.util.logging.Logger.getLogger(New_Mercaderia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(New_Mercaderia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(New_Mercaderia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New_Mercaderia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new New_Mercaderia().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox CmbCat;
    public javax.swing.JComboBox CmbM;
    public javax.swing.JComboBox CmbPorcTC1;
    public javax.swing.JComboBox CmbPro1;
    public javax.swing.JComboBox CmbV;
    public javax.swing.JButton btnCan;
    public static transient javax.swing.JButton btnEli;
    public javax.swing.JButton btnFechaHora;
    public static transient javax.swing.JButton btnMod;
    public javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    public javax.swing.JTextArea tare_desc;
    public javax.swing.JTextField txtCanti;
    public javax.swing.JTextField txtCantiMini;
    public javax.swing.JTextField txtCod;
    public javax.swing.JTextField txtCompra;
    public javax.swing.JTextField txtDia_lle;
    public javax.swing.JTextField txtHora_lle;
    public javax.swing.JTextField txtNom_Pro;
    public javax.swing.JTextField txtPre_uni;
    public javax.swing.JTextField txtPrecioMayor;
    public javax.swing.JTextField txtPrecioTar;
    // End of variables declaration//GEN-END:variables

    private void cargarPrecioVenta() {
   String comb = CmbV.getSelectedItem().toString();
   
   if(comb.equals("…")){
       JOptionPane.showMessageDialog(rootPane,"Escoja un porcentaje en Precio Venta");
   }
   else
   {
       float porcentaje = Float.parseFloat(comb) /100; // porcentaje ejemplo 0.1
       float valor_precio = Float.parseFloat(txtCompra.getText());  //valor de preico compra
       float multi = porcentaje * valor_precio;  //porcentaje
       float precio = multi + valor_precio;  // mostrar
       txtPre_uni.setText(Float.toString(precio));
   }
    }

    private void cargarPrecioMayor() {
  String comb = CmbM.getSelectedItem().toString();
   
   if(comb.equals("…")){
       JOptionPane.showMessageDialog(rootPane,"Escoja un porcentaje en Precio MAYOR");
   }
   else
   {
       float porcentaje = Float.parseFloat(comb) /100; // porcentaje ejemplo 0.1
       float valor_precio = Float.parseFloat(txtCompra.getText());  //valor de preico compra
       float multi = porcentaje * valor_precio;  //porcentaje
       float precio = multi + valor_precio;  // mostrar
       txtPrecioMayor.setText(Float.toString(precio));
   }
    
    }

    private void CargarPrecioTarjetaCredito() {
  String comb = CmbPorcTC1.getSelectedItem().toString();
   
   if(comb.equals("…")){
       JOptionPane.showMessageDialog(rootPane,"Escoja un porcentaje en Precio POR TARJETA DE CREDITO");
   }
   else
   {
       float porcentaje = Float.parseFloat(comb) /100; // porcentaje ejemplo 0.1
       float valor_precio = Float.parseFloat(txtPre_uni.getText());  //valor de preico compra
       float multi = porcentaje * valor_precio;  //porcentaje
       float precio = multi + valor_precio;  // mostrar
       txtPrecioTar.setText(Float.toString(precio));
   }

    }


}

