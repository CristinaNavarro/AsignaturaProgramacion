import java.util.Scanner;

public class CajaFuerte {
  public static void main (String[] args){
    Scanner teclado = new Scanner(System.in);
    int numerocuatrocifras=0000;
    
    for(int contador=0;contador<4;contador++){
      System.out.println("Introduzca un número de cuatro cifras");
      numerocuatrocifras = teclado.nextInt();
      if (numerocuatrocifras!=1337){
        System.out.println("Lo siento, esa no es la combinación");
      }else{
        System.out.print("La caja fuerte se ha abierto satisfactoriamente");
        break;
      }
    }
  }
}
