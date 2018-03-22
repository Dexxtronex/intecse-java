package Clases;
import Jdbc.Conexion;
import Jdbc.Conexion_cat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Carga_ComboBox {
    Connection cn;
    Conexion con = new Conexion();
    Conexion_cat con_cat = new Conexion_cat();
    int contador = 0;
    
    
    
    Connection cnn;
    Conexion conn = new Conexion();
    Conexion con_pro = new Conexion();
    int contador1 = 0;
    
    
    
    
    public ResultSet Combo(String x) throws Exception
    {
        cn = con.Conec();
        String sql = "SELECT Nombre FROM "+x;
        PreparedStatement pst = cn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        return rs;
    }
    public ResultSet Categoria() throws Exception
    {
        cn = con_cat.ConecCat();
        String sql = "show tables";
        PreparedStatement pst = cn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        return rs;
    }
    public ResultSet Combo1(String x) throws Exception
    {
        cnn = conn.Conec();
        String sql = "SELECT Nombre FROM "+x;
        PreparedStatement pst = cnn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        return rs;
    }
    public ResultSet Proveedores() throws Exception
    {
        cnn = con_pro.Conec();
        String sql = "show tables";
        PreparedStatement pst = cnn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        return rs;
    }
}
