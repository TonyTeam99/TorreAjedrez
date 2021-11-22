package org.iesalandalus.programacion.torreajedrez;

public class MainApp {
	private static Torre torre;

	public static void main(String[] args) {
		System.out.println("kk");
		Torre polla = new Torre();
		System.out.println(polla.toString());

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

}
