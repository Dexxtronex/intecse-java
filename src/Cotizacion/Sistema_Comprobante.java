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
import java.awt.Image;
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

/**
 *
 * @author anthony
 */
public class Sistema_Comprobante extends javax.swing.JFrame {
 private final String ruta = System.getProperties().getProperty("user.dir");
    public void Detalles_Factura() {
        Conexion co = new Conexion();
        Connection link = co.Conec();
        String factura = lblFact.getText();
        int ced = Integer.parseInt(txtCi.getText());
        String fecha = txtFecha.getText();
        String Hora = txtHora.getText();
        float subtotal = Float.parseFloat(txtSubtotal.getText());
        float Iva = Float.parseFloat(txtIva.getText());
        float Total = Float.parseFloat(txtTot.getText());
        try {
            PreparedStatement pst = link.prepareStatement("INSERT INTO comprobante(Num_Fac,CI,Fecha,Hora,Subtotal,Iva,Total) VALUES (?,?,?,?,?,?,?) ");
            pst.setString(1, factura);
            pst.setInt(2, ced);
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
        txtStock.setText(null);
        txtCant.setText(null);
        CmbPro.setSelectedIndex(0);
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
        
        correo.setVisible(false);
        nom.setVisible(false);
        ape.setVisible(false);
        CargarComboBox();
        FechaHora();
        deshabilitar();
        Ultimo_Num1();
        jTextField1.setVisible(false);
    }

    String Valores[] = new String[6];
    DefaultTableModel modelo = new DefaultTableModel();
    Conexion cn = new Conexion();
    Connection link = cn.Conec();
    Conexion_cat con_cat = new Conexion_cat();
    Connection link2 = con_cat.ConecCat();

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

    public void Subtotal() {
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
        btnCli = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        CmbPro = new javax.swing.JComboBox();
        CmbPrecio = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTot = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        ape = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblFact = new javax.swing.JLabel();
        btnEliminar_Articulo = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btnCli.setText("CLIENTE");
        btnCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliActionPerformed(evt);
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
                                .addComponent(btnCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addContainerGap(19, Short.MAX_VALUE))
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
                        .addComponent(btnCli)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 990, 210));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre del Producto", "Cantidad", "Prec. Unitario", "Total"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 1210, 190));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccion de Producto"));

        jLabel11.setText("Producto");

        CmbPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escoja Producto" }));
        CmbPro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbProItemStateChanged(evt);
            }
        });
        CmbPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CmbProMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CmbProMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmbProMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CmbProMouseEntered(evt);
            }
        });
        CmbPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbProActionPerformed(evt);
            }
        });
        CmbPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CmbProKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CmbProKeyReleased(evt);
            }
        });

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

        jLabel12.setText("Cantidad");

        txtCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantActionPerformed(evt);
            }
        });
        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantKeyTyped(evt);
            }
        });

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel16.setText("Stock");

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(CmbPro, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(CmbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(CmbPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(jLabel16)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 305, 940, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 130, 80));

        jButton2.setText("CANCELAR COTIZACION");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, -1, -1));

        jButton3.setText("COTIZACION");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 620, 90, -1));

        btnVenta.setText("Realizar Venta");
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 620, -1, -1));

        jLabel13.setText("Subtotal       $");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 600, -1, -1));
        getContentPane().add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 600, 170, -1));

        jLabel14.setText("IVA 12%      $");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 620, -1, -1));
        getContentPane().add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 620, 170, -1));

        jLabel15.setText("Total            $");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 640, 90, -1));

        txtTot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotActionPerformed(evt);
            }
        });
        getContentPane().add(txtTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 640, 170, -1));

        jLabel21.setFocusCycleRoot(true);
        jLabel21.setFocusTraversalPolicyProvider(true);
        jLabel21.setOpaque(true);
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 140, 150, 130));

        correo.setEditable(false);
        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, 130, -1));

        nom.setEditable(false);
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        getContentPane().add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, 130, -1));

        ape.setEditable(false);
        ape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apeActionPerformed(evt);
            }
        });
        getContentPane().add(ape, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, 130, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 90, -1));

        jPanel3.setBackground(new java.awt.Color(204, 153, 0));
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
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFact, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFact, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 330, -1));

        btnEliminar_Articulo.setText("Eliminar Articulo");
        btnEliminar_Articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_ArticuloActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar_Articulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sistemafondo.jpg"))); // NOI18N
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 700));

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, -1, -1));

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

    private void btnCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliActionPerformed
      
        ClientesFrame cli = new ClientesFrame(1);
        cli.setVisible(true);
    }//GEN-LAST:event_btnCliActionPerformed

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodActionPerformed

    private void CmbProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbProActionPerformed

    }//GEN-LAST:event_CmbProActionPerformed

    private void txtTotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(null, "Seguro Desea Cancelar la Cotizacion", "Cancelar", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            Limpiar();
            FechaHora();
            borrar_tabla();
        } 
        txtCi.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
   
        Codigo co = new Codigo();
        String recoge[] = co.Codigos();
        int stock = Integer.parseInt(txtStock.getText());
        int avender = Integer.parseInt(txtCant.getText());
        String combito = CmbPro.getSelectedItem().toString();
       
        System.out.println(combito);
        if(avender == 0 || avender == 0)
        {
            JOptionPane.showMessageDialog(null,"Elija una cantidad superior a 0","Error",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
        if (avender <= stock) {
            int ope = stock - avender;
            String convertidor = Integer.toString(ope);
            txtStock.setText(convertidor);
            String combo_Precio = CmbPrecio.getSelectedItem().toString();
            int ubicacion =0;
            if(combo_Precio.equals("Escoja Precio")){
               JOptionPane.showMessageDialog(rootPane,"ESCOJA UN TIPO DE PRECIO");
            }
            else{
                if(combo_Precio.equals( "Precio Unitario"))
                    ubicacion = 7;
            if(combo_Precio.equals( "Precio Por Mayor"))
                    ubicacion = 13;
            if(combo_Precio.equals( "Precio Tarjeta Credito"))
                    ubicacion = 14;
            
                
             
            String Producto = CmbPro.getSelectedItem().toString();
            if (Producto.equals("Escoja Producto") || txtCant.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Elija un Producto y Su Cantidad", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                int indices = co.retornador();
                modelo = (DefaultTableModel) Tabla.getModel();
                for (int cont = 1; cont <= indices; cont++) {
                    try {
                        PreparedStatement pst = link2.prepareStatement("SELECT * FROM " + recoge[cont] + " WHERE Nombre = '" + Producto + "'");
                        ResultSet rs = pst.executeQuery();
                        if (rs.next()) {
                            Valores[0] = rs.getString(1);
                            Valores[1] = rs.getString(2);
                            Valores[2] = txtCant.getText();
                            
                            
                            
                            
                            Valores[3] = rs.getString(ubicacion);
                            int Cantidad = Integer.parseInt(txtCant.getText().toString());
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
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Monto a vender Supera el Stock");
        }
        }
         correo.setText(txtCor.getText());
         nom.setText(txtNom.getText());
         ape.setText(txtApe.getText());
         
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void CmbProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbProMouseClicked

    }//GEN-LAST:event_CmbProMouseClicked
    public void Stocked() {
        Codigo co = new Codigo();
        String tablas[] = co.Codigos();
        int indices = co.retornador();
        String seleccionado = CmbPro.getSelectedItem().toString();
        if (seleccionado.equals("......")) {
            System.out.println("Escogistes el por defecto");
            txtStock.setText("");
        } else {
            for (int cont = 1; cont <= indices; cont++) {
                try {
                    PreparedStatement pst = link2.prepareStatement("SELECT * FROM " + tablas[cont] + " WHERE Nombre = '" + seleccionado + "'");
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        String recoger = rs.getString(3);
                        txtStock.setText(recoger);
                       Image i=null;
                       Blob blob=rs.getBlob("foto");
                       i=javax.imageio.ImageIO.read(blob.getBinaryStream());
                       ImageIcon image=new ImageIcon(i);
                    jLabel21.setIcon(image);


                    } else if (!rs.next()) {
                        System.out.println("No se encuentra");
                    }
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Error " + x);
                }
            }
        }
    }
    private void CmbProMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbProMouseEntered
    }//GEN-LAST:event_CmbProMouseEntered

    private void CmbProKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CmbProKeyPressed

    }//GEN-LAST:event_CmbProKeyPressed

    private void CmbProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CmbProKeyReleased
        Stocked();
    }//GEN-LAST:event_CmbProKeyReleased

    private void CmbProMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbProMouseReleased

    }//GEN-LAST:event_CmbProMouseReleased

    private void CmbProMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbProMousePressed

    }//GEN-LAST:event_CmbProMousePressed

    private void txtCiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiKeyTyped
        char c = evt.getKeyChar();
        if (c > '0' && c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtCiKeyTyped

    private void CmbProItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbProItemStateChanged
        Stocked();
        //Restar();
    }//GEN-LAST:event_CmbProItemStateChanged

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
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
       
        
        CmbPro.setSelectedIndex(0);
        CmbPrecio.setSelectedIndex(0);
        u.Actualizar_Ultimo("Comprobante", Ultimo_Num1() + 1);
        Ultimo_Num1();
        descontar();
       
        //crear comprobante xd 
         //enviar
        borrar_tabla();
        
        }
        
        
        
    }//GEN-LAST:event_btnVentaActionPerformed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         Comprobante n = new Comprobante();
      
        n.correo.setText(correo.getText());
        n.nom.setText(nom.getText());
        n.ape.setText(ape.getText());
        n.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyTyped
