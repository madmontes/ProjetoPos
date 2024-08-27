package br.edu.infnet.appMarcoMontes.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appMarcoMontes.model.domain.BilheteUnicoEstudante;
import br.edu.infnet.appMarcoMontes.model.repository.BilheteUnicoEstudanteRepository;

@Service
public class BilheteUnicoEstudanteService {
	
	@Autowired
	private BilheteUnicoEstudanteRepository bilheteUnicoEstudanteRepository;
	
	public void incluir(BilheteUnicoEstudante bilheteunicoestudante) {
		bilheteUnicoEstudanteRepository.save(bilheteunicoestudante);
			
	}
	
	public Iterable<BilheteUnicoEstudante> obterLista(){
		return bilheteUnicoEstudanteRepository.findAll();
	}
	
	public BilheteUnicoEstudante obterPortId(Integer id) {
		return bilheteUnicoEstudanteRepository.findById(id).orElse(null);
	}
	
	public void excluir (Integer id) {
		bilheteUnicoEstudanteRepository.deleteById(id);
		
	}
	
	public long obterQtde() {
		return bilheteUnicoEstudanteRepository.count();
	}

}
