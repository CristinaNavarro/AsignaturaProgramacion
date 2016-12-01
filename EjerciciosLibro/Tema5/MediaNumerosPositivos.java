import java.util.Scanner;

public class MediaNumerosPositivos {
  public static void main (String[] args) {
    Scanner teclado = new Scanner(System.in);
    int numero=0;
    int suma=0;
    int media=0;
    int contador=0;
    
    while (numero>=0) {
      System.out.println("Introduzca un número");
      numero = teclado.nextInt();
      suma = suma + numero;
      contador++;
    }
    media = suma/contador;
    System.out.print("La media es " +media);
  }
}
