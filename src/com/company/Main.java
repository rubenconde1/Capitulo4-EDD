package com.company;
import java.util.Scanner;

/**
 * Clase que genera todos los numeros primos de 1 hasta un numero maximo especificado por el usuario.
 * @author Ruben Conde
 * @version 1.3
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Creamos un vector e indicamos el numero para la Criba de Erastotenes.
         */
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes: ");
        int numeroCriba = lector.nextInt();
        int[] vector = new int[numeroCriba];
        System.out.println("\nVector inicial hasta: " + numeroCriba);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
        vector = generarPrimos(numeroCriba);
        System.out.println("\nVector de primos hasta: " + numeroCriba);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }
    // Generar numeros primos de 1 a max
    public static int[] generarPrimos (int max)
    {
        /**
         * Metodo para generar numeros primos.
         * @return Devuelve un vector de numeros primos en caso de de ser True, o lo devuelve vacio si es False.
         */
        int i, j;
        if (max >= 2) {
            // Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
            // Inicializar el array
            for (i = 0; i < dim; i++)
                esPrimo[i] = true;
            // Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
            // Criba
            for (i = 2; i < Math.sqrt(dim)+1; i++) {
                if (esPrimo[i]) {
                    // Eliminar los múltiplos de i
                    for (j = 2 * i; j < dim; j += i)
                        esPrimo[j] = false;
                }
            }
            // ¿Cuántos primos hay?
            int contador = 0;
            for (i = 0; i < dim; i++) {
                if (esPrimo[i])
                    contador++;
            }
            // Rellenar el vector de números primos
            int[] primos = new int[contador];
            for (i = 0, j = 0; i < dim; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
            return primos;
        } else { // max < 2
            return new int[0];
            // Vector vacío
        }
    }
}