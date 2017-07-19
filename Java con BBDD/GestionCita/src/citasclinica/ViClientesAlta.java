package citasclinica;

import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author i1i26
 */
public class ViClientesAlta extends JFrame{
  private JTextField texto;
  private JButton botonAltaCliente;
  private Box h;
  public ViClientesAlta(String[] alta){
    texto = new JTextField(20);
    botonAltaCliente = new JButton(alta[0]);
    h = Box.createHorizontalBox();
    h.add(texto);
    h.add(botonAltaCliente);
    add(h,BorderLayout.CENTER);
  }

  public String getTexto(){
    return texto.getText();
  }

  public JButton getBotonAltaCliente(){
    return botonAltaCliente;
  }

  public void propiedadesVentanaSecundaria(){
    pack();
    setVisible(true);
  }

}