package Clases;

import Clases.Control;
import Jdbc.Conexion;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.*;
import javax.swing.text.PlainDocument;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Panel {
    
    Control c;
    Conexion co;
    Connection cn;
    
    
    
    
    public Panel()
    {
        co = new Conexion();
        c = new Control();
        
        c.setNombres("");
        c.setApellidos("");
        c.setCi(0);
        c.setFn("");
        c.setSex("");
        c.setCor("");
        c.setTel(0);
        c.setCel(0);
        c.setDir("");
        c.setUsu("");
        c.setCon("");
        c.setTi_usu("");
    }
  

    
    
    public Control buscarnombre(int x)
    {
        Control y = new Control();
        cn = co.Conec();
        String consulta = "select Nombres,Apellidos,Fecha_nac,Cedula,Telefono,Celular,Direccion,Usuario,Contraseña,Sexo,Tipo_Usuario,Correo from formulario WHERE Cedula="+x;
        try
        {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            if(rs.next())
            {
            y.setNombres(rs.getString(1));
            y.setApellidos(rs.getString(2));
            y.setFn(rs.getString(3));
            y.setCi(Integer.parseInt(rs.getString(4)));
            y.setTel(Integer.parseInt(rs.getString(5)));
            y.setCel(Integer.parseInt(rs.getString(6)));
            y.setDir(rs.getString(7));
            y.setUsu(rs.getString(8));
            y.setCon(rs.getString(9));
            y.setSex(rs.getString(10));
            y.setTi_usu(rs.getString(11));
            y.setCor(rs.getString(12));
            }
            else if (!(rs.next()))
            {
                 System.out.println("Numero de cedula no registrado");
                JOptionPane.showMessageDialog(null,"Cedula no registrada");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        catch(SQLException s)
        {
            JOptionPane.showMessageDialog(null,s);
            System.out.println(s.getMessage());
        }
        return y;
    }
    public int buscarnombre1(int x)
    {   int devolver =0;
        Control y = new Control();
        cn = co.Conec();
        String consulta = "select Cedula from clientes WHERE Cedula="+x;
        try
        {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            if(rs.next())
            {
                devolver =1;
            }
            
        }
        catch(SQLException s)
        {
            JOptionPane.showMessageDialog(null,s);
            System.out.println(s.getMessage());
        }
        return devolver;
    }
    public void modificar(int cedula)
    {
        boolean respuesta=true;
        Conexion cn = new Conexion();
        Connection link=cn.Conec();
        String consulta ="UPDATE formulario set Nombres= '"+c.getNombres()+"',Apellidos = '"+c.getApellidos()+"',Fecha_Nac = '"+c.getFn()+"',Cedula = '"+c.getCel()+"', Telefono = '"+c.getTel()+"',Celular = '"+c.getCel()+"',Direccion = '"+c.getDir()+"',Usuario = '"+c.getUsu()+"',Contraseña = '"+c.getCon()+"',Tipo_Usuario = '"+c.getTi_usu()+"' WHERE cedula = "+cedula;
        try
        {
            PreparedStatement pst = link.prepareStatement(consulta);
            //int confirmacion = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar los datos?", "Confirmacion" ,JOptionPane.YES_NO_OPTION)
                int n = pst.executeUpdate();
                      if (n>0) 
                    {
                       JOptionPane.showMessageDialog(null,"Datos Modificados Satisfactoriamente");
                       System.out.println("Datos modificados");
                    }
                      else
                    {
                         JOptionPane.showMessageDialog(null, "Error");
                    }
        }
        catch(SQLException s)
        {
            System.out.println(s.getMessage());
        }
     
    }
    
    public String Fecha()
    {
      Date fecha_actual = new Date();
      SimpleDateFormat fechita = new SimpleDateFormat("dd/MM/YYYY");
      return fechita.format(fecha_actual);
    }
    public String Hora()
    {
        Control p = new Control();
        Calendar hour = new GregorianCalendar();
        int h,m,s;
        String x;
        h = hour.get(Calendar.HOUR_OF_DAY);
        m = hour.get(Calendar.MINUTE);
        s = hour.get(Calendar.SECOND);
        System.out.printf("%2d/%02d/%2d",h,m,s);
        x = h+":"+m+":"+s;
        p.setHora(x);
        return x;
    }
    
}
