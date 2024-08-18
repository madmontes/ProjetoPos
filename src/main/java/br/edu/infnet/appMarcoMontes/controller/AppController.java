package br.edu.infnet.appMarcoMontes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appMarcoMontes.model.service.BilheteUnicoEstudanteService;
import br.edu.infnet.appMarcoMontes.model.service.BilheteUnicoTemporalService;
import br.edu.infnet.appMarcoMontes.model.service.UsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private BilheteUnicoTemporalService bilheteUnicoTemporalService;
	@Autowired
	private BilheteUnicoEstudanteService bilheteUnicoEstudanteService;
	
	@GetMapping(value = "/")
	public String showIndex(Model model) {
		
		model.addAttribute("qtdeUsuario", usuarioService.obterQtde());
		model.addAttribute("qtdeBilheteUnico", 0);
		model.addAttribute("qtdeBilheteUnicoTemporal", bilheteUnicoTemporalService.obterLista().size());
		model.addAttribute("qtdeBilheteUnicoEstudante", bilheteUnicoEstudanteService.obterLista().size());
		
		return "index";
	}
	
	@GetMapping(value="/usuario/listagem")
	public String listarUsuario(Model model) {

		model.addAttribute("listagem",usuarioService.obterLista());
		
		return showIndex(model);
	}
	
	@GetMapping(value="/bilheteunicotemporal/listagem")
	public String listarBilheteUnicoTemporal(Model model) {

		model.addAttribute("listagem",bilheteUnicoTemporalService.obterLista());
		
		return showIndex(model);
	}
	
	@GetMapping(value="/bilheteunicoestudante/listagem")
	public String listarBilheteUnicoEstudante(Model model) {

		model.addAttribute("listagem",bilheteUnicoEstudanteService.obterLista());
		
		return showIndex(model);
	}

}


