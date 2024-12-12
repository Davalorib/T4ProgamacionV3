package T4Programacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BingoAzahara {

    static Scanner ent;

    public static void main(String[] args) {

        ent = new Scanner(System.in);

        int numCasos = ent.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }

    public static void casoDePrueba() {

        int n = numero();
        if (n < 1 || n > 50000) { //o matches("\\d{1,8}")
            System.err.println("Fuera de limites");
            System.exit(0);
        }
        carton(n);

    }

    public static int numero() {

        int n = 0;
        try {
            n = ent.nextInt();
        } catch (InputMismatchException er) {
            System.err.println("ERROR. Número no válido");
            System.exit(0); //o un return para volver a pedirlo
        }

        return n;
    }

    public static void carton(int n){

        String[] nombres = new String[n];
        int[][] cartones = new int[n][1000];
        int[] tamanosCarton = new int[n];

        // Leer datos de los jugadores
        for (int i = 0; i < n; i++) {
            String linea = ent.nextLine();
            String[] partes = linea.split(" ");
            nombres[i] = partes[0];

            // Guardar números del cartón
            int k = 0;
            for (int j = 1; j < partes.length - 1; j++) { // Ignorar el último "0"
                cartones[i][k++] = Integer.parseInt(partes[j]);
            }
            tamanosCarton[i] = k;
        }
        
    }

//     Scanner scanner = new Scanner(System.in);
//
//        while (scanner.hasNextInt()) {
//
//            String[] nombres = new String[n];
//            int[][] cartones = new int[n][1000]; // Máximo de 1000 números por cartón
//            int[] tamanosCarton = new int[n];
//
//            // Leer datos de los jugadores
//            for (int i = 0; i < n; i++) {
//                String linea = scanner.nextLine();
//                String[] partes = linea.split(" ");
//                nombres[i] = partes[0];
//
//                // Guardar números del cartón
//                int k = 0;
//                for (int j = 1; j < partes.length - 1; j++) { // Ignorar el último "0"
//                    cartones[i][k++] = Integer.parseInt(partes[j]);
//                }
//                tamanosCarton[i] = k;
//            }
//
//            // Leer números cantados
//            int m = scanner.nextInt(); // Número de bolas cantadas
//            scanner.nextLine(); // Consumir línea restante
//            String[] numerosCantadosStr = scanner.nextLine().split(" ");
//            int[] numerosCantados = new int[m];
//            for (int i = 0; i < m; i++) {
//                numerosCantados[i] = Integer.parseInt(numerosCantadosStr[i]);
//            }
//
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
