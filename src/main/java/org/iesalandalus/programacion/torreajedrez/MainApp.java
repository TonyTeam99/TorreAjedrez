package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	private static Torre torre;

	public static void main(String[] args) {
		System.out.println("=====================================");
		System.out.println("============Torre de Ajedrez=========");
		System.out.println("=====================================");
		do {
			mostrarMenu();
			ejecutarOpcion(elegirOpcion());
		} while (elegirOpcion() != 5);
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
		} while (opcionColor < 1 || opcionColor > 2);
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

	// Método elegir columna
	private static char elegirColumnaInicial() {
		char columna = 0;
		do {
			System.out.print("Introduzca la columna deseada (A , a , H , h): ");
			columna = Entrada.caracter();
		} while (columna != 'a' && columna != 'A' && columna != 'h' && columna != 'H');
		return columna;
	}

	// Método mostrar menú direcciones
	private static void mostrarMenuDirecciones() {
		System.out.println("============================");
		System.out.println(" ");
		System.out.println("1. Mover hacia arriba.");
		System.out.println("2. Mover hacia abajo.");
		System.out.println("3. Mover hacia la izquierda.");
		System.out.println("4. Mover hacia la derecha.");
		System.out.println("5. Realizar enroque corto.");
		System.out.println("6. Realizar enroque largo.");
		System.out.println(" ");
		System.out.println("============================");
	}

	// Método elegir Dirección
	private static Direccion elegirDireccion() {
		Direccion direccion = null;
		int opcionDireccion = 0;
		do {
			System.out.println(" ");
			System.out.print("Elija una opción entre las anteriores: ");
			opcionDireccion = Entrada.entero();
		} while (opcionDireccion < 1 || opcionDireccion > 6);

		switch (opcionDireccion) {
		case 1:
			direccion = direccion.ARRIBA;
			break;
		case 2:
			direccion = direccion.ABAJO;
			break;
		case 3:
			direccion = direccion.IZQUIERDA;
			break;
		case 4:
			direccion = direccion.DERECHA;
			break;
		case 5:
			direccion = direccion.ENROQUE_CORTO;
			break;
		case 6:
			direccion = direccion.ENROQUE_LARGO;
			break;
		}

		return direccion;
	}

	// Método crear Torre por defecto
	private static void crearTorreDefecto() {
		torre = new Torre();
	}

	// Método crear Torre Color
	private static void crearTorreColor() {
		torre = new Torre(elegirColor());
	}

	// Método crear Torre Color y Columna Inicial
	private static void crearTorreColorColumna() {
		torre = new Torre(elegirColor(), elegirColumnaInicial());
	}

	// Método mover
	private static void mover() {
		mostrarMenuDirecciones();
		Direccion direccion = elegirDireccion();
		if (direccion == direccion.ENROQUE_CORTO || direccion == direccion.ENROQUE_LARGO) {
			try {
				torre.enrocar(direccion);
			} catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Introduzca el número de pasos a mover");
			int pasos = Entrada.entero();
			try {
				torre.mover(direccion, pasos);
			} catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// Método ejecutar Opción
	private static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			crearTorreDefecto();
			break;
		case 2:
			crearTorreColor();
			break;
		case 3:
			crearTorreColorColumna();
			break;
		case 4:
			mover();
			break;
		case 5:
			System.out.println("Vuelva pronto");
			break;
		}
	}
}
