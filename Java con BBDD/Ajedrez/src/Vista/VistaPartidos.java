package Vista;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaPartidos extends JPanel{
	private ArrayList<JLabel> listaTexto;
	private ArrayList<JTextField> listaNombres;
	private ArrayList<JButton> listaBotones;
	private ArrayList<JPanel> listaPaneles;
	private ArrayList<JTextField> listaGanadores;
	private Box v;
	private int contadorField =0;
	private int contadorPartida =1;
	public VistaPartidos(String[] textoLabel, String[] textoBotones){
		listaTexto = new ArrayList();
		listaNombres = new ArrayList();
		listaBotones = new ArrayList();
		listaPaneles = new ArrayList();
		listaGanadores = new ArrayList();
		v = Box.createVerticalBox();
		for(int i=0;i<20;i++){
			if((i%2)==0){
			listaTexto.add(new JLabel(textoLabel[0] +" " +contadorPartida));
			contadorPartida++;
			} else {
				listaTexto.add(new JLabel(textoLabel[1]));
			}
		}
		for(int i=0;i<24;i++){
			listaNombres.add(new JTextField(10));
			listaNombres.get(i).setEnabled(false);
			if(i<13){
				listaPaneles.add(new JPanel());
			}
		}
		for(int i=0;i<2;i++){
			listaBotones.add(new JButton(textoBotones[i]));
		}

		listaPaneles.get(0).add(listaBotones.get(0));
		
		for(int i=1;i<11;i++){
			listaPaneles.get(i).add(listaTexto.get(contadorField));
			listaPaneles.get(i).add(listaNombres.get(contadorField));
			listaPaneles.get(i).add(listaTexto.get(contadorField+1));
			listaPaneles.get(i).add(listaNombres.get(contadorField+1));
			listaTexto.add(new JLabel("Ganador: "));
			listaPaneles.get(i).add(listaTexto.get(19+i));
			listaGanadores.add(new JTextField(5));
			listaGanadores.get(i-1).setEnabled(false);
			listaPaneles.get(i).add(listaGanadores.get(i-1));
			contadorField+=2;
		}
		contadorField=0;
		establecerPosiciones();
		listaPaneles.get(12).add(listaBotones.get(1));
		
		
		for(int i=0;i<13;i++){
			v.add(listaPaneles.get(i));
		}
		
		add(v);
	}
	public JButton getBotonPartidosSorteo(){
		return listaBotones.get(0);
	}
	
	public JButton getBotonPartidoGanador(){
		return listaBotones.get(1);
	}
	
	public int getNumeroNombre(int posicion){
		if(listaNombres.get(posicion).getText().equals("1")|| listaNombres.get(posicion).getText().equals("2")
				|| listaNombres.get(posicion).getText().equals("3")||listaNombres.get(posicion).getText().equals("4")
				||listaNombres.get(posicion).getText().equals("5")||listaNombres.get(posicion).getText().equals("6")){
			return Integer.parseInt(listaNombres.get(posicion).getText());
		}else{
			return 0;
		}
	}
	
	public void setTextoNombre(String nombre, int posicion){
		listaNombres.get(posicion).setText(nombre);
	}
	
	public String getTextoNombre(int posicion){
		return listaNombres.get(posicion).getText();
	}
	
	public void setGanador(int posicion, String nombre){
		listaGanadores.get(posicion).setText(nombre);
	}
	
	public String getGanador(int posicion){

		return listaGanadores.get(posicion).getText();
	}
	
	public int tamanoListaGanadores(){
		return listaGanadores.size();
	}
	
	public void establecerPosiciones(){
		contadorField=0;
		for(int i=1;i<5;i++){
			for(int j=i+1;j<6;j++){
				listaNombres.get(contadorField).setText(""+i);
				listaNombres.get(contadorField+1).setText(""+j);
				contadorField+=2;
			}
		}
	}
	
	public void reiniciarContadorField(){
		contadorField=0;
	}
	
	public void reiniciarGanadores(){
		for(int i=0;i<listaGanadores.size();i++){
			listaGanadores.get(i).setText("");
		}
	}
}
