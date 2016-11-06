import java.util.Scanner;
public class Multiplicacion{
  public static void main (String[] args){
    Scanner teclado = new Scanner(System.in);
    int numero1;
    int numero2;
    int multiplicacion;
    
    System.out.println("Introduce número 1");
    numero1 = teclado.nextInt();
    numero2 = teclado.nextInt();
    multiplicacion = numero1*numero2;
    
    System.out.print("El resultado es " +multiplicacion);
  }
}
