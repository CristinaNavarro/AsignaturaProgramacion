package Programacion;
/**
 * Define tres arrays de 20 números enteros cada una, con nombres numero ,
cuadrado y cubo . Carga el array numero con valores aleatorios entre 0 y 100. En el
array cuadrado se deben almacenar los cuadrados de los valores que hay en el
array numero . En el array cubo se deben almacenar los cubos de los valores que
hay en numero . A continuación, muestra el contenido de los tres arrays dispuesto
en tres columnas.
 * @author Cristina Navarro Soto
 */
public class CuadradoCubo {
  public static void main(String[] args) {
  int enteros[] = new int[20];
  int cuadrado[] = new int[20];
  int cubo[] = new int[20];
  for(int i=0;i<enteros.length;i++){
    cargar(enteros,i);
  }
  elevarCuadrado(cuadrado, enteros);
  elevarCubo(cubo, enteros);
  mostrar(enteros,cuadrado,cubo);
  }

  private static int cargar(int[] enteros, int i) {
      return enteros[i] = (int) (Math.random()*101);
  }

  private static void elevarCuadrado(int[] cuadrado, int[] enteros) {
    for(int i=0;i<enteros.length;i++){
      cuadrado[i]=enteros[i]*enteros[i];
    }
  }

  private static void elevarCubo(int[] cubo, int[] enteros) {
    for(int i=0;i<enteros.length;i++){
      cubo[i]=enteros[i]*enteros[i]*enteros[i];
    }
  }

  private static void mostrar(int[] enteros, int[] cuadrado, int[] cubo) {
    for (int i=0;i<enteros.length;i++){
      System.out.printf("%10d %10d %10d", enteros[i], cuadrado[i], cubo[i]);
      System.out.println("");
  }
   
  }
}
