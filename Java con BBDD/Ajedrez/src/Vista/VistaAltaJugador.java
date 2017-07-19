package Vista;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaAltaJugador extends JPanel {
	private JLabel texto;
	private JTextField nombre;
	private JButton aceptar;
	public VistaAltaJugador(){
		texto = new JLabel("Introduzca el nombre del jugador");
		nombre = new JTextField(20);
		aceptar = new JButton("Aceptar");
		//alerta.
		add(texto);
		add(nombre);
		add(aceptar);
	}
	
	public JButton getBotonAltaAceptar(){
		return aceptar;
	}
	
	public String getNombreAlta(){
		return nombre.getText();
	}
	
	public JTextField getFieldNombreAlta(){
		return nombre;
	}
}
