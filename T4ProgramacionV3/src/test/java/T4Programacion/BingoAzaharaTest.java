package T4Programacion;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
class BingoAzaharaTest {

    @Test
    void numero() {
        assertAll(() -> assertEquals(1, 1),
                () -> assertEquals(0,  0),
                () -> assertEquals(125,  125));
    }

    @Test
    void comprobar() {
        assertAll(() -> assertTrue(BingoAzahara.comprobar(1)),
                () -> assertFalse(BingoAzahara.comprobar(0)),
                () -> assertTrue(BingoAzahara.comprobar(50000)),
                () -> assertFalse(BingoAzahara.comprobar(50001)));
    }

    @Test
    void carton() {
        String entrada = "mauro 1 2 3 4 0\njose 11 22 33 44 55 0\n";
        System.setIn(new ByteArrayInputStream(entrada.getBytes()));

        BingoAzahara.ent = new Scanner(System.in);

        String[][] resul = BingoAzahara.carton(2);

        assertEquals(2, resul.length);

        assertArrayEquals(new String[]{"mauro", "1", "2", "3", "4", "0"}, resul[0]);
        assertArrayEquals(new String[]{"jose", "11", "22", "33", "44", "55", "0"}, resul[1]);
    }

    @Test
    void bolas() {

        String entrada = "1 2 3 4 0";
        System.setIn(new ByteArrayInputStream(entrada.getBytes()));
        BingoAzahara.ent = new Scanner(System.in);
        int[] resul = BingoAzahara.bolas(5);

        assertArrayEquals(new int[]{1, 2, 3, 4, 0}, resul);

        String entrada2 = "1 2 3\n";
        System.setIn(new ByteArrayInputStream(entrada2.getBytes()));
        BingoAzahara.ent = new Scanner(System.in);

        Exception er = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            BingoAzahara.bolas(5);
        });

        String entrada3 = "a b c d e\n";
        System.setIn(new ByteArrayInputStream(entrada3.getBytes()));
        BingoAzahara.ent = new Scanner(System.in);

        Exception er2 = assertThrows(NumberFormatException.class, () -> {
            BingoAzahara.bolas(5);
        });
    }

    @Test
    void ganadores() {

        String[][] matriz1 = {
                {"mauro", "1", "2", "3", "0"},
                {"jose", "4", "5", "6", "0"}
        };
        int[] bolas1 = {1, 2, 3, 4, 5, 6};
        String[] resultado1 = BingoAzahara.ganadores(matriz1, bolas1, 2);
        assertArrayEquals(new String[]{"mauro", "jose"}, resultado1);

        String[][] matriz2 = {
                {"mauro", "1", "2", "3", "0"},
                {"jose", "11", "22", "33", "0"}
        };
        int[] bolas2 = {1, 2, 3};
        String[] resultado2 = BingoAzahara.ganadores(matriz2, bolas2, 2);
        assertArrayEquals(new String[]{"mauro"}, resultado2);

        String[][] matriz3 = {
                {"mauro", "1", "2", "3", "0"},
                {"jose", "4", "8", "6", "0"}
        };
        int[] bolas3 = {1, 2, 3, 4, 5, 6};
        String[] resultado3 = BingoAzahara.ganadores(matriz3, bolas3, 2);
        assertArrayEquals(new String[]{"mauro"}, resultado3);

        String[][] matriz4 = {
                {"mauro", "1", "a", "3", "0"},
                {"jose", "1", "5", "6", "0"}
        };
        int[] bolas4 = {1, 2, 3, 4, 5, 6};
        String[] resultado4 = BingoAzahara.ganadores(matriz4, bolas4, 2);
        assertArrayEquals(new String[]{}, resultado4);
    }
}