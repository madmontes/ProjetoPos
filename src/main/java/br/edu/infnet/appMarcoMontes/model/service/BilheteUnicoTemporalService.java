package br.edu.infnet.appMarcoMontes.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appMarcoMontes.model.domain.BilheteUnicoTemporal;

@Service
public class BilheteUnicoTemporalService {
	
	private Map<Integer, BilheteUnicoTemporal> mapa = new HashMap<Integer, BilheteUnicoTemporal>();
	private Integer id = 0;
	
	public void incluir(BilheteUnicoTemporal bilheteunicotemporal) {
		bilheteunicotemporal.setId(++id);
		
		mapa.put(bilheteunicotemporal.getId(), bilheteunicotemporal);
	}
	
	public Collection<BilheteUnicoTemporal> obterLista(){
		return mapa.values();
	}
	
	public BilheteUnicoTemporal obterPortId(Integer id) {
		return mapa.get(id);
	}
	
	public void excluir (Integer id) {
		mapa.remove(id);
	}
}