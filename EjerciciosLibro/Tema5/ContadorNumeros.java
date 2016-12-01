import java.util.Scanner;

public class ContadorNumeros {
  public static void main (String[] args) {
    Scanner teclado = new Scanner(System.in);
    int numero=1;
    int contador=0;
    int resto=1;

    System.out.println("Introduzca un número");
    numero = teclado.nextInt();    
    while (resto!=0) {
      resto = numero%10;
      numero = numero/10;
      contador++;
    }
    contador = contador-1;
    System.out.print("Has introducido un total de " +contador +"números.");  
  }
}
