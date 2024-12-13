package T4Programacion;

import java.util.Arrays;
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

        if (n==0) {
            return false;
        }else {
            if(!comprobar(n)){
                System.exit(0);
            }
            String[][] matriz = carton(n);
            int n1 = numero();
            int[] bolas = bolas(n1);
            ganadores(matriz,bolas,n);
            return true;
        }
    }

    public static int numero() {

        int n = 0;
        try {
            n = ent.nextInt();
        } catch (InputMismatchException er) {
            System.err.println("ERROR. Número no válido");
            System.exit(0); //o un return para volver a pedirlo
        }

        ent.nextLine();
        return n;
    }

    public static boolean comprobar(int n){

        if (n < 1 || n > 50000) {
            System.err.println("Fuera de limites");
            return false;
        } else {
            return true;
        }
    }

    public static String[][] carton(int n){

        String datos;
        String[] carton;
        String[][] matriz = new String[n][1000];

        for (int i = 0; i < matriz.length; i++) {

            datos = ent.nextLine();
            carton = datos.split(" ");

            for (int j = 0; j < matriz[i].length; j++) {
                if (carton[j].equals("0")){
                    break;
                }
                matriz[i][j] = carton[j];
            }
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

    public static String ganadores(String[][] matriz, int[] bolas, int n){

        boolean bingo = true;
        int premio = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (!Arrays.asList(bolas).contains(matriz[i][j])) {
                    bingo = false;
                    break;
                }
            }
        }

        if(bingo){
            return "bingo";
        } else {
            return "no bingo";
        }

    }




//            // Buscar ganadores
//            String[] ganadores = new String[n];
//            int numGanadores = 0;
//
//            for (int i = 0; i < n; i++) {
//                boolean esGanador = true;
//                for (int j = 0; j < tamanosCarton[i]; j++) {
//                    boolean encontrado = false;
//                    for (int k = 0; k < m; k++) {
//                        if (cartones[i][j] == numerosCantados[k]) {
//                            encontrado = true;
//                            break;
//                        }
//                    }
//                    if (!encontrado) {
//                        esGanador = false;
//                        break;
//                    }
//                }
//                if (esGanador) {
//                    ganadores[numGanadores++] = nombres[i];
//                }
//            }
//
//            // Ordenar ganadores alfabéticamente
//            Arrays.sort(ganadores, 0, numGanadores);
//
//            // Mostrar ganadores
//            for (int i = 0; i < numGanadores; i++) {
//                if (i > 0) System.out.print(" ");
//                System.out.print(ganadores[i]);
//            }
//            System.out.println();
//        }
//
//        scanner.close();



}
