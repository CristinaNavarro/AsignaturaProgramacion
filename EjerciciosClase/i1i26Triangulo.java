import java.util.Scanner;
public class i1i26Triangulo {
  public static void main (String[] args) {
    Scanner teclado = new Scanner(System.in);
    int numeroAst=0;
    int numeroTotal=0;
    
    System.out.println("Introduzca la longitud: ");
    numeroTotal = teclado.nextInt();
    
    for (int i=1;i<=numeroTotal;i++){
      for (int j=0;j<=numeroAst;j++){
        System.out.print("*");
      }
      numeroAst++;
      System.out.print("\n");
    }
  }
}
