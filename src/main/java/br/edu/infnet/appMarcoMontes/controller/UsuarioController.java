package br.edu.infnet.appMarcoMontes.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appMarcoMontes.model.domain.Usuario;
import br.edu.infnet.appMarcoMontes.model.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@GetMapping(value = "usuario/listar")
	public Iterable<Usuario> obterLista(){
		return usuarioService.obterLista();
	}
	
	@GetMapping(value = "usuario/{id}")
	public Usuario obterPortId(@PathVariable Integer id) {
		return usuarioService.obterPortId(id);
	}
	
	@PostMapping(value = "usuario/incluir")
	public String incluir(@RequestBody Usuario usuario) {
		
		usuarioService.incluir(usuario);
		
		return "Inclusão do bilhete " + usuario + " realizada com sucesso!!!";
	}
	
	@DeleteMapping(value = "usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		usuarioService.excluir(id);
		
		return "A exclusão do id " + id + " realizada com sucesso!!!";
	}

}
