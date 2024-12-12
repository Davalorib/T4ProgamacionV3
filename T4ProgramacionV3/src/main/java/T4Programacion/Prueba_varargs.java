package T4Programacion;

public class Prueba_varargs {

    public static void principal(){

        String[] nombres = prueba("Pepe", "Miguel", "David", "Ismael", "Cesar", "Denys");
//        System.out.println(nombres[i]);

    }

    public static String[] prueba(String...nombres){

        for (int i = 0; i < nombres.length; i++) {

            System.out.println("Alumno "+ (i+1) +": "+ nombres[i]);

        }

        return nombres;
    }

}
