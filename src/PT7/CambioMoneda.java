package PT7;

import java.util.Scanner;

public class CambioMoneda {

	public static void main(String[] args) {
		// declaramos teclado y variable de euros
		Scanner keyboard = new Scanner(System.in);
		
		//recogemos datos y comprobamos que se trata de un numero decimal positivo
		System.out.println("Introduce la cantidad de euros.");
		String datos_keyboard = keyboard.nextLine();
		while (!stringEsNumeroDecimalPositivo(datos_keyboard)) {
			System.out.println("Datos no numéricos enteros positivos, introduce un número.");
			datos_keyboard = keyboard.nextLine();
		}
		double euros = Double.parseDouble(datos_keyboard);
		
		//recogemos datos y comprobamos que se ha introducido correctamente el nombre de la moneda
		System.out.println("Escribe el nombre de la moneda a la que convertir. (Yenes, Libras, Dolares)");
		datos_keyboard = keyboard.nextLine();
		while (!esDivisa(datos_keyboard)) {
			System.out.println("Datos no válidos, introduce el nombre de la moneda a la que convertir. (Yenes, Libras, Dolares)");
			datos_keyboard = keyboard.nextLine();
		}
		
		//calculamos y mostramos
		cambioDeDivisa(euros, datos_keyboard);

	}
	
	//calcula y muestra dependiendo del tipo de moneda
	public static void cambioDeDivisa(double euros, String divisa) {
		//declaramos array de constantes y variables
		final float tipo_divisa[] = {(float) 0.86, (float) 1.28611, (float) 129.852}; // paso innecesario puesto como muestra de guardado de datos en array ya que no lo he puesto en ningun otro ejercicio
		final float libras = tipo_divisa[0];
		final float dolares = tipo_divisa[1];
		final float yenes = tipo_divisa[2];
		double moneda_cambiada;
		
		//calculamos segun divisa
		switch (divisa.toUpperCase()) {
		case "LIBRAS":
			moneda_cambiada = euros * libras;
			System.out.println(String.format("%.2f", euros) + "€ equivale a " + String.format("%.2f", moneda_cambiada) + "£.");
			break;
		case "DOLARES":
			moneda_cambiada = euros * dolares;
			System.out.println(String.format("%.2f", euros) + "€ equivale a " + String.format("%.2f", moneda_cambiada) + "$.");
			break;
		case "DÓLARES":
			moneda_cambiada = euros * dolares;
			System.out.println(String.format("%.2f", euros) + "€ equivale a " + String.format("%.2f", moneda_cambiada) + "$.");
			break;
		case "YENES":
			moneda_cambiada = euros * yenes;
			System.out.println(String.format("%.2f", euros) + "€ equivale a " + String.format("%.2f", moneda_cambiada) + "¥.");
			break;
		default:
			System.out.println("ERROR: Nombre de divisa incorrecto");
			break;
		}
	}
	
	//comprueba si es una divisa existente en el sistema o no
	public static boolean esDivisa(String datos_keyboard) {
		//variable para comprobar si es dato numérico o no
		boolean es_divisa;
		
		switch (datos_keyboard.toUpperCase()) {
		case "LIBRAS":
			es_divisa = true;
			break;
		case "DOLARES":
			es_divisa = true;
			break;
		case "DÓLARES":
			es_divisa = true;
			break;
		case "YENES":
			es_divisa = true;
			break;
		default:
			es_divisa = false;
			break;
		}
		
		return es_divisa;
		
	}
	
	//valida si string es numero decimal positivo
	public static boolean stringEsNumeroDecimalPositivo(String datos_keyboard) {
		//variable para comprovar si es dato numérico o no
		boolean es_numero_positivo;
		
		//comprueba si el dato es positivo y numérico o no
		try {
			double numero = Double.parseDouble(datos_keyboard);
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
