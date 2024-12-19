package T4Programacion;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase contiene los métodos necesarios para resolver el problema 729 del Concurso ProgramaMe
 * @author David Alonso
 * @version 1.0 16/12/2002
 * @see <a href = "https://aceptaelreto.com/problem/statement.php?id=729" /> El bingo de Azahara </a>
 */
public class BingoAzahara {

    static Scanner ent;

    /**
     * El main de la manera que les gusta a estos.
     * @param args  pues el vector que hace que el main sea el main.
     */
    public static void main(String[] args) {
        ent = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    }

    /**
     * Este método contiene el código del programa, va llamando a los demás métodos.
     * @return true/false - devuelve un booleano para que el main siga ejecutando el programa o termine.
     */
    public static boolean casoDePrueba() {

        int n = numero();

        if (n == 0) {
            return false;
        }else {
            if(!comprobar(n)){
                return false;
            }
            String[][] matriz = carton(n);
            int n1 = numero();
            int[] bolas = bolas(n1);
            String[] ganadores = ganadores(matriz,bolas,n);
            ordenar(ganadores);
            imprimir(ganadores);

            return true;
        }
    }

    /**
     * Este método es para saber cuántos cartones vamos a tener, si dicho número es 0 o un carácter no válido, el programa terminará.
     * Luego lo reutilizamos para las bolas.
     * @return num - devuelve un número introducido por teclado, si es un carácter no válido devuelve un 0.
     */
    public static int numero() {

        try {
            int num = ent.nextInt();
            ent.nextLine();
            return num;
        } catch (InputMismatchException er) {
            ent.nextLine();
            return 0;
        }

    }

    /**
     * Este método es para comprobar que estamos dentro del rango que nos dicta el enunciado.
     * @param n es una variable de tipo int que contiene el número de cartones que vamos a tener.
     * @return true/false - devuelve un booleano true/false dependiendo si se encuentra o no dentro de nuestro rango.
     */
    public static boolean comprobar(int n) {

        if (n < 1 || n > 50000) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Este método es para pedir y almacenar los nombres y números de los cartones del bingo.
     * @param n es una variable de tipo int que contiene el número de cartones que vamos a tener.
     * @return matriz - devuelve una matriz con los datos de los cartones introducidos por teclado.
     */
    public static String[][] carton(int n) {

        String datos;
        String[][] matriz = new String[n][1000];

        for (int i = 0; i < n; i++) {
            datos = ent.nextLine();
            matriz[i] = datos.split(" ");
        }

        return matriz;
    }

    /**
     * Este método es para pedir y almacenar las bolas del bingo.
     * @param n1 es una variable de tipo int que contiene el número de bolas que vamos a tener.
     * @return bolas - devuelve un vector con los números de las bolas que han salido.
     */
    public static int[] bolas(int n1) {

        int[] bolas = new int[n1];
        String[] miau = ent.nextLine().split(" ");

        for (int i = 0; i < n1; i++) {
            bolas[i] = Integer.parseInt(miau[i]);
        }

        return bolas;
    }

    /**
     * Este método es para comparar los cartones con las bolas y sacar los posibles ganadores del bingo.
     * @param matriz es una matriz de tipo String que contiene datos de los cartones.
     * @param bolas es un vector de tipo int que contiene los números de las bolas que han salido en el bingo.
     * @param n es una variable de tipo int que contiene el número de cartones que tenemos.
     * @return ganadores - devuelve un vector con los nombres de los ganadores del bingo.
     */
    public static String[] ganadores(String[][] matriz, int[] bolas, int n) {

        String[] genios = new String[n];
        int cont = 0;
        int num = 0;

        for (int i = 0; i < n; i++) {
            boolean bingo = true;
            String pibe = matriz[i][0];

            for (int j = 1; j < matriz[i].length; j++) {
                if (matriz[i][j].equals("0")) {
                    break;
                }

                try {
                    num = Integer.parseInt(matriz[i][j]);
                } catch (NumberFormatException er) {
                    System.exit(0);
                }

                boolean eureka = false;

                for (int bola : bolas) {
                    if (bola == num) {
                        eureka = true;
                        break;
                    }
                }

                if (!eureka) {
                    bingo = false;
                    break;
                }
            }

            if (bingo) {
                genios[cont] = pibe;
                cont++;
            }
        }

        String[] ganadores = new String[cont];
        for (int i = 0; i < cont; i++) {
            ganadores[i] = genios[i];
        }

        return ganadores;
    }

    /**
     * Este método es para ordenar los nombres de los ganadores alfabéticamente.
     * @param pibes es un vector de tipo String que contiene los nombres de los ganadores del bingo.
     */
    public static void ordenar(String[] pibes) {

        String aux;

        for (int i = 0; i < pibes.length; i++) {
            for (int j = 0; j < pibes.length-i-1; j++) {
                //el compareTo compara cadenas en orden alfabético
                //si el actual va antes que el siguiente da un valor negativo, si el actual va después da uno positivo, si es igual un 0
                if (pibes[j].compareTo(pibes[j + 1]) > 0) {
                    aux = pibes[j];
                    pibes[j] = pibes[j + 1];
                    pibes[j + 1] = aux;
                }
            }
        }
    }

    /**
     * Este método es para imprimir por pantalla los nombres de los ganadores ordenados.
     * @param ganadores es un vector de tipo String que contiene los nombres de los ganadores del bingo.
     */
    public static void imprimir(String[] ganadores) {

        for (int i = 0; i < ganadores.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(ganadores[i]);
        }
        System.out.println();
    }

}