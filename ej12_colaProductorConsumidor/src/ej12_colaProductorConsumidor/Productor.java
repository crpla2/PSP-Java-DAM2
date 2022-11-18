package ej12_colaProductorConsumidor;

import java.util.concurrent.LinkedBlockingDeque;

public class Productor implements Runnable {
	LinkedBlockingDeque<String>cola;
	public Productor(LinkedBlockingDeque<String> cola) {
		super();
		this.cola = cola;
	}
	@Override
	public void run() {
		for (int i = 0; i < 40; i++) {		
			cola.add(Thread.currentThread().getName()+" Mensaje "+i);
		}
		
	}

}
