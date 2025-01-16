package T4Programacion;

import java.io.IOException;
import java.util.Scanner;

public class Recursividad {

    static Scanner ent = new Scanner(System.in);
    static char[] palabra=null;

    public static void main(String[] args) {

        menu();

    }

    public static void borrar() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

    }

    public static void menu(){

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
                String a = ent.next().toUpperCase();
                if (a.equals("P")){
                    System.out.println("Introduce tu palabra: ");
                    palabra = ent.next().toCharArray();
                    int largo = palabra.length;
                    tres2(largo-1);

                } else if (a.equals("N")){
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
                System.out.println("\nHas elegido Binario");
                System.out.println("Introduce tu número:  ");
                long bin = ent.nextInt();

                if (cuatro(bin)){
                    System.out.println("Tu número es binario");
                } else {
                    System.out.println("Tu número no es binario");
                }
                elec2();
                break;
            case 5:
                System.out.println("\nHas elegido A binario");
                System.out.println("Introduce tu número: ");
                int abin = ent.nextInt();
                System.out.println(cinco(abin));
                elec2();
                break;
            case 6:
                System.out.println("\nHas elegido Orden alfabético");
                System.out.println("Introduce tu palabra: ");
                palabra = ent.next().toCharArray();
                if (seis(0)){
                    System.out.println("Tu palabra está ordenada");
                } else {
                    System.out.println("Tu palabra no estä ordenada");
                }
                elec2();
                break;
            case 7:
                System.out.println("\nHas elegido Mostrar suma");
                System.out.println("Introduce tu número: ");
                int num10 = ent.nextInt();
                if (num10<0){
                    System.out.println("Introduce un número positivo porfa");
                } else {
                    int hola = siete(num10);
                    for (int i = 1; i <= num10; i++) {
                        System.out.print(i);
                        if (i==num10) {
                            System.out.print(" = ");
                        } else {
                            System.out.print(" + ");
                        }
                    }
                    System.out.println(hola);
                }
                elec2();
                break;
            default:
                System.out.println("Error");
                elec2();
                break;
        }

    }

    public static void elec2(){

        System.out.println("\nElige una opción:");
        System.out.println("    [M] - Volver al menú principal");
        System.out.println("    [X] - Salir");

        String s = ent.next();

        switch (s.toUpperCase()){
            case "M":
                try {
                    borrar();
                    menu();
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "X":
                System.exit(0);
                break;
            default:
                System.out.println("Error");
                break;
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

        if (posi==0){
            System.out.print(palabra[posi]);
        }else{
            System.out.print(palabra[posi]);
            tres2(posi-1);
        }

    }

    public static boolean cuatro(long num){

        if (num==0 || num== 1){
            return true;
        } else if (num>9) {
            if (num%10==0 || num%10==1){
                return cuatro(num/10);
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public static String cinco(int num){

        if (num==0 || num ==1){
            return Integer.toString(num);
        } else {
            return cinco(num/2)+num%2;
        }

    }

    public static boolean seis(int posi){

        if (posi<palabra.length-1) {
            if (palabra[posi]<=palabra[posi+1]){
                return seis(posi+1);
            } else {
                return false;
            }
        }
        return true;

    }

    public static int siete(int num){

        if (num > 1){
            return num + siete(num-1);
        } else {
            return num;
        }
    }
}
