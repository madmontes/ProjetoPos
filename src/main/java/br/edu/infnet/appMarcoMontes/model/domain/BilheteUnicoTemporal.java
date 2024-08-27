package br.edu.infnet.appMarcoMontes.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBBILHETEUNICOTEMPORAL")
public class BilheteUnicoTemporal extends BilheteUnico {
	
	private boolean personalizavel;
	private String caracteristica;
	
	@Override
	public String toString() {
		
		return String.format("%s;%s;%s", 
				super.toString(),
				personalizavel ? "personalizavel=sim" : "personalizavel=não", 
				caracteristica
				);
	}
	
	public boolean isPersonalizavel() {
		return personalizavel;
	}
	public void setPersonalizavel(boolean personalizavel) {
		this.personalizavel = personalizavel;
	}
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

}
