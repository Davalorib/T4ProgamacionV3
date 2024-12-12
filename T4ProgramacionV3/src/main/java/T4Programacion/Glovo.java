package T4Programacion;

import java.util.Scanner;

public class Glovo {

    public static void principal(){

        menu();
        int elec = elec();
        postelec(elec);

    }

    public static void menu(){

        System.err.println("Bienvenido a GLOVO-app");
        System.out.println("¿Qué quieres comprar?");
        System.out.println("        1. Comida");
        System.out.println("        2. Bebida");
        System.out.println("        0. Salir");

    }


    public static int elec(){

        Scanner ent = new Scanner(System.in);

        return ent.nextInt();
    }

    public static void postelec(int elec){

        String pedido = "";
        switch (elec){
            case 0:
                System.err.println("Pues adiós");
                System.exit(0);
            case 1:
                System.err.println("Has elegido comida");
                pedido = comida();
                break;
            case 2:
                System.err.println("Has elegido bebida");
                pedido = bebida();
                break;
            default:
                System.err.println("No existe eso");
                System.exit(0);
        }

        System.out.println("Has pedido "+ pedido);
    }

    public static String comida(){

        Scanner ent = new Scanner(System.in);

        System.out.println("\n¿Qué vas a querer?");
        return ent.next();

    }


    public static String bebida(){

        System.out.println("Dame tu edad: ");
        int edad = elec();
        String eleccion = "";

        if (edad>=18){
            eleccion = comida();
        } else {
            System.err.println("No puedes comprar bebida.");
            System.exit(0);
        }

        return eleccion;

    }


}
