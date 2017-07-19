package citasclinica;

import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author i1i26
 */
public class ViClientesBaja extends JFrame{
  private JComboBox listaCodigos;
  private JButton botonBajaCliente;
  private Box h;

  public ViClientesBaja(String[] baja){
    listaCodigos = new JComboBox();
    botonBajaCliente = new JButton(baja[0]);
    h = Box.createHorizontalBox();
    h.add(listaCodigos);
    h.add(botonBajaCliente);
    add(h,BorderLayout.CENTER);
  }

  public JButton getBotonBajaCliente(){
    return botonBajaCliente;
  }

  public int getTextoCombo(){
    return (Integer) listaCodigos.getSelectedItem();
  }

  public void propiedadesVentanaSecundaria(){
    pack();
    setVisible(true);
  }

  public void addElementosCombo(int codigo){
    listaCodigos.addItem(codigo);
  }
}