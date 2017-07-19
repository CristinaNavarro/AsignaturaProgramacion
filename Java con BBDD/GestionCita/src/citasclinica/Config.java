package citasclinica;


/**
 *
 * @author i1i26
 */
public class Config {
  private String base;
    private String usuario;
    private String password;
    public Config(){
      base = "jdbc:mysql://localhost/i1i26";
      usuario = "root";
      password = "";
    }
    public String getBase(){
      return base;
    }

    public String getUsuario(){
      return usuario;
    }

    public String getPassword(){
      return password;
    }
}