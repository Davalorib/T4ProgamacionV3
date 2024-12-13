package T4Programacion;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Base {

        public void ejercicio1() {
            //el scanner
            Scanner ent = new Scanner(System.in);
            Random random = new Random();
            //el random
            //las variables, vectores, matrices, y booleanos
            int bolas = random.nextInt(30) + 10;
            int contador1 = 0;
            int contador2 = 0;
            int contador3 = 0;
            int[] azar = new int[bolas];
            String datos1;
            String[] datos;
            int[] datosint = new int[3];
            int[][] matriz = new int[3][3];
            boolean formato;
            boolean repetir = true;
            System.out.println("\n*** BIENVENIDO AL BINGO DEL CASINO CANTÁBRICO ***");
            //la creacion de las bolas
            for (int i = 0; i < bolas; i++) {
                azar[i] = random.nextInt(90) + 1;
            }
            //
            //ordeno el vector de bolas random
            Arrays.sort(azar);
            //
            //un bucle que busca repetidos y los recalcula en caso de haber hasta que sean todos distintos
            while(repetir){
                repetir = false;
                for (int i = 0; i < azar.length; i++) {
                    if (i!=azar.length-1 && azar[i]==azar[i+1]){
                        azar[i] = random.nextInt(90)+1;
                        repetir = true;
                    }
                }
                Arrays.sort(azar);
            }
            //
            System.out.println(bolas +" bolas extraídas hasta ahora");
            System.out.println(Arrays.toString(azar));
            System.out.println("\n*** Introduce los datos de tu cartón ***");
            //for para ir pidiendo e introduciendo los vectores
            for (int i = 0; i < matriz.length; i++) {
                System.out.println("\nIntroduce los datos de tu " + (i + 1) + "ª fila en formato N-N-N: ");
                datos1 = ent.next();
                formato = datos1.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}"); //miramos si esta en este formato
                //si el formato no es el deseado
                if (!formato) {
                    System.err.println("Cerrando programa... Utiliza un formato válido");
                    return;
                }
                //
                datos = datos1.split("-"); //spliteamos guiones
                //un for para ir introduciendo el vector en la matriz
                for (int j = 0; j < matriz[i].length; j++) {
                    //pasamos todos a int
                    datosint[j] = Integer.parseInt(datos[j]);
                    //
                    // si hay alguno que no está en nuestro rango cerramos el programa
                    if (datosint[i] < 1 || datosint[i] > 90) {
                        System.err.println("> Tus valores tiene que estar entre 1 y 90 <");
                        return;
                    }
                    matriz[i][j] = datosint[j]; //igualamos la fila de la matriz al vector
                }
                //
            }
            //
            System.out.println("\nDatos del cartón introducido: ");
            //recorremos la matriz para mostrarla por pantalla
            for (int[] i : matriz) {
                for (int j : i) {
                    System.out.print(j + " ");
                }
                System.out.print("\n");
            }
            //
            //for que va recorriendo la matriz y va comprobando si los numeros de sus lineas estan en las bolas
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    //este for para ir recorriendo el vector azar
                    for (int k = 0; k < azar.length; k++) {
                        //para la primera fila
                        if (i==0 && matriz[i][j] == azar[k]){ //si está el numero
                            contador1++; //sumamos 1 a un contador
                        }
                        //para la segunda fila
                        if (i==1 && matriz[i][j] == azar[k]){ //si está el numero
                            contador2++; //sumamos 1 a un contador
                        }
                        //para la tercera fila
                        if (i==2 && matriz[i][j] == azar[k]){ //si está el numero
                            contador3++; //sumamos 1 a un contador
                        }
                    }
                }
            }
            System.out.println();
            System.out.println("PREMIOS:");
            //si la suma de los contadores es 9 significa que es bingo
            if (contador1+contador2+contador3 == 9){
                System.out.println("BINGOOO!!! ");
            } else { //si no es bingo
                if (contador1 == 3) { //si el primer contador es 3 es linea
                    System.out.println("Linea 1: CORRECTA!!");
                } else {
                    System.out.println("Linea 1: NO");
                }
                if (contador2 == 3) { //si el segundo contador es 3 es linea
                    System.out.println("Linea 2: CORRECTA!!");
                } else {
                    System.out.println("Linea 2: NO");
                }
                if (contador3 == 3) { //si el tercer contador es 3 es linea
                    System.out.println("Linea 3: CORRECTA!!");
                } else {
                    System.out.println("Linea 3: NO");
                }
            }
        }
}
