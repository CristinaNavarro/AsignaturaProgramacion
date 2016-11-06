import java.util.Scanner;

public class Operaciones {
  public static void main (String[] args){
    Scanner teclado = new Scanner(System.in);
    
    int numero1;
    int numero2;
    int suma;
    int resta;
    int multiplicacion;
    float division;
    
    System.out.println("Introduce primer número");
    numero1 = teclado.nextInt();
    System.out.println("Introduce segundo número");
    numero2 = teclado.nextInt();
    
    suma = numero1+numero2;
    resta = numero1-numero2;
    multiplicacion = numero1*numero2;
    division = numero1/(float)numero2;
    
    System.out.println("El resultado de la suma es " +suma);
    System.out.println("El resultado de la resta es " +resta);
    System.out.println("El resultado de la multiplicación es " +multiplicacion);
    System.out.print("El resultado de la división es " +division);
  }
}
