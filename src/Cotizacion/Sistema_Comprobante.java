/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotizacion;

import Menu.*;
import Clases.Codigo;
import Clases.Panel;
import Clases.Ultimo_Numero;
import Jdbc.Conexion;
import Jdbc.Conexion_cat;
import com.sun.awt.AWTUtilities;
import correo.Controlador;
import correo.Correo_E;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 *
 * @author anthony
 */
public class Sistema_Comprobante extends javax.swing.JFrame  implements Printable{
 private final String ruta = System.getProperties().getProperty("user.dir");
        public static int stock = 0;
        public static int avender=0;
        public static  String combo_Precio;
       public static  String recoge[] ;

    public void Detalles_Factura() {
        Conexion co = new Conexion();
        Connection link = co.Conec();
        String factura = lblFact.getText();
        
        String fecha = txtFecha.getText();
        String Hora = txtHora.getText();
        float subtotal = Float.parseFloat(txtSubtotal.getText());
        float Iva = Float.parseFloat(txtIva.getText());
        float Total = Float.parseFloat(txtTot.getText());
        try {
            PreparedStatement pst = link.prepareStatement("INSERT INTO comprobante(Num_Fac,CI,Fecha,Hora,Subtotal,Iva,Total) VALUES (?,?,?,?,?,?,?) ");
            pst.setString(1, factura);
            pst.setString(2, txtCi.getText());
            pst.setString(3, fecha);
            pst.setString(4, Hora);
            pst.setFloat(5, subtotal);
            pst.setFloat(6, Iva);
            pst.setFloat(7, Total);
            int n = pst.executeUpdate();
            if (n > 0) {
                System.out.println("Registrado detalles de COMPROBANTE");
            }
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Limpiar() {
        txtCi.setText(null);
        txtNom.setText(null);
        txtApe.setText(null);
        txtCod.setText(null);
        txtDir.setText(null);
        txtCor.setText(null);
        txtSexo.setText(null);
        txtTel.setText(null);
        txtCel.setText(null);
        txtFecha.setText(null);
        txtHora.setText(null);
       
        txtSubtotal.setText(null);
        txtIva.setText(null);
        txtTot.setText(null);
    }

    public void Articulos_Vendidos() {
        Conexion co = new Conexion();
        Connection link = co.Conec();
        int num_filas = Tabla.getRowCount();
        for (int cont = 0; cont < num_filas; cont++) {
            String numero_fac = lblFact.getText();
            String Codigo = Tabla.getValueAt(cont, 0).toString();
            String Nombre_pro = Tabla.getValueAt(cont, 1).toString();
            int Cantidad = Integer.parseInt(Tabla.getValueAt(cont, 2).toString());
            float P_uni = Float.parseFloat(Tabla.getValueAt(cont, 3).toString());
            float Tot = Float.parseFloat(Tabla.getValueAt(cont, 4).toString());
            try {
                PreparedStatement pst = link.prepareStatement("INSERT INTO detalle_comprobante(Num_Factura,codigo,Nom_Pro,cantidad,Precio_Unit,Total) VALUES (?,?,?,?,?,?)");
                pst.setString(1, numero_fac);
                pst.setString(2, Codigo);
                pst.setString(3, Nombre_pro);
                pst.setInt(4, Cantidad);
                pst.setFloat(5, P_uni);
                pst.setFloat(6, Tot);
               
                int n = pst.executeUpdate();
                if (n <= 0) {
                    JOptionPane.showMessageDialog(null, "Error de Venta-Comprobante");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
Correo_E n = new Correo_E();
    public Sistema_Comprobante() {
     initComponents();
        setTitle("COMPROBANTES");
        setLocationRelativeTo(null);
                BttnProducto.setEnabled(false);

        correo.setVisible(false);
        nom.setVisible(false);
        ape.setVisible(false);
        FechaHora();
        deshabilitar();
        Ultimo_Num1();
        jTextField1.setVisible(false);
    }

    public static String Valores[] = new String[6];
    public static DefaultTableModel modelo = new DefaultTableModel();
    Conexion cn = new Conexion();
    Connection link = cn.Conec();
    public static Conexion_cat con_cat = new Conexion_cat();
    public static Connection link2  = con_cat.ConecCat();

    public void borrar_tabla() {
        try
        {
        modelo = (DefaultTableModel)Tabla.getModel();
        int row = modelo.getRowCount();
        for (int cont = 0; row > cont; cont++) {
            modelo.removeRow(0);
        }
        }
        catch(Exception e)
        {
            System.out.println("No se limpio la tabla");
        }
    }

    public void descontar() {
        Codigo co = new Codigo();
        String arreglo[] = co.Codigos();
        int retornador = co.retornador();
        int num_filas = Tabla.getRowCount();
        
        JOptionPane.showMessageDialog(null, "COTIZACION REALIZADA", "COTIZACION Registrada", JOptionPane.INFORMATION_MESSAGE);
        Limpiar();
        modelo = (DefaultTableModel) Tabla.getModel();
        FechaHora();
        Ultimo_Numero u = new Ultimo_Numero();
        u.Actualizar_Ultimo("Comprobante", Ultimo_Num1());
        Ultimo_Num1();
    }

    public void FechaHora() {
        Panel pa = new Panel();
        String fechas = pa.Fecha();
        txtFecha.setText(fechas);
        fechas = pa.Hora();
        txtHora.setText(fechas);
    }

    public static void Subtotal() {
        int cont;
        float tot = 0;
        int filas = Tabla.getRowCount();
        float subto[] = new float[filas];
        for (cont = 0; cont < filas; cont++) {
            subto[cont] = Float.parseFloat(Tabla.getValueAt(cont, 4).toString());
        }
        for (cont = 0; cont < filas; cont++) {
            tot = tot + subto[cont];
        }
        String x = Float.toString(tot);
        txtSubtotal.setText(""+Math.rint(tot*100)/100);
        float Impuesto = (tot * 12) / 100;
        x = Float.toString(Impuesto);
        txtIva.setText(""+Math.rint(Impuesto * 100)/100);
        Impuesto = tot + Impuesto;
        x = Float.toString(Impuesto);
        txtTot.setText(""+Math.rint(Impuesto * 100)/100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSexo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        BtnCLi = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        CmbPrecio = new javax.swing.JComboBox();
        BttnProducto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        BtnCotizacion = new javax.swing.JButton();
        BtnRealizarVenta = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTot = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        ape = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblFact = new javax.swing.JLabel();
        btnEliminar_Articulo = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblProducto = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));

        jLabel2.setText("C.I.");

        txtCi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiActionPerformed(evt);
            }
        });
        txtCi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiKeyTyped(evt);
            }
        });

