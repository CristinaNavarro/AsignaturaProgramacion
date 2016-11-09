import java.util.Scanner;
public class i1i26Cuadro {
  public static void main (String[] args) {
    Scanner teclado = new Scanner(System.in);
    int longitud;
    
    System.out.println("Introduzca la longitud del cuadro: ");
    longitud = teclado.nextInt();
    
    for (int j=1;j<=longitud;j++) {
      for (int i=1;i<=longitud;i++) {
        if (j==1 || j==longitud) {
        System.out.print("*");
        }else if (i==1 || i==longitud){
          System.out.print("*");
        }else{
          System.out.print(" ");
        }
      }
      System.out.print("\n");
    } 
  }
}
