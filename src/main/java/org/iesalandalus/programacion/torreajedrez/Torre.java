package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	private Color color;
	private Posicion posicion;

	public Torre() {
		posicion = new Posicion(8, 'h');
		setColor(Color.NEGRO);
	}

}
