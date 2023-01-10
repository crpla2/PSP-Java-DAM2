package modelo;

import java.io.Serializable;
import java.util.Date;

public class Mensaje implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date fechaHora;
	private String texto;
	private String emisor;
	
	public static final String ANSI_RED="\u001b[31m";
	public static final String ANSI_GREEN="\u001b[32m";
	public static final String ANSI_RESET="\u001b[0m";
	
	public Mensaje(String emisor,String texto ) {
		super();
		this.fechaHora = new Date();
		this.texto = texto;
		this.emisor = emisor;
	}

	public String toString() {
		return ANSI_GREEN+"(" + fechaHora + ")" +ANSI_RESET +ANSI_RED+ emisor +": "+ANSI_RESET+"\t"+ texto + "\n";
	}
	
	
}
