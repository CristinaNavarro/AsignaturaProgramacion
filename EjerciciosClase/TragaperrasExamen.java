package Programacion;
import java.util.Scanner;
/**
 *
 * @author Cristina Navarro Soto
 */
public class TragaperrasExamen {

  public static void main(String[] args) {
    int tragaperras[] = new int[3];
    int contador;
    int intentos = 0;
    String enter;
    boolean iguales = false;
    int modoJuego;
    boolean modoCorrecto = false;
    while (!modoCorrecto) {
      System.out.println("Seleccione el modo de juego: 1.Aleatorio 2.Introducir un número 3.Introducir dos números");
      modoJuego = introducir();
      System.out.println("Introduzca el número de intentos.");
      contador = introducir();
      while (!iguales && intentos < contador) {
        if (modoJuego == 1) {
          modoCorrecto = true;
          //aleatorio
          for (int j = 0; j < contador; j++) {
            for (int i = 0; i < 3; i++) {
              tragaperras[i] = aleatorio();
              System.out.print(tragaperras[i]);
            }
            intentos++;
            System.out.println("\nPulse enter para continuar.");
            enter = avanzar();
            System.out.println("");
            iguales = igualdad(tragaperras[0], tragaperras[1], tragaperras[2]);
          }
        } else if (modoJuego == 2) {
          modoCorrecto = true;
          //un número elegido
          System.out.println("Introduzca el valor deseado");
          tragaperras[0] = introducir();
          for (int j = 0; j < contador; j++) {
            System.out.print(tragaperras[0] + " ");
            for (int i = 1; i < 3; i++) {
              tragaperras[i] = aleatorio();
              System.out.print(tragaperras[i] + " ");
            }
            intentos++;
            System.out.println("\nPulse enter para continuar.");
            enter = avanzar();
            System.out.println("");
            iguales = igualdad(tragaperras[0], tragaperras[1], tragaperras[2]);
          }
        } else if (modoJuego == 3) {
          modoCorrecto = true;
          System.out.println("Introduzca el valor deseado");
          tragaperras[0] = introducir();
          tragaperras[1] = tragaperras[0];
          //dos números elegidos
          while (intentos < contador && !iguales) {
            System.out.print(tragaperras[0] + " " + tragaperras[1] + " ");
            for (int i = 2; i < 3; i++) {
              tragaperras[i] = aleatorio();
              System.out.print(tragaperras[i]);
            }
            intentos++;
            System.out.println("\nPulse enter para continuar.");
            enter = avanzar();
            System.out.println("");
            iguales = igualdad(tragaperras[0], tragaperras[1], tragaperras[2]);
          }
        } else {
          System.out.println("Introduce un modo de juego correcto.");
        }
      }
    }
    if (iguales) {
      System.out.println("Has ganado");
    } else {
      System.out.println("Has perdidos");
    }
  }
  //métodos

  private static int aleatorio() {
    return (int) ((9) * Math.random() + 1);
  }

  private static int introducir() {
    Scanner teclado = new Scanner(System.in);
    return teclado.nextInt();
  }

  private static String avanzar() {
    Scanner teclado = new Scanner(System.in);
    return teclado.nextLine();
  }

  private static boolean igualdad(int tragaperra, int tragaperra0, int tragaperra1) {
    if (tragaperra == tragaperra0 && tragaperra == tragaperra1) {
      return true;
    } else {
      return false;
    }
  }
}
