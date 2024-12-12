package T4Programacion;

import java.util.Scanner;

public class Bateria_3 {

    public static void principal(){

        String mayus = metodo1();
        System.out.println("Tu palabra en mayúsculas: "+ mayus);
        System.out.println("Tu palabra tiene "+ metodo2(mayus) +" vocales");
    }

    public static String metodo1(){

        Scanner ent = new Scanner(System.in);
        System.out.println("Dame tu cadena a convertir a MAYÚSCULAS");

        return ent.next().toUpperCase();
    }

    public static int metodo2(String mayus){

        String[] mayus2;
        int cont = 0;

        mayus2 = mayus.split("");

        for (int i = 0; i < mayus2.length; i++) {
            if (mayus2[i].equals("A") || mayus2[i].equals("E") || mayus2[i].equals("I") || mayus2[i].equals("O") || mayus2[i].equals("U")){
                cont++;
            }
        }
        return cont;
    }

}
