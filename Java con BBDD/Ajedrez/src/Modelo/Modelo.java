package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class Modelo {
	private String[] textoLabelVistaPartido = {"Partido", "vs","Ganador: "};
	private String[] textoBotonesVistaPartido = {"Sortear","Recuento de puntos"};
	private DatosConexion datos;
	private Connection conexion;
	private ResultSet rs;
	
	public Modelo(){
		
		try {
			datos = new DatosConexion();
			DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
			conexion = DriverManager.getConnection(datos.getBD(),datos.getUsuario(),datos.getPass());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//metodos de vistas
	public String[] getTxtLabelVPartido(){
		return textoLabelVistaPartido;
	}
	public String[] getTxtBotonesVPartido(){
		return textoBotonesVistaPartido;
	}
	
	//metodos de BD
	public void insertarJugador(String nombre){
		if(!nombre.equals("")){
			try {
				if(getNumeroMayor()>4){
					JOptionPane.showMessageDialog(null, "Ya no se pueden introducir mas jugadores", "Alerta", 2);
				}else{
					PreparedStatement pst = conexion.prepareStatement("INSERT INTO jugadores (codigo, nombre, partidasganadas) VALUES (?,?,0)");
					pst.setInt(1,getNumeroMayor()+1);
					pst.setString(2, nombre);
					pst.executeUpdate();
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Ese nombre de jugador ya esta registrado", "Alerta", 2);
			}
		}
	}
	
	public void eliminarRegistrosJugadores(){
		PreparedStatement pst;
		try {
			pst = conexion.prepareStatement("DELETE FROM jugadores");
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void consultaNombre(int codigo){
		Statement st;
		try {
			st = conexion.createStatement();
			rs = st.executeQuery("SELECT nombre FROM jugadores WHERE codigo = " +codigo);
			
		} catch (SQLException e) {
			
			
		}
	}
	
	public String recogerNombre(){
		
		try {
			if(rs.next()){
				return rs.getString("Nombre");
			}else{
				return "";
			}
		} catch (SQLException e) {
			System.out.println("Problema al recoger el nombre");
		}
		return "";
	}
	
	
	public int getNumeroMayor(){
		Statement s;
		try {
			s = conexion.createStatement();
			rs = s.executeQuery("SELECT MAX(codigo) codigo FROM jugadores");
			rs.first();
			return rs.getInt("Codigo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public int getPuntuacion(String nombre){
		Statement s;
		try {
			s = conexion.createStatement();
			rs = s.executeQuery("SELECT partidasGanadas FROM jugadores WHERE nombre =  '"+nombre+"'");
			rs.first();
			return rs.getInt("partidasGanadas");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void anadirPunto(String nombre){
		PreparedStatement pst;
		int puntos = getPuntuacion(nombre)+1;
		try {
			pst = conexion.prepareStatement("UPDATE jugadores SET partidasganadas = ? WHERE nombre = ?");
			pst.setInt(1, puntos);
			pst.setString(2, nombre);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public int getNumeroGanadores(){
		try {
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public String getNombreGanador(){
	
		try {
			if(rs.next()){			
				return rs.getString("nombre");
			}else{
				return "";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";

	}
	
	public void consultaGanador(){
		Statement s;
		try {
			s = conexion.createStatement();
			rs = s.executeQuery("SELECT nombre, partidasganadas FROM jugadores GROUP BY nombre HAVING PartidasGanadas IN(SELECT MAX(partidasganadas) FROM jugadores)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void reiniciarPuntuaciones(){
		PreparedStatement pst;
		try {
			pst = conexion.prepareStatement("UPDATE jugadores SET partidasganadas=0");
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void ConsultaRellenarTabla(){
		Statement s;
		try {
			s= conexion.createStatement();
			rs = s.executeQuery("SELECT * FROM jugadores ORDER BY partidasganadas DESC");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rellenarTabla(JTable tabla, DefaultTableModel modelo){
		try {
			while(rs.next()){
				Object[] fila = new Object[3];
				fila[0] = rs.getInt("Codigo");
				fila[1] = rs.getString("Nombre");
				fila[2] = rs.getInt("partidasganadas");
				modelo.addRow(fila);
				//tabla.setModel(modelo);
			}
			tabla.updateUI();
		} catch (SQLException e) {
			System.out.println("No se rellena");
		}
	}
	
	public void reiniciarTabla(JTable tabla,DefaultTableModel modelo){
		while(modelo.getRowCount()>0){

			modelo.removeRow(0);
		}
		tabla.updateUI();
	}
	
	
	
	
}
