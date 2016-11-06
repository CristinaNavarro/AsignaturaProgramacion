import java.util.Scanner;

public class TablaMultiplicar {
  public static void main (String[] args){
    Scanner teclado = new Scanner(System.in);
    
    int numero;
    int resultado;
    
    System.out.println("Introduzca un número para mostrar su tabla de multiplicación ");
    numero = teclado.nextInt();
    
    for (int contador=0;contador<11;contador++){
      resultado=numero*contador;
      System.out.println(+numero+"*"+contador +"=" +resultado);
    }
  }
}
