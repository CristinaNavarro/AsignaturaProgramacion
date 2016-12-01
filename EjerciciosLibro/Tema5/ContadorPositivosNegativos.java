import java.util.Scanner;

public class ContadorPositivosNegativos {
  public static void main (String[] args) {
    Scanner teclado = new Scanner(System.in);
    
    int numero;
    int contadorpositivos=0;
    int contadornegativos=0;
    
    for (int contador=0;contador<10;contador++) {
      System.out.print("Introduzca un número");
      numero = teclado.nextInt();
      if (numero>=0){
        contadorpositivos++;
      }else{
        contadornegativos++;
      }
    } 
    System.out.print("Se han introducido " +contadorpositivos +" números positivos y " +contadornegativos +" números negativos.");
  }
}
