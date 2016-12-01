import java.util.Scanner;

public class ConversorMonedas{
  public static void main (String [] args){
    Scanner teclado = new Scanner(System.in);
    
    double cantidadeuro;
    double cantidadpeseta;
    
    System.out.println("Introduce la cantidad en euros");
    cantidadeuro = teclado.nextDouble();
    
    cantidadpeseta = 166.67*cantidadeuro;
    
    System.out.print("La cantidad en pesetas es " +cantidadpeseta);
  }
}
