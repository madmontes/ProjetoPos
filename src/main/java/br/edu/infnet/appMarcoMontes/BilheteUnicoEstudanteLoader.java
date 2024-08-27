package br.edu.infnet.appMarcoMontes;

import java.io.BufferedReader;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appMarcoMontes.model.domain.BilheteUnicoEstudante;
import br.edu.infnet.appMarcoMontes.model.domain.Usuario;
import br.edu.infnet.appMarcoMontes.model.service.BilheteUnicoEstudanteService;

@Component
public class BilheteUnicoEstudanteLoader implements ApplicationRunner {
	
	@Autowired
	private BilheteUnicoEstudanteService bilheteunicoestudanteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/bilheteunicoestudante.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] campos = null;
		
		while(linha != null) {
			
			campos = linha.split(";");
			
			Usuario usuario = new Usuario();
			usuario.setId(Integer.valueOf(campos[7]));
			
			BilheteUnicoEstudante bilheteunicoestudante = new BilheteUnicoEstudante();
			bilheteunicoestudante.setNumero(Integer.valueOf(campos[0]));
			bilheteunicoestudante.setTipo(campos[1]);
			bilheteunicoestudante.setDescricao(campos[2]);
			bilheteunicoestudante.setGratuidade(Boolean.valueOf(campos[3]));
			bilheteunicoestudante.setSaldo(Float.valueOf(campos[4]));
			bilheteunicoestudante.setCota(Integer.valueOf(campos[5]));
			bilheteunicoestudante.setInstituicao(campos[6]);
			bilheteunicoestudante.setUsuario(usuario);
			
			bilheteunicoestudanteService.incluir(bilheteunicoestudante);
						
			linha = leitura.readLine();
		}
		
		for(BilheteUnicoEstudante estudante : bilheteunicoestudanteService.obterLista()) {
			System.out.println("[BILHETEUNICOESTUDANTE] " + estudante);
		}
		
		leitura.close();	
	}	

}
