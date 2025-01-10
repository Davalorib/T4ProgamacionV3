package T4Programacion;

import java.io.IOException;
import java.util.Scanner;

public class Recursividad {

    static Scanner ent = new Scanner(System.in);
    static String palabra;

    public static void main(String[] args) {

        menu();

    }

    public static void borrar() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void menu(){

        System.out.flush();
        System.out.println("*** Batería de ejercicios sobre recursividad ***");
        System.out.println("Selecciona a continuación el modo que quieras ejecutar...");
        System.out.println("    1 - Dígitos");
        System.out.println("    2 - Potencias");
        System.out.println("    3 - Del Revés");
        System.out.println("    4 - Binario");
        System.out.println("    5 - A binario");
        System.out.println("    6 - Orden alfabético");
        System.out.println("    7 - Mostrar suma");
        elec();

    }

    public static void elec(){

        int n = ent.nextInt();

        switch (n){
            case 1:
                System.out.println("\nHas elegido Dígitos");
                System.out.println("Introduce tu número: ");
                int num = num();
                if (num==0){
                    System.out.println("Tu número tiene 1 dígito");
                } else {
                    System.out.println("Tu número tiene "+uno(num)+" dígitos");
                }
                elec2();
                break;
            case 2:
                System.out.println("\nHas elegido Potencias");
                System.out.println("Introduce tu número base: ");
                int base = num();
                System.out.println("Introduce tu exponente: ");
                int exp = num();
                if (exp==0){
                    System.out.println("Tu número es 1");
                } else if (exp==1) {
                    System.out.println("Tu número es "+base);
                } else {
                    System.out.println(dos(base,exp));
                }
                elec2();
                break;
            case 3:
                System.out.println("\nHas elegido Del Revés");
                System.out.println("Introduce el modo: ");
                System.out.println("    P - palabra         N - Número");
                if (ent.next().equals("P")){
                    System.out.println("Introduce tu palabra: ");
                    palabra = ent.next();
                    if (palabra.length()==1){
                        System.out.println("Tu palanra del revés es "+palabra);
                    } else {
                        tres2(palabra.length());
                    }
                } else if (ent.next().equals("N")){
                    System.out.println("Introduce tu número: ");
                    int rev = num();
                    if (rev<10){
                        System.out.println("Tu número del revés es "+rev);
                    } else {
                        tres(rev);
                    }
                }
                elec2();
                break;
            case 4:
                cuatro();
            case 5:
                cinco();
            case 6:
                seis();
            case 7:
                siete();
            default:
                System.out.println("Error");
        }

    }

    public static void elec2(){

        System.out.println("\nElige una opción:");
        System.out.println("    [M] - Volver al menú principal");
        System.out.println("    [X] - Salir");

        String s = ent.next();

        switch (s.toUpperCase()){
            case "M":
                menu();
            case "X":
                System.exit(0);
            default:
                System.out.println("Error");
        }

    }

    public static int num(){
        return ent.nextInt();
    }

    public static int uno(int num){

        if (num<10){
            return 1;
        }

        return 1+ uno(num/10);
    }

    public static int dos(int base, int exp){

        if (exp<2){
            return base;
        }

        return base*(dos(base,--exp));
    }

    public static void tres(int rev){

        if (rev<10){
            System.out.print(rev);
        } else {
            System.out.print(rev%10);
            tres(rev/10);
        }

    }

    public static void tres2(int posi){

        if (posi<2){
            System.out.print(palabra.charAt(0));
        } else {
            System.out.print(palabra.charAt(posi-1));
        }

    }

    public static void cuatro(){



        elec2();

    }

    public static void cinco(){

        System.out.flush();
        System.out.println("Has elegido A binario");
        elec2();

    }

    public static void seis(){

        System.out.flush();
        System.out.println("Has elegido Orden alfabético");
        elec2();

    }

    public static void siete(){

        System.out.flush();
        System.out.println("Has elegido Mostrar suma");
        elec2();

    }


}
