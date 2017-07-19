package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Modelo.Modelo;
import Vista.VistaPpal;

public class Controlador implements ActionListener, KeyListener {
	private VistaPpal vista;
	private Modelo modelo;
	public Controlador(){
		modelo = new Modelo();
		vista = new VistaPpal(modelo.getTxtLabelVPartido(),modelo.getTxtBotonesVPartido());
		vista.getBotonAltaAceptar().addActionListener(this);
		vista.getBotonPartidosSorteo().addActionListener(this);
		vista.getBotonPartidoGanador().addActionListener(this);
		vista.getBotonReset().addActionListener(this);
		vista.getBotonActualizar().addActionListener(this);
		vista.getFieldNombreAlta().addKeyListener(this);

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.getBotonAltaAceptar()){
			modelo.insertarJugador(vista.getNombreAlta());
		} else if(e.getSource() == vista.getBotonPartidosSorteo()){
			if(modelo.getNumeroMayor()==5){
				for(int i=0;i<20;i++){
					if(vista.getNumeroNombre(i)==0){
						JOptionPane.showMessageDialog(null, "Pulse reiniciar para comenzar otro torneo","Alerta",2);
						i=20;
					}else{
						modelo.consultaNombre(vista.getNumeroNombre(i));
						String palabra = modelo.recogerNombre();
						if(!palabra.equals("")){
							vista.setTextoNombre(palabra, i);
							if(i%2!=0){
								vista.ganadorPartido(i);
							}
						}
					}
				}
			}else{
				JOptionPane.showMessageDialog(null,"No hay suficientes jugadores para comenzar el torneo","Alerta",2);
			}
		}else if(e.getSource() == vista.getBotonPartidoGanador()){
			modelo.reiniciarPuntuaciones();
			for(int i=0;i<vista.tamanoListaGanadores();i++){
				modelo.anadirPunto(vista.getGanador(i));
			}
			modelo.consultaGanador();
			int num = modelo.getNumeroGanadores();
			modelo.consultaGanador();
			switch(num){
				case 1:
					JOptionPane.showMessageDialog(null, "El ganador es " +modelo.getNombreGanador(),"Alerta",2);
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "Los ganadores son " +modelo.getNombreGanador() +" y " +modelo.getNombreGanador() 
,"Alerta",2);
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "Los ganadores son " +modelo.getNombreGanador() +" y " 
				+modelo.getNombreGanador() +" y " +modelo.getNombreGanador() ,"Alerta",2);
					break;
				case 4:
					JOptionPane.showMessageDialog(null, "Los ganadores son " +modelo.getNombreGanador() +" y " 
				+modelo.getNombreGanador() +" y " +modelo.getNombreGanador() +" y " +modelo.getNombreGanador(),"Alerta",2);
					break;
				case 5:
					JOptionPane.showMessageDialog(null, "Todos han ganado","Alerta",2);
					break;
			}
			
		}else if(e.getSource() == vista.getBotonReset()){
			modelo.eliminarRegistrosJugadores();
			vista.reiniciar(modelo.getNumeroMayor());
		}else if(e.getSource()==vista.getBotonActualizar()){
			modelo.ConsultaRellenarTabla();
			modelo.reiniciarTabla(vista.enviarTabla(), vista.enviarModelo());
			modelo.ConsultaRellenarTabla();
			modelo.rellenarTabla(vista.enviarTabla(), vista.enviarModelo());
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		char c=e.getKeyChar(); 
		if(e.getSource()==vista.getFieldNombreAlta()){
			       
	        if(!Character.isAlphabetic(c) && !Character.isWhitespace(c)) { 
	        	e.consume(); 
	        }  
	        
		}
		if(c == KeyEvent.VK_ESCAPE){
			System.exit(-1);
		}
		
	}
	
}
