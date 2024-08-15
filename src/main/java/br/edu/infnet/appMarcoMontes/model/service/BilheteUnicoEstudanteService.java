package br.edu.infnet.appMarcoMontes.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appMarcoMontes.model.domain.BilheteUnicoEstudante;

@Service
public class BilheteUnicoEstudanteService {
	
	private Map<Integer, BilheteUnicoEstudante> mapa = new HashMap<Integer, BilheteUnicoEstudante>();
	private Integer id = 0;
	
	public void incluir(BilheteUnicoEstudante bilheteunicoestudante) {
		bilheteunicoestudante.setId(++id);
		
		mapa.put(bilheteunicoestudante.getId(), bilheteunicoestudante);
	}
	
	public Collection<BilheteUnicoEstudante> obterLista(){
		return mapa.values();
	}

}
