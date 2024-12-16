package T4Programacion;

import java.util.*;

public class Tumadre {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);

        while (true) {
            int n = ent.nextInt();

            if (n == 0) {
                break;
            }

            // Almacenar el cartón de cada jugador en un Map
            Map<String, Set<Integer>> jugadores = new HashMap<>();

            // Leer cada cartón
            for (int i = 0; i < n; i++) {
                String nombre = ent.next();  // Leer el nombre del jugador
                Set<Integer> numeros = new HashSet<>();

                int num;
                while ((num = ent.nextInt()) != 0) {
                    numeros.add(num);
                }

                jugadores.put(nombre, numeros);
            }

            int m = ent.nextInt();  // Cantidad de números que salen del bombo
            Set<Integer> bolas = new HashSet<>();

            for (int i = 0; i < m; i++) {
                bolas.add(ent.nextInt());
            }

            List<String> ganadores = new ArrayList<>();

            // Comprobar qué jugadores completaron su cartón
            for (String jugador : jugadores.keySet()) {
                Set<Integer> carton = jugadores.get(jugador);

                if (bolas.containsAll(carton)) {
                    ganadores.add(jugador);
                }
            }

            // Ordenar alfabéticamente
            Collections.sort(ganadores);

            // Imprimir los nombres de los jugadores ganadores
            for (int i = 0; i < ganadores.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(ganadores.get(i));
            }
            System.out.println();
        }
    }
}