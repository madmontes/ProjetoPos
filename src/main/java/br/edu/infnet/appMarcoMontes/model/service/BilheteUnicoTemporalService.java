package br.edu.infnet.appMarcoMontes.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appMarcoMontes.model.domain.BilheteUnicoTemporal;
import br.edu.infnet.appMarcoMontes.model.repository.BilheteUnicoTemporalRepository;

@Service
public class BilheteUnicoTemporalService {
	
	@Autowired
	private BilheteUnicoTemporalRepository bilheteUnicoTemporalRepository;
	
	public void incluir(BilheteUnicoTemporal bilheteunicotemporal) {
		bilheteUnicoTemporalRepository.save(bilheteunicotemporal);
			
	}
	
	public Iterable<BilheteUnicoTemporal> obterLista(){
		return bilheteUnicoTemporalRepository.findAll();
	}
	
	public BilheteUnicoTemporal obterPortId(Integer id) {
		return bilheteUnicoTemporalRepository.findById(id).orElse(null);
	}
	
	public void excluir (Integer id) {
		bilheteUnicoTemporalRepository.deleteById(id);
		
	}
	
	public long obterQtde() {
		return bilheteUnicoTemporalRepository.count();
	}

}