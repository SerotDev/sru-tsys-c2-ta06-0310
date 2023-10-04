package PT12;

import java.util.Iterator;

import javax.swing.JOptionPane;

public class AcabadosEnDigitoElegido {

	public static void main(String[] args) {
		//declaramos constantes y variables de datos
		final int rango_min = 1;
		final int rango_max = 300;
		int dimension_array, digito;
		
		//Pedimos dimension del array a generar
		String datos_keyboard = JOptionPane.showInputDialog("Introduce la dimension del array a generar.");
		while (!stringEsNumeroEnteroPositivo(datos_keyboard)) {
			datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros o negativos, introduce la dimension del array a generar.");
		}
		dimension_array = Integer.parseInt(datos_keyboard); //guardamos tamaño de array
		
		//creamos array y llenamos de datos aleatorios
		int array[] = new int[dimension_array];
		rellenarArrayAleatorios(array, rango_min, rango_max);
		
		//Pedimos ultimo dígito a buscar
		datos_keyboard = JOptionPane.showInputDialog("Introduce dígito para buscar los elementos cuyo último número sea igual.");
		while (!stringEsNumeroEnteroPositivoDeUnaCifra(datos_keyboard)) {
			datos_keyboard = JOptionPane.showInputDialog("El dato introducido no es un número entero positivo de una cifra, dígito a buscar.");
		}
		digito = Integer.parseInt(datos_keyboard); //guardamos digito
		
		//si existe alguna coincidencia se crea y muestra un nuevo array con las coincidencias de ultimo dígito encontradas.
		if (cantidadCoincidenciasUltimoDigito(array, digito) != 0) {
			int array_coincidencias[] = crearArrayCoincidenciasUltimoDigito(array, digito);
			mostrarArray("Se han encontrado " + array_coincidencias.length + " numeros acabados en " + digito, array_coincidencias);
		} 
		//si no existe coincidencia se muestra mensaje de que no existen .
		else {
			JOptionPane.showMessageDialog(null, "Lo sentimos, no se encuentra ningún elemento en lista que acabe en " + digito + ".");
		}
		
	}
	
	//muestra los elementos de un array
	public static void mostrarArray(String nombre_array, int array[]){
		String datos_array = "";
		for (int i = 0; i < array.length; i++) {
			datos_array += array[i] + " ";
			//agregamos salto de linea cada 50 iteraciones
			if ((i+1) % 50 == 0) {
				datos_array += "\n";
			}
		}
		JOptionPane.showMessageDialog(null, nombre_array + ":\n" + datos_array);
	}
	
	//devuelve el numero de coincidencias de ultimo digito
	public static int[] crearArrayCoincidenciasUltimoDigito(int array[], int digito){
		int array_coincidencias[] = new int[cantidadCoincidenciasUltimoDigito(array, digito)];
		int coincidencias = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i]%10 == digito) {
				array_coincidencias[coincidencias] = array[i];
				coincidencias++;
			}
		}
		return array_coincidencias;
	}
	
	//devuelve el numero de coincidencias de ultimo digito
	public static int cantidadCoincidenciasUltimoDigito(int array[], int digito){
		int coincidencias = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i]%10 == digito) {
				coincidencias++;
			}
		}
		return coincidencias;
	}
	
	//rellena un array con datos aleatorios
	public static int[] rellenarArrayAleatorios(int array[], int rango_min, int rango_max){
		for (int i = 0; i < array.length; i++) {
			array[i] = generarAleatorio(rango_min, rango_max);
		}
		return array;
	}
	
	//genera un numero aleatorio entre un rango de 2 numeros
	public static int generarAleatorio(int rango_min, int rango_max) {
		double random = Math.random() * (rango_max - (rango_min - 1)) + rango_min; //generamos numero con rangos y quitamos los decimales
		return (int)random;
	}
	
	//valida si string es numero entero positivo de una cifra
	public static boolean stringEsNumeroEnteroPositivoDeUnaCifra(String datos_keyboard) {
		//variable para comprobar si es dato numérico de una cifra o no
		boolean es_numero_positivo_de_una_cifra;
		//comprueba si el dato es positivo y numérico entero de una cifra o no
		try {
			int numero = Integer.parseInt(datos_keyboard);
			es_numero_positivo_de_una_cifra = true;
			if (numero < 0 || numero > 9) {
				es_numero_positivo_de_una_cifra = false;
			}
		} catch (Exception e) {
			es_numero_positivo_de_una_cifra = false;
		}	
		return es_numero_positivo_de_una_cifra;
	}
		
	//valida si string es numero entero positivo
	public static boolean stringEsNumeroEnteroPositivo(String datos_keyboard) {
		//variable para comprobar si es dato numérico o no
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
