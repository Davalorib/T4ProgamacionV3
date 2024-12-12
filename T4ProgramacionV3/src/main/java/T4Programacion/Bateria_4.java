package T4Programacion;

import java.util.Scanner;

public class Bateria_4 {

    static java.util.Scanner in;

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {

        }
    }

    public static boolean casoDePrueba() {

        float numero = in.nextFloat();

        if (numero==-1) {
            return false;
        } else {
            float[] semana = nums(numero);

            return true;
        }
    }

    /**
     * Se termina de introducir datos para que el programa funcione
     * @param numero - esto
     * @return - devolvemos un vector de 6
     */

    public static float[] nums(float numero){

        float[] nums2 = new float[6];

        nums2[0] = numero;

        for (int i = 1; i < nums2.length; i++) {
            nums2[i] = in.nextFloat();
        }

        return nums2;
    }

    public static String max(float[] semana){

        float max = 0;

        for (float v : semana) {
            if (v > max) {
                max = v;
            }
        }

        return "";
    }

}
