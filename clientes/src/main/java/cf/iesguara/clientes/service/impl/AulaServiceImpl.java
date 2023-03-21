package cf.iesguara.clientes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cf.iesguara.clientes.exception.ResourceNotFoundException;
import cf.iesguara.clientes.model.S_Aula;
import cf.iesguara.clientes.repository.AulaRepository;
import cf.iesguara.clientes.service.AulaService;
@Service
@Component
public class AulaServiceImpl implements AulaService {
	@Autowired
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

	@Override
	public S_Aula guardarAula(S_Aula aula) {
		//Guardar siempre el codigo en mayusculas
		aula.setCodigo((aula.getCodigo().toUpperCase()));
		return aulaRepo.save(aula);
	}

	@Override
	public List<S_Aula> mostrarAulas() {
		return aulaRepo.findAll();
	}
	


}
