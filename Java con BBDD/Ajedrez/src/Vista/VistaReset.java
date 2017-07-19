package Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaReset extends JPanel{
	private JLabel texto;
	private JButton boton;
	public VistaReset(){
		texto = new JLabel("Pulse si desea reiniciar jugadores y partidos");
		boton = new JButton("Reiniciar");
		add(texto);
		add(boton);
	}
	
	public JButton getBotonReset(){
		return boton;
	}
}
