package br.edu.infnet.appMarcoMontes;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appMarcoMontes.model.domain.BilheteUnicoTemporal;
import br.edu.infnet.appMarcoMontes.model.service.BilheteUnicoTemporalService;

@Component
public class BilheteUnicoTemporalLoader implements ApplicationRunner {
	
	@Autowired
	private BilheteUnicoTemporalService bilheteunicotemporalservice;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/bilheteunicotemporal.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] campos = null;
		
		while(linha != null) {
			
			campos = linha.split(";");
			
			BilheteUnicoTemporal bilheteunicotemporal = new BilheteUnicoTemporal();
			
			bilheteunicotemporal.setNumero(Integer.valueOf(campos[0]));
			bilheteunicotemporal.setTipo(campos[1]);			
			bilheteunicotemporal.setDescricao(campos[2]);
			bilheteunicotemporal.setGratuidade(Boolean.valueOf(campos[3]));
			bilheteunicotemporal.setSaldo(Float.valueOf(campos[4]));
			bilheteunicotemporal.setCaracteristica(campos[5]);
			bilheteunicotemporal.setPersonalizavel(Boolean.valueOf(campos[6]));			
			
			bilheteunicotemporalservice.incluir(bilheteunicotemporal);
			
			linha = leitura.readLine();
		}	
		
		for(BilheteUnicoTemporal temporal : bilheteunicotemporalservice.obterLista()) {			
			System.out.println("[BILHETEUNICOTEMPORAL] " + temporal);									
		}
		
		leitura.close();
	}

}
