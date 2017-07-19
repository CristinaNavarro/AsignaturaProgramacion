package citasclinica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author i1i26
 */
public class MoClinica {

  private String[] textoLabel = {"Clientes", "Citas"};
  private String[] textoBotones = {"Alta de cliente", "Baja de cliente", "Alta de cita", "Baja de cita", "Modificacion cita", "Reinicio de citas"};
  private String[] altaBaja = {"Dar de alta", "Dar de baja"};
  private String[] citas = {"Aceptar", "Ver citas"};
  private String[] listaModificaciones = {"Tiene el dia y la hora:", "Se cambia al dia y hora:"};
  private String[] listaDias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
  private Integer[] listaHoras = {3, 4, 5, 6, 7};
  private Connection conexion;
  //private Statement s;
  private ResultSet rs;
  public Config datosConexion = new Config();

  public MoClinica() {
    try {
      DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
      System.out.println("Conectando..");
      conexion = DriverManager.getConnection(datosConexion.getBase(), datosConexion.getUsuario(), datosConexion.getPassword());
      System.out.println("Conectado.");
    } catch (SQLException ex) {
      Logger.getLogger(MoClinica.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
/////////////////////////////////////////////metodos para textos de vista

  public String[] getTextoLabel() {
    return textoLabel;
  }

  public String[] getTextoButton() {
    return textoBotones;
  }

  public String[] getTextoAltaBaja() {
    return citas;
  }

  public String[] getTextoAModificaciones() {
    return listaModificaciones;
  }

  public String[] getTextoDia() {
    return listaDias;
  }

  public Integer[] getHora() {
    return listaHoras;
  }
/////////////////////////////////////////////////////////////////metodos sobre los datos de la bbdd

  public void darAltaCliente(String nombre) {
    try {
      PreparedStatement st = conexion.prepareStatement("INSERT INTO cliente (nombre) VALUES (?)");
      st.setString(1, nombre);
      st.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(MoClinica.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void darBajaCliente(int codigo) {
    try {
      PreparedStatement st = conexion.prepareStatement("DELETE FROM cliente WHERE CODIGO = ?");
      st.setInt(1, codigo);
      st.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(MoClinica.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void crearConsultaCodigos() throws SQLException {
    Statement s;
    s = conexion.createStatement();
    rs = s.executeQuery("SELECT codigo FROM cliente");
  }

  public void crearConsultaCodigosConCita() throws SQLException {
    Statement s;
    s = conexion.createStatement();
    rs = s.executeQuery("SELECT DISTINCT codigo FROM cita");
  }

  public void crearConsultaLista() throws SQLException {
    Statement s;
    s = conexion.createStatement();
    rs = s.executeQuery("SELECT * FROM cita ORDER BY case when dia = 'Lunes' then 1 when dia = 'Martes' then 2"
    		+ " when dia = 'Miercoles' then 3 when dia = 'Jueves' then 4 else 5 end asc, hora");
  }

  public int cogerCodigos() throws SQLException {
    if (rs.next()) {
      return rs.getInt("CODIGO");
    } else {
      return 0;
    }
  }

  public String cogerDia() {
    try {
      if (rs.next()) {
        return rs.getString("DIA");
      } else {
        return "";
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return "";
  }

  public int cogerCod() throws SQLException {
    return rs.getInt("CODIGO");
  }

  public int cogerHora() throws SQLException {
    return rs.getInt("HORA");
  }

//////////////////////////////////////////////////////////////////////////gestion citas
  public void anadirCita(String dia, int hora, int codigo) {

    Statement st;
    try {
      st = conexion.createStatement();
      st.executeUpdate("INSERT INTO cita (dia, hora, codigo) VALUES ('" + dia + "', '" + hora + "', '" + codigo + "')");
    } catch (SQLException e) {
      System.out.println("Ya existe una cita en ese momento.");
    }

  }
  
   public void eliminarCita(String dia, int hora, int codigo) {
    
    try {
      Statement s = conexion.createStatement();
      ResultSet rs = s.executeQuery("SELECT dia, hora, codigo FROM cita WHERE dia = '"+dia+"' AND hora = '"+hora+"' AND codigo = '"+codigo+"'");
      rs.last();
      int fila = rs.getRow();
      System.out.print(fila);
      if(fila!=0){
	      PreparedStatement st = conexion.prepareStatement("DELETE FROM cita WHERE dia = ? AND hora = ? AND codigo = ?");
	      st.setString(1, dia);
	      st.setInt(2, hora);
	      st.setInt(3, codigo);
	      st.executeUpdate();
      } else {
    	  System.out.println("No se ha encontrado ninguna cita en ese momento.");
      }
    } catch (SQLException e) {
      System.out.println("No se ha encontrado una cita con esas caracteristicas, compruebe los datos.");
    }
  }

  public void modificarCita(String nombre) { //modificar a cliente
    try {
      PreparedStatement st = conexion.prepareStatement("UPDATE cliente SET nombre = ?");
      st.setString(1, nombre);
      st.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(MoClinica.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void reiniciarCitas() {
    PreparedStatement st;
    try {
      st = conexion.prepareStatement("DELETE FROM cita");
      st.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
