package citasclinica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author i1i26
 * 								
 */
public class CoClinica implements ActionListener {

  private ViClinica vistaPpal;
  private MoClinica modelo;
  private ViClientesAlta vistaClienteAlta;
  private ViClientesBaja vistaClienteBaja;
  private ViCitaAltaBaja vistaCitaAlta;
  private ViCitaAltaBaja vistaCitaBaja;
  private ViModificacionCita vistaModificacionCita;
  private ViLista vistaLista;
  private Alerta vistaAlerta;
  private boolean clientesAlta = false;
  private boolean clientesBaja = false;
  private boolean citaAlta = false;
  private boolean citaBaja = false;
  private boolean modificacionCita = false;
  private boolean reiniciar = false;
  private int numero;

  public CoClinica() {
    modelo = new MoClinica();
    vistaPpal = new ViClinica(modelo.getTextoLabel(), modelo.getTextoButton());
    vistaPpal.propiedadesVentanaPrincipal();
    for (int i = 0; i < 6; i++) {
      vistaPpal.getBotonMenu(i).addActionListener(this);
    }
  }

  public void actionPerformed(ActionEvent e) {
    //////////////////////////////////////////////////////////////////////menu principal
    //alta cliente
    if (e.getSource() == vistaPpal.getBotonMenu(0)) {
      vistaClienteAlta = new ViClientesAlta(modelo.getTextoAltaBaja());
      vistaClienteAlta.propiedadesVentanaSecundaria();
      clientesAlta = true;
      vistaClienteAlta.getBotonAltaCliente().addActionListener(this);
    }
    //baja cliente
    if (e.getSource() == vistaPpal.getBotonMenu(1)) {
      vistaClienteBaja = new ViClientesBaja(modelo.getTextoAltaBaja());
      clientesBaja = true;
      vistaClienteBaja.getBotonBajaCliente().addActionListener(this);
      try {
        modelo.crearConsultaCodigos();
        do {
          numero = modelo.cogerCodigos();
          if (numero != 0) {
            vistaClienteBaja.addElementosCombo(numero);
          }
        } while (numero != 0);
      } catch (SQLException ex) {
        Logger.getLogger(CoClinica.class.getName()).log(Level.SEVERE, null, ex);
      }
      vistaClienteBaja.propiedadesVentanaSecundaria();

    }
    //alta cita
    if (e.getSource() == vistaPpal.getBotonMenu(2)) {
      vistaCitaAlta = new ViCitaAltaBaja(modelo.getTextoAltaBaja());
      vistaCitaAlta.propiedadesVentanaSecundaria();
      citaAlta = true;
      try {
        modelo.crearConsultaCodigos();
        do {
          numero = modelo.cogerCodigos();
          if (numero != 0) {
            vistaCitaAlta.addElementoComboAB(numero);
          }
        } while (numero != 0);
      } catch (SQLException ex) {
        Logger.getLogger(CoClinica.class.getName()).log(Level.SEVERE, null, ex);
      }

      //introduccion de datos en segundo y tercer combo
      vistaCitaAlta.addElementoComboDia(modelo.getTextoDia());
      vistaCitaAlta.addElementoComboHora(modelo.getHora());

      vistaCitaAlta.getBotonAceptar().addActionListener(this);
      vistaCitaAlta.getBotonListado().addActionListener(this);

    }
    //baja cita
    if (e.getSource() == vistaPpal.getBotonMenu(3)) {
      vistaCitaBaja = new ViCitaAltaBaja(modelo.getTextoAltaBaja());

      vistaCitaBaja.propiedadesVentanaSecundaria();
      citaBaja = true;
      try {
        modelo.crearConsultaCodigosConCita();//hay un fallo no se cual
        do {
          numero = modelo.cogerCodigos();
          if (numero != 0) {
            vistaCitaBaja.addElementoComboAB(numero);
          }
        } while (numero != 0);
      } catch (SQLException ex) {
        Logger.getLogger(CoClinica.class.getName()).log(Level.SEVERE, null, ex);
      }

      //introduccion de datos en segundo y tercer combo
      vistaCitaBaja.addElementoComboDia(modelo.getTextoDia());
      vistaCitaBaja.addElementoComboHora(modelo.getHora());

      vistaCitaBaja.getBotonAceptar().addActionListener(this);
      vistaCitaBaja.getBotonListado().addActionListener(this);

    }
    //modificar
    if (e.getSource() == vistaPpal.getBotonMenu(4)) {
      vistaModificacionCita = new ViModificacionCita(modelo.getTextoAModificaciones());
      modificacionCita = true;
      vistaModificacionCita.getBotonModificacion().addActionListener(this);
      vistaModificacionCita.getListado().addActionListener(this);
      try {
        modelo.crearConsultaCodigosConCita();
        do {
          numero = modelo.cogerCodigos();
          if (numero != 0) {
            vistaModificacionCita.addComboCodigo(numero);
          }
        } while (numero != 0);
      } catch (SQLException ex) {
        Logger.getLogger(CoClinica.class.getName()).log(Level.SEVERE, null, ex);
      }

      vistaModificacionCita.addComboDiaActual(modelo.getTextoDia());
      vistaModificacionCita.addComboHoraActual(modelo.getHora());
      vistaModificacionCita.addComboDiaDeseado(modelo.getTextoDia());
      vistaModificacionCita.addComboHoraDeseada(modelo.getHora());
      vistaModificacionCita.propiedadesVentanaSecundaria();
    }

    //Reiniciar
    if (e.getSource() == vistaPpal.getBotonMenu(5)) {
      vistaAlerta = new Alerta();
      vistaAlerta.getBotonAlerta().addActionListener(this);
      reiniciar = true;

    }
///////////////////////////////////////////////////////////////////////////////////gestion clientes
    //alta cliente
    if (clientesAlta) {
      if (e.getSource() == vistaClienteAlta.getBotonAltaCliente()) {
        modelo.darAltaCliente(vistaClienteAlta.getTexto());
      }
    }
    //baja cliente
    if (clientesBaja) {
      if (e.getSource() == vistaClienteBaja.getBotonBajaCliente()) {
        modelo.darBajaCliente(vistaClienteBaja.getTextoCombo());
      }
    }
////////////////////////////////////////////////////////////////////////////////////gestion citas
    //anadir o eliminar una cita
    if (citaAlta) {
      if (e.getSource() == vistaCitaAlta.getBotonAceptar()) {
        modelo.anadirCita(vistaCitaAlta.getDia(), vistaCitaAlta.getHora(), vistaCitaAlta.getCodigo());
      }
      if (e.getSource() == vistaCitaAlta.getBotonListado()) {
        gestionVistaLista();
      }
    }
    if (citaBaja) {
      if (e.getSource() == vistaCitaBaja.getBotonAceptar()) {
        modelo.eliminarCita(vistaCitaBaja.getDia(), vistaCitaBaja.getHora(), vistaCitaBaja.getCodigo());
      }
      if (e.getSource() == vistaCitaBaja.getBotonListado()) {
        gestionVistaLista();
      }
    }

    //gestion modificaciones de citas
    if (modificacionCita) {
      if (e.getSource() == vistaModificacionCita.getBotonModificacion()) {
        modelo.eliminarCita(vistaModificacionCita.getListaDatosDiaActual(),
                vistaModificacionCita.getListaDatosHoraActual(), vistaModificacionCita.getListaDatosCodigo());
        modelo.anadirCita(vistaModificacionCita.getListaDatosDiaDeseado(),
                vistaModificacionCita.getListaDatosHoraDeseada(), vistaModificacionCita.getListaDatosCodigo());
      }
      if (e.getSource() == vistaModificacionCita.getListado()) {
        gestionVistaLista();
      }
    }
    if (reiniciar) {
      if (e.getSource() == vistaAlerta.getBotonAlerta()) {
        modelo.reiniciarCitas();
      }
    }
  }

  public void gestionVistaLista() {
    vistaLista = new ViLista();
    try {

      modelo.crearConsultaLista();
      String dia;
      do {
        dia = modelo.cogerDia();
        if (!dia.equals("")) {
          vistaLista.anadirLabel(dia, modelo.cogerHora(), modelo.cogerCod());
        }
      } while (!dia.equals(""));
    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
  }
}
