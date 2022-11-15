package ej03_ContadorSimple;

public class Contador {// Clase Thread Safe (syncronised)
	private boolean positivo;
	private int numero;

	public Contador(boolean positivo) {
		super();
		this.positivo = positivo;
		this.numero = 0;
	}

	public void contar() {
		if (positivo)
			synchronized (this) {//Sincronizacion de la operacion
				this.numero++;
			}
		else
			synchronized (this) {//Sincronizacion de la operacion
				this.numero--;
			}
	}

	public synchronized void descontar() {//Sicronización de todo el método
		if (!positivo)
			this.numero++;

		else
			this.numero--;
	}

	@Override
	public String toString() {
		return "Contador [positivo=" + positivo + ", numero=" + numero + "]";
	}

}
