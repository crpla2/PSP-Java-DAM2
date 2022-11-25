package Ejercicio2;

/**
 * Clase que extiende de Thread y que gestiona los ingresos que se van a
 * realizar sobre una cuenta recibida por parametro, tiene un objeto aviso que
 * sirve para notificar a los clientes que se ha realizado un ingreso.
 * 
 * @author usuario
 *
 */
public class Pagador extends Thread {
	Cuenta cuenta;
	Object aviso;

	/**
	 * Metodo constructor de la clase Pagador recibe como parametro una cuenta y un
	 * Objeto aviso.
	 * 
	 * @param cuenta
	 * @param aviso
	 */
	public Pagador(Cuenta cuenta, Object aviso) {

		this.cuenta = cuenta;
		this.aviso = aviso;
	}

	/**
	 * Metodo que implementa el comportamiento del hilo de la Clase Pagador. Realiza
	 * tres ingresos de 1000, esperando 5 segundos entre cada ingreso. Tras realizar
	 * el ingreso notifica a los hilos que estan a la espera a través del objeto
	 * aviso. Imprime por pantalla cada vez que realiza un ingreso.
	 */
	@Override
	public void run() {
		try {
			for (int i = 0; i < 3; i++) {// realiza tres repeticiones
				sleep(5000);// espera 5 segundos
				cuenta.ingreso(1000);// ingresa 1000
				synchronized (aviso) {
					aviso.notifyAll();// notifica a todos los hilos que estén a la espera del objeto aviso
				}

				System.out.println("Soy el Pagador he ingresado 1000");// Imprime por pantalla que se ha realizado un
																		// ingreso
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
