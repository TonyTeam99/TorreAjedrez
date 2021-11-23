package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	private static Torre torre;

	public static void main(String[] args) {
		System.out.println("kk");
	}

	// Método mostrar Torre
	private static void mostrarTorre() {
		try {
			System.out.println(torre.toString());
		} catch (NullPointerException t) {
			System.out.println("ERROR: La torre no se ha creado.");
		}
	}

	// Método mostrar Menú
	private static void mostrarMenu() {
		System.out.println(" ");
		System.out.println("1. Crear una torre por defecto.");
		System.out.println("2. Crear una torre eligiendo su color.");
		System.out.println("3. Crear una torre eligiendo su color y posición inicial.");
		System.out.println("4. Mover la torre.");
		System.out.println("5. Salir.");
	}

	// Método elegir opción
	private static int elegirOpcion() {
		int opcionMenu;
		do {
			System.out.println("Elija una de las opciones anteriores");
			opcionMenu = Entrada.entero();
		} while (opcionMenu < 1 || opcionMenu > 5);
		return opcionMenu;
	}

	// Método elegir Color
	private static Color elegirColor() {
		Color color = null;
		int opcionColor;
		do {
			System.out.println("===============");
			System.out.println(" ");
			System.out.println("1. Negro.");
			System.out.println("2. Blanco.");
			System.out.println(" ");
			System.out.print("Elija un color: ");
			opcionColor = Entrada.entero();
		} while (opcionColor != 1 && opcionColor != 2);
		switch (opcionColor) {
		case 1:
			color = Color.NEGRO;
			break;
		case 2:
			color = color.BLANCO;
			break;
		}
		return color;
	}
}
