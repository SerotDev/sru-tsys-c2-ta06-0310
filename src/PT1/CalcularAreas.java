package PT1;

import javax.swing.JOptionPane;

public class CalcularAreas {

	public static void main(String[] args) {
		//declaramos variable del area
		double area;
		
		//Pedimos tipo de figura
		String datos_keyboard = JOptionPane.showInputDialog("Introduce tipo de figura para calcular su área: (Círculo, Triángulo, Cuadrado).");
		while (stringEsFiguraGeometrica(datos_keyboard) == 0) {
			datos_keyboard = JOptionPane.showInputDialog("Datos incorrectos, introduce tipo de figura para calcular su área: (Círculo, Triángulo, Cuadrado).");
		}
		int tipo_figura = stringEsFiguraGeometrica(datos_keyboard); //guardamos tipo de figura geométrica
		
		//Mostrmos area segun tipo de figura
		switch (tipo_figura) {
		
		//CIRCULO
		case 1:
			//pedimos radio del circulo
			datos_keyboard = JOptionPane.showInputDialog("Introduce el tamaño del radio.");
			while (!stringEsDecimalPositivo(datos_keyboard)) {
				datos_keyboard = JOptionPane.showInputDialog("Tamaño del radio incorrecto, introducelo de nuevo.");
			}
			area = areaCirculo(Double.parseDouble(datos_keyboard));
			JOptionPane.showMessageDialog(null, "El tamaño del area del círculo es de " + area);
			break;
			
		//TRIANGULO
		case 2:
			//pedimos base del triangulo y guardamos
			datos_keyboard = JOptionPane.showInputDialog("Introduce base del triángulo.");
			while (!stringEsDecimalPositivo(datos_keyboard)) {
				datos_keyboard = JOptionPane.showInputDialog("Tamaño de la base del triángulo incorrecto, introdúcelo de nuevo.");
			}
			double base_triangulo = Double.parseDouble(datos_keyboard);
			
			//pedimos altura del triangulo
			datos_keyboard = JOptionPane.showInputDialog("Introduce altura del triángulo.");
			while (!stringEsDecimalPositivo(datos_keyboard)) {
				datos_keyboard = JOptionPane.showInputDialog("Tamaño de la altura del triángulo incorrecta, introdúcela de nuevo.");
			}
			
			//mostramos area
			area = areaTriangulo(base_triangulo, Double.parseDouble(datos_keyboard));
			JOptionPane.showMessageDialog(null, "El tamaño del area del triángulo es de " + area);
			break;
			
		//CUADRADO
		case 3:
			//pedimos el lado del cuadrado
			datos_keyboard = JOptionPane.showInputDialog("Introduce lado del cuadrado.");
			while (!stringEsDecimalPositivo(datos_keyboard)) {
				datos_keyboard = JOptionPane.showInputDialog("Tamaño del lado del cuadrado incorrecto, introdúcelo de nuevo.");
			}
			
			//mostramos area
			area = areaCuadrado(Double.parseDouble(datos_keyboard));
			JOptionPane.showMessageDialog(null, "El tamaño del area del cuadrado es de " + area);
			break;
		
		//ERROR
		default:
			System.out.println("La figura a mostrar su área no existe.");
			break;
		}
		
		

	}
	
	//Metodo para validar si es figura: 0 no es figura - 1 circulo - 2 triangulo - 3 cuadrado 
	public static int stringEsFiguraGeometrica(String datos_keyboard) {
		//variable para guardar si es figura y tipo de figura
		int figura;
		
		//comprueba si el dato corresponde a una figura geométrica
		switch (datos_keyboard.toUpperCase()) {
		case "CIRCULO":
			figura = 1;
			break;
		case "CÍRCULO":
			figura = 1;
			break;
		case "TRIANGULO":
			figura = 2;
			break;
		case "TRIÁNGULO":
			figura = 2;
			break;
		case "CUADRADO":
			figura = 3;
			break;
			
		default:
			figura = 0;
			break;
		}
		
		return figura;
	}
	
	//Metodo para validar si los datos introducidos es un numero decimal positivo
	public static boolean stringEsDecimalPositivo(String datos_keyboard) {
		//variable para comprobar si es dato numérico o no
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
	
	//método para devolver área del circulo
	public static double areaCirculo(double radio) {
		double area = Math.PI * Math.pow(radio, 2);
		return area;
	}
	
	//método para devolver área del triangulo
	public static double areaTriangulo(double base, double altura) {
		double area = (base * altura) / 2;
		return area;
	}
	
	//método para devolver área del cuadrado
	public static double areaCuadrado(double lado) {
		double area = lado * lado;
		return area;
	}

}