        jLabel3.setText("Nombres");

        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });

        jLabel4.setText("Apellidos");

        jLabel5.setText("Direccion");

        jLabel6.setText("Telefono");

        jLabel7.setText("Correo");

        jLabel8.setText("Sexo");

        jLabel9.setText("Celular");

        txtCel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelActionPerformed(evt);
            }
        });

        jLabel10.setText("Codigo");

        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });

        BtnCLi.setText("CLIENTE");
        BtnCLi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCLiActionPerformed(evt);
            }
        });

        jLabel17.setText("Fecha");

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        jLabel18.setText("Hora");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNom)
                            .addComponent(txtApe)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnCLi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtCi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnCLi)
                        .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 1120, 210));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre del Producto", "Cantidad", "Prec. Unitario", "Total"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 1130, 190));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccion de Producto"));

        CmbPrecio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escoja Precio", "Precio Unitario", "Precio Por Mayor", "Precio Tarjeta Credito" }));
        CmbPrecio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbPrecioItemStateChanged(evt);
            }
        });
        CmbPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CmbPrecioMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CmbPrecioMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmbPrecioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CmbPrecioMouseEntered(evt);
            }
        });
        CmbPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbPrecioActionPerformed(evt);
            }
        });
        CmbPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CmbPrecioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CmbPrecioKeyReleased(evt);
            }
        });

        BttnProducto.setText("Producto");
        BttnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttnProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(CmbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BttnProducto)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BttnProducto))
                .addContainerGap())
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 305, 410, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura.jpg"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 130, 80));

        jButton2.setText("CANCELAR COTIZACION");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, -1, -1));

        BtnCotizacion.setText("COTIZACION");
        BtnCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCotizacionActionPerformed(evt);
            }
        });
        jPanel4.add(BtnCotizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 590, 90, -1));

        BtnRealizarVenta.setText("Realizar Venta");
        BtnRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRealizarVentaActionPerformed(evt);
            }
        });
        jPanel4.add(BtnRealizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 620, -1, -1));

        jLabel13.setText("Subtotal       $");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 600, -1, -1));
        jPanel4.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 600, 80, -1));

        jLabel14.setText("IVA 12%      $");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 620, -1, -1));
        jPanel4.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 620, 80, -1));

        jLabel15.setText("Total            $");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 640, 90, -1));

        txtTot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotActionPerformed(evt);
            }
        });
        jPanel4.add(txtTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 640, 80, -1));

        correo.setEditable(false);
        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });
        jPanel4.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, 130, -1));

        nom.setEditable(false);
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        jPanel4.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, 130, -1));

        ape.setEditable(false);
        ape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apeActionPerformed(evt);
            }
        });
        jPanel4.add(ape, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, 130, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 90, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print me.png"))); // NOI18N
        jButton3.setText("Imprimir");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print grande.png"))); // NOI18N
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print grande.png"))); // NOI18N
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 620, -1, -1));

        jPanel3.setBackground(new java.awt.Color(238, 210, 127));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("COTIZACION");

        lblFact.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblFact.setForeground(new java.awt.Color(255, 0, 51));
        lblFact.setText("0000");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblFact, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFact, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 450, -1));

        btnEliminar_Articulo.setText("Eliminar Articulo");
        btnEliminar_Articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_ArticuloActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminar_Articulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, 140, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sistemafondo.jpg"))); // NOI18N
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 700));

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, -1, -1));

        lblProducto.setText("----");
        jPanel4.add(lblProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 50, -1, -1));

        lblCantidad.setText("----");
        jPanel4.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 50, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomActionPerformed

    private void txtCelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelActionPerformed


    private void txtCiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiActionPerformed
        String cedula = (txtCi.getText());
        try {
            PreparedStatement pst = link.prepareStatement("SELECT * FROM clientes WHERE Cedula = '" + cedula + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                deshabilitar();
                txtCod.setText(rs.getString(1));
                txtNom.setText(rs.getString(3));
                txtApe.setText(rs.getString(4));
                txtDir.setText(rs.getString(5));
                txtCor.setText(rs.getString(6));
                txtSexo.setText(rs.getString(7));
                txtCel.setText(rs.getString(8));
                txtTel.setText(rs.getString(9));
            } else if (!(rs.next())) {
                JOptionPane.showMessageDialog(rootPane, "USUARIO NO ENCONTRADO");
                Form_Clientes nuevo = new Form_Clientes();
                nuevo.txtCi.setText(txtCi.getText());
                nuevo.setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }//GEN-LAST:event_txtCiActionPerformed

    private void BtnCLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCLiActionPerformed
       
        ClientesFrame cli = new ClientesFrame(1);
        cli.setVisible(true);
    }//GEN-LAST:event_BtnCLiActionPerformed

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodActionPerformed

    private void txtTotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(null, "Seguro Desea Cancelar la Cotizacion", "Cancelar", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            Limpiar();
            FechaHora();
            borrar_tabla();
            CmbPrecio.setSelectedIndex(0);
            txtCi.setText("");
            txtCi.setEnabled(true);
            BtnCLi.setEnabled(true);
            BttnProducto.setEnabled(false);
        } 
        txtCi.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed
   
    private void txtCiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiKeyTyped
        char c = evt.getKeyChar();
        if (c > '0' && c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtCiKeyTyped

    private void BtnRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRealizarVentaActionPerformed
        int filas = Tabla.getRowCount();
        System.out.println(filas);
        if(filas <= 0)
        {
            JOptionPane.showMessageDialog(null,"No agrego Articulos para Vender","Error",JOptionPane.ERROR_MESSAGE);
        }
        if(txtNom.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Falta Datos de Factura","Error",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
        Ultimo_Numero u = new Ultimo_Numero();
        Detalles_Factura();
        
        Articulos_Vendidos();
       
        
        CmbPrecio.setSelectedIndex(0);
        u.Actualizar_Ultimo("Comprobante", Ultimo_Num1() + 1);
        Ultimo_Num1();
        descontar();
       
        //crear comprobante xd 
         //enviar
        borrar_tabla();
        
        }
        
        
        
    }//GEN-LAST:event_BtnRealizarVentaActionPerformed

    private void btnEliminar_ArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_ArticuloActionPerformed
        DefaultTableModel modelo = new DefaultTableModel();
        int fila = Tabla.getSelectedRow();
        if(fila >= 0)
        {
            int confirmaloco = JOptionPane.showConfirmDialog(null, "¿Seguro desea Quitar el articulo?","Advertencia",JOptionPane.YES_NO_OPTION);
            if(confirmaloco == JOptionPane.YES_OPTION)
            {
                modelo = (DefaultTableModel) Tabla.getModel();
                modelo.removeRow(fila);
                System.out.println("Fila "+fila+" Eliminada");
                Tabla.setModel(modelo);
                Subtotal();
            } 
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Seleccione un articulo");
        }
    }//GEN-LAST:event_btnEliminar_ArticuloActionPerformed

    private void BtnCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCotizacionActionPerformed
         Comprobante n = new Comprobante();
      
        n.correo.setText(correo.getText());
        n.nom.setText(nom.getText());
        n.ape.setText(ape.getText());
        n.setVisible(true);
    }//GEN-LAST:event_BtnCotizacionActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void apeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CmbPrecioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbPrecioItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPrecioItemStateChanged

    private void CmbPrecioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbPrecioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPrecioMousePressed

    private void CmbPrecioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbPrecioMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPrecioMouseReleased

    private void CmbPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbPrecioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPrecioMouseClicked

    private void CmbPrecioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbPrecioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPrecioMouseEntered

    private void CmbPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbPrecioActionPerformed
 if((CmbPrecio.getSelectedItem().toString().equals("Escoja Precio")==false ))
        {
         CmbPrecio.setEnabled(false);
        BttnProducto.setEnabled(true);
        BttnProducto.requestFocus();
        }
        else{
            CmbPrecio.requestFocus();
             JOptionPane.showMessageDialog(rootPane,"ERROR, ESCOJA PRECIO");
        }



    }//GEN-LAST:event_CmbPrecioActionPerformed

    private void CmbPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CmbPrecioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPrecioKeyPressed

    private void CmbPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CmbPrecioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPrecioKeyReleased

    private void BttnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttnProductoActionPerformed
