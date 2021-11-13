package org.iesalandalus.programacion.torreajedrez;

public class Posicion {
	private int fila;
	private char columna;

	// Constructor
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}

	// Setters and Getters
	private void setFila(int fila) {
		if (fila < 1 || fila > 8)
			throw new IllegalArgumentException("ERROR: Fila no v�lida.");
		this.fila = fila;
	}

	public int getFila() {
		return fila;
	}

	private void setColumna(char columna) {
		if (columna < 'a' || columna > 'h')
			throw new IllegalArgumentException("ERROR: Columna no v�lida.");
		this.columna = columna;
	}

	public char getColumna() {
		return columna;
	}

}