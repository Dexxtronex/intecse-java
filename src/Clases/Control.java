package Clases;


public class Control {
    
    public String Nombres;
    public String Apellidos;
    public int Ci;
    public String fn;
    public String sex;
    public String cor;
    public int tel;
    public int cel;
    public String dir;
    public String usu;
    public String con;
    public String ti_usu;
    public String hora;
    public String Clasificacion;

    
    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }
    
        public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getCi() {
        return Ci;
    }


    public void setCi(int Ci) {
        this.Ci = Ci;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getCel() {
        return cel;
    }

    public void setCel(int cel) {
        this.cel = cel;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getTi_usu() {
        return ti_usu;
    }

    public void setTi_usu(String ti_usu) {
        this.ti_usu = ti_usu;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getHora() {
        return hora;
    }

   
     public void Clasifica(String radio)
     {
         Clasificacion = radio;
     }
     public String getClasifica()
      {
         return Clasificacion;
      }
    
    
}
