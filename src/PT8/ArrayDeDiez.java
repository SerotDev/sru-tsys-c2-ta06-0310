package PT8;

import java.util.Scanner;

public class ArrayDeDiez {

	public static void main(String[] args) {
		// declaramos array
		int array_valores[] = new int[10];
		
		//rellenamos datos
		rellenarValores(array_valores);
		
		//mostramos datos
		mostrarValores(array_valores);
	}
	
	//muestra los valores
	public static void mostrarValores(int array_valores[]) {
		for (int i = 0; i < array_valores.length; i++) {
			System.out.print("| Dato Nº" + (i+1) + ":" + array_valores[i] + " ");
		}
		System.out.print("|");
	}
	
	//rellena un array con datos introducidos por teclado
	public static int[] rellenarValores(int array_valores[]){
		//rellemanos array con datos introducidos por el usuario
		Scanner keyboard = new Scanner(System.in);
		
		for (int i = 0; i < array_valores.length; i++) {
			System.out.println("Introduce un número para almacenarlo en la posicion Nº" + (i+1) + ".");
			String datos_keyboard = keyboard.nextLine();
			
			//validamos que sea dato numérico entero
			while (!stringEsNumeroEntero(datos_keyboard)) {
				System.out.println("Dato Nº" + (i+1) + " incorrecto, introduce un número entero.");
				datos_keyboard = keyboard.nextLine();
			}
			
			//guardamos dato introducido a la posicion del array correspondiente
			array_valores[i] = Integer.parseInt(datos_keyboard);
		}
		
		return array_valores;
	}
	
	//valida si string es numero entero
	public static boolean stringEsNumeroEntero(String datos_keyboard) {
		//variable para comprovar si es dato numérico o no
		boolean es_numero;
		
		//comprueba si el dato es numérico entero o no
		try {
			Integer.parseInt(datos_keyboard);
			es_numero = true;
		} catch (Exception e) {
			es_numero = false;
		}
		
		return es_numero;
	}

}
