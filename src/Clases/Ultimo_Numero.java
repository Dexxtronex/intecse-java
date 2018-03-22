/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Jdbc.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Ultimo_Numero {
    
        Conexion co = new Conexion();
        Connection link = co.Conec();
    public int Ultimo_numero(String columna)
    {
        int num = 0;
        try
        {
            PreparedStatement pst = link.prepareStatement("SELECT * FROM ultimo_numero");
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                 num = rs.getInt(columna);
            }
            pst.close();
            rs.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"No se ejecuto la Operacion");
        }
        
        return num;
    }
    
    public void Actualizar_Ultimo(String columna,int x)
    {
        
        try
        {
            PreparedStatement pst = link.prepareStatement("UPDATE ultimo_numero SET "+columna+" = '"+x+"'");
            int r = pst.executeUpdate();
            if(r > 0)
            {
                System.out.println("Actualizado");
            }
            pst.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error "+e);
        }
    }
}

