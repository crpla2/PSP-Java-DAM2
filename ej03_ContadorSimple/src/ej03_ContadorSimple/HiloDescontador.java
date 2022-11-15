package ej03_ContadorSimple;

public class HiloDescontador extends Thread {
	private int vueltas;
	private Contador contador;
	
	
	public HiloDescontador(int vueltas, Contador contador) {
		super();
		this.vueltas = vueltas;
		this.contador = contador;
	}


	@Override
	public void run() {
		for (int i = 0; i < vueltas; i++) {
	//		synchronized (contador) {//Se utiliza porque la clase Contador no es Thread Safe(Transaccion)
				contador.descontar();				
		//	}
			
		}

	}
}
