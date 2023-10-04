package PT2;

import javax.swing.JOptionPane;

public class NumerosAleatorios {

	public static void main(String[] args) {
		//declaramos variables de datos
		int cantidad_aleatorios, rango_min, rango_max;
		
		//Pedimos cantidad de numeros aleatoreos a generar
		String datos_keyboard = JOptionPane.showInputDialog("Introduce cantidad de numeros aleatorios a generar.");
		while (!stringEsNumeroEnteroPositivo(datos_keyboard)) {
			datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros o negativos, introduce antidad de numeros aleatorios a generar.");
		}
		cantidad_aleatorios = Integer.parseInt(datos_keyboard); //guardamos cantidad de aleatorios
		
		//Pedimos rango mínimo de los numeros aleatoreos
		datos_keyboard = JOptionPane.showInputDialog("Introduce el rango mínimo de los numeros aleatorios a generar.");
		while (!stringEsNumeroEntero(datos_keyboard)) {
			datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros, introduce el rango mínimo de los numeros aleatorios a generar.");
		}
		rango_min = Integer.parseInt(datos_keyboard); //guardamos rango mínimo
		
		//Pedimos rango máximo de los numeros aleatoreos
		datos_keyboard = JOptionPane.showInputDialog("Introduce el rango máximo de los numeros aleatorios a generar.");
		while (!stringEsNumeroEntero(datos_keyboard)) {
			datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros, introduce el rango máximo de los numeros aleatorios a generar.");
		}
		rango_max = Integer.parseInt(datos_keyboard); //guardamos rango máximo
		//mientras rango máximo sea mas pequeño o igual que el rango minimo se sigue pidiendo y validando el valor máximo
		while (rango_max <= rango_min) {
			datos_keyboard = JOptionPane.showInputDialog("El valor máximo de rango es igual o más pequeño que el rango mínimo, introduce un rango más grande que el valor mínimo de rango.");
			while (!stringEsNumeroEntero(datos_keyboard)) {
				datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros, introduce el rango máximo de los numeros aleatorios a generar.");
			}
			rango_max = Integer.parseInt(datos_keyboard); //guardamos rango máximo
			
		}
		
		//generamos y rellenamos array con el tamaño de aleatorios
		int grid_aleatorios[] = rellenarArrayAleatorios(cantidad_aleatorios, rango_min, rango_max);
		
		//mostramos array
		JOptionPane.showMessageDialog(null, "Datos generados: " + stringDeArray(grid_aleatorios));

	}
	
	//convierte los datos de un array en una cadena de texto
	public static String stringDeArray(int array[]){
		//declaramos y rellemanos string con datos de array
		String datos_array = "" + array[0];
		for (int i = 1; i < array.length; i++) {
			datos_array += ", " + array[i];
		}

		return datos_array;
	}
	
	//rellena un array con datos aleatorios
	public static int[] rellenarArrayAleatorios(int tamaño_grid, int rango_min, int rango_max){
		//creamos el array
		int grid_aleatorios[] = new int[tamaño_grid];
		
		//rellemanos de aleatorios
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
	
	//valida si string es numero entero
	public static boolean stringEsNumeroEntero(String datos_keyboard) {
		//variable para comprobar si es dato numérico o no
		boolean es_numero;
		
		//comprueba si el dato es positivo y numérico entero o no
		try {
			Integer.parseInt(datos_keyboard);
			es_numero = true;
		} catch (Exception e) {
			es_numero = false;
		}
		
		return es_numero;
	}
}
