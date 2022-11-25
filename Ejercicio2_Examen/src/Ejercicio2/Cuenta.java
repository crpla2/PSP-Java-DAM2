package Ejercicio2;

/**
 * Clase cuenta que gestiona el saldo y movimientos d3e una cuenta
 * 
 * @author usuario
 *
 */
public class Cuenta {
	private int saldo;
	int movimientos = 0;

	/**
	 * Constructor de la clase cuenta que recibe como parámetro el saldo inicial
	 * 
	 * @param saldo es un entero
	 */
	public Cuenta(int saldo) {
		this.saldo = saldo;
	}

	/**
	 * Metodo que devuelve el saldo disponible de la cuenta
	 * 
	 * @return saldo es un entero
	 */
	public synchronized int getSaldo() {
		return saldo;
	}

	/**
	 * Metodo que añade una cantidad determinada pasada por parametro al saldo de la
	 * cuenta
	 * 
	 * @param cantidad es un entero
	 */
	public synchronized void ingreso(int cantidad) {
		this.saldo += cantidad;
		this.movimientos++;
	}

	/**
	 * Método que resta una cantidad determinada pasada por parametro al saldo de la
	 * cuenta
	 * 
	 * @param cantidad
	 */
	public synchronized void egreso(int cantidad) {
		this.saldo -= cantidad;
		this.movimientos++;
	}

	/**
	 * Metodo que imprime por pantalla en número de movimientos realizados y el
	 * saldo
	 */
	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", movimientos=" + movimientos + "]";
	}

}
