package T4Programacion;

import java.util.Scanner;

public class Bateria_1 {

    public static void principal(){

        System.out.println("Dame un número entero: ");
        int num = numero();
        System.out.println(calculo(num));

    }

    public static int numero(){

        Scanner ent = new Scanner(System.in);
        return ent.nextInt();
    }

    public static int calculo(int num){

        int a = 1;
        for (int i = 0; i < 3; i++) {
            a*=num;
        }

        return a;
    }

}
