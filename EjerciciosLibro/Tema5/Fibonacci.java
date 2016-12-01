import java.util.Scanner;

public class Fibonacci {
  public static void main (String[] args){
    Scanner teclado = new Scanner(System.in);
    
    long numero;
    long numero1=0;
    long numero2=0;
    long numerointroducido;
    
    System.out.println("Introduzca un número ");
    numerointroducido = teclado.nextInt();
    for(long repeticion=0;repeticion<numerointroducido;repeticion++){
      if (numero2==0) {
        System.out.print(numero2 +" ");
        numero2++;
      }else{
      numero = numero1 + numero2;
      numero1 = numero2;
      numero2 = numero;
      System.out.print(numero +" ");
      }
    }
  }
}
