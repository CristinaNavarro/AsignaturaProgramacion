import java.util.Scanner;

public class ContadorNumerosPositivos{
  public static void main (String[] args) {
    Scanner teclado = new Scanner(System.in);
    int contador=0;
    int numero=0;
    
    while (numero>=0){
      System.out.println("Introduzca un número");
      numero = teclado.nextInt();
      contador++;
    }
    contador = contador-1;
    System.out.print("Ha introducido " +contador +" números positivos.");
  }
}
