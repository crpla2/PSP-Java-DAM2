package Ejercicio2;

import java.util.Random;

/**
 * Clase que extiende de Thread y que gestiona los egresos que se van a realizar
 * sobre una cuenta recibida por parametro por un cliente determinado, tiene un
 * objeto aviso que sirve para recibir una notificacion del pagador de que se ha
 * realizado un ingreso.
 * 
 * @author usuario
 *
 */
public class Cliente extends Thread {

	String nombre;
	Cuenta cuenta;
	Object aviso;

	/**
	 * Constructor de la clase Cliente recibe como parametro El nombre del cliente,
	 * una cuenta y un objeto aviso.
	 * 
	 * @param nombre es un String
	 * @param cuenta en un entero
	 * @param aviso  es un Object
	 */
	public Cliente(String nombre, Cuenta cuenta, Object aviso) {

		this.nombre = nombre;
		this.cuenta = cuenta;
		this.aviso = aviso;
	}

	/**
	 * Metodo que implementa el comportamiento del hilo de la Clase Cliente.
	 * ÇRealiza 10 extracciones esperando un segundo entre cada una de ellas, en
	 * caso de que en el momento de la extracción no haya saldo suficiente, se
	 * quedara a la espera de que el pagador notifique un ingreso a través del
	 * objeto aviso.
	 */
	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {// realiza 10 repeticiones
			int extraccion;
			try {
				sleep(1000);// espera un segundo
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Random rand = new Random();
			extraccion = 100 + rand.nextInt(200);// genera una cantidad aleatoria para la extraccion entre 100 y 300

			while (cuenta.getSaldo() < extraccion) { // mientras el saldo sea inferios a la extraccion
				synchronized (aviso) {
					try {
						aviso.wait();// espera a que Pagador le notifique a traves de aviso
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			// si hay saldo suficiente
			int EurosIniciales = cuenta.getSaldo();
			int EurosFinales = EurosIniciales - extraccion;
			cuenta.egreso(extraccion);// realiza la extracción
			System.out.println("Soy " + nombre + ": " + EurosIniciales + "-" + extraccion + "=" + EurosFinales);// imprime
																												// el
																												// resultado
																												// del
																												// egreso
																												// por
																												// pantalla

		}

	}

}
