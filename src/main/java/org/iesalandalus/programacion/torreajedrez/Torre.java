package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	private Color color;
	private Posicion posicion;

	private void setPosicion(Posicion posicion) {

		this.posicion = posicion;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setColor(Color color) {
		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public Torre() {
		posicion = new Posicion(8, 'h');
		setColor(Color.NEGRO);
	}

}
