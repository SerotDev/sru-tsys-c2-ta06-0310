package PT9;

import javax.swing.JOptionPane;

public class SumaArrayAleatorios {
	public static void main(String[] args) {
		//declaramos variables de datos
		int cantidad_aleatorios;
		
		//Pedimos cantidad de numeros aleatoreos a generar
		String datos_keyboard = JOptionPane.showInputDialog("Introduce cantidad de numeros aleatorios a generar.");
		while (!stringEsNumeroEnteroPositivo(datos_keyboard)) {
			datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros o negativos, introduce cantidad de numeros aleatorios a generar.");
		}
		cantidad_aleatorios = Integer.parseInt(datos_keyboard); //guardamos cantidad de aleatorios
		
		//generamos y rellenamos array con rango de aleatorios
		int grid_aleatorios[] = new int[cantidad_aleatorios];
		rellenarArrayAleatorios(grid_aleatorios, 0, 9);
		
		//mostramos suma total
		mostrarSumaArray(grid_aleatorios);

	}
	
	//calcula y muestra la suma total de los elementos de un array
	public static void mostrarSumaArray(int array[]){
		//calculamos y mostramos suma total del array
		int suma_total = array[0];
		String operacion_suma = "" + array[0];
		for (int i = 1; i < array.length; i++) {
			suma_total += array[i];
			operacion_suma += "+" + array[i];
		}
		operacion_suma += "=" + suma_total;
		JOptionPane.showMessageDialog(null, operacion_suma);
		
	}
	
	//rellena un array con datos aleatorios
	public static int[] rellenarArrayAleatorios(int grid_aleatorios[], int rango_min, int rango_max){
		//recorremos y llenamos con aleatorios
		for (int i = 0; i < grid_aleatorios.length; i++) {
			grid_aleatorios[i] = generarAleatorio(rango_min, rango_max);
		}

		return grid_aleatorios;
	}
	
	//genera un numero aleatorio entre un rango de 2 numeros
	public static int generarAleatorio(int rango_min, int rango_max) {
		double random = Math.random() * (rango_max - (rango_min - 1)) + rango_min; //generamos numero con rangos y quitamos los decimales
		 return (int)random;
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
