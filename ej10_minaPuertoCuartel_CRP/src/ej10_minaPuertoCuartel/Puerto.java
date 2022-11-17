package ej10_minaPuertoCuartel;

import java.util.ArrayList;

public class Puerto implements Runnable {
	public static final String ANSI_RED="\u001b[31m";
	public static final String ANSI_GREEN="\u001b[32m";
	public static final String ANSI_RESET="\u001b[0m";
	int barcos;
	String nombre;
	Mina mina;

	public Puerto(int barcos, Mina mina, String nombre) {
		super();
		this.barcos = barcos;
		this.mina = mina;
		this.nombre = nombre;
	}
	
	public void construirSiHayDinero() {
		// cada barco cuesta dos monedas
		if(mina.getMonedas()>=2) {
			mina.gastar(2);
			barcos++;
		}else {
			System.out.println(ANSI_RED+"Puerto de "+nombre+": ¡No hay monedas suficientes!. No construyo"+ANSI_RESET);
		}
	}
	public void construirEnCola() throws InterruptedException {
		synchronized(mina){
			while(mina.getMonedas()<2) {
				System.out.println(ANSI_RED+"Puerto de "+nombre+": No hay monedas suficientes, esperando..."+ANSI_RESET);
				mina.wait();	
			}
			mina.gastar(2);
		}	
		barcos++;
		System.out.println(ANSI_GREEN+"Puerto de "+nombre+": Se ha construido un barco. Ahora hay "+barcos+"."+ANSI_RESET);
	}

	@Override
	public String toString() {
		return "Puerto de "+nombre+" [barcos=" + barcos + "]";
	}

	@Override
	public void run() {
		try {
			construirEnCola();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}

