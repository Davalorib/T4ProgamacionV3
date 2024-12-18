package T4Programacion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BingoAzaharaTest {

    @BeforeEach
    void configurarEscenario() {
        // Restaurar entrada y salida estándar antes de cada prueba
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void numeroConFormatoIncorrecto() {
        // Simulamos la entrada de un carácter no válido
        String entradaSimulada = "aaa\n";
        System.setIn(new ByteArrayInputStream(entradaSimulada.getBytes()));

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        BingoAzahara.ent = new Scanner(System.in); // Actualizamos el Scanner
        int resultado = BingoAzahara.numero();

        // Verificamos el resultado esperado
        assertEquals(0, resultado); // Debe devolver 0 para entrada no válida
        assertTrue(salida.toString().contains("ERROR")); // Verificamos mensaje de error
    }


    @Test
    void comprobarRangos() {
        assertTrue(BingoAzahara.comprobar(1)); // Validar límite inferior válido
        assertTrue(BingoAzahara.comprobar(50000)); // Validar límite superior válido
        assertTrue(!BingoAzahara.comprobar(0)); // Validar valor fuera del rango inferior
        assertTrue(!BingoAzahara.comprobar(50001)); // Validar valor fuera del rango superior
    }

    @Test
    void validarCartones() {
        // Simulamos la entrada necesaria para 3 cartones
        String entradaSimulada = """
        Juan 1 2 3
        Maria 4 5 6
        Pedro 7 8 9
        """;
        System.setIn(new ByteArrayInputStream(entradaSimulada.getBytes()));

        BingoAzahara.ent = new Scanner(System.in); // Actualizamos el Scanner
        String[][] resultado = BingoAzahara.carton(3); // Llamamos con 3 cartones

        // Verificamos los valores de los cartones
        assertEquals("Juan", resultado[0][0]); // Nombre del primer cartón
        assertEquals("Maria", resultado[1][0]); // Nombre del segundo cartón
        assertEquals("Pedro", resultado[2][0]); // Nombre del tercer cartón
        assertEquals("3", resultado[0][3]); // Último número del primer cartón
    }


    @Test
    void validarBolas() {
        String entradaSimulada = "10 20 30";
        System.setIn(new ByteArrayInputStream(entradaSimulada.getBytes()));

        BingoAzahara.ent = new Scanner(System.in);
        int[] resultado = BingoAzahara.bolas(3);

        assertArrayEquals(new int[]{10, 20, 30}, resultado); // Verificar bolas generadas
    }

    @Test
    void validarGanadores() {
        String[][] matriz = {
                {"Juan", "1", "2", "3"},
                {"Maria", "4", "5", "6"},
                {"Pedro", "7", "8", "9"}
        };
        int[] bolas = {1, 2, 3, 4, 5, 6};

        String[] resultado = BingoAzahara.ganadores(matriz, bolas, 3);

        assertEquals("Juan", resultado[0]); // Verificar primer ganador
        assertEquals("Maria", resultado[1]); // Verificar segundo ganador
        assertEquals(2, resultado.length); // Verificar que solo haya dos ganadores
    }

    @Test
    void ordenarGanadores() {
        String[] ganadores = {"Pedro", "Juan", "Maria"};
        String[] esperado = {"Juan", "Maria", "Pedro"};

        BingoAzahara.ordenar(ganadores);

        assertEquals(esperado[0], ganadores[0]); // Verificar primer nombre ordenado
        assertEquals(esperado[1], ganadores[1]); // Verificar segundo nombre ordenado
        assertEquals(esperado[2], ganadores[2]); // Verificar tercer nombre ordenado
    }
}