char c = evt.getKeyChar();
 int numerocaracteres = 4;
 if((c<'0'||c>'9'))
        {          

            evt.consume();

        } 
 if(txtCant.getText().length()>= numerocaracteres){
    evt.consume(); 
 }    }//GEN-LAST:event_txtCantKeyTyped

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        JFileChooser archivo= new JFileChooser();
        int ventana=archivo.showOpenDialog(null);
        if(ventana==JFileChooser.APPROVE_OPTION){
            File file=archivo.getSelectedFile();
            jLabel20.setText(String.valueOf(file));
            Image foto=getToolkit().getImage(jLabel20.getText());
            jLabel21.setIcon(new ImageIcon(foto));
        }
    }//GEN-LAST:event_jLabel21MouseClicked

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
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPrecioActionPerformed

    private void CmbPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CmbPrecioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPrecioKeyPressed

    private void CmbPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CmbPrecioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbPrecioKeyReleased

    public void CargarComboBox() {
        Conexion_cat cn = new Conexion_cat();
        Connection con = cn.ConecCat();
        Codigo cod = new Codigo();
        String nombre[] = cod.Codigos();
        int retor = cod.retornador();
        for (int r = 1; r <= retor; r++) {
            try {
                PreparedStatement pst = con.prepareStatement("SELECT * FROM " + nombre[r]);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    CmbPro.addItem(rs.getString(2));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }
    }

    public void Restar() {
        String recoger = CmbPro.getSelectedItem().toString();
        int num_filas = Tabla.getRowCount();
        if (Tabla != null) {
            for (int cont = 0; cont >= num_filas; cont++) {
                if (Tabla.getValueAt(cont, 1).toString().equals(recoger)) {
                    int valor = Integer.parseInt(Tabla.getValueAt(cont, 2).toString());
                    String Stock = txtStock.getText();
                    int conver = Integer.parseInt(Stock);
                    valor = conver - valor;
                    Stock = Integer.toString(valor);
                    txtStock.setText(Stock);
                }
            }
        } else if (Tabla == null) {
            System.out.println("Todavia no se vende nada");
        }
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
        txtStock.setEnabled(false);
        txtSubtotal.setEnabled(false);
        txtIva.setEnabled(false);
        txtTot.setEnabled(false);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CmbPrecio;
    private javax.swing.JComboBox CmbPro;
    public javax.swing.JTable Tabla;
    public static transient javax.swing.JTextField ape;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCli;
    private javax.swing.JButton btnEliminar_Articulo;
    private javax.swing.JButton btnVenta;
    private javax.swing.JTextField correo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblFact;
    public static transient javax.swing.JTextField nom;
    public static javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtCant;
    public static javax.swing.JTextField txtCel;
    public static javax.swing.JTextField txtCi;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtCor;
    public static javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtIva;
    public static javax.swing.JTextField txtNom;
    public static javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtSubtotal;
    public static javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtTot;
    // End of variables declaration//GEN-END:variables
}
