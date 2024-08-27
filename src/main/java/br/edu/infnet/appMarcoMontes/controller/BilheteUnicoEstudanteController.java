package br.edu.infnet.appMarcoMontes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appMarcoMontes.model.domain.BilheteUnicoEstudante;
import br.edu.infnet.appMarcoMontes.model.service.BilheteUnicoEstudanteService;

@RestController
public class BilheteUnicoEstudanteController {
	
	@Autowired
	private BilheteUnicoEstudanteService bilheteunicoestudanteService;
	@GetMapping(value = "bilheteunicoestudante/listar")
	public Iterable<BilheteUnicoEstudante> obterLista(){
		return bilheteunicoestudanteService.obterLista();
	}
	
	@GetMapping(value = "bilheteunicoestudante/{id}")
	public BilheteUnicoEstudante obterPortId(@PathVariable Integer id) {
		return bilheteunicoestudanteService.obterPortId(id);
	}
	
	@PostMapping(value = "bilheteunicoestudante/incluir")
	public String incluir(@RequestBody BilheteUnicoEstudante bilheteunicoestudante) {
		
		bilheteunicoestudanteService.incluir(bilheteunicoestudante);
		
		return "Inclusão do bilhete " + bilheteunicoestudante + " realizada com sucesso!!!";
	}
	
	@DeleteMapping(value = "bilheteunicoestudante/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		bilheteunicoestudanteService.excluir(id);
		
		return "A exclusão do id " + id + " realizada com sucesso!!!";
	}

}