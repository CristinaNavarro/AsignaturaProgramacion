package citasclinica;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Alerta extends JFrame {
	private JLabel alerta;
	private JButton aceptar;
	public Alerta(){
		alerta = new JLabel("Va a borrar todas las citas. Si desea continuar pulse si, de lo contrario cierre la ventana.");
		aceptar = new JButton("Si");
		add(alerta,BorderLayout.CENTER);
		add(aceptar,BorderLayout.SOUTH);
		setVisible(true);
		pack();
	}
	public JButton getBotonAlerta(){
		return aceptar;
	}
}