Inventario ob = new Inventario();
ob.setVisible(true);

    }//GEN-LAST:event_BttnProductoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
try
            {
                PrinterJob ob  = PrinterJob.getPrinterJob();
                ob.setPrintable(this);
                boolean top = ob.printDialog();
                if(top ){
               ob.print();
              
                }
            }
            catch(PrinterException ex)
            {
JOptionPane.showMessageDialog(null,"Error en imprimir","error"+ex, JOptionPane.INFORMATION_MESSAGE);
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    

    

    
    public static void Agregar_Producto(String producto, String cantidad ){
         Codigo co = new Codigo();
        String recoge[] = co.Codigos();
     
        
            String combo_Precio = CmbPrecio.getSelectedItem().toString();
            int ubicacion =0;
            if(combo_Precio.equals("Escoja Precio")){

                System.out.println("ERROR INGRESE ");

            }
            else{
                if(combo_Precio.equals( "Precio Unitario")){
                     ubicacion = 7;
                }
                   
            if(combo_Precio.equals( "Precio Por Mayor")){
                 ubicacion = 13;
            }
                   
            if(combo_Precio.equals( "Precio Tarjeta Credito")){
                 ubicacion = 14;
            }
                   
            
                
             
           
                int indices = co.retornador();
                modelo = (DefaultTableModel) Tabla.getModel();
                for (int cont = 1; cont <= indices; cont++) {
                    try {
                        PreparedStatement pst = link2.prepareStatement("SELECT * FROM " + recoge[cont] + " WHERE Nombre = '" + producto + "'");
                        ResultSet rs = pst.executeQuery();
                        if (rs.next()) {
                            Valores[0] = rs.getString(1);
                            Valores[1] = rs.getString(2);
                            Valores[2] = cantidad;
                            
                            
                            
                            
                            Valores[3] = rs.getString(ubicacion);
                            int Cantidad = Integer.parseInt(cantidad);
                            float precio = Float.parseFloat(Valores[3]);
                            float tot = precio * Cantidad;
                            Valores[4] = Float.toString(tot);
                            Valores[5] = rs.getString(3);
                            modelo.addRow(Valores);
                            Tabla.setModel(modelo);
                        } else if (!(rs.next())) {
                            System.out.println("No Encontrado en " + recoge[cont]);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                    Subtotal();
                }
            
            
            
        } 
       
    
         nom.setText(txtNom.getText());
         ape.setText(txtApe.getText());
         
    }
   
public int Ultimo_Num1() {
        Ultimo_Numero numero = new Ultimo_Numero();
        int ultimo = numero.Ultimo_numero("Comprobante");
        if (ultimo < 10) {
            String Convertidor = Integer.toString(ultimo);
            Convertidor = "00000" + Convertidor;
            lblFact.setText(Convertidor);
        }
        if (ultimo >= 10 && ultimo < 100) {
            String Convertidor = Integer.toString(ultimo);
            Convertidor = "0000" + Convertidor;
            lblFact.setText(Convertidor);
        }
        if (ultimo >= 100 && ultimo < 1000) {
            String Convertidor = Integer.toString(ultimo);
            Convertidor = "000" + Convertidor;
            lblFact.setText(Convertidor);
        }
        if (ultimo >= 1000 && ultimo < 10000) {
            String Convertidor = Integer.toString(ultimo);
            Convertidor = "00" + Convertidor;
            lblFact.setText(Convertidor);
        }
        if (ultimo >= 10000 && ultimo < 100000) {
            String Convertidor = Integer.toString(ultimo);
            Convertidor = "0" + Convertidor;
            lblFact.setText(Convertidor);
        }
        if (ultimo >= 100000 && ultimo < 1000000) {
            String Convertidor = Integer.toString(ultimo);
            Convertidor = Convertidor;
            lblFact.setText(Convertidor);
        }
        return ultimo;
    }
    public void deshabilitar() {
        //txtCi.setEnabled(false);
        txtNom.setEnabled(false);
        txtApe.setEnabled(false);
        txtDir.setEnabled(false);
        txtCod.setEnabled(false);
        txtSexo.setEnabled(false);
        txtCel.setEnabled(false);
        txtTel.setEnabled(false);
        txtDir.setEnabled(false);
        txtCor.setEnabled(false);
        txtFecha.setEnabled(false);
        txtHora.setEnabled(false);
        txtSubtotal.setEnabled(false);
        txtIva.setEnabled(false);
        txtTot.setEnabled(false);
        BtnCotizacion.setEnabled(false);
        BtnRealizarVenta.setEnabled(false);
        btnEliminar_Articulo.setEnabled(false);
        CmbPrecio.setEnabled(false);
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
            java.util.logging.Logger.getLogger(Sistema_Comprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema_Comprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema_Comprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema_Comprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema_Comprobante().setVisible(true);
            }
        });
    }
    public int print(Graphics graphics, PageFormat pageFormat, int index) throws PrinterException 
 {
        if (index > 0)
        {
            
            return NO_SUCH_PAGE;
        }
        Graphics2D hub =    (Graphics2D) graphics;
        hub.translate(pageFormat.getImageableX()+50, pageFormat.getImageableY());
        
     
        hub.scale(0.45, 0.65);
   jPanel4.printAll(graphics);
        return PAGE_EXISTS;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BtnCLi;
    private javax.swing.JButton BtnCotizacion;
    public static javax.swing.JButton BtnRealizarVenta;
    private javax.swing.JButton BttnProducto;
    public static javax.swing.JComboBox CmbPrecio;
    public static javax.swing.JTable Tabla;
    public static transient javax.swing.JTextField ape;
    public static javax.swing.JButton btnEliminar_Articulo;
    private javax.swing.JTextField correo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblFact;
    public static javax.swing.JLabel lblProducto;
    public static transient javax.swing.JTextField nom;
    public static javax.swing.JTextField txtApe;
    public static javax.swing.JTextField txtCel;
    public static javax.swing.JTextField txtCi;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtCor;
    public static javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    public static javax.swing.JTextField txtIva;
    public static javax.swing.JTextField txtNom;
    public static javax.swing.JTextField txtSexo;
    public static javax.swing.JTextField txtSubtotal;
    public static javax.swing.JTextField txtTel;
    public static javax.swing.JTextField txtTot;
    // End of variables declaration//GEN-END:variables
}
