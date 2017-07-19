package citasclinica;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViLista extends JFrame{
	private JLabel titulo;
	private ArrayList<JLabel> registro;
	private Box v;
	private int i=0;
	public ViLista(){
		registro = new ArrayList();
		titulo = new JLabel("Listado de citas");
		v = Box.createVerticalBox();
		v.add(titulo);
		add(v);
		setVisible(true);
		
	}
	public void anadirLabel(String dia, int hora, int codigo){
		registro.add(new JLabel(dia +" a las " +hora +" tiene cita el cliente " +codigo));
		v.add(registro.get(i));
		i++;
		pack();
	}
}
