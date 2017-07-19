package citasclinica;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author i1i26
 */
public class ViClinica extends JFrame {
  private ArrayList<JLabel> listaTexto;
  private ArrayList<JButton> listaBotones;
  private Box h1;
  private Box h2;

  public ViClinica(String[] textoLabel, String[] textoBoton){
    listaTexto = new ArrayList();
    listaBotones = new ArrayList();
    h1 = Box.createHorizontalBox();
    h2 = Box.createHorizontalBox();
    for(int i=0;i<2;i++){
      listaTexto.add(new JLabel(textoLabel[i]));
    }
    h1.add(listaTexto.get(0));
    h2.add(listaTexto.get(1));

    for(int i=0;i<6;i++){
      listaBotones.add(new JButton(textoBoton[i]));
      switch(i){
        case 0:
        case 1:
          h1.add(listaBotones.get(i));
          break;
        case 2:
        case 3:
        case 4:
        case 5:
          h2.add(listaBotones.get(i));
          break;
      }
    }
    add(h1,BorderLayout.NORTH);
    add(h2,BorderLayout.CENTER);
  }

  public void propiedadesVentanaPrincipal(){
    pack();
    setDefaultCloseOperation(ViClinica.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public JButton getBotonMenu(int contador){
    return listaBotones.get(contador);
  }

  
}