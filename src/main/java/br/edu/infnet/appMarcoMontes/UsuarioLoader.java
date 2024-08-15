package br.edu.infnet.appMarcoMontes;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appMarcoMontes.model.domain.BilheteUnicoEstudante;
import br.edu.infnet.appMarcoMontes.model.domain.BilheteUnicoTemporal;
import br.edu.infnet.appMarcoMontes.model.domain.Usuario;
import br.edu.infnet.appMarcoMontes.model.service.UsuarioService;

@Component
public class UsuarioLoader implements ApplicationRunner {
	
	@Autowired
	private UsuarioService usuarioservice;	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/usuario.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] campos = null;
		
		Usuario usuario = null;
		
		while(linha != null) {
		
			campos = linha.split(";");
			
			switch (campos[0].toUpperCase()) {
			case "U":
				usuario = new Usuario();
				usuario.setCpf(campos[1]);
				usuario.setEmail(campos[2]);
				usuario.setNome(campos[3]);
				
				usuarioservice.incluir(usuario);
				break;
				
			case "T":				
				BilheteUnicoTemporal bilheteunicotemporal = new BilheteUnicoTemporal();
				bilheteunicotemporal.setNumero(Integer.valueOf(campos[1]));
				bilheteunicotemporal.setTipo(campos[2]);			
				bilheteunicotemporal.setDescricao(campos[3]);
				bilheteunicotemporal.setGratuidade(Boolean.valueOf(campos[4]));
				bilheteunicotemporal.setSaldo(Float.valueOf(campos[5]));
				bilheteunicotemporal.setCaracteristica(campos[6]);
				bilheteunicotemporal.setPersonalizavel(Boolean.valueOf(campos[7]));
				
				usuario.getBilhetes().add(bilheteunicotemporal);
				
				break;
				
			case "E":
				BilheteUnicoEstudante bilheteunicoestudante = new BilheteUnicoEstudante();			
				bilheteunicoestudante.setNumero(Integer.valueOf(campos[1]));
				bilheteunicoestudante.setTipo(campos[2]);
				bilheteunicoestudante.setDescricao(campos[3]);
				bilheteunicoestudante.setGratuidade(Boolean.valueOf(campos[4]));
				bilheteunicoestudante.setSaldo(Float.valueOf(campos[5]));
				bilheteunicoestudante.setCota(Integer.valueOf(campos[6]));
				bilheteunicoestudante.setInstituicao(campos[7]);
				
				usuario.getBilhetes().add(bilheteunicoestudante);
			
				break;

			default:
				break;
			}

		
			linha = leitura.readLine();
		}
		
		for(Usuario user : usuarioservice.obterLista()) {
			System.out.println("[USUARIO]" + user);
		}
		
		leitura.close();
	}
}
