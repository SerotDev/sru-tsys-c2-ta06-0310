package PT4;

import java.util.Iterator;
import java.util.Scanner;

public class NumeroFactorial {

	public static void main(String[] args) {
		//declaramos entrada de teclado
		Scanner keyboard = new Scanner(System.in);
		
		//Pedimos cantidad de numeros aleatoreos a generar
		System.out.println("Introduce número entero positivo para conocer su factorial.");
		String datos_keyboard = keyboard.nextLine();
		while (!stringEsNumeroEnteroPositivo(datos_keyboard)) {
			System.out.println("Datos no numéricos enteros positivos, introduce un número para conocer su factorial.");
			datos_keyboard = keyboard.nextLine();
		}
		int numero = Integer.parseInt(datos_keyboard);
		
		//calculamos y guardamos factorial del numero
		int factorial = calcularFactorial(numero);
		
		//mostramos factorial
		System.out.print(numero);
		for (int i = numero-1; i > 0; i--) {
			System.out.print("*" + i);
			if (i == 1) {
				System.out.print("=" + factorial);
			}
		}
	
	}
	
	
	//calcula el factorial de un numero dado
	public static int calcularFactorial(int numero) {
		int factorial = numero;
		for (int i = numero - 1; i > 0; i--) {
			factorial *= i;
		}
		return factorial;
	}
	
	//valida si string es numero entero positivo
	public static boolean stringEsNumeroEnteroPositivo(String datos_keyboard) {
		//variable para comprovar si es dato numérico o no
		boolean es_numero_positivo;
		
		//comprueba si el dato es positivo y numérico entero o no
		try {
			int numero = Integer.parseInt(datos_keyboard);
			es_numero_positivo = true;
			if (numero < 0) {
				es_numero_positivo = false;
			}
		} catch (Exception e) {
			es_numero_positivo = false;
		}
		
		return es_numero_positivo;
	}

}
