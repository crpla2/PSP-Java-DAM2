package Ejercicio1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Clase Lanzador qu lanza el programa
 * @author usuario
 *
 */
public class Lanzador {
	/**
	 * Metodo Principal
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Thread>listahilos= new ArrayList<>();//Se crea una lista de hilos
		for (int i = 0; i < 10; i++) {//se repite 10 veces
			try {
				Thread.sleep(500);//Se espera medio segundo
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Hilo hilo = new Hilo();
			listahilos.add(hilo);//Se añaden hilos a la lista
			hilo.start();//se inicia el hilo
			
		}
		for (int i = 0; i < 10; i++) {//Se repite 10 veces
			Thread hilo;
			try {
				hilo=listahilos.get(i);//Se recogen los hilos de la lista
				hilo.join();//Se espera la finalizacion de los hilos
				System.out.println("Ha finalizado el hilo "+hilo.getName());//Se imprime
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
