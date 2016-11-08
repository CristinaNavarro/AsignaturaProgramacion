import java.util.Scanner;

public class NumeroCuboCuadrado {
  public static void main (String[] args) {
    Scanner teclado = new Scanner(System.in);
    
    int numero;
    int cuadrado;
    int cubo;
    
    System.out.print("Introduzca un número");
    numero = teclado.nextInt();
    for(int contador=0;contador<5;contador++) {
      cuadrado = (int) Math.pow(numero,2);
      cubo = (int) Math.pow(numero,3);
      System.out.println(numero +" " +cuadrado +" " +cubo);
      numero++;
    }
  }
}
