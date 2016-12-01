import java.util.Scanner;

public class Potencia {
  public static void main (String [] args) {
    Scanner teclado = new Scanner(System.in);
    
    int base=0;
    int exponente=0;
    int potencia;
    
    System.out.println("Introduzca la base");
    base = teclado.nextInt();
    System.out.println("Introduzca el exponente");
    exponente = teclado.nextInt();
    potencia = (int) Math.pow(base, exponente);
    System.out.print("El resultado es " +potencia);
  }
}
