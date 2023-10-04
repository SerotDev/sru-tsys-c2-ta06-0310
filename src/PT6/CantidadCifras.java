package PT6;

import java.util.Scanner;

public class CantidadCifras {

	public static void main(String[] args) {
		// declaramos teclado
		Scanner keyboard = new Scanner(System.in);
		
		//recogemos datos y comprovamos que se trata de un numero entero positivo
		System.out.println("Introduce número entero positivo.");
		String numero = keyboard.nextLine();
		while (!stringEsNumeroEnteroPositivo(numero)) {
			System.out.println("Datos no numéricos enteros positivos, introduce un número.");
			numero = keyboard.nextLine();
		}
		
		//mostramos binario
		System.out.println("El numero " + numero + " tiene " + numero.length() + " carácteres.");
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
