package citasclinica;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author i1i26
 */
public class ViCitaAltaBaja extends JFrame {
  private ArrayList<JComboBox> listaCombo;
  private ArrayList<JButton> listaBotones;
  Box v;
  Box h;
  public ViCitaAltaBaja(String[] texto){
    listaCombo = new ArrayList();
    listaBotones = new ArrayList();
    v = Box.createVerticalBox();
    h = Box.createHorizontalBox();
    for(int i=0;i<3;i++){
      listaCombo.add(new JComboBox());
      v.add(listaCombo.get(i));
    }
    for(int i=0;i<2;i++){
      listaBotones.add(new JButton(texto[i]));
      h.add(listaBotones.get(i));
    }
    add(v,BorderLayout.CENTER);
    add(h,BorderLayout.SOUTH);
  }

  public JButton getBotonAceptar(){
    return listaBotones.get(0);
  }
  public JButton getBotonListado(){
    return listaBotones.get(1);
  }
  public void propiedadesVentanaSecundaria(){
    pack();
    setVisible(true);
  }
  
  public void addElementoComboAB(int codigo){
	  listaCombo.get(0).addItem(codigo);
  }
  
  public void addElementoComboDia(String[] dia){
	  for(int i=0;i<dia.length;i++){
		  listaCombo.get(1).addItem(dia[i]); 
	  }
  }
  
  public void addElementoComboHora(Integer[] hora){
	  for(int i=0;i<hora.length;i++){
		  listaCombo.get(2).addItem(hora[i]);
	  }
  }
  
  public String getDia(){
	  return (String) listaCombo.get(1).getSelectedItem();
  }
  
  public int getHora(){
	  return (Integer) listaCombo.get(2).getSelectedItem();
  }
  
  public int getCodigo(){
	  return (Integer) listaCombo.get(0).getSelectedItem();
  }
}