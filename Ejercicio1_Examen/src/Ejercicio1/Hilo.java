package Ejercicio1;
/**
 * Clase hilo que extiende de Thread que espera 0.3 segundos cuando es lanzada y dice su nombre
 * @author usuario
 *
 */
public class Hilo extends Thread {
	/*
	 * Método que implementa el comportamiento de la clase Hilo, no hace nada, solo espera e imprime su nombre
	 */
	@Override
	public void run() {
	
		try {
			sleep(300);//espera 0.3 segundos
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Soy el hilo "+getName());//imprime su nombre
	}
	
		

}
