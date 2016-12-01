import java.util.Scanner;
public class i1i26Colina {
  public static void main (String[] args) {
    Scanner teclado = new Scanner(System.in);
    int numeroAst=1;
    int numeroTotal;
    System.out.println("Introduzca la altura: ");
    numeroTotal = teclado.nextInt();
    //////////////////////////////////////////////
    int numEspacios=numeroTotal-1;
    for (int i=1;i<=numeroTotal;i++){
      for (int z=0; z<=numEspacios; z++) {
        System.out.print(" ");
      }
      for (int j=0;j<numeroAst;j++){
        System.out.print("*");
      }
    //////////////////////////////////////////
      numeroAst += 2;
      numEspacios--;
      System.out.print("\n");
    }
  }
}




