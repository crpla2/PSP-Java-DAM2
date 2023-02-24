package cf.iesguara.clientes.service.impl;

import java.util.Optional;

import cf.iesguara.clientes.exception.ResourceNotFoundException;
import cf.iesguara.clientes.model.S_Aula;
import cf.iesguara.clientes.repository.AulaRepository;
import cf.iesguara.clientes.service.AulaService;

public class AulaServiceImpl implements AulaService {

	private AulaRepository aulaRepo;
	
	public AulaServiceImpl(AulaRepository aulaRepo) {
		super();
		this.aulaRepo = aulaRepo;
	}

	@Override
	public S_Aula mostrarAulaId(long idAula) {
		Optional<S_Aula> aulaOpt= aulaRepo.findById(idAula);
		if(aulaOpt.isPresent()) {
			return aulaOpt.get();
		}
		else {
			throw  new ResourceNotFoundException("Aula", "id", idAula);
		}
	}

}
