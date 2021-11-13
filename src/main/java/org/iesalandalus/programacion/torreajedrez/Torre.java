package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

public class Torre {
	private Color color;
	private Posicion posicion;

	// Constructor por defecto de Torre Negra en 8h
	public Torre() {
		posicion = new Posicion(8, 'h');
		setColor(Color.NEGRO);
	}

	// Constructor posición torres blanca y negra
	public Torre(Color color) {
		setColor(color);
		if (color.equals(color.BLANCO)) {
			setPosicion(new Posicion(1, 'h'));
		} else {
			setColor(Color.NEGRO);
			setPosicion(new Posicion(8, 'h'));
		}
	}

	// Constructor con entradas de color y columna
	public Torre(Color color, char columna) {
		setColor(color);
		if (columna == 'A' || columna == 'a' || columna == 'H' || columna == 'h') {
			if (color.equals(color.BLANCO)) {
				setPosicion(new Posicion(1, columna));
			} else {
				setColor(Color.NEGRO);
				setPosicion(new Posicion(8, columna));
			}
		} else {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
	}

	// Getters and Setters
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

	// Método mover
	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		if (pasos < 1) {
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
		} else if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		switch (direccion) {
		case ARRIBA:
			if (color == color.NEGRO) {
				try {
					setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			} else {
				try {
					setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			}
			break;
		case ABAJO:
			if (color == color.NEGRO) {
				try {
					setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			} else {
				try {
					setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			}
			break;
		case IZQUIERDA:
			if (color == color.NEGRO) {
				try {
					setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + pasos)));
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			} else {
				try {
					setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - pasos)));
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			}
			break;
		case DERECHA:
			if (color == color.NEGRO) {
				try {
					setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - pasos)));
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			} else {
				try {
					setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + pasos)));
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			}
			break;
		}
	}

}
