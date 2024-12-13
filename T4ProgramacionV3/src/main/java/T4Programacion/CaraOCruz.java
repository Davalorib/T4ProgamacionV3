package T4Programacion;

import java.util.Random;
import java.util.Scanner;

public class CaraOCruz {

    public static void main(String[] args) {

        principal();
    }

    public static void principal(){

        Scanner ent = new Scanner(System.in);

        System.out.println("cara o cruz tt");
        String elec = ent.next();

        //metodo para devolver el resultado del sorteo
        String resultado = sorteo();
        comprobarElec(elec, resultado);
    }

    public static void comprobarElec(String elec, String resultado){

        System.out.println("Ha salido "+ resultado);

        if (resultado.equals(elec)){
            System.out.println("Que suerte tienes payaso");
        } else {
            System.out.println("Parguela");
        }
    }

    public static String sorteo(){

        Random random = new Random();

        String[] opciones = {"cara","cruz"};

        String resultado = opciones[random.nextInt(2)];

        return resultado;
    }

}
