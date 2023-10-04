package PT10;

import java.util.Iterator;

import javax.swing.JOptionPane;

public class ArrayAleatoriosPrimos {

	public static void main(String[] args) {
		//declaramos variables de datos
		int cantidad_aleatorios, rango_min, rango_max;
		
		//Pedimos cantidad de numeros aleatoreos a generar
		String datos_keyboard = JOptionPane.showInputDialog("Introduce cantidad de numeros aleatorios a generar.");
		while (!stringEsNumeroEnteroPositivo(datos_keyboard)) {
			datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros o negativos, introduce cantidad de numeros aleatorios a generar.");
		}
		cantidad_aleatorios = Integer.parseInt(datos_keyboard); //guardamos cantidad de aleatorios
		
		//Pedimos rango mínimo de los numeros aleatoreos
		datos_keyboard = JOptionPane.showInputDialog("Introduce el rango mínimo de los numeros aleatorios a generar.");
		while (!stringEsNumeroEnteroPositivo(datos_keyboard)) {
			datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros, introduce el rango mínimo de los numeros aleatorios a generar.");
		}
		rango_min = Integer.parseInt(datos_keyboard); //guardamos rango mínimo
		
		//Pedimos rango máximo de los numeros aleatoreos
		datos_keyboard = JOptionPane.showInputDialog("Introduce el rango máximo de los numeros aleatorios a generar.");
		while (!stringEsNumeroEnteroPositivo(datos_keyboard)) {
			datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros, introduce el rango máximo de los numeros aleatorios a generar.");
		}
		rango_max = Integer.parseInt(datos_keyboard); //guardamos rango máximo
		//mientras rango máximo sea mas pequeño o igual que el rango minimo se sigue pidiendo y validando el valor máximo
		while (rango_max <= rango_min) {
			datos_keyboard = JOptionPane.showInputDialog("El valor máximo de rango es igual o más pequeño que el rango mínimo, introduce un rango más grande que " + rango_min + ".");
			while (!stringEsNumeroEnteroPositivo(datos_keyboard)) {
				datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros, introduce el rango máximo de los numeros aleatorios a generar.");
			}
			rango_max = Integer.parseInt(datos_keyboard); //guardamos rango máximo
		}
		//se comprueba si algun numero del rango de numeros es primo
		boolean tiene_primo = false;
		while (!tiene_primo) {
			tiene_primo = false;
			for (int i = rango_min; i <= rango_max; i++) {
				if (esPrimo(i)) {
					tiene_primo = true;
				}
			}
			//si el rango no tiene primos pregunta otra vez los datos
			if (!tiene_primo) {
				datos_keyboard = JOptionPane.showInputDialog("El rango que has introducido no contiene numeros primos, introduce un valor máximo de rango más alto que " + rango_max + ".");
				while (!stringEsNumeroEnteroPositivo(datos_keyboard)) {
					datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros, introduce el rango máximo de los numeros aleatorios a generar.");
				}
				//mientras el rango maximo introducido sea inferior al anterior repite la peticion de datos
				while (Integer.parseInt(datos_keyboard) <= rango_max) {
					datos_keyboard = JOptionPane.showInputDialog("El valor máximo de rango introducido es igual o más pequeño que el anterior, introduce un valor más grande que " + rango_max +".");
					while (!stringEsNumeroEnteroPositivo(datos_keyboard)) {
						datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros, introduce el rango máximo de los numeros aleatorios a generar.");
					}
				}
				rango_max = Integer.parseInt(datos_keyboard); //guardamos rango máximo
			}
			
		}
		
		//generamos y rellenamos array con rango de aleatorios
		int grid_aleatorios[] = new int[cantidad_aleatorios];
		rellenarArrayAleatorios(grid_aleatorios, rango_min, rango_max);
		
		//mostramos lista y el mayor primo de todos
		mostrarPrimosArray(grid_aleatorios);

	}
	
	//calcula y muestra la suma total de los elementos de un array
	public static void mostrarPrimosArray(int array[]){
		//recorremos array y mostramos entre [] los numeros primos
		int primo_mayor = 0;
		String primos_de_array = "";
		for (int i = 0; i < array.length; i++) {
			//salto de linea cada 40 elementos
			if (i%40 == 0) {
				primos_de_array += "\n";
			}
			//si dato es primo se añade a la cadena del array
			if (esPrimo(array[i])) {
				primos_de_array += "[" + array[i] + "] ";
				//se guarda el primo en caso de que el que se esta evaluando sea mayor que el guardado
				if (array[i] > primo_mayor) {
					primo_mayor = array[i];
				}
			} else {
				primos_de_array += array[i] + " ";
			}
		}
		JOptionPane.showMessageDialog(null, "Lista generada, los numeros primos estan marcados entre corchetes. (ej. [3])\n" + primos_de_array + "\n"
				+ "\nEl primo más grande del array es el " + primo_mayor);
		
	}
	
	//rellena un array con datos aleatorios
	public static int[] rellenarArrayAleatorios(int grid_aleatorios[], int rango_min, int rango_max){
		//mientras no existan numeros primos dentro del array se rellena
		boolean tiene_primo = false;
		while (!tiene_primo) {
			for (int i = 0; i < grid_aleatorios.length; i++) {
				grid_aleatorios[i] = generarAleatorio(rango_min, rango_max);
				if (esPrimo(grid_aleatorios[i])) {
					tiene_primo = true;
				}
			}
		}
		return grid_aleatorios;
	}
	
	//genera un numero aleatorio entre un rango de 2 numeros
	public static int generarAleatorio(int rango_min, int rango_max) {
		double random = Math.random() * (rango_max - (rango_min - 1)) + rango_min; //generamos numero con rangos y quitamos los decimales
		 return (int)random;
	}
	
	//valida si es numero primo o no
	public static boolean esPrimo(int numero) {
		//variable para comprobar si es dato numérico o no
		boolean es_primo = true;
		if (numero < 2) {
			es_primo = false;
		} else if (numero >= 4) {
			for (int i = 2; i < numero; i++) {
				if (numero % i == 0) {
					es_primo = false;
				}
			}
		}
		return es_primo;
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
