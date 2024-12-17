package T4Programacion;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BingoAzaharaTest {

    @Test
    void numero() {

        //simulamos que el usuario ingresa caracteres
        String entrada = "a";
        System.setIn(new ByteArrayInputStream(entrada.getBytes()));

        //creamos un ByteArrayOutputStream para guardar la salida por consola
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        BingoAzahara prueba = new BingoAzahara();

        //llamamos al metodo que procesa la entrada
        int resultado = prueba.numero();

        //verificamos que el valor que devuelve es el esperado (-1)
        assertEquals(0, resultado);

    }

    @Test
    void comprobar() {
    }

    @Test
    void carton() {
    }

    @Test
    void bolas() {
    }

    @Test
    void ganadores() {
    }
}