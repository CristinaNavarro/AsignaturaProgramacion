package Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class VistaPpal extends JFrame {
	private JTabbedPane pestana;
	private VistaAltaJugador vistaAlta;
	private VistaPartidos vistaPartidos;
	private VistaReset vistaReset;
	private VistaTable vistaTable;
	private int contadorPartidosJugados=0;
	public VistaPpal(String[] textoLabel, String[] textoBotones){
		pestana = new JTabbedPane();
		vistaAlta = new VistaAltaJugador();
		vistaPartidos = new VistaPartidos(textoLabel, textoBotones);
		vistaReset = new VistaReset();
		vistaTable = new VistaTable();
		pestana.add(vistaAlta,"Alta jugador");
		pestana.add(vistaPartidos,"Partidos");
		pestana.add(vistaReset, "Reset");
		pestana.add(vistaTable, "Tabla de Jugadores");
		add(pestana);
		setVisible(true);
		pack();
		setDefaultCloseOperation(VistaPpal.EXIT_ON_CLOSE);
	}
	
	public JButton getBotonAltaAceptar(){
		return vistaAlta.getBotonAltaAceptar();
	}
	
	public String getNombreAlta(){
		return vistaAlta.getNombreAlta();
	}
	
	public JButton getBotonPartidosSorteo(){
		return vistaPartidos.getBotonPartidosSorteo();
	}
	
	public JButton getBotonPartidoGanador(){
		return vistaPartidos.getBotonPartidoGanador();
	}
	
	public JButton getBotonReset(){
		return vistaReset.getBotonReset();
	}
	
	public int getNumeroNombre(int posicion){
		return vistaPartidos.getNumeroNombre(posicion);
	}
	
	public void setTextoNombre(String nombre, int posicion){
		vistaPartidos.setTextoNombre(nombre, posicion);
	}
	
	public void ganadorPartido(int posicion){
		
		switch((int)(Math.random()*2)){
			case 0:
				vistaPartidos.setGanador(contadorPartidosJugados, vistaPartidos.getTextoNombre(posicion-1));
				contadorPartidosJugados++;
				break;
			case 1:
				vistaPartidos.setGanador(contadorPartidosJugados, vistaPartidos.getTextoNombre(posicion));
				contadorPartidosJugados++;
				break;
		}
	}
	public int tamanoListaGanadores(){
		return vistaPartidos.tamanoListaGanadores();
	}
	
	public void reiniciar(int numeroJugadores){
		if(numeroJugadores<5){
			contadorPartidosJugados=0;
			vistaPartidos.establecerPosiciones();
			vistaPartidos.reiniciarContadorField();
			vistaPartidos.reiniciarGanadores();
		}
	}
	
	public String getGanador(int posicion){

		return vistaPartidos.getGanador(posicion);
	}
	
	public JTable enviarTabla(){
		return vistaTable.enviarTabla();
	}
	
	public DefaultTableModel enviarModelo(){
		return vistaTable.enviarModelo();
	}
	
	public JButton getBotonActualizar(){
		return vistaTable.getBotonActualizar();
	}
	
	public JTextField getFieldNombreAlta(){
		return vistaAlta.getFieldNombreAlta();
	}
}
