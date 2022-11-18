package ej12_colaProductorConsumidor;

import java.util.concurrent.LinkedBlockingDeque;

public class Consumidor implements Runnable {
	LinkedBlockingDeque<String>cola;
	public Consumidor(LinkedBlockingDeque<String> cola) {
		super();
		this.cola = cola;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
