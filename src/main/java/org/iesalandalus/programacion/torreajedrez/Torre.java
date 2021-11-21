package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

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
		if (color.equals(null)) {
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
			if (color.equals(color.NEGRO)) {
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
			if (color.equals(color.NEGRO)) {
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
			if (color.equals(color.NEGRO)) {
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
			if (color.equals(color.NEGRO)) {
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

	// Método enrocar
	public void enrocar(Direccion direccion) throws OperationNotSupportedException {
		if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		if (color.equals(color.NEGRO)) {
			switch (direccion) {
			case ENROQUE_CORTO:
				if (posicion.getColumna() == 'h' && (posicion.getFila() == 8)) {
					setPosicion(new Posicion(posicion.getColumna() == 'f' && posicion.getFila() == 8));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
				break;
			case ENROQUE_LARGO:
				if (posicion.getColumna() == 'a' && (posicion.getFila() == 8)) {
					setPosicion(new Posicion(posicion.getColumna() == 'd' && posicion.getFila() == 8));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
				break;
			}
		} else {
			switch (direccion) {
			case ENROQUE_CORTO:
				if (posicion.getColumna() == 'h' && (posicion.getFila() == 1)) {
					setPosicion(new Posicion(posicion.getColumna() == 'f' && posicion.getFila() == 1));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
				break;
			case ENROQUE_LARGO:
				if (posicion.getColumna() == 'a' && (posicion.getFila() == 1)) {
					setPosicion(new Posicion(posicion.getColumna() == 'd' && posicion.getFila() == 1));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
				break;
			}
		}
	}

	// Método equals y hashCode
	@Override
	public int hashCode() {
		return Objects.hash(color, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torre other = (Torre) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}

	// Método toString
	@Override
	public String toString() {
		return "fila=" + posicion.getFila() + ", columna=" + posicion.getColumna() + ", color=" + color;
	}

}
