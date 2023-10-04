package PT3;

import javax.swing.JOptionPane;

public class NumeroPrimo {

	public static void main(String[] args) {
		//Pedimos numero a mirar si es primo o no
		String datos_keyboard = JOptionPane.showInputDialog("Introduce numero para conocer si es primo o no.");
		while (!stringEsNumeroEntero(datos_keyboard)) {
			datos_keyboard = JOptionPane.showInputDialog("Datos no numéricos enteros, introduce un numero para conocer si es primo o no.");
		}
		
		//mostramos mensaje dependiendo de si es primo o no
		if (esPrimo(Integer.parseInt(datos_keyboard))) {
			JOptionPane.showMessageDialog(null, "El número " + datos_keyboard + " es primo.");
		} else {
			JOptionPane.showMessageDialog(null, "El número " + datos_keyboard + " no es primo.");
		}

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
