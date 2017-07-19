package citasclinica;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author i1i26
 */
public class ViModificacionCita extends JFrame {

  private ArrayList<JComboBox> listaDatos;
  private ArrayList<JLabel> listaBloque;
  private Box v;
  private ArrayList<JButton> botonesMod;

  public ViModificacionCita(String[] texto) {
    listaDatos = new ArrayList();
    listaBloque = new ArrayList();
    botonesMod = new ArrayList();
    botonesMod.add(new JButton("Modificar"));
    botonesMod.add(new JButton("Lista de citas"));
    v = Box.createVerticalBox();
    for (int i = 0; i < 5; i++) {
      listaDatos.add(new JComboBox());
    }
    for (int i = 0; i < 2; i++) {
      listaBloque.add(new JLabel(texto[i]));
    }
    v.add(listaDatos.get(0));
    v.add(listaBloque.get(0));
    v.add(listaDatos.get(1));
    v.add(listaDatos.get(2));
    v.add(listaBloque.get(1));
    v.add(listaDatos.get(3));
    v.add(listaDatos.get(4));
    v.add(botonesMod.get(0));
    v.add(botonesMod.get(1));
    add(v, BorderLayout.CENTER);
  }

  public int getListaDatosCodigo() {
    return (Integer) listaDatos.get(0).getSelectedItem();
  }

  public void addComboCodigo(int codigo) {
    listaDatos.get(0).addItem(codigo);
  }

  public String getListaDatosDiaActual() {
    return (String) listaDatos.get(1).getSelectedItem();
  }

  public void addComboDiaActual(String[] dia) {
    for (int i = 0; i < dia.length; i++) {
      listaDatos.get(1).addItem(dia[i]);
    }
  }

  public int getListaDatosHoraActual() {
    return (Integer) listaDatos.get(2).getSelectedItem();
  }

  public void addComboHoraActual(Integer[] hora) {
    for (int i = 0; i < hora.length; i++) {
      listaDatos.get(2).addItem(hora[i]);
    }
  }

  public String getListaDatosDiaDeseado() {
    return (String) listaDatos.get(3).getSelectedItem();
  }

  public void addComboDiaDeseado(String[] dia) {
    for (int i = 0; i < dia.length; i++) {
      listaDatos.get(3).addItem(dia[i]);
    }
  }

  public int getListaDatosHoraDeseada() {
    return (Integer) listaDatos.get(4).getSelectedItem();
  }

  public void addComboHoraDeseada(Integer[] hora) {
    for (int i = 0; i < hora.length; i++) {
      listaDatos.get(4).addItem(hora[i]);
    }
  }

  public JButton getBotonModificacion() {
    return botonesMod.get(0);
  }

  public JButton getListado() {
    return botonesMod.get(1);
  }

  public void propiedadesVentanaSecundaria() {
    pack();
    setVisible(true);
  }
}
