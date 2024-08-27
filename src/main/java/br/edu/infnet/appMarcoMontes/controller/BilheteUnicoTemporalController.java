package br.edu.infnet.appMarcoMontes.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appMarcoMontes.model.domain.BilheteUnicoTemporal;
import br.edu.infnet.appMarcoMontes.model.service.BilheteUnicoTemporalService;

@RestController
public class BilheteUnicoTemporalController {
	
	@Autowired
	private BilheteUnicoTemporalService bilheteunicotemporalService;
	@GetMapping(value = "bilheteunicotemporal/listar")
	public Iterable<BilheteUnicoTemporal> obterLista(){
		return bilheteunicotemporalService.obterLista();
	}
	
	@GetMapping(value = "bilheteunicotemporal/{id}")
	public BilheteUnicoTemporal obterPortId(@PathVariable Integer id) {
		return bilheteunicotemporalService.obterPortId(id);
	}
	
	@PostMapping(value = "bilheteunicotemporal/incluir")
	public String incluir(@RequestBody BilheteUnicoTemporal bilheteunicotemporal) {
		
		bilheteunicotemporalService.incluir(bilheteunicotemporal);
		
		return "Inclusão do bilhete " + bilheteunicotemporal + " realizada com sucesso!!!";
	}
	
	@DeleteMapping(value = "bilheteunicotemporal/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		bilheteunicotemporalService.excluir(id);
		
		return "A exclusão do id " + id + " realizada com sucesso!!!";
	}

}