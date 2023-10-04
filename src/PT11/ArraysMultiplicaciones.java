package PT11;

import javax.swing.JOptionPane;

public class ArraysMultiplicaciones {

	public static void main(String[] args) {
		
		//declaramos constantes y variables de datos
		final int rango_min = 1;
		final int rango_max = 50;
		int dimension_array;
		
		//Pedimos dimension del array a generar
		String datos_keyboard = JOptionPane.showInputDialog("Introduce la dimension del array a generar.");
		while (!stringEsNumeroEnteroPositivo(datos_keyboard)) {
			datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros o negativos, introduce la dimension del array a generar.");
		}
		dimension_array = Integer.parseInt(datos_keyboard); //guardamos cantidad de aleatorios
		
		//creamos primer array y llenamos de datos aleatorios
		int array_1[] = new int[dimension_array];
		rellenarArrayAleatorios(array_1, rango_min, rango_max);
		
		//creamos segundo array apuntando al primero, lo convertimos en una copia para que no apunte a la misma dirección de memoria y reasignamos sus valores con datos aleatorios
		int array_2[] = array_1;
		array_2 = array_1.clone();
		rellenarArrayAleatorios(array_2, rango_min, rango_max);
		
		//creamos y llenamos un nuevo array con los datos de los dos anteriores multiplicados
		int[] array_3 = generarArrayMultiplicados(array_1, array_2);
		
		//mostramos el contenido de cada array
		mostrarArray("Datos de array 1", array_1);
		mostrarArray("Datos de array 2", array_2);
		mostrarArray("Datos de array 3", array_3);

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
	
	//devuelve un nuevo array con los datos de los arrays multiplicados
	public static int[] generarArrayMultiplicados(int array_1[], int array_2[]){
		//creamos array
		int array_3[] = new int[array_1.length];
		//recorremos, multiplicamos y guardamos
		for (int i = 0; i < array_1.length; i++) {
			array_3[i] = array_1[i] * array_2[i];
		}
		return array_3;
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
