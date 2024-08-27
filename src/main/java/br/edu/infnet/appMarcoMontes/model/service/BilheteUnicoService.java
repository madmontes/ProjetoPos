package br.edu.infnet.appMarcoMontes.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appMarcoMontes.model.domain.BilheteUnico;
import br.edu.infnet.appMarcoMontes.model.repository.BilheteUnicoRepository;

@Service
public class BilheteUnicoService {
	
	@Autowired
	private BilheteUnicoRepository bilheteUnicoRepository;
	
	public Iterable<BilheteUnico> obterLista(){
		return bilheteUnicoRepository.findAll();
	}
	
	public long obterQtde() {
		return bilheteUnicoRepository.count();
	}

}