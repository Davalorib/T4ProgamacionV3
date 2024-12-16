package T4Programacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BingoAzahara {

    static Scanner ent;

    public static void main(String[] args) {
        ent = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    }

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

    public static boolean comprobar(int n){

        if (n < 1 || n > 50000) {
            return false;
        } else {
            return true;
        }
    }

    public static String[][] carton(int n){

        String datos;
        String[][] matriz = new String[n][1000];

        for (int i = 0; i < n; i++) {
            datos = ent.nextLine();
            matriz[i] = datos.split(" ");
        }

        return matriz;
    }

    public static int[] bolas(int n1){

        int[] bolas = new int[n1];
        String[] miau = ent.nextLine().split(" ");

        for (int i = 0; i < n1; i++) {
            bolas[i] = Integer.parseInt(miau[i]);
        }

        return bolas;
    }

    public static String[] ganadores(String[][] matriz, int[] bolas, int n) {

        String[] genios = new String[n];
        int cont = 0;

        for (int i = 0; i < n; i++) {
            boolean bingo = true;
            String pibe = matriz[i][0];

            for (int j = 1; j < matriz[i].length; j++) {
                if (matriz[i][j].equals("0")) {
                    break;
                }

                int num = Integer.parseInt(matriz[i][j]);
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

    public static void ordenar(String[] pibes) {

        String aux;

        for (int i = 0; i < pibes.length; i++) {
            for (int j = 0; j < pibes.length-i-1; j++) {
                if (pibes[j].compareTo(pibes[j + 1]) > 0) {
                    aux = pibes[j];
                    pibes[j] = pibes[j + 1];
                    pibes[j + 1] = aux;
                }
            }
        }
    }

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

