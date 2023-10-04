package PT5;

import java.util.Scanner;

public class DecimalABinario {

	public static void main(String[] args) {
		// declaramos teclado
		Scanner keyboard = new Scanner(System.in);
		
		//recogemos datos y comprobamos que se trata de un numero entero positivo
		System.out.println("Introduce numero para conocer su binario");
		String decimal = keyboard.nextLine();
		while (!stringEsNumeroEnteroPositivo(decimal)) {
			System.out.println("Datos no numéricos enteros positivos, introduce un número para conocer su binario.");
			decimal = keyboard.nextLine();
		}
		
		//mostramos binario
		System.out.println("El numero " + decimal + " en binario es " + decimalABinario(Integer.parseInt(decimal)) + ".");

	}
	
	//calculamos su numero en binario
	public static String decimalABinario(int numero) {
		String binario = "";
		while (numero > 0) {
			if (numero % 2 == 0) {
				binario = "0" + binario;
			} else {
				binario = "1" + binario;
			}
			numero = numero/2;
		}
		return binario;
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
