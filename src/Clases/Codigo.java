package Clases;

import Jdbc.Conexion_cat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Codigo 
{

     int cont =0;
    
 public String[] Codigos()
 {
     Conexion_cat co = new Conexion_cat();
     Connection link = co.ConecCat();
     String x[] = new String[100000];
          try { 
         String sql = "show tables";
         PreparedStatement pst = link.prepareStatement(sql);
         ResultSet rs = pst.executeQuery();
         while(rs.next())
         {
          cont = cont + 1;
          x[cont] = rs.getString(1);
         }
         rs.close();
          }   
         catch (SQLException ex) 
         {
         Logger.getLogger(Codigo.class.getName()).log(Level.SEVERE, null, ex);
         }
          return x;
 }
   
 public int retornador()
 {/*
     int acum = 0;
     Conexion_cat co = new Conexion_cat();
     Connection link = co.ConecCat();
          try { 
         String sql = "show tables";
         PreparedStatement pst = link.prepareStatement(sql);
         ResultSet rs = pst.executeQuery();
         while(rs.next())
         {
          cont = cont + 1;
         }
         rs.close();
          }   
         catch (SQLException ex) 
         {
         Logger.getLogger(Codigo.class.getName()).log(Level.SEVERE, null, ex);
         }
*/     return cont;
 }
}