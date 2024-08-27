package br.edu.infnet.appMarcoMontes.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appMarcoMontes.model.domain.Usuario;
import br.edu.infnet.appMarcoMontes.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void incluir(Usuario usuario) {

		usuarioRepository.save(usuario);
	}
	
	public Iterable<Usuario> obterLista(){
		return usuarioRepository.findAll();
	}
	
	public Usuario obterPortId(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public void excluir (Integer id) {
		usuarioRepository.deleteById(id);
	}
	
	public long obterQtde() {
		return usuarioRepository.count();
	}
}
