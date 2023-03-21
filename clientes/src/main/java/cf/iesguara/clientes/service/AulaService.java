package cf.iesguara.clientes.service;

import java.util.List;

import cf.iesguara.clientes.model.S_Aula;

public interface AulaService {
	
	public S_Aula mostrarAulaId(long id);
	
	public S_Aula guardarAula(S_Aula aula);
	
	public List<S_Aula> mostrarAulas();
}
