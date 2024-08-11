package br.edu.infnet.appMarcoMontes.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appMarcoMontes.model.domain.Usuario;

@Service
public class UsuarioService {
	
	private Map<Integer, Usuario> mapa = new HashMap<Integer, Usuario>();
	private Integer id = 0;
	
	public void incluir(Usuario usuario) {
		usuario.setId(++id);
		
		mapa.put(usuario.getId(), usuario);
	}
	
	public Collection<Usuario> obterLista(){
		return mapa.values();
	}

}
