import java.util.Scanner;

public class SumaPositivos {
  public static void main (String[] args) {
    Scanner teclado = new Scanner(System.in);
    
    int numero=0;
    int suma=0;
    System.out.println("Introduzca un número positivo");
    numero = teclado.nextInt();
    for (int contador=0;contador<100;contador++) {
      if (numero>0){
      suma = suma+numero;
      numero++;
      }else{
      System.out.println("Número incorrecto. Introduzca un número positivo, por favor.");
      contador = contador-1;
      }
    }
    System.out.print("" +suma);
  }
}
