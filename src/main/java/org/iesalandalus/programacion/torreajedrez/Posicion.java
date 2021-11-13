package org.iesalandalus.programacion.torreajedrez;

import org.apache.commons.math3.exception.NullArgumentException;

public class Posicion {
	private int fila;
	private char columna;

	// Constructor
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}

	// Constructor copia
	public Posicion(Posicion p) {
		if (p == null) {
			throw new NullArgumentException("ERROR: No es posible copiar una posición nula.");
		}
		this.fila = (p.getFila());
		this.columna = (p.getColumna());
	}

	// Setters and Getters
	private void setFila(int fila) {
		if (fila < 1 || fila > 8)
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		this.fila = fila;
	}

	public int getFila() {
		return fila;
	}

	private void setColumna(char columna) {
		if (columna < 'a' || columna > 'h')
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		this.columna = columna;
	}

	public char getColumna() {
		return columna;
	}

}