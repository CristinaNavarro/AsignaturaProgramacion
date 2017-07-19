package Modelo;

import java.util.ArrayList;

import javax.swing.JLabel;

public class DatosConexion {
	private String[] texto = {"jdbc:mysql://localhost/Ajedrez","root",""};
	public DatosConexion(){

	}
	
	public String getBD(){
		return texto[0];
	}
	public String getUsuario(){
		return texto[1];
	}
	public String getPass(){
		return texto[2];
	}
}
