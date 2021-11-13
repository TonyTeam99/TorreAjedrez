package org.iesalandalus.programacion.torreajedrez;

public class Posicion {
	private int fila;
	private char columna;

	private void setFila(int fila) {
		if (fila < 1 || fila > 8)
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		this.fila = fila;
	}

	public int getFila() {
		return fila;
	}

	private void setColumna(char columna) {
		if (!(columna == 'a' || columna == 'b' || columna == 'c' || columna == 'd' || columna == 'e' || columna == 'f' || columna == 'g' || columna == 'h'))
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		this.columna = columna;
	}

	public char getColumna() {
		return columna;
	}

}