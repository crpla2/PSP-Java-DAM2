package Ejercicio2;

/**
 * Clase programa que simula una serie de movimientos sobre una cuenta que
 * comparten varios clientes y que tiene un único pagador. Tanto los ingresos
 * como los egresos se realizan mediante diferrentes hilos.
 * 
 * @author usuario
 *
 */
public class Programa {
	/**
	 * Método principal de la Clase Programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Object aviso = new Object();
		Cuenta cuenta = new Cuenta(1000);

		Pagador pagador = new Pagador(cuenta, aviso);// Se crea un bojeto de la clase Pagador
		pagador.start();// Se inicia el hilo pagador

		Cliente martin = new Cliente("Martín", cuenta, aviso);// Se crea un bojeto de la clase Cliente
		martin.start();// Se inicia el hilo martin
		Cliente juan = new Cliente("Juan", cuenta, aviso);// Se crea un bojeto de la clase Cliente
		juan.start();// Se inicia el hilo juan

		try {
			pagador.join();// Se espera la finalización del hilo pagador

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			martin.join();// Se espera la finalización del hilo martin
			juan.join();// Se espera la finalización del hilo juan
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cuenta);// Se imprime el toString del objeto cuenta

	}

}
