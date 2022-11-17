package ej10_minaPuertoCuartel;

public class PuertoSubcontratado extends Thread {
	public static final String ANSI_RED="\u001b[31m";
	public static final String ANSI_GREEN="\u001b[32m";
	public static final String ANSI_RESET="\u001b[0m";
	int barcos;
	String nombre;
	Mina mina;
	
	public PuertoSubcontratado(int barcos, String nombre, Mina mina) {
		super();
		this.barcos = barcos;
		this.nombre = nombre;
		this.mina = mina;
	}

	@Override
	public void run() {
		try {
			synchronized(mina){
				while(mina.getMonedas()<2) {
					System.out.println(ANSI_RED+"Puerto de "+nombre+": No hay monedas suficientes, esperando..."+ANSI_RESET);
					mina.wait();	
				}
				mina.gastar(2);
			}	
			barcos++;
			System.out.println(ANSI_GREEN+"Puerto de "+nombre+": Se ha construido un barco. Ahora hay "+barcos+"."+ANSI_RESET);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return "Puerto de "+nombre+" [barcos=" + barcos + "]";
	}
}
