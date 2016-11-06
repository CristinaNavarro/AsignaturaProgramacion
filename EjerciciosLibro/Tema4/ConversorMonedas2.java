import java.util.Scanner;

public class ConversorMonedas2 {
  public static void main (String[] args){
    Scanner teclado = new Scanner(System.in);
    double cantidadeuro;
    double cantidadpeseta;
    
    System.out.println("Introduce la cantidad en pesetas");
    cantidadpeseta = teclado.nextDouble();
    cantidadeuro = cantidadpeseta/166.67;
    
    System.out.print("La cantidad en euros es " +cantidadeuro);
    
  }
}
